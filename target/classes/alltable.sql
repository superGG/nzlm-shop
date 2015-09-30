

drop database if exists solrshopping;

create database solrshopping;

use solrshopping;

create table goods(
	
	`id` int not null auto_increment,
	`goodsname` varchar(50),
	`description` varchar(50),
	`goodsattribute` varchar(50),
	`goodsprice` float,
	`goodspic` varchar(50),
	`goodsbrand` varchar(20),
	`goodstype` varchar(20),
	`ishot` boolean,
	`manufacturer` varchar(20),
	`goodslabel` varchar(50),
	`category` int,
	primary key (id)
);

create table `brand` (
	id int not null auto_increment,
	description varchar(20),
	attributkey  int,
	primary key(id)
);

create table `attribut` (
	id int not null auto_increment,
	attributeName varchar(20),
	primary key(id)
);