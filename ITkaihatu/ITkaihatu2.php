<?php

    //ヘッダの設定、文字コードをutf-8に指定
    header('charset=utf-8');

    // defineの値は環境によって変えてください。
    // define('HOSTNAME', 'mysql57.syou.sakura.ne.jp');
    // define('DATABASE', 'syou_kaihatu');
    // define('USERNAME', 'syou');
    // define('PASSWORD', 'syou_it_kaihatu');
    //
    //   try {
    //     /// DB接続を試みる
    //     $db  = new PDO('mysql:host=' . HOSTNAME . ';dbname=' . DATABASE, USERNAME, PASSWORD);
    //     $msg = "MySQL への接続確認が取れました。";
    //   } catch (PDOException $e) {
    //     $isConnect = falses;
    //     $msg       = "MySQL への接続に失敗しました。<br>(" . $e->getMessage() . ")";
    //   }
    //
    //    //SQL文を実行する
    //    $qry = $db->prepare('select * from test');
    //    $qry->execute();
    //
    //    //fetch文でSELECTした結果を取り出す
    //    foreach($qry->fetchAll() as $q){
    //    // 取り出したデータの処理
    //    echo
    //    }

    //データベースの内容を記入して列表示
       $fruits = array('kamo','バナナ', 'りんご', 'みかん', 'メロン', 'いちご');
       function display_list ($array) {
           $list = '<ul>';
           foreach ($array as $v) {
               $list .= '<li>'. $v .'</li>';
           }
           $list .= '</ul>';
           return $list;
       }
 ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>IT開発Q&A</title>
    <!-- 画面の大きさ調整 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="css/IT2.css">
  </head>
  <body>
    <!-- ヘッダー 上部のバーを表示する -->
    <header>
      <!-- ジャンルタイトルを表示する -->
        <div class="menutop">
          <h1>
            <a>Q&A</a>
          </h1>
        </div>
    <nav>
      <div class="collapse navbar-collapse" id="Navber">
        <!-- メニューバー 他の画面との行き来をする-->
      <ul>
        <li class="current"><a href=>ホーム</a></li>
        <li><a href=”#”>Q&A</a></li>
      </ul>
    </nav>
    </header>

    <!-- 質問ブロック -->
    <!-- javascript -->
    <!-- n件づつ取得 -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
     <script type="text/javascript" src="js/IT1.js"></script>

    <!-- 質問があれば以下に表示していく -->
    <div id="number_list">
       <ul class="list">
         <!-- 質問ボックス要素(質問内容、回答一つ、全回答表示ボタン) -->
         <?php
         // データベースの質問表示

            echo display_list($fruits);

          ?>
         <li>質問内容(タップで回答する)、回答(1件)、全件表示ボタン
         </li>
         <li>2</li>
         <li>3</li>
         <li>4</li>
         <li>5</li>
         <li>6</li>
         <li>7</li>
         <li>8</li>
         <li>9</li>
         <li>10</li>
       </ul>
      <!-- スワイプで表示するようにする -->
       <button type=button id="more_btn">もっと見る</button>
       <button type=button id="close_btn">表示数を戻す</button>
    </div>
  </body>
</html>
