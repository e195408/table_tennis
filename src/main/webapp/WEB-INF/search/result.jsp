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
<h1>検索結果一覧</h1>
<table>
    <tr>
        <th>相手の名前</th>
        <th>試合情報</th>
        <th>自分の取ったセット数</th>
        <th>相手の取ったセット数</th>
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
<%@ include file="../common/footer.jsp" %>
</body>
</html>
