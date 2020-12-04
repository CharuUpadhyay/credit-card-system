DROP TABLE IF EXISTS card;

CREATE TABLE card (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250),
  balance FLOAT,
  number VARCHAR(250),
  credit_limit FLOAT
);

insert into card
values(10001,'Alice', '1045', '1111222233334444', 2000);

insert into card
values(10002,'Bob', '1044', '1111222233334445', 4000);