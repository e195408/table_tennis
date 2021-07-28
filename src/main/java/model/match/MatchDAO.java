package model.match;

import lib.mysql.Client;
import model.Default;
import model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class MatchDAO extends Client{
    private static HttpServletRequest httpServletRequest;
    private static Default user;

    //Match登録メソッド
    public static void registMatch(Match match,Integer userId) {
        Connection connection = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;

        try {
            //SQLコマンド
            String sql = "insert into matches (id,name,round) values(?, ?, ?)";
            String sql2 = "insert into regist (matches_id,users_id) values(?, ?)";

            connection = create();

            //SQLコマンドの実行
            stmt = connection.prepareStatement(sql);
            stmt2 = connection.prepareStatement(sql2);

            //SQLコマンドの?に値を代入する
            stmt.setInt(1, match.getId());
            stmt.setString(2, match.getName());
            stmt.setString(3, match.getRound());

            stmt2.setInt(1, match.getId());
            stmt2.setInt(2, userId);

            stmt.executeUpdate();
            stmt2.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

//
//    public static User selectUserByMail(String mail) {
//        Connection connection = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            String sql = "select * from users where mail = ?";
//            connection = create();
//            stmt = connection.prepareStatement(sql);
//            stmt.setString(1, mail);
//            rs = stmt.executeQuery();
//            //スコープの問題があるので一旦外で定義
//            User user = null;
//            if (rs.next()) {
//                user = new User(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getString("mail"),
//                        rs.getString("ps"),
//                        rs.getString("answer"),
//                        rs.getTimestamp("created_at"),
//                        rs.getTimestamp("updated_at"),
//                        rs.getInt("questions_id")
//                );
//            }
//            return user;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            close(connection, stmt, rs);
//        }
//    }

}