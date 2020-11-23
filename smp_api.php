<?php

//ヘッダの設定、文字コードをutf-8に指定
header('charset=utf-8');

header('charset=utf-8');

//ここにPHPスクリプトを記述
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	//フォームリクエストの内容を取得
	$id = htmlspecialchars($_POST['id'], ENT_QUOTES, 'UTF-8');

	$url = "http://syou.sakura.ne.jp/api.php?id={$id}";
	$json = file_get_contents($url);
	$json = mb_convert_encoding($json,'UTF-8','ASCII,JIS,UTF-8,EVC-JP,SJIS-WIN');
	$data = json_decode($json);
	//var_dump($data);
}



?>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
	<h1>課題15 APIの取得</h1>

	<form action="smp_api.php" method="POST">
		<div>
			キーワード<input type="text" name="id">
			<button type="submit" name="sub" class="btn btn-primary">送信</button>
		</div>


	</form>
	<?php

	if(isset($data)){
		foreach ($data as $item) {
			print "{$item->name}{$item->class}";
		}
	}


	?>

	<!--ここからBootStrap用js読込-->
	<script type="text/javascript" src="js/jquery-3.3.1.slim.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
