package controller.search;

import model.opponent.Opponent;
import model.opponent.OpponentDAO;
import model.regist.RegistDAO;
import model.result.ResultDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/result/delete")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
        // idをうけとる
        Integer deleteId = Integer.parseInt(request.getParameter("id"));
        //idからその詳細を削除する
        ResultDAO.deleteResult(deleteId);

        response.sendRedirect("/Search");
    }
}