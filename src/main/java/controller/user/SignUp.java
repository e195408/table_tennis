package controller.user;

import model.user.User;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/User/SignUp")
public class SignUp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/users/signUp.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //requestオブジェクトから情報を取り出す
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String ps = request.getParameter("ps");
        Integer questionId = Integer.parseInt(request.getParameter("question"));
        String answer = request.getParameter("answer");

        //Userインスタンスの生成
        User user = new User(
                null,
                name,
                mail,
                ps,
                answer,
                null,
                null,
                questionId
        );

        user.registUser();

        //成功したらsampleTest.javaにGETリクエストを送る
        response.sendRedirect("/test");
    }
}