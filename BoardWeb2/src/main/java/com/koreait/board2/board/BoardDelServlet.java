package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardVO;
import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/del")
public class BoardDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String strIboard = req.getParameter("iboard");
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO)session.getAttribute("loginUser");
        if(loginUser ==null){
            //res.sendRedirect("/board/detail?err=1"); 새로운 req가 만들어진다.
            req.setAttribute("err","로그인을 해주세요");
            req.getRequestDispatcher("/board/detail").forward(req,res);//req,res 값이 그대로 넘어간다.
            return;
        }

        int intIboard = MyUtils.parseStringToInt(strIboard);
        BoardVO vo = new BoardVO();
        vo.setIboard(intIboard);
        vo.setWriter(loginUser.getIuser());
        int result = BoardDAO.DelBoard(vo);
        switch (result){
            case 1:
                res.sendRedirect("/board/list");
                break;
            case 0:
                req.setAttribute("err","로그인을 해주세요");
                req.getRequestDispatcher("/board/detail").forward(req,res);
                break;
        }
    }
}
