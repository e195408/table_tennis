package controller.search;

import model.match.Match;
import model.match.MatchDAO;
import model.opponent.Opponent;
import model.opponent.OpponentDAO;
import model.regist.RegistDAO;
import model.result.Result;
import model.result.ResultDAO;
import model.user.User;
import model.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet("/Search")
public class Search extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // sessionからuserIdを持ってくる
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");
        Integer userId = user.getId();

        // OpponentListを作成
        ArrayList<Opponent> opponentList = new ArrayList<>();
        OpponentDAO opponentDAO = new OpponentDAO();
        opponentList = opponentDAO.searchOpponentList(userId);

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("opponentList",opponentList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/search/search.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //requestオブジェクトから情報を取り出す
        Integer opponentId = Integer.parseInt(request.getParameter("opponent"));

        ResultDAO resultDAO = new ResultDAO();
        ArrayList<Result> resultList = resultDAO.searchResultList(opponentId);
        request.setAttribute("resultList", resultList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/search/result.jsp");
        dispatcher.forward(request, response);
    }
}