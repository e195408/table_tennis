<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: narasakinayu
  Date: 2021/07/28
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>対戦詳細登録</title>
</head>
<body>
<p>詳細を入力してください</p>
<form action=/Result/New method="post">
    <table>
        <tr>
            <tb>対戦した大会名</tb>
            <tb>
                <select name="match" class="form-select">
                    <option selected>選択してください</option>
                    <c:forEach var="matchList" items="${matchList}">
                        <option value="${matchList.id}"><c:out value="${matchList.name}${matchList.round}"/></option>
                    </c:forEach>
                </select>
            </tb>
        </tr>
        <br>
        <tr>
            <tb>対戦した相手名</tb>
            <tb>
                <select name="opponent" class="form-select">
                    <option selected>選択してください</option>
                    <c:forEach var="opponentList" items="${opponentList}">
                        <option value="${opponentList.id}"><c:out value="${opponentList.name}"/></option>
                    </c:forEach>
                </select>
            </tb>
        </tr>
        <br>
        <tr>
            <tb>自分の取ったセット数</tb>
            <tb><input type="number" name="myScore" max="4" required /></tb>
        </tr>
        <br>
        <tr>
            <tb>相手の取ったセット数</tb>
            <tb><input type="number" name="opponentScore" max="4" required /></tb>
        </tr>
    </table>
    <input type="submit" name="button" value="登録" >
</form>
</body>
</html>
