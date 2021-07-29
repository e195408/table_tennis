<%--
  Created by IntelliJ IDEA.
  User: narasakinayu
  Date: 2021/07/29
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>検索画面</title>
</head>
<body>
<p>検索したい相手を入力してください</p>
<form  action="/Search" method="post">
    <table>
        <tr>
            <tb>対戦相手</tb>
            <tb>
                <select name="opponent" class="form-select">
                    <option selected>選択してください</option>
                    <c:forEach var="opponentList" items="${opponentList}">
                        <option value="${opponentList.id}"><c:out value="${opponentList.name}"/></option>
                    </c:forEach>
                </select>
            </tb>
        </tr>
    </table>
    <input type="submit" name="button" value="検索">
</form>
</body>
</html>
