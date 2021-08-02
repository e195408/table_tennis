
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>マイページ</title>
</head>
<body>
<h1>ようこそマイページへ</h1>
<style>
    h1{font-size: 25px;
        color: darkslategray;
    }
</style>
<p>試合情報を登録する場合は
    <a href = /Match/New>こちら</a>
</p>
<p>対戦相手を登録する場合は
    <a href = /Opponent/New>こちら</a>
</p>
<p>対戦結果を登録する場合は
    <a href = /Result/New>こちら</a>
</p>
<p>対戦結果を検索する場合は
    <a href = /Search>こちら</a>
</p>
<br>
<a href = /signOut>ログアウト</a>
</body>
</html>
