<%--
  Created by IntelliJ IDEA.
  User: narasakinayu
  Date: 2021/06/22
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ログイン後画面</title>
</head>
<body>
<p>ログイン成功</p>
<p>あなたの名前は${currentUser.getName()}</p>
<a href = /Opponent/New>新規対戦相手登録</a>
</body>
</html>