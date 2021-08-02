package model.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static lib.mysql.Client.close;
import static lib.mysql.Client.create;

public class QuestionDAO{
    //questionを選択するためのメソッド
    public ArrayList<Question> searchQuestionList(){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            ArrayList<Question> list = new ArrayList<Question>();
            // SQLコマンド
            String sql = "select * from questions";
            connection = create();
            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next())
            {
                Question question = new Question(rs.getInt(1),rs.getString(2));
                list.add(question);
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
