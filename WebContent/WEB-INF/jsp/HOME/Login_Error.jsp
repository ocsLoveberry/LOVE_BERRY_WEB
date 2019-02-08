<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOVE BERRY ログインエラー</title>
</head>
<style>
/* 背景*/
body {
	max-width: 5000px;
	margin: auto auto;
	height: 100%;
	background-color: #ccc;
}

.sub {
	width: 300px;
	margin: auto auto;
}

h1 {
	text-align: center;
	font-size: 4em;
	color: #fff;
}

h2 {
	text-align: center;
	font-size: 2em;
	margin: 0px 40px;
	color: #000;
}

form {
	width: 400px;
	margin: auto auto;
}

#box {
	width: 500px;
	margin: auto auto;
}

h4 {
	text-align: center;
}

input[type="text"], input[type="password"] {
	width: 200px;
	padding: 3px;
	margin: 10px 0px 0px 10px;
	font-size: 16px;
	font: 15px/24px sans-serif;
	box-sizing: border-box; /*ボックスサイズの自動設定*/
	transition: 0.3s;
	letter-spacing: 1px;
	color: #aaaaaa;
	border: 1px solid #1b2538;
	border-radius: 4px;
}

input[type='text']:focus, input[type="password"]:focus {
	border: 1px solid #FF8000;
	outline: none;
	box-shadow: 0 0 5px 1px rgba(218, 60, 65, .5);
}

input[type="submit"], input[type="reset"] {
	position: relative; /*位置の設定（相対位置）*/
	display: inline-block; /*表示形式の設定*/
	padding: 0.25em 0.5em; /*内側の空白の設定*/
	text-decoration: none; /*テキストの見た目の設定*/
	color: #FFF; /*文字色の設定*/
	background: #fd9535; /*背景色*/
	border-bottom: solid 2px #d27d00; /*少し濃い目の色に*/
	border-radius: 4px; /*角の丸み*/
	box-shadow: inset 0 2px 0 rgba(255, 255, 255, 0.2), 0 2px 2px
		rgba(0, 0, 0, 0.19); /*ボタンの影の設定*/
	font-weight: bold; /*文字の太さの設定*/
	margin: 15px 15px 15px 40px;
	font-size: 16px;
}

input[type="submit"]:active { /*ボタンが押されたときの設定*/
	border-bottom: solid 2px #fd9535; /*ふちの設定*/
	box-shadow: 0 0 2px rgba(0, 0, 0, 0.30); /*影の設定*/
}
</style>
<body>
	<h1>LOVE BERRY</h1>
	<div id="box">
		<h2>ログインエラー</h2>
		<h4>ログインIDまたはパスワードに誤りがあります。</h4>
		<h4>再度入力してください。</h4>
		<a href="ShowTopServlet">戻る</a>
	</div>
</body>
</html>