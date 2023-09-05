<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles.css">
  <title>サンプル</title>
  <!-- ... FullCalendarのスタイルシートとスクリプトをHTMLファイルにインクルード ... -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/5.10.1/main.min.css" rel="stylesheet">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/5.10.1/main.min.js"></script>
</head>
  <header>
    <h1>サンプルHP</h1>
    <nav>
      <ul>
        <ol><a href="MeiboEntry">個別情報登録</a></ol>
        <ol><a href="ShowAllMeibo">名簿一覧</a></ol>
        <ol><a href="ShowAllShinamono">贈り物・貰い物一覧</a></ol>
        <ol><a href="ShinamonoEntry">贈り物・貰い物登録(仮)</a></ol>
      </ul>
    </nav>
  </header>
  
  <section class="main-content">
    <h2>大切な人との、ご縁をつづる。</h2>
    <p>贈り物・頂き物・記念日・年賀状送付管理・お年玉管理・弔慶事金額を一括管理</p>
  </section>

  <!-- カレンダーを表示するためのコンテナを作る -->
  <div id="calendar"></div>

  <!-- フッター ... -->

  <script>
    // ページが読み込まれたときに、FullCalendarのカレンダーを
    // 初期化し、表示するスクリプトを追加
    document.addEventListener('DOMContentLoaded', function() {
      var calendarEl = document.getElementById('calendar');

      var calendar = new FullCalendar.Calendar(calendarEl, {
        // カレンダーの設定オプション
        initialView: 'dayGridMonth', // カレンダーの初期表示ビュー
        events: [
          // イベントデータをここに追加
          // { title: 'イベント名', start: '開始日時', end: '終了日時' }
        ]
      });

      calendar.render(); // カレンダーを表示
    });
  </script>

  <footer>
    <p>&copy; team フォレスト</p>
  </footer>
  <a href="Logoutinfo">ログアウト</a> <!--8/30追加-->
</body>
</html>