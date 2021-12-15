CREATE DATABASE IF NOT EXISTS api_database;
USE api_database;

CREATE TABLE user(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name  VARCHAR(50),
	pseudo VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE gift(
	id INT PRIMARY KEY NOT NULL  AUTO_INCREMENT,
	name  VARCHAR(50),
	url  VARCHAR(100),
    prix FLOAT,
	img  VARCHAR(100),
	userIdWant INT,
	userIdOffer INT,
    FOREIGN KEY (userIdWant) REFERENCES user(id),
    FOREIGN KEY (userIdOffer) REFERENCES user(id)
);