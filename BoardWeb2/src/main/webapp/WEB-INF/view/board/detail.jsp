<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BoardVO vo = (BoardVO) request.getAttribute("data");
    UserVO loginUser = (UserVO)session.getAttribute("loginUser");
    int prevIboard = (int) request.getAttribute("prevIboard");
    int nextIboard = (int) request.getAttribute("nextIboard");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= vo.getTitle()%></title>
</head>
<body>
    <h1>디테일</h1>

    <div>${requestScope.err}</div>

    <div>
        글 번호: <%=vo.getIboard()%>
    </div>
    <div>
        제목 : <%=vo.getTitle()%>
    </div>
    <div>
        작성자 : <%=vo.getWriterNm()%>
    </div>
    <div>
        작성날짜 : <%=vo.getRdt()%>
    </div>
    <div>
        내용 : <%=vo.getCtnt()%>
    </div>
    <% if(loginUser != null && vo.getWriter() == loginUser.getIuser()) {%>
    <div>
        <a href="/board/del?iboard=<%=vo.getIboard()%>"><input type="button" value="삭제" ></a>
        <a href="/board/mod?iboard=<%=vo.getIboard()%>"><input type="button" value="수정"></a>
    </div>
    <%} %>
    <div>
        <% if(nextIboard !=0) {%>
        <a href="/board/detail?iboard=<%= nextIboard%>"><button>다음글</button></a>
        <%} %>
        <% if(prevIboard !=0) {%>
        <a href="/board/detail?iboard=<%= prevIboard%>"><button>이전글</button></a>
        <%} %>
        <div>
            <a href="/board/list"><button>리스트로 돌아가기</button></a>
        </div>
    </div>

    <div>
        <div class="comment-txt">
            <textarea id="cmtCnt" name="cmtCnt" placeholder="여러분의 소중한 의견을 적어주세요"></textarea>
        </div>
        <div class="comment-button">
            <button id="cmtCnt-btn">댓글달기</button>
        </div>
    </div>

</body>
</html>
