package com.koreait.board2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyUtils {
    public static void disForward(HttpServletRequest req, HttpServletResponse res, String jsp ) throws ServletException, IOException {
        String path ="/WEB-INF/view/" + jsp +".jsp";
        req.getRequestDispatcher(path).forward(req,res);
    }

    public static int parseStringToInt(String str){
        return parseStringToInt(str, 0);
    }

    // str ="12" > 12 값 리턴
    // str = "1a2" > defVal값 리턴
    public static int parseStringToInt(String str, int defVal){
        try {
            //Wrapper 클래스스
            return Integer.parseInt(str);
        } catch(Exception e){}
        return defVal;
    }

    public static int getParameterInt(HttpServletRequest req, String str){
        String st = req.getParameter(str);
        return parseStringToInt(st);
    }
}
