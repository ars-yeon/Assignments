package com.example.imagesearchapp.search

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearchapp.data.KakaoImage
import com.example.imagesearchapp.data.KakaoImageList
import com.example.imagesearchapp.databinding.SearchFragmentBinding
import com.example.imagesearchapp.data.SharedViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SharedViewModel
    private val searchItems = mutableListOf<KakaoImage>()
    private lateinit var adapter: SearchAdapter
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        recyclerView = binding.searchRv
        val searchEv = binding.searchEv
        val btnSearch = binding.searchIcSearch
        val btnDelete = binding.searchIcDelete

        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        adapter = SearchAdapter(searchItems, viewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        actionSearch(searchEv)
        setButton(searchEv, btnSearch, btnDelete)
        textWatcher(searchEv, btnDelete)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setSearch(query: String) {
        viewModel.searchImage(query).enqueue(object : Callback<KakaoImageList> {
            override fun onResponse(
                call: Call<KakaoImageList>,
                response: Response<KakaoImageList>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        searchItems.clear()
                        searchItems.addAll(it.data)
                        adapter.notifyDataSetChanged()
                        logApiResponse(it.data.size)

                        recyclerView.scrollToPosition(0)
                    }
                } else {
                    logApiError(response.code())
                }
            }

            override fun onFailure(call: Call<KakaoImageList>, t: Throwable) {
                logApiFailure()
            }
        })
    }

    private fun setButton(searchEv: EditText, btnSearch: ImageView, btnDelete: ImageView) {
        btnSearch.setOnClickListener {
            val query = searchEv.text.toString().trim()
            if (query.isNotEmpty()) {
                setSearch(query)
                hideKeyboardInput(searchEv)
            } else {
                showEmptyQueryAlert()
            }
        }

        btnDelete.setOnClickListener { searchEv.text.clear() }
    }

    private fun textWatcher(searchEv: EditText, btnDelete: ImageView) {
        searchEv.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.isNotEmpty() == true) {
                    btnDelete.visibility = View.VISIBLE
                } else {
                    btnDelete.visibility = View.INVISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun hideKeyboardInput(view: View) {
        val inputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun showEmptyQueryAlert() {
        AlertDialog.Builder(requireContext())
            .setTitle("알림")
            .setMessage("검색어를 입력하세요.")
            .setPositiveButton("확인", null)
            .show()
    }

    private fun actionSearch(searchEv: EditText) {
        searchEv.setOnEditorActionListener { _, actionId, _ ->
            val query = searchEv.text.toString().trim()
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.searchImage(query)
                return@setOnEditorActionListener true
            } else {
                return@setOnEditorActionListener false
            }
        }
    }

    private fun logApiResponse(dataSize: Int) {
        Log.d("###", "데이터 수: $dataSize")
    }

    private fun logApiError(errorCode: Int) {
        Log.d("###", "에러 코드: $errorCode")
    }

    private fun logApiFailure() {
        Log.e("###", "API 요청 실패")
    }
}