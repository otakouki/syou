<?php

    //ヘッダの設定、文字コードをutf-8に指定
    header('charset=utf-8');

    //defineの値は環境によって変えてください。
    define('HOSTNAME', 'mysql57.syou.sakura.ne.jp');
    define('DATABASE', 'syou_kaihatu');
    define('USERNAME', 'syou');
    define('PASSWORD', 'syou_it_kaihatu');

      try {
        /// DB接続を試みる
        $db  = new PDO('mysql:host=' . HOSTNAME . ';dbname=' . DATABASE, USERNAME, PASSWORD);
        $msg = "MySQL への接続確認が取れました。";
      } catch (PDOException $e) {
        $isConnect = falses;
        $msg       = "MySQL への接続に失敗しました。<br>(" . $e->getMessage().")";
      }

      //SQL作成
      //qno,Linkecnt,questを取り出す(並べ替えに使う)
      $QA_q1 = 'SELECT QA_quest.Qno,QA_Anser.Anser,QA_quest.Likecnt,QA_quest.DT FROM QA_quest LEFT OUTER JOIN QA_Anser on QA_quest.Qno = QA_Anser.qno ';

      //質問表示(qnoかぶり無し)
      $QA_q = 'SELECT * FROM QA_quest LEFT OUTER JOIN QA_Anser
              on QA_quest.Qno = QA_Anser.qno GROUP BY QA_quest.Qno';

      //queryに$sqlを渡す
      $res_q = $db->query($QA_q);
      $res_q1 = $db->query($QA_q1);

      // 並び替え要素を取り出す
      foreach($res_q1 as $d){
        $qno[] = $d['Qno'];
        $Linkcnt[] = $d['Linkcnt'];
        $DT[] = $d['DT'];
      }

      // 配列にクエスト,アンサーを入れる
      foreach($res_q as $d){
        $qno_quest[] = $d['Qno'];
        $quest[] = $d['Quest'];
        $anser[] = $d['Anser'];
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
        <li><a href=”#”>質問する</a></li>
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
         <div class="">
         <?php
            // データベースの質問表示
            for($i = 0 ; $i < count($qno); $i++){
              echo "<div class='a'>".$quest[$i]."</div>";
              echo $anser[$i];
            }
          ?>
        </div>

          <?php //test($qnoq,$qnoa) ?>
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
