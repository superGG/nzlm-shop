

drop database if exists solrshopping;

create database solrshopping;

use solrshopping;

create table goods(
	
	`id` int not null auto_increment,
	`goodsname` varchar(50),
	`goodsattributes` varchar(50),
	`goodsprice` float,
	`goodspic` varchar(50),
	`ishot` boolean,
	`goodslabel` varchar(50),
	`typeId` Int(50),
	primary key (id)
);


create table `types` (
	id int not null auto_increment,
	typeName varchar(20),
	`parentTypeId` Int(50),
	primary key(id)
);