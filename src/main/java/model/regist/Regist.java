package model.regist;

import model.Default;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Regist extends Default {

    //属性
    private Integer matchId;
    private Integer userId;

    //Servlet内で作るインスタンス用のコンストラクタ
    public Regist(
            Integer id,
            Integer matchId,
            Integer userId
    ) {
        super(id);
        //親クラスのインスタンスを呼び出す
        this.matchId = matchId;
        this.userId = userId;
    }

    //setメソッド
    public void setMatchId(Integer matchId){ this.matchId = matchId; }
    public void setUserId(Integer userId){ this.userId = userId; }

    //getメソッド
    public Integer getMatchId(){ return this.matchId; }
    public Integer getUserId(){ return this.userId; }

    //Registを登録するメソッド
    public static void registRegists(Regist regist) {
        RegistDAO.registRegists(regist);
    }
}
