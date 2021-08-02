<%--
  Created by IntelliJ IDEA.
  User: narasakinayu
  Date: 2021/07/26
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>試合情報登録画面</title>
</head>
<body>
<h1>試合情報を入力してください</h1>
<form action="/Match/New" method="post">
    <table>
        <tr>
            <tb>ID</tb>
            <tb><input type="id" name="id" required/></tb>
        </tr>
        <br>
        <tr>
            <tb>大会名</tb>
            <tb><input type="text" name="name" required/></tb>
        </tr>
        <br>
        <tr>
            <tb>試合段階</tb>
            <tb><input type="text" name="round" required/></tb>
        </tr>
        <br>
    </table>
    <input type="submit" name="button" value="登録">
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
