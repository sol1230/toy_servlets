package com.sol1230.toy_servlets.survey;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(urlPatterns = "/pollListServlet")
public class SurveyBeanServlets extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws IOException {
    DataInfo dataInfo = new DataInfo();
    HashMap<String, Object> bundlesData = dataInfo.getBundlesData();
    HashMap<String, String> information = dataInfo.getInformation();

    // Display
    response.setContentType("text/html;charset=UTF-8"); // PrintWriter보다 위에 있어야 하는지?
    PrintWriter printWriter = response.getWriter();

    printWriter.println("<html lang='en'>");
    printWriter.println("<head>");
    printWriter.println("    <meta charset='UTF-8'>");
    printWriter.println("    <title>Poll With Beans</title>");
    printWriter.println(
      "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'"
    );
    printWriter.println(
      "        integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous'>"
    );
    printWriter.println("    <link rel='stylesheet' href='./css/commons.css'>");
    printWriter.println("</head>");

    printWriter.println("<body>");
    printWriter.println("    <div class='container'>");
    printWriter.println("<div class='fs-3'>Survey</div>");
    printWriter.println("<br />");

    printWriter.println("<div> 이름 : " + information.get("Name") + "</div>");
    printWriter.println("<div> 소속 : " + information.get("belong") + "</div>");

    ArrayList<MemberBean> surveyWithAnswer = (ArrayList<MemberBean>) bundlesData.get(
      "surveyWithAnswer"
    );

    printWriter.println("<div></div>");
    printWriter.println("<hr />");
    for (int i = 0; i < surveyWithAnswer.size(); i++) {
      MemberBean memberBean = surveyWithAnswer.get(i);

      if (i == 0) {
        printWriter.println(
          "<div>" + (i + 1) + ". " + memberBean.getq() + "</div>"
        );
        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q1' id='q1a1' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q1a1' class='form-check-label'>" +
          memberBean.geta1() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q1' id='q1a2' class='form-check-input'>"
        );
        printWriter.println(
          " <label for='q1a2' class='form-check-label'>" +
          memberBean.geta2() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println(" <div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q1' id='q1a3' class='form-check-input'>"
        );
        printWriter.println(
          " <label for='q1a3' class='form-check-label'>" +
          memberBean.geta3() +
          "</label>"
        );
        printWriter.println("</div>");
        printWriter.println("<br />");
      } else if (i == 1) {
        printWriter.println(
          "<div>" + (i + 1) + ". " + memberBean.getq() + "</div>"
        );
        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q2' id='q2a1' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q2a1' class='form-check-label'>" +
          memberBean.geta1() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q2' id='q2a2' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q2a2' class='form-check-label'>" +
          memberBean.geta2() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q2' id='q2a3' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q2a3' class='form-check-label'>" +
          memberBean.geta3() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q2' id='q2a4' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q2a4' class='form-check-label'>" +
          memberBean.geta4() +
          "</label>"
        );
        printWriter.println("</div>");
        printWriter.println("<br />");
      } else if (i == 2) {
        printWriter.println(
          "<div>" + (i + 1) + ". " + memberBean.getq() + "</div>"
        );
        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q3' id='q3a1' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q3a1' class='form-check-label'>" +
          memberBean.geta1() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q3' id='q3a2' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q3a2' class='form-check-label'>" +
          memberBean.geta2() +
          "</label>"
        );
        printWriter.println("</div>");
        printWriter.println("<br />");
      } else if (i == 3) {
        printWriter.println(
          "<div>" + (i + 1) + ". " + memberBean.getq() + "</div>"
        );
        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q4' id='q4a1' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q4a1' class='form-check-label'>" +
          memberBean.geta1() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q4' id='q4a2' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q4a2' class='form-check-label'>" +
          memberBean.geta2() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q4' id='q4a3' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q4a3' class='form-check-label'>" +
          memberBean.geta3() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q4' id='q4a4' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q4a4' class='form-check-label'>" +
          memberBean.geta4() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q4' id='q4a5' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q4a5' class='form-check-label'>" +
          memberBean.geta5() +
          "</label>"
        );
        printWriter.println("</div>");
        printWriter.println("<br />");
      } else if (i == 4) {
        printWriter.println(
          "<div>" + (i + 1) + ". " + memberBean.getq() + "</div>"
        );
        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q5' id='q5a1' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q5a1' class='form-check-label'>" +
          memberBean.geta1() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q5' id='q5a2' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q5a2' class='form-check-label'>" +
          memberBean.geta2() +
          "</label>"
        );
        printWriter.println("</div>");

        printWriter.println("<div class='form-check '>");
        printWriter.println(
          "<input type='radio' name='q5' id='q5a3' class='form-check-input'>"
        );
        printWriter.println(
          "<label for='q5a3' class='form-check-label'>" +
          memberBean.geta3() +
          "</label>"
        );
        printWriter.println("</div>");
        printWriter.println("<br />");
      } else {
        break;
      }
    }
    printWriter.println("<div>");
    printWriter.println("<form action='/index.html' method='get'>");
    printWriter.println("<button>제출하기</button>");
    printWriter.println("</form>");
    printWriter.println("</div>");

    printWriter.println(
      "    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'"
    );
    printWriter.println(
      "        integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'"
    );
    printWriter.println("        crossorigin='anonymous'></script>");
    printWriter.println("</body>");
    printWriter.println("</html>   ");
    printWriter.close();
  }
}
