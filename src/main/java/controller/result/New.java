package controller.result;

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
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet("/Result/New")
public class New extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Match> list = new ArrayList<>();
        // MatchManagerオブジェクトの生成
        MatchDAO manager = new MatchDAO();
        // 大会名をlistに返す
        list = manager.searchMatchList();

        // OpponentListを作成
        ArrayList<Opponent> opponentList = new ArrayList<>();
        OpponentDAO opponentDAO = new OpponentDAO();
        opponentList = opponentDAO.searchOpponentList();

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("matchList",list);
        request.setAttribute("opponentList",opponentList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/result/New.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //requestオブジェクトから情報を取り出す
        Integer matchId = Integer.parseInt(request.getParameter("match"));
        Integer opponentId = Integer.parseInt(request.getParameter("opponent"));
        Integer myScore = Integer.parseInt(request.getParameter("myScore"));
        Integer opponentScore = Integer.parseInt(request.getParameter("opponentScore"));

        RegistDAO registDAO = new RegistDAO();
        Integer registId = RegistDAO.selectRegistByMatch(matchId);

        //Resultインスタンスの生成
        Result result = new Result(
                null,
                myScore,
                opponentScore,
                registId,
                opponentId
        );

        ResultDAO.registResult(result);

        //成功したらsampleTest.javaにGETリクエストを送る
        response.sendRedirect("/test");
    }
}