CREATE DATABASE bankdb;

USE bankdb;

CREATE TABLE accounts(
    account_no INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    mobile VARCHAR(15),
    balance DOUBLE
);

CREATE TABLE transactions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    account_no INT,
    type VARCHAR(20),
    amount DOUBLE,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(account_no) REFERENCES accounts(account_no)
);
