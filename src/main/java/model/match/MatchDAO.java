package model.match;

import lib.mysql.Client;
import model.Default;
import model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;

public class MatchDAO extends Client{
    private static HttpServletRequest httpServletRequest;
    private static Default user;

    //Match登録メソッド
    public static void registMatch(Match match) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQLコマンド
            String sql = "insert into matches (id,name,round) values(?, ?, ?)";

            connection = create();

            //SQLコマンドの実行
            stmt = connection.prepareStatement(sql);

            //SQLコマンドの?に値を代入する
            stmt.setInt(1, match.getId());
            stmt.setString(2, match.getName());
            stmt.setString(3, match.getRound());

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public ArrayList<Match> searchMatchList(Integer userId){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            ArrayList<Match> list = new ArrayList<Match>();
            // SQLコマンド
            String sql = "select * from matches inner join regists on matches.id = regists.matches_id where users_id = '" + userId + "'";
            connection = create();
            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next())
            {
                Match match = new Match(rs.getInt(1),rs.getString(2),rs.getString(3));
                list.add(match);
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