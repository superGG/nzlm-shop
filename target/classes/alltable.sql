

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

insert into types(id,typeName,parentTypeId) value(1,'苹果1',null);
insert into types(id,typeName,parentTypeId) value(2,'苹果2',1);
insert into types(id,typeName,parentTypeId) value(3,'苹果3',1);
insert into types(id,typeName,parentTypeId) value(4,'苹果4',3);
insert into types(id,typeName,parentTypeId) value(5,'苹果5',3);
insert into types(id,typeName,parentTypeId) value(6,'苹果6',1);
insert into types(id,typeName,parentTypeId) value(7,'苹果7',1);

select * from types;
