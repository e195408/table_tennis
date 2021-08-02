package model.regist;

import lib.mysql.Client;
import model.Default;
import model.opponent.Opponent;
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

    // MatchIdからRegistIdを検索するメソッド
    public static Integer selectRegistByMatch(Integer matchId) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select id from regists where matches_id = ?";
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

    public static void registRegists(Regist regist) {
    //Regist登録メソッド
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQLコマンド
            String sql = "insert into regists (matches_id,users_id) values(?,?)";

            connection = create();

            //SQLコマンドの実行
            stmt = connection.prepareStatement(sql);

            //現在時間の取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            //SQLコマンドの?に値を代入する
            stmt.setInt(1, regist.getMatchId());
            stmt.setInt(2, regist.getUserId());

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }
}