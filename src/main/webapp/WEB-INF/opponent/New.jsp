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
    <title>対戦相手登録画面</title>
</head>
<body>
<h1>相手の情報を入力してください</h1>
<form action="/Opponent/New" method="post">
    <table>
        <tr>
            <tb>氏名</tb>
            <tb><input type="text" name="name" required/></tb>
        </tr>
    </table>
    <input type="submit" name="button" value="登録">
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
