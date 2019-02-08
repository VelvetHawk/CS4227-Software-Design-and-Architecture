CREATE DATABASE accounts;
USE accounts;
CREATE USER sqluser IDENTIFIED BY 'sqluserpw';
grant usage on *.* to sqluser@localhost identified by 'sqluserpw'; 
grant all privileges on accounts.* to sqluser@localhost;
CREATE TABLE takeawayaccounts(id INT NOT NULL AUTO-INCREMENT, username VARCHAR(30) NOT NULL, password VARCHAR(30) NOT NULL, PRIMARY KEY(id) );
INSERT INTO takeawayaccounts(default, 'Joe Bloggs', 'password');
