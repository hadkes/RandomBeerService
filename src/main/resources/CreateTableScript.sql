create database db_randombeer;
use db_randombeer;

DROP TABLE beer;
DROP TABLE provider;


CREATE TABLE provider
(
   name   				varchar(255) PRIMARY KEY,
   address1				varchar(255) NOT NULL,
   address2				varchar(255),
   state				varchar(255) NOT NULL,
   country				varchar(255) NOT NULL
);

CREATE TABLE beer
(
   id                   varchar(255) PRIMARY KEY,
   alcohol_percentage   double,
   cost                 double,
   description          varchar(1024),
   name                 varchar(255) NOT NULL,
   provider_name        varchar(255),
   FOREIGN KEY(provider_name) REFERENCES provider(name)
);

-- DROP TABLE review;
-- CREATE TABLE review
-- (
-- 	id					varchar(255) PRIMARY KEY,
-- 	reviewer			varchar(255) NOT NULL,
-- 	review 				varchar(255) NOT NULL,
-- 	beer_id				varchar(255),
-- 	FOREIGN KEY(beer_id) REFERENCES beer(id)
-- );