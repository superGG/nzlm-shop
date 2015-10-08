

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

insert into types(id,typeName,parentTypeId) values (1,'电子产品',null);
insert into types(id,typeName,parentTypeId) values (2,'U盘',1);
insert into types(id,typeName,parentTypeId) values (3,'手机',1);
insert into types(id,typeName,parentTypeId) values (4,'魅族',3);
insert into types(id,typeName,parentTypeId) values (5,'iphone',3);
insert into types(id,typeName,parentTypeId) values (6,'小米',3);
insert into types(id,typeName,parentTypeId) values (7,'金士顿',2);
insert into types(id,typeName,parentTypeId) values (8,'Sandisk',2);
insert into types(id,typeName,parentTypeId) values (9,'东芝',2);


select * from goods;
