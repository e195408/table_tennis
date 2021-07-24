<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ユーザーログイン</title>
</head>
<body>
<p>ユーザー情報を入力してください</p>
<form action="/sessions/new" method="post">
    <table>
        <tr>
            <td>メールアドレス</td>
            <td><input type="email" name="mail" required /></td>
        </tr>
        <tr>
            <td>パスワード</td>
            <td><input type="password" name="ps" maxlength="20" required></td>
        </tr>
    </table>
    <input type="submit" name="button" value="ログイン" >
</form>
</body>
</html>