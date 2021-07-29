package model.regist;

import lib.mysql.Client;
import model.Default;
import model.regist.Regist;
import model.result.Result;
import model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;

public class RegistDAO extends Client {
    private static HttpServletRequest httpServletRequest;
    private static Default user;

//    //Result登録メソッド
//    public static void registResult(Result result) {
//        Connection connection = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            //SQLコマンド
//            String sql = "insert into results (my_score,opponent_score,regist_id,opponents_id) values(?, ?, ?,?)";
//
//            connection = create();
//
//            //SQLコマンドの実行
//            stmt = connection.prepareStatement(sql);
//
//            //SQLコマンドの?に値を代入する
//            stmt.setInt(1, result.getMyScore());
//            stmt.setInt(2, result.getOpponentScore());
//            stmt.setInt(3, result.getRegistId());
//            stmt.setInt(4, result.getOpponentId());
//
//            stmt.executeUpdate();
//            return;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return;
//        } finally {
//            close(connection, stmt, rs);
//        }
//    }

    // MatchIdからRegistIdを検索するメソッド
    public static Integer selectRegistByMatch(Integer matchId) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select id from regist where matches_id = ?";
            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, matchId);
            rs = stmt.executeQuery();
            rs.first();
            Regist regist = new Regist(
                    rs.getInt("id"),null,null
            );
            return regist.getId();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}