CREATE TABLE CAT(
    ID INTEGER PRIMARY KEY,
    NAME VARCHAR(10) NOT NULL,
    BIRTHDAY DATE NOT NULL,
    SEX CHAR(2),
    CAT_KIND VARCHAR(10) NOT NULL,
    IS_FOSTER_PARENTS BOOLEAN DEFAULT FALSE,
    COMMENT VARCHAR(100)
);

DROP TABLE CAT;
DELETE FROM CAT;

UPDATE CAT SET IS_FOSTER_PARENTS=0 WHERE ID=2;






insert into CAT
    values(001,'ちゃちゃ','2022-01-8','メス','ペルシャ',TRUE,
    'ご覧いただきありがとうございます。
    父 チンチラシルバー
    母 チンチラシルバー
    人懐っこくて元気いっぱいの子猫です。
    お問合せお待ちしております。'
);
insert into CAT
    values(002,'ダリア','2022-04-15','メス','アビシニアン',FALSE,
    'とても綺麗なブルーカラーちゃん♪
    可愛い?可愛い?女の子ニャン??
    お兄ちゃんと仲良く遊び、よく寝て、クスク成長中です。
    是非、是非、私に会いに来てニャン(=^x^=)'
);     
insert into CAT
    values(003,'レオン','2021-10-04','オス','ロシアンブルー',FALSE,
    '子猫の時猫風になり右目に後遺症がのこりました日常生活に問題ありません 
     たまに涙目になります 食欲旺盛で元気です 人懐こい子です 
     家族の一員として大事に飼ってくださる方'
);      
insert into CAT
    values(004,'すもも','2022-02-24','メス','バンビーノ',TRUE,
    '社交的でとても人懐っこく人が大好きです。お膝に乗るのも大好き
    寒がりさんなのでふっかふかの暖いベッドなど大好きです
    短足のブルー＆クリームの女の子'
);

insert into CAT
    values(005,'にゃんちゅう','2022-05-20','オス','カオマニー',FALSE,
    '穏やかな性格でちょっとビビリ屋さんです。
    この子も抱っこが、超大好きで誰とでもすぐ仲良しになれます。
    男の子は女の子と比べて筋肉質で身体はひと回り大きいです。'
);
insert into CAT
    values(006,'ビスケット','2022-01-17','オス','マルチカン',FALSE,
    'とても活発な子に成長しました。身体もしっかりとしてとても健康です。
    兄弟仲良くリビングの中を走り回って居ます。
    とても甘えん坊でいつもそばに居ます。一緒に寝てくれます。'
);
insert into CAT
    values(007,'ちゃちゃ','2021-11-15','オス','ベンガル',FALSE,
    '濃淡のグラデーション、カラー、バランスも型も大変美しい超美ロゼットの美少年?
    可愛いお顔だちの超甘えん坊 お膝大好き
    とても性格の良い穏やかな子です フタリ兄弟の弟君'
);
insert into CAT
    values(008,'ハゼル','2021-05-15','メス','メインクーン',FALSE,
    '大人しく可愛らしい女の子です。
    慎重派のため、馴れるまでに少し時間がかかるかもしれませんが、
    馴れると抱っこもさせてくれる甘えん坊さんです。'
);
insert into CAT
    values(009,'まりん','2018-07-30','メス','雑種',FALSE,
    '最初だけ人見知りするかもしれませんが人には慣れています。
    おやつの催促の時はデレデレしてくれます
    ゆっくり猫ちゃんのペースで仲良くなってあげて下さい。'
);
insert into CAT
    values(0010,'こてつ','2022-01-08','オス','雑種',FALSE,
    '個性的なお鼻の柄。
    シャーなど威嚇はありませんが人に対して怖さがあり人慣れがまだですが猫の飼育に
    慣れている方であれば大丈夫なのではと里親募集中です。'
);

SELECT ID,NAME,BIRTHDAY,timestampdiff(
    MONTH, BIRTHDAY, CURRENT_DATE) as AGE,SEX,CAT_KIND,IS_FOSTER_PARENTS,COMMENT 
    FROM CAT
    where IS_FOSTER_PARENTS =0
    ORDER BY ID
    
SELECT ID,NAME,BIRTHDAY,timestampdiff(
    MONTH, BIRTHDAY, CURRENT_DATE) as AGE,SEX,CAT_KIND,IS_FOSTER_PARENTS,COMMENT 
    FROM CAT
    where IS_FOSTER_PARENTS =1
    ORDER BY ID
    
    
    

