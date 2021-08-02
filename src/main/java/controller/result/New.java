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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet("/Result/New")
public class New extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // sessionからuserIdを持ってくる
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");
        Integer userId = user.getId();

        // MatchListを作成
        ArrayList<Match> list = new ArrayList<>();
        MatchDAO matchDAO= new MatchDAO();
        // userIdからmatchListをさがす
        list = matchDAO.searchMatchList(userId);

        // OpponentListを作成
        ArrayList<Opponent> opponentList = new ArrayList<>();
        OpponentDAO opponentDAO = new OpponentDAO();
        // userIdからopponentListを探す
        opponentList = opponentDAO.searchOpponentList(userId);

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

        Result.registResult(result);

        //成功したらSuccess.javaにGETリクエストを送る
        response.sendRedirect("/success");
    }
}