package controller.opponent;

import model.opponent.Opponent;
import model.opponent.OpponentDAO;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Opponent/New")
public class New extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/opponent/New.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //requestオブジェクトから情報を取り出す
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");

        //Opponentインスタンスの生成
        Opponent opponent = new Opponent(
                null,
                name,
                user.getId()
        );

        Opponent.registOpponent(opponent);

        //成功したらsampleTest.javaにGETリクエストを送る
        response.sendRedirect("/success");
    }
}