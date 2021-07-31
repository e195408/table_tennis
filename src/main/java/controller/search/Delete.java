package controller.search;

import model.opponent.Opponent;
import model.opponent.OpponentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // idをうけとる
        // id

//
//        ArrayList<Opponent> opponentList = new ArrayList<>();
//        OpponentDAO opponentDAO = new OpponentDAO();
//        opponentList = opponentDAO.searchOpponentList();

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        response.sendRedirect("/Search");
    }
}