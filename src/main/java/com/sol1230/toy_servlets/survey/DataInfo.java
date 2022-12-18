package com.sol1230.toy_servlets.survey;

import java.util.ArrayList;
import java.util.HashMap;

public class DataInfo {

  public HashMap<String, String> getInformation() {
    HashMap<String, String> information = new HashMap<String, String>();
    information.put("Name", "이은솔");
    information.put("belong", "Gyeonggi-do");
    return information;
  }

  public ArrayList<MemberBean> getSurveyWithAnswer() {
    ArrayList<MemberBean> survey = new ArrayList<>();

    MemberBean memberBean01 = new MemberBean();
    memberBean01.setq("해당 매장을 방문시 매장은 청결 하였습니까?");
    memberBean01.seta1("전혀 아니다");
    memberBean01.seta2("아니다");
    memberBean01.seta3("보통이다");
    survey.add(memberBean01);

    MemberBean memberBean02 = new MemberBean();
    memberBean02.setq("주문시 직원은 고객님께 친절 하였습니까?");
    memberBean02.seta1("전혀 아니다");
    memberBean02.seta2("아니다");
    memberBean02.seta3("보통이다");
    memberBean02.seta4("그렇다");
    survey.add(memberBean02);

    MemberBean memberBean03 = new MemberBean();
    memberBean03.setq("주문하신 음료가 나오기까지 시간이 적당하였습니까?");
    memberBean03.seta1("전혀 아니다");
    memberBean03.seta2("아니다");
    survey.add(memberBean03);

    MemberBean memberBean04 = new MemberBean();
    memberBean04.setq("직원이 제조한 음료에 대해 맛은 좋았습니까?");
    memberBean04.seta1("전혀 아니다");
    memberBean04.seta2("아니다");
    memberBean04.seta3("보통이다");
    memberBean04.seta4("그렇다");
    memberBean04.seta5("매우 그렇다");
    survey.add(memberBean04);

    MemberBean memberBean05 = new MemberBean();
    memberBean05.setq("해당 매장을 다음에도 재방문 하실 의향이 있으십니까?");
    memberBean05.seta1("전혀 아니다");
    memberBean05.seta2("아니다");
    memberBean05.seta3("보통이다");
    survey.add(memberBean05);

    return survey;
  }

  public HashMap<String, Object> getBundlesData() {
    DataInfo dataInfo = new DataInfo();
    HashMap<String, String> information = dataInfo.getInformation();
    HashMap<String, Object> bundlesData = new HashMap<>();

    bundlesData.put("information", information);
    bundlesData.put("surveyWithAnswer", dataInfo.getSurveyWithAnswer());

    return bundlesData;
  }
}
