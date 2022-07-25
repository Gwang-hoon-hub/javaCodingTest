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