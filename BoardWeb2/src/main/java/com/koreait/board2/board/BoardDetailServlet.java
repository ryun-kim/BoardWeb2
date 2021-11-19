package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String str = req.getParameter("iboard");
        int strint = MyUtils.parseStringToInt(str);
        BoardVO vo = new BoardVO();
        vo.setIboard(strint);
        int prevIboard = BoardDAO.prevBoard(vo);
        int nextIboard = BoardDAO.nextBoard(vo);
        req.setAttribute("prevIboard", prevIboard);
        req.setAttribute("nextIboard", nextIboard);
        req.setAttribute("data",BoardDAO.selBoardDetail(vo));
        MyUtils.disForward(req,res,"board/detail");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
