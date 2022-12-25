<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
      <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
</head>

<body>
<% 
    HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question");
    ArrayList<HashMap> answers = (ArrayList<HashMap>)request.getAttribute("answers");
%>
<div class="container mt-3">

<%-- 버튼 --%>
    <div> 
    <% if((int)question.get("ORDERS") == 1) { %>
        <a href="" class="btn btn-success" onclick="alert('첫번째 페이지 입니다.')"> Prev </a>
        <a href="/polls/PollServlet?QUESTIONS_UID=Q<%= (int)question.get("ORDERS")+1 %>" class="btn btn-success"> Next </a>
    <% } else if((int)question.get("ORDERS") == 5) { %>
        <a href="/polls/PollServlet?QUESTIONS_UID=Q<%= (int)question.get("ORDERS")-1 %>" class="btn btn-success"> Prev </a>
         <a href="" class="btn btn-success" onclick="alert('마지막 페이지 입니다.')"> Next </a>
    <% } else { %>
        <a href="/polls/PollServlet?QUESTIONS_UID=Q<%= (int)question.get("ORDERS")-1 %>" class="btn btn-success"> Prev </a>
        <a href="/polls/PollServlet?QUESTIONS_UID=Q<%= (int)question.get("ORDERS")+1 %>" class="btn btn-success"> Next </a>
    <% } %>
    </div>

    <%-- survey --%>
    <div class="mt-3">
        <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS")%>
    </div>
    <div>
    <% for(int i = 0; i < answers.size(); i++){ %>
    <div class="form-check">
    <input type="radio" name="answer" class="form-check-input" id="<%= answers.get(i).get("EXAMPLE_UID") %>" value="<%= answers.get(i).get("EXAMPLE_UID") %>"/>
        <label for="<%= answers.get(i).get("EXAMPLE_UID") %>" class="form-check-label">
      (<%= answers.get(i).get("ORDERS") %>) <%= answers.get(i).get("EXAMPLE") %>
        </label>
    </div> 
    <% } %>
    </div>
    </div>
</body>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>