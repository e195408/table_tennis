<%--
  Created by IntelliJ IDEA.
  User: narasakinayu
  Date: 2021/07/29
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>検索結果画面</title>
</head>
<body>
<p>検索結果一覧</p>
<table>
    <tr>
        <th>相手の名前</th>
        <th>自分の取ったセット数</th>
        <th>相手の点数</th>
    </tr>
    <br>
    <c:forEach var="result" items="${result}">
        <tr>
            <td>${result.opponentName}</td>
            <td>${result.myScore}</td>
            <td>${result.opponentScore}</td>
        </tr>
    </c:forEach>
</table>
<a href = /test>マイページへ移動する</a><br>
</body>
</html>
