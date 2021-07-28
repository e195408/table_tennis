<%--
  Created by IntelliJ IDEA.
  User: narasakinayu
  Date: 2021/07/28
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新規対戦相手登録</title>
</head>
<body>
<p>相手の情報を入力してください</p>
<form action="/Opponent/New" method="post">
    <table>
        <tr>
            <tb>ID</tb>
            <tb><input type="number" name="id" required/></tb>
        </tr>
        <br>
        <tr>
            <tb>氏名</tb>
            <tb><input type="text" name="name" required/></tb>
        </tr>
    </table>
    <input type="submit" name="button" value="登録">
</form>
</body>
</html>
