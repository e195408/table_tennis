package model.result;

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

public class ResultDAO extends Client{
    private static HttpServletRequest httpServletRequest;
    private static Default user;

    //Result登録メソッド
    public static void registResult(Result result) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQLコマンド
            String sql = "insert into results (my_score,opponent_score,regists_id,opponents_id) values(?, ?, ?,?)";

            connection = create();

            //SQLコマンドの実行
            stmt = connection.prepareStatement(sql);

            //SQLコマンドの?に値を代入する
            stmt.setInt(1, result.getMyScore());
            stmt.setInt(2, result.getOpponentScore());
            stmt.setInt(3, result.getRegistId());
            stmt.setInt(4, result.getOpponentId());

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public static void deleteResult(Integer deleteId) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQLコマンド
            String sql = "delete from results where id = '" + deleteId + "'";

            connection = create();

            //SQLコマンドの実行
            stmt = connection.prepareStatement(sql);

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public ArrayList<Result> searchResultList(Integer opponentId){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            ArrayList<Result> list = new ArrayList<Result>();
            // SQLコマンド
            String sql =
                    "select res.my_score,res.opponent_score,opp.name,r.name,r.round from results as res join opponents as opp on (res.opponents_id = opp.id)" +
                            "JOIN (SELECT reg.id,mat.name,mat.`round` FROM regists as reg JOIN matches as mat ON reg.matches_id = mat.id) AS r ON res.regists_id = r.id " +
                            "where opp.id =" + opponentId;
            connection = create();
            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next())
            {
                Result result = new Result(
                        null,
                        rs.getInt("res.my_score"),
                        rs.getInt("res.opponent_score"),
                        rs.getString("opp.name"),
                        rs.getString("r.name"),
                        rs.getString("r.round")
                );
                list.add(result);
                // 取得した情報を表示します。
            }
            return list;
        } catch (SQLException e) {
            // エラーが発生した場合、エラーの原因を出力する
            e.printStackTrace();
            return null;
        } finally {
            close(connection,stmt,rs);
        }
    }
}