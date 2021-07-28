package model.opponent;
//  自分が格納されているフォルダの外にある必要なクラス

import lib.mysql.Client;
import model.user.User;

import java.sql.*;

public class OpponentDAO extends Client {
    //User登録メソッド
    public static void registOpponent(Opponent opponent) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQLコマンド
            String sql = "insert into opponents (id,name) values(?,?)";

            connection = create();

            //SQLコマンドの実行
            stmt = connection.prepareStatement(sql);

            //現在時間の取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            //SQLコマンドの?に値を代入する
            stmt.setInt(1, opponent.getId());
            stmt.setString(2, opponent.getName());

            stmt.executeUpdate();
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