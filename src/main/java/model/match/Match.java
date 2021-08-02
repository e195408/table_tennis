package model.match;

import model.Default;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Match extends Default{

    //属性
    private String name;
    private String round;

    //Servlet内で作るインスタンス用のコンストラクタ
    public Match(
            Integer id,
            String name,
            String round
    ){
        super(id);
        //親クラスのインスタンスを呼び出す
        this.name = name;
        this.round = round;
    }

    //setメソッド
    public void setName(String name){this.name = name; }
    public void setRound(String round){this.round = round; }

    //getメソッド
    public String getName(){ return this.name; }
    public String getRound(){ return this.round; }

    //Matchを登録するメソッド
    public static void registMatch(Match match) {
        MatchDAO.registMatch(match);
    }

}
