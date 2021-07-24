package model.user;

import model.Default;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class User extends Default {
    public final static String currentUserKey = "currentUser";

    //属性
    private String name;
    private String mail ;
    private String ps ;
    private String answer ;
    private Integer questionId ;

    //Servlet内で作るインスタンス用のコンストラクタ
    public User(
            Integer id,
            String name,
            String mail,
            String ps,
            String answer,
            Timestamp createdAt,
            Timestamp updatedAt,
            Integer questionId
    ){
        super(id, createdAt, updatedAt);
        //親クラスのインスタンスを呼び出す
        this.name = name;
        this.mail = mail;
        this.ps = ps;
        this.questionId = questionId;
        this.answer = answer;
    }

    //setメソッド
    public void setName(String name){this.name = name; }
    public void setMail(String mail){this.mail = mail; }
    public void setPs(String ps){this.ps = ps; }
    public void setQuestionId(Integer questionId){this.questionId = questionId;}
    public void setAnswer(String answer){this.answer = answer;}

    //getメソッド
    public String getName(){ return this.name; }
    public String getMail(){ return this.mail; }
    public String getPs(){ return this.ps; }
    public Integer getQuestionId(){ return this.questionId; }
    public String getAnswer(){ return this.answer; }

    //controller/User/SignUp.javaからの呼び出し
    public void registUser(){
        this.hashPassword();
        UserDAO.registUser(this);
    }

    //User認証の機構
    public boolean authenticateUser(HttpServletRequest request) {
        //Mailをもとにユーザーが存在するか調べる
        User persistedUser = UserDAO.selectUserByMail(this.mail);
        if (persistedUser == null) {    //Mailをもつユーザーがいなければ
            return false;
        }
        //ここからはMailをもつユーザーがいればの話
        this.hashPassword();    //入力されたパスワードをハッシュ化
        if (this.ps.equals(persistedUser.ps)) { //ハッシュ化したものとDBのパスワードが一致すれば
            HttpSession session = request.getSession(); //セッションを作って
            session.setAttribute(currentUserKey, persistedUser);    //セッションスコープにユーザー情報保存
            return true;
        } else {    //パスワードが違ったらfalseを返す
            return false;
        }
    }

    //ハッシュ化
    public void hashPassword(){
        this.ps=getHash(this.mail,this.ps);
    }
    private String getHash(String email, String password) {
        final String HASH_ALGORITHM = "SHA-256";
        final int STRETCH_COUNT = 1024;
        final String FIXED_SALT = "vBjRGHZ6awqJL9JDQuNftAzaPSnHszQN";
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String salt = email + FIXED_SALT;
        messageDigest.update(salt.getBytes());
        byte[] hashed = messageDigest.digest(password.getBytes());
        for (int i = 0; i < STRETCH_COUNT; i++) {
            hashed = messageDigest.digest(hashed);
        }
        return getHexString(hashed);
    }
    private String getHexString(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(Integer.toHexString((bytes[i] >> 4) & 0x0f));
            stringBuffer.append(Integer.toHexString(bytes[i] & 0x0f));
        }
        return stringBuffer.toString();
    }

//    public static User getCurrentUser(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        return (User) session.getAttribute(currentUserKey);
//    }
//    //セッションスコープからcurrentUserKeyを取り除く
//    public static void logoutUser(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.removeAttribute(currentUserKey);
//    }

}
