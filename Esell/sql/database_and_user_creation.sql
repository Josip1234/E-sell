create database if not exists esell char set utf8mb4 collate utf8mb4_general_ci;
create user if not exists 'adminesell'@'localhost' identified by 'admin';
grant all privileges on esell.* to 'adminesell'@'localhost';
use esell; 
select * from users;