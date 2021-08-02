package model.question;

import model.Default;

public class Question extends Default {

    //属性
    private String content;

    //Servlet内で作るインスタンス用のコンストラクタ
    public Question(
            Integer id,
            String content
    ) {
        super(id);
        //親クラスのインスタンスを呼び出す
        this.content = content;
    }

    //setメソッド
    public void setContent(String content){this.content = content; }

    //getメソッド
    public String getContent(){ return this.content; }

}
