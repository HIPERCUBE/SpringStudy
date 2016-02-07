create table account (
  ano int generated always as identity(start with 1, increment by 1) primary key,
  owner varchar(10) not null,
  balance int not null
);

insert into account (owner, balance) values ('홍길동', 1000000);
insert into account (owner, balance) values ('스프링', 0);