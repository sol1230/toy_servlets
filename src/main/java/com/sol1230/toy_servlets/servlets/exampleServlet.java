package com.sol1230.toy_servlets.servlets;

import com.sol1230.toy_servlets.dao.PollWithDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(urlPatterns = "/polls/exampleServlet")
public class exampleServlet extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    // input type
    response.setContentType("text/html;charset=UTF-8");
    String questions_Uid = request.getParameter("QUESTIONS_UID");

    // biz with DB and Class
    PollWithDB pollWithDB = new PollWithDB();
    PrintWriter printWriter = response.getWriter();

    HashMap<String, Object> question;
    try {
      question = pollWithDB.getQuestion("questions_Uid");
      //display
      printWriter.println(
        "<div>" +
        "<a href='/polls/exampleServlet?QUESTIONS_UID=Q1'>Q1</a> /" +
        "</div>"
      );
      printWriter.println(
        "<div>" +
        "<a href='/polls/exampleServlet?QUESTIONS_UID=Q2'>Q2</a> /" +
        "</div>"
      );
      printWriter.println(
        "<div>" +
        "<a href='/polls/exampleServlet?QUESTIONS_UID=Q3'>Q3</a> /" +
        "</div>"
      );
      printWriter.println(
        "<div>" +
        "<a href='/polls/exampleServlet?QUESTIONS_UID=Q4'>Q4</a> /" +
        "</div>"
      );
      printWriter.println(
        "<div>" +
        "<a href='/polls/exampleServlet?QUESTIONS_UID=Q5'>Q5</a> /" +
        "</div>"
      );

      printWriter.println(
        "<div>" + question.get("ORDERS") + ". " + question.get("QUESTIONS")
      );
    } catch (SQLException e) {
      e.printStackTrace();
    }
    ArrayList<HashMap> answers;
    try {
      answers = pollWithDB.getAnswer("questions_Uid");

      for (int i = 0; i < answers.size(); i++) {
        printWriter.println("<div>" + answers.get(i) + "</div>");

        printWriter.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
