package model.user;
//  自分が格納されているフォルダの外にある必要なクラス

import lib.mysql.Client;
import model.user.User;

import java.sql.*;
import java.util.Objects;

public class UserDAO extends Client {
    //User登録メソッド
    public static void registUser(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQLコマンド
            String sql = "insert into users (name,mail,ps,answer,created_at,updated_at,questions_id) values(?, ?, ?, ?, ?, ?, ?)";

            connection = create();

            //SQLコマンドの実行
            stmt = connection.prepareStatement(sql);

            //現在時間の取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            //SQLコマンドの?に値を代入する
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getMail());
            stmt.setString(3, user.getPs());
            stmt.setString(4, user.getAnswer());
            stmt.setTimestamp(5, currentTime);
            stmt.setTimestamp(6, currentTime);
            stmt.setInt(7, user.getQuestionId());

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static User selectUserByMail(String mail) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from users where mail = ?";
            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, mail);
            rs = stmt.executeQuery();
            //スコープの問題があるので一旦外で定義
            User user = null;
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("mail"),
                        rs.getString("ps"),
                        rs.getString("answer"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getInt("questions_id")
                );
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }

}