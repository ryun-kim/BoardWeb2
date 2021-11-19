<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = (String) request.getAttribute("err");
    BoardVO vo =(BoardVO) request.getAttribute("errdata");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mod</title>
</head>
<body>
<h1>글수정</h1>
<% if(err !=null) {%>
<div><%=err%></div>
<%}%>
<div>
    <form action="/board/mod?iboard=${moddata.iboard}" method="post">
        <div><input type="text" name="title" placeholder="title" value="<% if(vo ==null){%>${moddata.title}<%}else{%>${errdata.title}<%}%>"></div>
        <div>
            <textarea name="ctnt" placeholder="content" rows="20"><% if(vo ==null){%>${moddata.ctnt}<%}else{%>${errdata.ctnt}<%}%></textarea>
        </div>
        <div>
            <input type="submit" value="수정">
            <input type="reset" value="초기화">
        </div>
    </form>
</div>
</body>
</html>