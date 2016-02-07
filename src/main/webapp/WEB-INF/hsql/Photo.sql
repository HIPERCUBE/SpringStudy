create table photo (
	pno int generated always as identity(start with 1, increment by 1) primary key,
	pnation varchar(100) not null,
	plocation varchar(100) not null,
	pdate timestamp not null,
	poriginalfilename varchar(100) not null,
	psavedfilename varchar(100) not null,
	pmime varchar(100) not null,
	pdescription varchar(4000) not null
);

insert into photo (pnation, plocation, pdate, poriginalfilename, psavedfilename, pmime, pdescription) values ('오스트리아', '할슈타트', sysdate, 'photo1.jpg', 'photo1.jpg', 'image/jpeg',  '호숫가의 동화마을로 유명한 오스트리아 찰츠캄머구트 지역의 할슈타트는 소금도시라는 뜻을 가진 마을로 예전에는 소금광산으로 유명했습니다. 지금까지도 소금광산의 모습은 그대로 남아 있긴하지만 지금은 아름다운 호수와 동화 같은 마을 전경으로 더 유명하죠');
insert into photo (pnation, plocation, pdate, poriginalfilename, psavedfilename, pmime, pdescription) values ('체코', '프라하', sysdate, 'photo2.jpg', 'photo2.jpg', 'image/jpeg', '프라하는 체코의 수도이며, 아름답게 보전된 도시, 경이로운 건축양식, 무수히 많은 아름다운 옛 건물, 요리조리 연결된 골목길 그리고 카렐다리, 구시가 광장, 프라하 성 등 유명한 유적의 도시입니다. 1992년 866헥터에 이르는 고풍스런 시내중심이 UNESCO가 지정한 세계문화 및 자연유산에 등재되었습니다. 프라하의 아름다움은 매직에 가깝습니다. 그래서 한번 방문한 관광객은 언젠가 다시 한번 프라하를 찾을 수밖에 없습니다.');
insert into photo (pnation, plocation, pdate, poriginalfilename, psavedfilename, pmime, pdescription) values ('그리스', '산토리니', sysdate, 'photo3.jpg', 'photo3.jpg', 'image/jpeg', '그리스 산토리니의 푸른 바다와 하늘 그리고 하얀집들에서 흘러나오는 불빛의 아름다움이 마치 동화속의 그림같음');
insert into photo (pnation, plocation, pdate, poriginalfilename, psavedfilename, pmime, pdescription) values ('이탈리아', '로마', sysdate, 'photo4.jpg', 'photo4.jpg', 'image/jpeg', '로마도 볼것이 많아서 관광하기에는 안성맞춤이죠^^ 조금 걷기만해도 유물 유적이 나오는 곳이니 말이에요. 1위와 마찬가지로 여행할 때 주의해야 할 곳이 또 로마네요. 소매치기 좀도둑도 많은 편이고 요샌 위장경찰까지....여기도 조심합시다^^/ 맘편히 여행하는 그 날이 왔으면 좋겠네요.');
insert into photo (pnation, plocation, pdate, poriginalfilename, psavedfilename, pmime, pdescription) values ('스페인', '바르셀로나', sysdate, 'photo5.jpg', 'photo5.jpg', 'image/jpeg', '스페인을 여행한 많은 친구들이 마드리드보단 바르셀로나! 하고 외치던데.. 오늘은 독특한 건축물과 함께 활기가 넘치는 곳, 바르셀로나에서 보내고 싶어지네요.');
insert into photo (pnation, plocation, pdate, poriginalfilename, psavedfilename, pmime, pdescription) values ('이탈리아', '프렌체', sysdate, 'photo6.jpg', 'photo6.jpg', 'image/jpeg', '산 로렌초 성당과 메디치 예배당 관람을 마치고 미켈란젤로 광장(언덕)으로 가는 길이었다. 비는 다행히 그쳤지만 먹구름이 낀 날씨라 석양은 보기 힘들거 같다. 그래도 피렌체에서 계획했던 대부분의 일정은 마무리 지었고 두오모에서 못 본 상황에서 미켈란젤로 광장에서 피렌체 야경을 보는 건 당연한 수순.');
insert into photo (pnation, plocation, pdate, poriginalfilename, psavedfilename, pmime, pdescription) values ('프랑스', '프로방스', sysdate, 'photo7.jpg', 'photo7.jpg', 'image/jpeg', '프로방스(Provence)라는 말만 들어도 아련한 향수(鄕愁)에 젖습니다. 로맨틱하고 목가적인, 오늘날 도시인들이 잃은 황금의 이상향(理想鄕)같은 곳이란 감정이 일어납니다. 최근 여행기사에 자주 등장하고 있지만요.');
insert into photo (pnation, plocation, pdate, poriginalfilename, psavedfilename, pmime, pdescription) values ('오스트리아', '할슈타트', sysdate, 'photo8.jpg', 'photo8.jpg', 'image/jpeg', '고자우 호수를 갈 때 첫눈이 내리기 시작하더니, 그날 밤 할슈타트에는 어린 시절 꿈꾸던 크리스마스와 같은 광경이 동화책처럼 펼쳐졌다. 교회의 첨탑, 호수, 할슈타트의 그림 같은 집지붕 위에, 늦가을이 한창 앉아 있던 빛 고운 색색 깔의 단풍에 예기치 않은 마법의 은가루가 뿌려지면서 여행은 더욱더 운치가 있어졌다.');
insert into photo (pnation, plocation, pdate, poriginalfilename, psavedfilename, pmime, pdescription) values ('스위스', '바젤', sysdate, 'photo9.jpg', 'photo9.jpg', 'image/jpeg', '가끔 문득 스위스의 어떤 것들이 그리울 때가 있다. 처음엔 그렇게 답답하고, 불편했던 그 나라에 어느새 나도 조금씩 녹아들어 있었던 모양이다. 특히 겨울이 오면 그렇다. 찬바람이 옷깃을 여미게 하고, 손이 시려워 뜨것운 핫팩이 필요한 크리스마스 즈음에 말이다. 11월 말 부터 여기 저기 생기는 크리스마스 마켓의 아기자기한 불빛, 꽁꽁언 손을 뜨끈하게 녹여주는 뱅쇼, 신비롭게 거리를 감싸는 물안개... 그중에서도 한국으로 홀딱 들고 왔으면 좋겠는 것은 바로 바젤에서 열리는 크리스마스 마켓이다.');
insert into photo (pnation, plocation, pdate, poriginalfilename, psavedfilename, pmime, pdescription) values ('독일', '로텐부르크', sysdate, 'photo10.jpg', 'photo10.jpg', 'image/jpeg', '사진발(?)이 가장 좋다는 플뢴라인입니다. 로텐부르크는 걸어서 20분이면 도심의 끝에서 끝을 갈 수 있습니다. 어슬렁거리며 여유있게 산책하기에 정말 좋은 도시입니다. 특히 새벽에 산책나가보면 그렇게 평화롭고 아름다울 수가 없습니다. 이런 도시에서 하루 묵지 않고 그냥 휙 스쳐지나간다는 건 죄악(?)입니다. ');