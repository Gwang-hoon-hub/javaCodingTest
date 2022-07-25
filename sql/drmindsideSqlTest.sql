CREATE DATABASE drmInside;
use drmInside;

CREATE TABLE deposit(
                        txn_date date NULL,
                        amt numeric NULL
);

CREATE TABLE payout(
                       txn_date date NULL,
                       amt numeric NULL
);

INSERT INTO deposit (txn_date, amt)
values ('2021-01-01', 100000),
       ('2021-01-01', 100000),
       ('2021-03-01', 100000),
       ('2021-03-01', 100000),
       ('2021-05-01', 100000),
       ('2021-05-01', 100000),
       ('2021-05-01', 100000),
       ('2021-08-01', 100000),
       ('2021-08-01', 100000),
       ('2021-08-01', 100000),
       ('2021-12-01', 100000);

INSERT INTO payout (txn_date, amt)
values ('2021-01-01', 20000),
       ('2021-01-01', 20000),
       ('2021-04-01', 20000),
       ('2021-05-01', 20000),
       ('2021-06-01', 20000),
       ('2021-06-01', 20000),
       ('2021-11-01', 20000),
       ('2021-11-01', 20000),
       ('2021-12-01', 20000),
       ('2022-01-01', 20000);

SELECT d.txn_date, d.amt as d
FROM deposit as d
         LEFT OUTER JOIN payout as p
                         ON month(d.txn_date) = month(p.txn_date)
UNION
SELECT p.txn_date, p.amt as p
FROM deposit as d
         RIGHT OUTER JOIN payout as p
                          ON month(d.txn_date) = month(p.txn_date);

-- 월별 합계를 구하는 테이블을 각각 구현 -> 이제는 합쳐야 한다.
SELECT distinct txn_date, sum(d.amt) over(partition by txn_date) as depositSum
FROM deposit as d;

SELECT distinct txn_date, sum(p.amt) over(partition by txn_date) as payoutSum
FROM payout as p;

-- 현재 테이블 나옴 이제 계산을 하면된다.
SELECT data.txn_date, data.depositSum, data.payoutSum,
       data.depositSum - data.payoutSum as total_sum,
       sum(data.depositSum - data.payoutSum) over(order by data.txn_date) as accumal
from (
         SELECT distinct d.txn_date,
                         IFNULL(sum(d.amt) over(partition by d.txn_date), 0) as depositSum,
                         IFNULL(sum(p.amt) over(partition by p.txn_date), 0) as payoutSum
         FROM deposit as d
                  LEFT JOIN payout as p
                            ON d.txn_date = p.txn_date
         UNION
         SELECT distinct p.txn_date,
                         IFNULL(sum(d.amt) over(partition by d.txn_date), 0) as depositSum,
                         IFNULL(sum(p.amt) over(partition by p.txn_date), 0) as payoutSum
         FROM payout as p
                  LEFT JOIN deposit as d
                            ON d.txn_date = p.txn_date
     ) as data
order by data.txn_date;