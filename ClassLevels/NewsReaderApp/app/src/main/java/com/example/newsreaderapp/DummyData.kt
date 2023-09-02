package com.example.newsreaderapp

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DummyData {
    fun dummyItem(): List<NewsItem> {
        val dataList = mutableListOf<NewsItem>()
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        dataList.add(
            NewsItem(
                "R.drawable.sample_1",
                "루키",
                LocalDateTime.parse("2023-09-01T21:39:00", formatter),
                "[23월드컵] 월드컵 첫 출전 팀의 돌풍, 디펜딩 챔피언까지 삼켰다... 4쿼터 역전쇼",
                "라트비아가 스페인을 눌렀다. \n" +
                        "\n" +
                        "라트비아는 1일(이하 한국시간) 인도네시아 자카르타 인도네시아 스타디움에서 열린 2023 FIBA 남자농구 월드컵 2라운드 스페인과의 경기에서 74-69로 승리했다.\n" +
                        "\n" +
                        "월드컵 첫 출전인 라트비아가 또 한 번 사고를 쳤다. 이미 1라운드에서 FIBA 랭킹 5위의 강호 프랑스를 탈락시킨 라트비아는 디펜딩 챔피언 스페인까지 꺾으며 치열한 8강 경쟁을 예고했다. n" +
                        "\n" +
                        "라트비아는 이번 대회를 앞두고 강력한 에이스 크리스탑스 포르징기스가 부상으로 인해 불참하는 악재가 발생한 바 있다. 하지만 다른 선수들이 똘똘 뭉쳐 포르징기스의 공백을 메우는 중이다.\n" +
                        "\n" +
                        "이날 경기에서는 NBA 리거인 장신 슈터 다비스 베르탄스(16점)가 승부처 팀의 기둥 역할을 해내며 역전승을 이끌었다. 베르탄스 외에도 로디언스 크루츠(13점 8리바운드)를 비롯해 4명의 선수가 두 자릿수 득점을 기록했다.\n" +
                        "\n" +
                        "디펜딩 챔피언 스페인은 라트비아에 일격을 당하며 적신호가 켜졌다. 4쿼터 11점에 그치며 상대의 페이스에 완전히 말린 듯한 모습을 보였다. 전체적으로 공격이 쉽게 풀리지 않은 것이 뼈아팠다.\n" +
                        "팽팽한 양상으로 흘러가던 경기는 3쿼터 중반 스페인 쪽으로 주도권이 넘어갔다. 스페인은 탄탄한 수비로 라트비아를 오랜 시간 무득점으로 묶은 뒤 루디 페르난데스와 다리오 브리주엘라의 외곽포로 격차를 벌렸다. 스페인의 공세에 밀린 라트비아는 47-58로 3쿼터를 마쳤다.\n" +
                        "\n" +
                        "하지만 라트비아는 쉽게 포기하지 않았다. 4쿼터 들어 스페인의 공격을 연달아 막아낸 라트비아는 베르탄스의 앤드원 플레이로 상승세를 탔다. 이어 크리스터스 조릭스의 3점슛이 연달아 터지며 순식간에 스코어가 동점이 됐다.\n" +
                        "\n" +
                        "이후 시소게임이 전개된 가운데 승부처에서 웃은 팀은 라트비아였다. 라트비아는 리드를 가져오는 베르탄스의 3점슛에 이어 크루츠가 포스트 플레이로 득점하며 5점 차로 앞섰다.\n" +
                        "\n" +
                        "공격이 계속 막히던 스페인은 브리주엘라의 3점슛으로 마지막 희망을 잡았다. 하지만 연달아 득점에 실패하며 힘이 빠졌고, 승부처 집중력이 더 강했던 라트비아가 승리를 차지했다.\n" +
                        "\n" +
                        "스페인은 3일에 캐나다를 상대하고 라트비아는 브라질을 상대한다. 미국 다음의 우승 후보로 급부상한 캐나다의 저력이 만만치 않기 때문에 스페인은 탈락을 걱정해야 하는 상황이 됐다.",
                false
            )
        )
        dataList.add(
            NewsItem(
                "R.drawable.sample_2",
                "점프볼",
                LocalDateTime.parse("2023-09-02T00:53:00", formatter),
                "[FIBA WC] 돈치치의 슬로베니아, FIBA 랭킹 3위 호주 격파",
                "[점프볼=최서진 기자] 루카 돈치치가 이끄는 슬로베니아는 지는 법을 잊어버렸다.\n" +
                        "\n" +
                        "슬로베니아는 일본 오키나와에서 열린 2023 FIBA(국제농구연맹) 남자농구 월드컵 2라운드에서 강호 호주를 91-80으로 잡았다.\n" +
                        "\n" +
                        "FIBA 랭킹 7위 슬로베니아는 마이크 토비(18점 12리바운드 5어시스트)와 돈치치(19점 7리바운드 6어시스트)를 앞세워 NBA리거가 즐비한 FIBA 랭킹 3위 호주를 꺾었다. 호주는 조시 기디(25점 8리바운드 4어시스트)와 패티 밀스(17점 8리바운드 3어시스트)가 반격했지만, 4쿼터를 지배하지 못했다.\n" +
                        "\n" +
                        "슬로베니아는 주도권을 선점했다. 그러나 66-62로 출발한 4쿼터 초반 턱밑까지 호주의 추격을 허용했다. 기디의 돌파 득점에 2점 차(66-64)까지 쫓겼다. 그레고르 흐로바트가 외곽슛으로 응수했고, 알렉세이 니콜리치의 외곽포까지 터지면서 맞불을 놨다. 이미 슬로베니아는 승기를 잡았지만, 경기 종료 1분여 전 돈치치는 3점슛에 이어 레이업슛과 자유투 득점까지 추가하며 승리에 쐐기를 박았다.\n" +
                        "\n" +
                        "한편, 월드컵에 처음 출전한 라트비아는 사고를 제대로 쳤다. FIBA 랭킹 1위 스페인을 5점 차(74-69)로 잡았다. 이미 1라운드에서 FIBA 랭킹 5위인 프랑스를 잡아 2라운드 진출을 막아선 바 있다. NBA리거인 데이비스 베르탄스가 16점 3리바운드로 활약했다. 또한 미국도 순항을 이어갔다. 몬테네그로를 상대로 85-73으로 승리했다.\n" +
                        "\n" +
                        "2023 FIBA 농구 월드컵 9월 1일 경기 결과\n" +
                        "(3승 1패) 이탈리아 78-76 세르비아 (3승 1패)\n" +
                        "(4승) 독일 100-73 조지아 (2승 2패)\n" +
                        "(4승) 미국 85-73 몬테네그로 (2승 2패)\n" +
                        "(3승 1패) 라트비아 74-69 스페인 (3승 1패)\n" +
                        "(3승 1패) 푸에르토리코 102-97 도미니카 공화국 (3승 1패)\n" +
                        "(4승) 슬로베니아 91-80 호주 (2승 2패)\n" +
                        "(4승) 리투아니아 92-67 그리스 (2승 2패)\n" +
                        "(3승 1패) 브라질 69-65 캐나다 (3승 1패)\n" +
                        "\n" +
                        "2023 FIBA 농구 월드컵 9월 2일 경기 일정 *표시는 쿠팡플레이 중계\n" +
                        "핀란드-베네수엘라\n" +
                        "앙골라-남수단\n" +
                        "뉴질랜드-이집트\n" +
                        "코트디부아르-프랑스\n" +
                        "일본-카보베르데\n" +
                        "필리핀-중국\n" +
                        "요르단-멕시코\n" +
                        "이란-레바논\n" +
                        "\n" +
                        "# 사진_FIBA 제공",
                false
            )
        )
        dataList.add(
            NewsItem(
                "R.drawable.sample_3",
                "마니아타임즈",
                LocalDateTime.parse("2023-09-01T10:50:00", formatter),
                "댈러스 구단주 큐반 \"마리화나 너무 많이 피우는 선수는 트레이드해버리겠다\" 경고...\"팀에는 그들만의 문화가 있다!\"",
                "미국프로농구(NBA)는 최근 마리화나 사용에 대한 입장을 완화했다. 경기 중이 아닌 자유 시간에는 피울 수 있게 한 것이다. 검사도 하지 않기로 했다.\n" +
                        "\n" +
                        "하지만 댈러스 매버릭스 구단주 마크 큐반은 선수들의 마리화나 사용에 부정적이다.\n" +
                        "\n" +
                        "큐반은 최근 '더팻베브' 팟캐스트에 출연해 마리화나를 너무 많이 피우는 선수는 과거에도 그랬듯이 앞으로도 트레이드해버리겠다\"고 경고했다.\n" +
                        "\n" +
                        "그러면서 \"팀에는 그들만의 문화가 있다\"고 강조했다. 댈러스 소속으로 뛰는 한 마리화나를 지나치게 많이 피우는 것을 결코 용납하지 않겠다는 것이다.\n" +
                        "\n" +
                        "큐반은 마리화나가 선수를 산만하게 만들고 중독과 같은 다른 문제를 야기할 수 있다고 믿고 있다.\n" +
                        "\n" +
                        "이에 대해 일부 팬은 마리화나는 무해한 약물이기 피워도 된다고 주장하고 있다. 설사 마리화나가 해롭다해도 그것이 선수를 트레이드할 이유가 되어서는 안 된다는 팬들도 있다.",
                false
            )
        )
        dataList.add(
            NewsItem(
                "R.drawable.sample_0",
                "바스켓코리아",
                LocalDateTime.parse("2023-09-01T09:37:00", formatter),
                "샬럿, 코비 시먼스 방출 … 백코트 정리",
                "샬럿 호네츠가 선수단을 추렸다.\n" +
                        " \n" +
                        "\n" +
                        "샬럿은 지난 31일(이하 한국시간) 코비 시먼스(가드, 196cm, 86kg)를 방출했다고 구단 SNS를 통해 알렸다.\n" +
                        " \n" +
                        "\n" +
                        "시먼스는 이번 여름에 살아남기 어려워 보였다. 당장 지난 시즌에 뚜렷한 활약을 펼치지 못했다. 샬럿이 지난 드래프트에서 닉 스미스 주니어(1라운드 27순위)를 지명했고, 외부에서 프랭크 닐리키나를 충원했다. 이로 인해 백코트 전력이 채워졌다.\n" +
                        " \n" +
                        "\n" +
                        "결국, 샬럿은 결정을 내렸다. 또한, 기존 전력은 P.J. 워싱턴과 재계약을 체결하면서 선수단이 가득 찼다. 기존 선수 한 명을 내보내야 우선 15명이 정해지는 만큼, 시먼스와 함께 하지 않기로 했다. 트레이닝캠프에 앞서 다른 선수를 불러들일 여지도 있긴 하나 우선 정리 대상과 결별하면서 선수단을 정리한 것으로 보인다.\n" +
                        " \n" +
                        "\n" +
                        "그는 지난 시즌 막판에야 샬럿에서 기회를 얻을 수 있었다. 3월 말에 투웨이딜을 체결하며 가까스로 기회를 얻었다. 4월 초에 정규계약을 따냈다. 그는 5경기에서 경기당 5.6분을 소화하며 1점(.167 .200 1.000) 0.8리바운드 1어시스트에 그쳤다. 무엇보다 슛이 잘 들어가지 않았다. 많은 경기에 나서지 못했기에 크게 지적할 부분은 아니나 전반적인 성공률이 너무 저조했다.\n" +
                        " \n" +
                        "\n" +
                        "지난 4월 5일 열린 토론토 랩터스와의 홈경기에서 시즌 최다인 5점을 올렸다. 이날 3점슛 하나를 곁들이기도 했으나 득점 시도가 원활하지 않았다. 가장 많은 11분 40초를 뛰면서 평소보다 많은 기회를 받았으나 한계를 보였다. 점수 차가 크게 벌어지면서 승패가 갈렸기에 나설 수 있었다. 그랬다고 하더라도 전체적인 경기력이 아쉬웠다.\n" +
                        " \n" +
                        "\n" +
                        "그는 지난 2018-2019 시즌에 클리블랜드 캐벌리어스에서 어렵사리 뛸 수 있었다. 이후 만 4년 만에 다시 빅리그에서 뛸 기회를 얻었다. 샬럿의 산하 G-리그팀인 그린스보로 스웜에서 두 시즌을 보냈고, 한 시즌을 폴란드에서 보내기도 했다. 돌아온 그는 투웨이딜로 그린스보로에 둥지를 틀었다. 클리블랜드에서 뛰기 전에는 멤피스 그리즐리스에 몸담기도 했다.\n" +
                        " \n" +
                        "\n" +
                        "시먼스는 어느 덧 20대 중반이 됐다. 지난 2017 드래프트에서 호명을 받지 못한 그는 멤피스와 투웨이딜을 통해 인연을 맺었다. 많은 시간을 G-리그에서 보내야 했으나 막 20대에 진입했기에 유망주로 가치가 없지 않았다. 그러나 NBA에서 자리를 잡지 못하면서 한계를 보였다. 멤피스에서 뛸 당시에는 32경기에서 평균 20.1분 동안 6.1점 1.1리바운드 2.1어시스트를 올렸다.\n" +
                        " \n" +
                        "\n" +
                        "트레이닝캠프를 앞두고 있는 시점에서 방출이 된 만큼, 시먼스도 당장 새로운 팀을 찾는 것은 쉽지 않다. 아직 투웨이 계약을 모두 채운 팀이 없어 기회를 얻을 수는 있으나 캠프에서 뛰는 조건으로 다른 팀의 부름을 받는 것이 좀 더 현실적일 수 있다. 당장 NBA 계약을 시도하는 것은 여러모로 어려울 전망이다.",
                false
            )
        )
        dataList.add(
            NewsItem(
                "R.drawable.sample_5",
                "루키",
                LocalDateTime.parse("2023-09-01T06:25:00", formatter),
                "동국대 이학승의 당찬 포부 \"프로에서 꼭 살아남는 슈터가 되겠다\"",
                "동국대 슈터 이학승이 KBL 무대 도전에 나선다. \n" +
                        "\n" +
                        "이학승은 9월 21일 열리는 2023 KBL 신인드래프트에 도전장을 내민다. 190cm 신장의 슈터 이학승은 이번 2023 KUSF 대학농구 U-리그 정규시즌 14경기를 모두 출장해 평균 5.6점 3.8리바운드를 기록했다.\n" +
                        "\n" +
                        "이학승이 전년도에 비해 수치상으로 그리 좋은 성적을 거둔 것은 아니지만 기록으로는 보이지 않는 움직임과 몸을 아끼지 않는 허슬 플레이로 맏형답게 팀을 이끌었다.\n" +
                        "\n" +
                        "이학승은 \"현재 시즌을 마치고 여수에서 전지훈련을 하고 있다. 프로 선배님들과 연습 경기도 하며 감각을 유지하고 있고 드래프트에 맞춰 컨디션을 관리하고 있다\"며 근황을 전했다.\n" +
                        "\n" +
                        "이학승은 2021년 당시 발목 부상을 입으며 시즌을 제대로 소화하지 못했다. 부상에서 복귀한 이후에도 그의 장점이었던 엄청난 활동량을 찾아보기 힘들었다.\n" +
                        "\n" +
                        "하지만 이학승은 부상에서 완벽히 회복한 이번 시즌 제물포고 재학 당시를 떠올리게 하는 많은 움직임을 가져갔다.\n" +
                        "\n" +
                        "이에 이학승은 \"현재는 걱정을 하지 않아도 될 정도다. 꾸준한 재활을 통해 완벽히 회복했고 움직임을 가져가는데 어려움은 없다. 제 장점이 움직임을 가져가며 슈팅을 던지는 것인데 발목을 의식하다보니 슈팅까지 흔들렸던 것 같다. 하지만 시즌을 치르며 점점 밸런스를 찾았고 나름 좋은 활약을 보였다고 생각한다\"고 밝혔다.\n" +
                        "\n" +
                        "그의 말처럼 이학승은 이번 시즌 최종전이었던 지난 6월 26일 조선대와의 원정 경기에서 13득점을 기록한 바 있다. 이학승은 점차 몸 컨디션이 올라오고 있는 만큼 자신의 다른 장점들 또한 부각시키기 위해 노력 중이라고 전했다.\n" +
                        "\n" +
                        "이학승은 \"최근 볼 핸들링에 대해 많은 연습을 가져가고 있다. 프로에 가기 전까지 많은 부분들을 키우고 싶다. 먼저 프로에 간 동국대 출신 선배들이 웨이트 트레이닝을 열심히 하라고 해주셔서 이 부분 또한 게을리 하지 않고 있다. 프로에서 꼭 살아남는 슈터가 되고 싶다\"며 당찬 포부를 밝혔다.\n" +
                        "\n" + "끝으로 대학생활 4년을 돌아보며 가장 기억에 남는 경기가 있는지에 대해 묻자 이학승은 지난해 6월 3일 홈에서 열렸던 연세대와의 경기를 꼽았다. 해당 경기에서 동국대는 연세대를 상대로 82-78로 승리하는 이변을 만들어냈고 이학승 또한 17득점을 기록했다. \n" +
                        "\n" +
                        "이학승은 \"개인적으로도 팀적으로도 연세대와의 경기가 가장 기억에 많이 남는다. 연세대라는 강호를 잡아서 기쁘기도 했고 스스로 해줘야할 때 해준 것 같아 기분이 좋다. 이호근 감독님이 2학년 때 부임하셨는데 슈팅 타이밍과 도전적인 자세를 많이 배웠다. 또 수비 이론에 대해서도 많이 깨우친 것 같다. 동국대 시절 좋은 기억과 감독님께 배운 경험들을 토대로 프로에서 당당히 도전하겠다\"고 다짐했다.",
                false
            )
        )
        dataList.add(
            NewsItem(
                "R.drawable.sample_6",
                "스타뉴스",
                LocalDateTime.parse("2023-09-01T17:11:00", formatter),
                "허웅·라건아 등 KCC 선수들 작별인사 \"전주 팬들 함성 잊지 않겠다\"",
                "프로농구 KCC 이지스 선수들이 전주 팬들에게 진심을 담은 작별인사를 남겼다.\n" +
                        "\n" +
                        "KCC의 슈퍼스타 허웅은 지난 8월 30일 자신의 SNS에 \"내겐 너무 익숙했던 전주 KCC에서 1년 동안 뛸 수 있어 행복하고, 소중한 시간이었다. 매 경기 많은 팬들이 찾아와 응원해주신 덕분에 더 힘내서 뛸 수 있었다\"고 되돌아보며 \"전주체육관에서의 팬분들의 함성소리 잊지 않겠다\"고 적었다.\n" +
                        "\n" +
                        "또 허웅은 \"앞으로 부산 KCC에서 좋은 모습으로 찾아뵙겠다\"고 약속했다.\n" +
                        "\n" +
                        "KCC는 2001년부터 연고지로 사용했던 전주시를 22년 만에 떠나 부산으로 옮긴다. 전주를 떠나는 이유는 홈구장 전주체육관을 놓고 KCC와 전주시가 오랜 갈등을 빚었기 때문이다.\n" +
                        "\n" +
                        "전주시는 1974년 건립돼 50년이나 지난 낡은 전주체육관 대신 2023년까지 새 경기장을 지어주기로 약속했다. 하지만 이는 지켜지지 않았다. 결국 KCC는 계속된 요구에도 받아들여지지 않자 마음이 떴고, 부산으로 연고지를 옮기기로 했다." +
                        "\n" + "KCC는 프로농구 최고 인기 팀 중 하나로 꼽힌다. 경기장 문제와 별개로 전주 팬들은 언제나 폭발적인 응원을 보냈다. 홈뿐만 아니라 원정까지 전주 팬들이 가득 들어찬 경기가 많았다. 선수들 입장에서는 평생 잊을 수 없는 소중한 추억이다. 전주를 떠나게 됐지만, KCC 선수들은 그간 전주 팬들의 뜨거운 관심과 응원에 감사인사를 전했다.\n" +
                        "\n" + "팀 핵심 센터 라건아도 \"전주에 진심으로 감사드린다. 아름다운 도시인 전주로 트레이드 된 후 팬들의 환영에 너무 행복했다. 제가 우리 팀을 우승으로 이끌었으면 좋았을 텐데, 제가 부족했고, 팬분들은 우리가 우승한 것처럼 여전히 반겨줘서 고마웠다\"고 적었다.\n" +
                        "\n" +
                        "이어 라건아는 \"기복이 심한 여러 해 동안 항상 응원해주시고, 좋은 추억을 만들어주셔서 감사하다. 우리는 새로운 곳에서 시작을 하지만, 이곳 전주에서 시작했다는 것을 결코 잊지 않겠다\"고 약속했다.\n" +
                        "\n" +
                        "KCC 베테랑 정창영도 같은 마음이었다.\n" +
                        "\n" +
                        "정창영은 \"그동안 전주팬들 덕분에 전주에서 너무나 행복한 시즌을 보낼 수 있었다. 저 또한 팬들이 있었기에 성장할 수 있었다\"고 했다. 그러면서 \"어디에서든 이 감사한 마음 절대 잊지 않고 좋은 모습 보여드리겠다\"고 덧붙였다.\n",
                false
            )
        )
        dataList.add(
            NewsItem(
                "R.drawable.sample_7",
                "루키",
                LocalDateTime.parse("2023-08-31T21:36:00", formatter),
                "금빛 열정으로 가득한 AG 대표팀 양홍석의 목표",
                "대표팀에 승선한 양홍석의 목표는 '금'이다.\n" +
                        "\n" +
                        "2022 항저우 아시안게임 남자농구 국가대표팀은 대회 준비에 한창이다. 프로팀들과의 연습 경기를 통해 손발을 맞추고 있으며, 9월 초에는 일본으로 전지훈련을 다녀올 예정이다. 31일 대표팀은 서울 삼성 썬더스와의 연습경기에서 63-54로 승리했다.\n" +
                        "\n" +
                        "대표팀은 경기 초반 야투 난조에 살짝 고전하는 듯했으나 촘촘한 수비와 고른 로테이션을 바탕으로 공격을 전개했다. 허훈의 원활한 경기 운영과 하윤기의 투맨 게임이 돋보였다. 이 외에도 여러 선수들이 외곽에서 강한 모습을 보였다.\n" +
                        "\n" +
                        "이날 지난 23일 추가로 발탁된 양홍석도 코트 위에 올랐다. 그는 좋은 오프더볼 무브를 선보였고 적극적인 수비 가담으로 대표팀에 힘을 보탰다.\n" +
                        "\n" +
                        "경기 이후 만난 양홍석은 \"적응하고 있는 단계다. 현재 몸 상태는 나쁘지 않고 또 경기 치르면서 손발을 맞추다 보면 더 좋아질 것 같다\"라며 이날 경기를 돌아봤다.\n" +
                        "\n" +
                        "이어 대표팀 합류에 대해서는 \"불러주셔서 정말 감사드린다. 감독님께서 정말 고민을 많이 하셨을 것 같다. 고민한 것을 후회하지 않으시도록 최대한 열심히 잘해야 한다\"라며 국가대표로서 책임감을 드러냈다.\n" +
                        "\n" +
                        "양홍석의 추일승호 승선은 이번이 처음이 아니다. 그는 지난 2022 FIBA 남자농구 아시아컵에서 추일승 감독과 함께했다. 그렇기에 추일승 감독이 선호하는 농구 스타일을 더욱 잘 알 것.\n" +
                        "\n" +
                        "양홍석은 \"터프한 농구를 좋아하시는 것 같다. 공격에서는 자신 있게 붙이고 수비에서도 압박하면서 경기하길 원하신다. 또 이런 부분이 제가 LG에 가서 해야 하는 부분이기 때문에 잘 해내려고 노력 중이다\"라고 답했다.\n" +
                        "\n" +
                        "그의 말대로 추일승 감독은 장신의 포워드 자원을 활용한 공격형 농구를 구사한다. 포워드들의 로테이션을 통해 내외곽에서 경쟁력을 갖추는 것이다. 이날 역시 대표팀은 잦은 공수 전환과 달리는 농구를 선보이며 재빠르게 경기를 풀어갔다.\n" +
                        "\n" +
                        "추 감독의 공격 농구가 원활히 이루어지기 위해 양홍석은 어떤 점을 보완해야 할까?\n" +
                        "\n" +
                        "그는 \"외곽슛이랑 리바운드다. 가드 선수보다 제가 사이즈가 더 좋기 때문에 수비나 파이팅 있는 부분을 더 준비해야 할 것 같다\"라고 말했다.\n" +
                        "\n" +
                        "끝으로 그에게 목표를 묻자 \"금메달\"이라며 비장한 각오를 내비쳤다.",
                false
            )
        )
        dataList.add(
            NewsItem(
                "R.drawable.sample_8",
                "마이데일리",
                LocalDateTime.parse("2023-08-30T10:20:00", formatter),
                "KGC 정관장 스포츠단으로 변모, 남자농구단 정관장 레드부스터스로 새출발",
                "[마이데일리 = 김진성 기자]KGC인삼공사 스포츠단이 ‘정관장 스포츠단’으로 새롭게 변화한다.\n" +
                        "\n" +
                        "KGC인삼공사는 30일 \"최근 마스터 브랜드인 ‘정관장’을 글로벌 건강식품 솔루션 브랜드로 재탄생시킨다는 전략하에 브랜드 리뉴얼을 단행한 바 있다. 이에 따라 스포츠단의 명칭도 ‘정관장 스포츠단’으로 바꾸고 프로종목인 남자농구단과 여자배구단의 팀명 변경도 새롭게 추진했다\"라고 했다.  \n" +
                        "\n" +
                        "구체적으로 KGC는 \"지난 7월 사내 공모를 통해 선정된 네이밍 후보를 바탕으로 팀명 선정을 위한 팬 투표를 진행했으며, 그 결과 남자 프로농구단은 ‘정관장 레드부스터스(Red Boosters)’로, 여자 프로배구단은 ‘정관장 레드스파크스(Red Sparks)’가 최종 팀명으로 선정됐다. 정관장 레드부스터스(Red Boosters)는 ‘건강과 에너지의 원천인 정관장 농구팀의 강력한 파워’를 정관장 레드스파크스(Red Sparks)는 ‘불꽃처럼 빛나는 경기력으로 승리하는 배구단’의 의미를 갖고 있다\"라고 했다.\n" +
                        "\n" +
                        "정관장 스포츠단 이종림 단장은 “KGC인삼공사의 대표 브랜드 정관장과 스포츠는 건강이라는 동일한 가치를 추구해왔다” 라며 “앞으로 새로운 팀명과 함께 보다 건강하고 밝은 모습으로 팬들에게 보답하겠다”라고 소감을 밝혔다. \n" +
                        "\n" +
                        "KGC인삼공사는 \"팬투표로 진행된 정관장스포츠단 팀명 이벤트 응모결과는 구단 SNS를 통해 확인할 수 있다\"라고 했다.",
                false
            )
        )
        dataList.add(
            NewsItem(
                "R.drawable.sample_9",
                "스포츠경향",
                LocalDateTime.parse("2023-08-30T10:15:00", formatter),
                "휴스턴서 꽃 피우지 못한 유망주, 밀워키와 투웨이 계약 체결[오피셜]",
                "타이타이 워싱턴 주니어(21)가 밀워키 벅스(이하 밀워키)로 자신의 재능을 옮긴다.\n" +
                        "\n" +
                        "밀워키는 30일 오전(한국시간) 구단 공식 SNS를 통해 워싱턴 주니어와 투웨이 계약을 체결했다고 발표했다. 이는 오클라호마시티 썬더가 방출을 결정한 지 11일 만에 일어난 것이다.\n" +
                        "\n" +
                        "2022년 NBA 드래프트 1라운드 29순위로 미네소타 팀버울브스에 지명된 워싱턴 주니어는 곧바로 휴스턴 로키츠로 트레이드됐고 신인 시즌을 보냈다. 그는 정규리그 31경기에서 평균 4.7득점과 1.5어시스트를 기록했다.\n" +
                        "\n" +
                        "케빈 포터 주니어의 백업 포인트 가드를 맡을 것으로 여겨졌던 워싱턴 주니어는 시즌 중반쯤에 다이센 닉스의 등장으로 로테이션 멤버에서 제외됐다.\n" +
                        "\n" +
                        "이에 워싱턴 주니어는 지난 2월 인터뷰에서 “내 전화번호에서 호출될 때마다 준비된 상태를 유지하는 것이 중요하다”며 “코트에 있을 때 슛을 던지든 말든 상관없다. 생산적인 움직임을 가져가려는 방법을 찾는 중이다”고 언제든지 노력하는 사고방식을 가지는 것이 중요하다고 강조했다.\n" +
                        "\n" +
                        "남은 신인 시즌을 벤치에서 머무는 대신 G리그행을 택한 워싱턴 주니어는 전 휴스턴 감독 스티븐 사일러스가 이끄는 리오 그란데 벨리 바이퍼스에서 뛰는 동안 평균 20.2득점 4.7어시스트 야투 성공률 48.3%를 기록했다. 특히 그는 지난 1월 스톡턴 킹스전에서 53득점과 10리바운드를 해낸 바 있다.\n" +
                        "\n" +
                        "올여름 휴스턴은 워싱턴 주니어와 우스만 가루바를 애틀랜타로 트레이드했다. 이후 애틀랜타는 워싱턴과 가루바를 오클라호마시티 썬더로 보냈다. 두 사람은 서머 리그 후반에 합류해 오클라호마시티 유니폼을 입고 뛰었지만, 지난 19일 방출됐다.\n" +
                        "\n" +
                        "단, 워싱턴 주니어는 바이버스를 G리그 파이널에 진출하도록 도운 바 있다. 그가 바이퍼스에서 보낸 시간이 NBA에서 경력을 이어갈 수 있는 기반을 마련할 수 있게 도왔다.",
                false
            )
        )
        dataList.add(
            NewsItem(
                "R.drawable.sample_10",
                "바스켓코리아",
                LocalDateTime.parse("2023-08-29T20:11:00", formatter),
                "‘성장통’ 겪고 있는 LG 이승우, “이제는 내가 변해야 한다”",
                "이승우의 차기 시즌 목표는 더 많은 출전 기회를 받는 것이다.\n" +
                        "\n" +
                        "이승우(193cm, F)는 2021~2022시즌 데뷔했다. 데뷔 시즌부터 두각을 나타냈고 빠르게 팀의 핵심 선수로 성장했다. 그렇게 데뷔 시즌에 7점 4.2리바운드를 기록했다.\n" +
                        "\n" +
                        "하지만 2년 차에 성장통을 겪었다. 새롭게 부임한 조상현 LG 감독의 색깔에 적응하지 못했고 출전 기회는 점점 줄어들었다. 그 결과, 25경기 출전해 평균 15분을 뛰었다. 출전 기회가 줄어들지 성적도 자연스럽게 줄어들었다. 평균 기록은 4.4점 3.4리바운드에 그쳤다.\n" +
                        "\n" +
                        "코트 밖에서 LG의 농구를 바라본 이승우는 “지난 시즌 벤치에 앉아있으며 많은 생각을 했다. 가장 큰 것은 밖에서 보면서 코트 위에서 뛰고 싶다는 생각을 많이 했다. 내가 무엇이 부족하고 무엇을 채워야 하는지 생각했다”라며 지난 시즌을 돌아봤다.\n" +
                        "\n" +
                        "이어, “가장 중요한 것은 감독님의 색깔에 빠르게 적응해야 한다. 감독님께서 슈팅과 수비를 강조하신다. 아직 내가 부족한 부분이 많다”라며 “반대로 내 장점은 살려야 한다. 템포 푸쉬, 리바운드를 통해 팀에 도움이 되고 싶다”라고 덧붙였다.\n" +
                        "\n" +
                        "다소 아쉬운 시즌을 보낸 만큼 이승우의 각오는 남달랐다. 이승우는 “매 비시즌 때 내 약점을 보완해야 한다고 생각한다. 크게 변하지는 않을 수 있다. 하지만 조금씩이라도 좋아지면 된다. 이번에도 똑같다. 감독님이 원하시는 부분을 더 보완해야 한다. 감독님의 스타일과 주문은 작년과 똑같다. 이제는 내가 변해야 한다”라는 각오를 전했다.\n" +
                        "\n" +
                        "그리고 “슈팅에서도 성장이 있어야 한다. 훈련 때 코치님들이 봐주신다. 일단 많이 던져야 한다. 그래서 새벽에도 혼자 나와서 슈팅 연습을 진행한다”라며 슈팅 개선을 강조했다.\n" +
                        "\n" +
                        "LG는 이번 FA 시장을 통해 최대어 중 한 명인 양홍석(195cm, F)을 영입했다. 양홍석과 한 팀이 된 이승우는 “기대했던 것만큼 좋은 선수다. 새로운 자극제가 되고 있다”라며 “공격력도 좋고 리바운드에 대한 적극성도 좋고 에너지도 좋다. 무엇보다도 파이팅이 넘친다. 덕분에 팀 분위기가 올라간다. 막내 라인이 해야 할 것을 하고 계신다”라며 양홍석과 함께 뛰게 된 소감을 전했다.\n" +
                        "\n" +
                        "양홍석을 영입한 LG는 차기 시즌 강력한 우승 후보로 뽑히고 있다. 하지만 이승우는 “작년에도 높게 올라갔다. 이번에도 평가가 좋다. 그렇다고 우리의 태도에 변화가 있는 것은 아니다. 전과 똑같은 자세로 똑같은 양의 훈련을 진행하고 있다. 방심하지 않고 더 좋아지려고 노력하고 있다”라며 방심하지 않은 모습을 보였다.\n" +
                        "\n" +
                        "마지막으로 이승우에게 목표를 묻자 “목표를 세세하게 잡지는 않았다. 일단 작년보다 많이 출전하고 싶다. 세부적인 기록은 코트에 서 있는 시간이 길어질수록 따라오는 것이다”라며 많은 출전 시간을 목표로 설정했다.\n" +
                        "\n" +
                        "사진 제공 = KBL",
                false
            )
        )

        return dataList.sortedBy { it.date }
    }
}