<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新規ユーザー情報登録</title>
</head>
<body>
<h1>ユーザー情報を入力してください</h1>
<style>
    h1{font-size: 25px;
        color: darkslategray;
    }
</style>
<form action="/User/SignUp" method="post">
    <table>
        <tr>
            <td>氏名</td>
            <td><input type="text" name="name" required /></td>
        </tr>
        <tr>
            <td>メールアドレス</td>
            <td><input type="email" name="mail" required /></td>
        </tr>
        <tr>
            <td>パスワード</td>
            <td><input type="password" name="ps" maxlength="20" required></td>
        </tr>
        <tr>
            <td>秘密の質問</td>
            <td>
                <select name="question" class="form-select">
                    <option selected>選択してください</option>
                    <c:forEach var="question" items="${question}">
                        <option value="${question.id}"><c:out value="${question.content}"/></option>
                    </c:forEach>
                </select>
                →質問の答え
                <input type="answer" name="answer" required />
            </td>
        </tr>
    </table>
    <input type="submit" name="button" value="登録" >
</form>
</body>
</html>