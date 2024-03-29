create table heroes_info_xxxx(
	id integer,
	name varchar(50),
	gender varchar(50),
	eye_color varchar(50),
	race varchar(50),
	hair_color varchar(50),
	height real,
	publisher varchar(100),
	skin_color varchar(50),
    alignment varchar(100),
	weight integer not null
);

select * from heroes_info_xxxx;

create table heroes(
	id integer generated by default as identity primary key ,
	name varchar(50) not null,
	gender varchar(50) not null,
	eye_color varchar(50) not null,
	race varchar(50) not null,
	hair_color varchar(50) not null,
	height real,
	publisher varchar(100),
	skin_color varchar(50) not null,
    alignment varchar(100) not null,
	weight integer not null
);

select * from heroes;

drop table heroes_info_xxxx;
drop table heroes;

insert into heroes(name, gender, eye_color, race, hair_color, height, publisher, skin_color, alignment, weight)
select name, gender, eye_color, race, hair_color, height, publisher, skin_color, alignment, weight
from heroes_info_xxxx;

--Середній зріст героїв (виключаючи зріст тих, який нуль або менше)
select  avg(weight), count(*) from heroes where weight >= 0;

-- Ім’я найвищого героя
select name, height from heroes where height = ( select  max(height) from heroes);

-- Ім’я самого важкого героя
select name, weight from heroes where weight = (select  max(weight) from heroes);

-- Кількість осіб в кожній гендерній групі
select gender, count(*) from heroes group by gender;

-- Кількість осіб в кожному угрупуванні (добро / зло / інші)
select alignment, count(*) from heroes group by alignment;

-- 5 назв самих популярних видавців
select publisher, count(*) from heroes group by publisher order by count desc limit 5


-- 3 назви найрозповсюдженіших кольорів волосся
select hair_color, count(*) from heroes group by hair_color order by count desc limit 3

-- Найрозповсюдженіший колір очей
select eye_color, count(*) from heroes group by eye_color order by count desc limit 1

-- ДОДАТКОВО

create table heroes_adv(
	id integer generated by default as identity primary key ,
	name varchar(50) not null,
	gender varchar(50) not null,
	eye_color varchar(50) not null,
	race varchar(50) not null,
	hair_color varchar(50) not null,
	height real,
	publisher varchar(100),
	skin_color varchar(50) not null,
    alignment varchar(100) not null,
	weight integer not null
);

insert into heroes_adv(name, gender, eye_color, race, hair_color, height, publisher, skin_color, alignment, weight)
select name, gender, eye_color, race, hair_color, height, publisher, skin_color, alignment, weight
from heroes;

create table publishers (
id integer generated by default as identity primary key ,
name varchar(100),
created_at timestamp default NOW()
);

insert into publishers(name)
select distinct publisher
from heroes;

select * from publishers;

-- мігрувати в неї всіх видавців (лише унікальні) з таблиці heroes

insert into heroes_adv(name, gender, eye_color, race, hair_color, height, publisher, skin_color, alignment, weight)
select name, gender, eye_color, race, hair_color, height, publisher, skin_color, alignment, weight
from heroes;

-- додати в heroes поле publisher_id (foreign key на id в publishers)

alter table heroes_adv add publisher_id integer;

foreign key (publisher_id) references publishers(id);

alter table heroes_adv
add constraint heroes_adv_publisher_fk
foreign key (publisher_id)
references publishers (id);

update heroes_adv
set publisher_id = (
select id from publishers where publishers.name = heroes_adv.publisher
);

select * from heroes_adv;

-- видалити колонку publisher з героїв

alter table heroes_adv drop column publisher;

select * from heroes_adv;

-- переписати запит: 5 назв самих популярних видавців
select publishers.name, counts.count
from(
	select publisher_id, count(*) as count
  from heroes_adv
  group by publisher_id
  order by count desc
  limit 5
) counts
join publishers on publishers.id = counts.publisher_id order by count desc;