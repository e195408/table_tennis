package model.result;

import model.Default;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Result extends Default {

    //属性
    private Integer myScore;
    private Integer opponentScore;
    private Integer registId;
    private Integer opponentId;
    private String opponentName;

    //Servlet内で作るインスタンス用のコンストラクタ
    public Result(
            Integer id,
            Integer myScore,
            Integer opponentScore,
            Integer registId,
            Integer opponentId
    ) {
        super(id);
        //親クラスのインスタンスを呼び出す
        this.myScore = myScore;
        this.opponentScore = opponentScore;
        this.registId = registId;
        this.opponentId = opponentId;
    }


    //Servlet内で作るインスタンス用のコンストラクタ
    public Result(
            Integer id,
            Integer myScore,
            Integer opponentScore,
            Integer registId,
            Integer opponentId,
            String opponentName
    ) {
        super(id);
        //親クラスのインスタンスを呼び出す
        this.myScore = myScore;
        this.opponentScore = opponentScore;
        this.registId = registId;
        this.opponentId = opponentId;
        this.opponentName = opponentName;
    }

    //setメソッド
    public void setMyScore(Integer myScore) { this.myScore = myScore; }
    public void setOpponent(Integer opponentScore){ this.opponentScore = opponentScore; }
    public void setRegistId(Integer registId){ this.registId = registId; }
    public void setOpponentId(Integer opponentId){ this.opponentId = opponentId; }
    public void setOpponentName(String opponentName){ this.opponentName = opponentName; }

    //getメソッド
    public Integer getMyScore(){ return this.myScore; }
    public Integer getOpponentScore(){ return this.opponentScore; }
    public Integer getRegistId(){ return this.registId; }
    public Integer getOpponentId(){ return this.opponentId; }
    public String getOpponentName(){ return this.opponentName; }

//    //User認証の機構
//    public boolean authenticateUser(HttpServletRequest request) {
//        //Mailをもとにユーザーが存在するか調べる
//        User persistedUser = UserDAO.selectUserByMail(this.mail);
//        if (persistedUser == null) {    //Mailをもつユーザーがいなければ
//            return false;
//        }
//        //ここからはMailをもつユーザーがいればの話
//        this.hashPassword();    //入力されたパスワードをハッシュ化
//        if (this.ps.equals(persistedUser.ps)) { //ハッシュ化したものとDBのパスワードが一致すれば
//            HttpSession session = request.getSession(); //セッションを作って
//            session.setAttribute(currentUserKey, persistedUser);    //セッションスコープにユーザー情報保存
//            return true;
//        } else {    //パスワードが違ったらfalseを返す
//            return false;
//        }
//    }

}
