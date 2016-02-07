create table board (
  bno int generated always as identity(start with 1, increment by 1) primary key,
  btitle varchar(100) not null,
  bcontent varchar(4000) not null,
  bdate timestamp not null,
  mid varchar(10) references member(mid)
);

insert into board (btitle, bcontent, bdate, mid) values ('Spring', 'Spring을 이용한 MVC 웹 애플리케이션', sysdate, 'test');