<?php
// defineの値は環境によって変えてください。
define('HOSTNAME', 'mysql57.syou.sakura.ne.jp');
define('DATABASE', 'syou_kaihatu');
define('USERNAME', 'syou');
define('PASSWORD', 'syou_it_kaihatu');

try {
  /// DB接続を試みる

  $dbh  = new PDO('mysql:host=' . HOSTNAME . ';dbname=' . DATABASE, USERNAME, PASSWORD);
  $msg = "MySQL への接続確認が取れました。";
  $id = htmlspecialchars($_GET['id'], ENT_QUOTES, 'UTF-8');
  $sql = "SELECT * FROM test where id = '{$id}'" ;

	// SQL実行
	$res = $dbh->query($sql);

	// 取得したデータを出力

	$test = $res->fetchAll(PDO::FETCH_ASSOC);
	Http_response_code(200);
	header("Content-type: application/json; charset=UTF-8");
	header("X-Content-Type-Options:nosniff");
	print json_encode($test, JSON_PRETTY_PRINT|JSON_UNESCAPED_UNICODE|JSON_UNESCAPED_SLASHES);

} catch (PDOException $e) {
  $isConnect = false;
  $msg       = "MySQL への接続に失敗しました。<br>(" . $e->getMessage() . ")";
}
?>
