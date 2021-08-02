package model.opponent;

import model.Default;
import model.user.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Opponent extends Default {

    //属性
    private String name;
    private Integer userId;

    //Servlet内で作るインスタンス用のコンストラクタ
    public Opponent(
            Integer id,
            String name,
            Integer userId
    ) {
        super(id);
        //親クラスのインスタンスを呼び出す
        this.name = name;
        this.userId = userId;
    }

    //setメソッド
    public void setName(String name){this.name = name; }
    public void setUserId(Integer userId){ this.userId = userId;}

    //getメソッド
    public String getName(){ return this.name; }
    public Integer getUserId(){ return this.userId; }

    //Opponentを登録するメソッド
    public static void registOpponent(Opponent opponent) {
        OpponentDAO.registOpponent(opponent);
    }


}
