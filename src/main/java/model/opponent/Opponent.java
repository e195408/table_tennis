package model.opponent;

import model.Default;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Opponent extends Default {

    //属性
    private String name;

    //Servlet内で作るインスタンス用のコンストラクタ
    public Opponent(
            Integer id,
            String name
    ) {
        super(id);
        //親クラスのインスタンスを呼び出す
        this.name = name;
    }

    //setメソッド
    public void setName(String name){this.name = name; }

    //getメソッド
    public String getName(){ return this.name; }

//    //controller/User/SignUpUser.javaからの呼び出し
//    public void registUser(){
//        this.hashPassword();
//        UserDAO.registUser(this);
//    }

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
