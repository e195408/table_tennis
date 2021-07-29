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

}
