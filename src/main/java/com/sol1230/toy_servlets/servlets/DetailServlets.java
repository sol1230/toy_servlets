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

@WebServlet(urlPatterns = "/polls/PollServlet")
public class DetailServlets extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    // input type
    // response.setContentType("text/html;charset=UTF-8");
    String questions_Uid = request.getParameter("QUESTIONS_UID");

    // biz with DB and Class
    PollWithDB pollWithDB = new PollWithDB();

    HashMap<String, Object> question = null;
    ArrayList<HashMap> answers = null;

    //display
    try {
      question = pollWithDB.getQuestion(questions_Uid);
      answers = pollWithDB.getAnswer(questions_Uid);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // output with html
    request.setAttribute("question", question);
    request.setAttribute("answers", answers);

    // jsp
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(
      "/polls/detail.jsp"
    );
    requestDispatcher.forward(request, response);
  }
}
