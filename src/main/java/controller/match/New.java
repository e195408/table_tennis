package controller.match;

import  model.match.Match;
import model.match.MatchDAO;
import model.regist.Regist;
import model.regist.RegistDAO;
import model.user.User;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Match/New")
public class New extends HttpServlet{
    private HttpServletRequest httpServletRequest;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/match/new.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //requestオブジェクトから情報を取り出す
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String round = request.getParameter("round");

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");
        Integer userId = user.getId();

        //Matchインスタンスの生成
        Match match = new Match(
                id,
                name,
                round
        );
        // Registインスタンスの生成
        Regist regist = new Regist(
                null,
                id,
                userId
        );

        MatchDAO.registMatch(match);
        RegistDAO.registRegists(regist);


        //成功したらsampleTest.javaにGETリクエストを送る
        response.sendRedirect("/success");
    }
}
