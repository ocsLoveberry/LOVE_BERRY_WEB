<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/LOVE_BERRY_WEB/css/Admin_addStuInfo.css">
<title>学生情報登録</title>
<title></title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">

$(function(){
	//学科が変更されたら発動！
	$('select[name="gakka_cd"]').change(function(){
		// 専攻：の処理

		// 親要素の選択
		// 選択中の学科のクラス名を取得！(R,S,G,B,L)
		var gakka_cd = $('select').val();

		// 専攻の要素数を取得！
		var count = $('select[name="senko_cd"]').children().length;

		// 子要素の処理①
		// 選考の要素数分、for文で処理！
		for (var i=0; i<count; i++){
			var senko = $('select[name="senko_cd"] option:eq(' + i +')');
			// 選択した学科と同じクラス名だった場合
			if(senko.attr("class") === gakka_cd){
				senko.show();
			}else{
				senko.hide();
			}
		}

		// 子要素の処理②
		// クラス：の処理
		count = $('select[name="class_gakka"]').children().length;
		for (var i=0; i<count; i++){
			var gakka = $('select[name="class_gakka"] option:eq(' + i +')');
			// 選択した学科と同じクラス名だった場合
			if(gakka.attr("class") === gakka_cd){
				$('#class_gakka').val(gakka_cd);
				gakka.show();
			}else{
				gakka.hide();
			}
		}

	})
})
</script>
</head>
<body>
<h1>学生情報登録</h1>
	<form action="AddStudentInformationServlet" method="post">
		学籍番号：	  <input type="text" name="seki_no" maxlength="6" placeholder="学籍番号を入力" required="required"><br>
		氏		名	：	  <input type="text" name="name" maxlength="10" placeholder="氏名を入力" required="required"><br>
		メッセージ：<input type="text" name="message" placeholder="メッセージを入力" required="required"><br>
		パスワード：<input type="password" name="password" placeholder="パスワードを入力" required="required"><br>
		<!-- パスワードのpattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 8文字以上で1文字以上の数字、小文字アルファベット、大文字アルファベットがそれぞれ含まれていること-->
		メールアドレス：<input type="text" name="mail_adress" placeholder="info@example.com"><br>
		<!-- メールアドレスのpattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" -->
		学科：
		<select name="gakka_cd" required="required">
			<option selected="selected" disabled="disabled">専攻を選択してください</option>
			<option value="R" class="R">大学併修学科</option>
			<option value="S" class="S">システム開発学科</option>
			<option value="G" class="G">ゲーム学科</option>		<!-- DBデータなし -->
			<option value="B" class="B">ビジネス学科</option>		<!-- DBデータなし -->
			<option value="L" class="L">短期養成学科</option>		<!-- DBデータなし -->
		</select><br>
		専攻：
		<select name="senko_cd" required="required">
			<option selected="selected" disabled="disabled">専攻を選択してください</option>
			<option value="r_system" class="R">大学システム専攻</option>
			<option value="r_business" class="R">大学ビジネス専攻</option>				<!-- DBデータなし -->
			<option value="r_game" class="R">大学ゲーム専攻</option>					<!-- DBデータなし -->
			<option value="r_medical_infomation" class="R">大学医療情報専攻</option>	<!-- DBデータなし -->
			<option value="g_create" class="G">ゲームクリエイト専攻</option>					<!-- DBデータなし -->
			<option value="g_program" class="G">ゲームプログラム専攻</option>					<!-- DBデータなし -->
			<option value="b_business" class="B">ビジネス専攻</option>					<!-- DBデータなし -->
			<option value="b_accounting_office" class="B">経理事務専攻</option>			<!-- DBデータなし -->
			<option value="b_medical_office" class="B">医療事務専攻</option>			<!-- DBデータなし -->
			<option value="s_system" class="J">システム専攻</option>
			<option value="s_net_security" class="S">ネットセキュリティ専攻</option>	<!-- DBデータなし -->
			<option value="s_program" class="S">プログラム専攻</option>					<!-- DBデータなし -->
			<option value="l_tanki_yousei" class="L">短期養成専攻</option>		<!-- DBデータなし&& 専攻もない -->
		</select><br>
		クラス：
		<select name="class_gakka" id="class_gakka" required="required">
			<option value="R" class="R">R</option>
			<option value="S" class="S">S</option>
			<option value="G" class="G">G</option>	<!-- DBデータなし -->
			<option value="B" class="B">B</option>	<!-- DBデータなし -->
			<option value="J" class="J">J</option>	<!-- DBデータなし -->
			<option value="L" class="L">L</option>	<!-- DBデータなし -->
			<option value="M" class="M">M</option>	<!--全然わからん！魔法！調べといて -->
		</select>
		<select name="class_year" required="required">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
		</select>
		<select name="class_AorB" required="required">
			<option value="A">A</option>
			<option value="B">B</option>
		</select>
		<select name="class_1or2or3" required="required">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select><br>
		入学年度：
		<select name="year" required="required">
			<option value="">--</option>
			<option value="2000">2000</option>
			<option value="2001">2001</option>
			<option value="2002">2002</option>
			<option value="2003">2003</option>
			<option value="2004">2004</option>
			<option value="2005">2005</option>
			<option value="2006">2006</option>
			<option value="2007">2007</option>
			<option value="2008">2008</option>
			<option value="2009">2009</option>
			<option value="2010">2010</option>
			<option value="2011">2011</option>
			<option value="2012">2012</option>
			<option value="2013">2013</option>
			<option value="2014">2014</option>
			<option value="2015">2015</option>
			<option value="2016">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
			<option value="2020">2020</option>
			<option value="2021">2021</option>
			<option value="2022">2022</option>
			<option value="2023">2023</option>
			<option value="2024">2024</option>
			<option value="2025">2025</option>
			<option value="2026">2026</option>
			<option value="2027">2027</option>
			<option value="2028">2028</option>
			<option value="2029">2029</option>
			<option value="2030">2030</option>
			<option value="2031">2031</option>
			<option value="2032">2032</option>
			<option value="2033">2033</option>
			<option value="2034">2034</option>
			<option value="2035">2035</option>
			<option value="2036">2036</option>
			<option value="2037">2037</option>
			<option value="2038">2038</option>
			<option value="2039">2039</option>
			<option value="2040">2040</option>
			<option value="2041">2041</option>
			<option value="2042">2042</option>
			<option value="2043">2043</option>
			<option value="2044">2044</option>
			<option value="2045">2045</option>
			<option value="2046">2046</option>
			<option value="2047">2047</option>
			<option value="2048">2048</option>
			<option value="2049">2049</option>
			<option value="2050">2050</option>
			<option value="2051">2051</option>
			<option value="2052">2052</option>
			<option value="2053">2053</option>
			<option value="2054">2054</option>
			<option value="2055">2055</option>
			<option value="2056">2056</option>
			<option value="2057">2057</option>
			<option value="2058">2058</option>
			<option value="2059">2059</option>
			<option value="2060">2060</option>
			<option value="2061">2061</option>
			<option value="2062">2062</option>
			<option value="2063">2063</option>
			<option value="2064">2064</option>
			<option value="2065">2065</option>
			<option value="2066">2066</option>
			<option value="2067">2067</option>
			<option value="2068">2068</option>
			<option value="2069">2069</option>
			<option value="2070">2070</option>
			<option value="2071">2071</option>
			<option value="2072">2072</option>
			<option value="2073">2073</option>
			<option value="2074">2074</option>
			<option value="2075">2075</option>
			<option value="2076">2076</option>
			<option value="2077">2077</option>
			<option value="2078">2078</option>
			<option value="2079">2079</option>
			<option value="2080">2080</option>
			<option value="2081">2081</option>
			<option value="2082">2082</option>
			<option value="2083">2083</option>
			<option value="2084">2084</option>
			<option value="2085">2085</option>
			<option value="2086">2086</option>
			<option value="2087">2087</option>
			<option value="2088">2088</option>
			<option value="2089">2089</option>
			<option value="2090">2090</option>
			<option value="2091">2091</option>
			<option value="2092">2092</option>
			<option value="2093">2093</option>
			<option value="2094">2094</option>
			<option value="2095">2095</option>
			<option value="2096">2096</option>
			<option value="2097">2097</option>
			<option value="2098">2098</option>
			<option value="2099">2099</option>
			<option value="2100">2100</option>
		</select>年<br>

		<input type="submit" value="送信">
	</form>
	<form action="ShowTopServlet"><input type="submit" value=" " id="back"></form>
</body>
</html>