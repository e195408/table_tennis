package model.opponent;
//  自分が格納されているフォルダの外にある必要なクラス

import lib.mysql.Client;
import model.match.Match;
import model.user.User;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;

public class OpponentDAO extends Client {
    //User登録メソッド
    public static void registOpponent(Opponent opponent) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQLコマンド
            String sql = "insert into opponents (name,users_id) values(?,?)";

            connection = create();

            //SQLコマンドの実行
            stmt = connection.prepareStatement(sql);

            //現在時間の取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            //SQLコマンドの?に値を代入する
            stmt.setString(1, opponent.getName());
            stmt.setInt(2, opponent.getUserId());

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }

    public ArrayList<Opponent> searchOpponentList(Integer userId){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            ArrayList<Opponent> list = new ArrayList<Opponent>();
            // SQLコマンド
            String sql = "select * from opponents where users_id = '" + userId + "'";
            connection = create();
            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next())
            {
                Opponent opponent = new Opponent(rs.getInt(1),rs.getString(2),rs.getInt(3));
                list.add(opponent);
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