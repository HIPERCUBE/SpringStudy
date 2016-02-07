create table member (
  mid varchar(10) primary key,
  mname varchar(10) not null,
  mpassword varchar(10) not null
);

insert into member (mid, mname, mpassword) values ('test', '테스트', '12345');
