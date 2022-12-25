package com.sol1230.toy_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollWithDB {

  // 질문 출력
  public HashMap<String, Object> getQuestion(String questions_uid)
    throws SQLException {
    Commons commons = new Commons();
    Statement questionStatement = commons.getStatement();

    String query =
      "SELECT * FROM QUESTIONS_LIST " +
      " WHERE QUESTIONS_UID = '" +
      questions_uid +
      "'";
    ResultSet resultSetQue = questionStatement.executeQuery(query);

    HashMap<String, Object> question = null;
    while (resultSetQue.next()) {
      question = new HashMap<>();
      question.put("ORDERS", resultSetQue.getInt("ORDERS"));
      question.put("QUESTIONS", resultSetQue.getString("QUESTIONS"));
      question.put("QUESTIONS_UID", resultSetQue.getString("QUESTIONS_UID"));
    }
    return question;
  }

  // 답 출력
  public ArrayList<HashMap> getAnswer(String questions_uid)
    throws SQLException {
    Commons commons = new Commons();
    Statement answerStatement = commons.getStatement();

    String query =
      "SELECT * FROM ANSWERS INNER JOIN EXAMPLE_LIST " +
      " ON ANSWERS.EXAMPLE_UID = EXAMPLE_LIST.EXAMPLE_UID " +
      " WHERE QUESTIONS_UID = '" +
      questions_uid +
      "'";

    ResultSet resultSetAns = answerStatement.executeQuery(query);
    ArrayList<HashMap> answers = new ArrayList<>();
    HashMap<String, Object> example_list = null;

    while (resultSetAns.next()) {
      example_list = new HashMap<>();
      example_list.put("ORDERS", resultSetAns.getInt("ORDERS"));
      example_list.put("EXAMPLE", resultSetAns.getString("EXAMPLE"));
      example_list.put("EXAMPLE_UID", resultSetAns.getString("EXAMPLE_UID"));

      answers.add(example_list);
    }
    return answers;
  }
}
