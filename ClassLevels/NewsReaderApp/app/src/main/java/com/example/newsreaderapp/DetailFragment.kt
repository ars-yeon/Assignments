package com.example.newsreaderapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsreaderapp.databinding.FragmentDetailBinding

@Suppress("DEPRECATION")
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
//    private var bookmark = false

    private var articleDetail: String? = null
    /*private val newsPosition: Int by lazy {
        arguments?.getInt(Constants.NEWS_INDEX, 0) ?: 0
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            articleDetail = it.getString("articleDetail")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val ivImg = binding.ivImg
        val tvagency = binding.tvAgency
        val tvDate = binding.tvDate
        val tvTitle = binding.tvTitle
        val tvConent = binding.tvContent
        arguments?.let { it ->
            val clickedNewsItem = it.getParcelable<NewsItem>(Constants.NEWS_OBJECT)
            clickedNewsItem?.let {
                ivImg.setImageResource(it.img)
                tvagency.text = it.agency
                tvDate.text = it.formattedDate
                tvTitle.text = it.title
                tvConent.text = it.content
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBack.setOnClickListener {
            val titleFragment = TitleFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, titleFragment)
                .commit()
        }
    }

    companion object {
        fun newInstance(newsItem: NewsItem): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putParcelable("newsItem", newsItem)
            fragment.arguments = bundle
            return fragment
        }
    }
}