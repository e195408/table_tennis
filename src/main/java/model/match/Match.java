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
//
//    //controller/match/New.javaからの呼び出し
//    public void registMatch(){
//        MatchDAO.registMatch(this);
//    }
//
//    //User認証の機構
//    public boolean authenticateUser(HttpServletRequest request) {
//        //Mailをもとにユーザーが存在するか調べる
//        model.user.User persistedUser = UserDAO.selectUserByMail(this.mail);
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
