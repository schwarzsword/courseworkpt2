create type role as enum ('user', 'admin', 'expert');
create type state as enum ('on_admin_verifying', 'on_expert_verifying', 'on_market', 'sold');

create table painting(
id serial primary key,
name varchar(50),
author varchar(50),
description text,
img text
);

create table registration(
id serial primary key,
login varchar (30) unique,
password text
);

create table users(
id serial primary key,
name varchar(50),
surname varchar(50),
regist integer unique not null check (regist > 0) references registration(id),
mail varchar(255) unique,
phone varchar (20) unique,
role role
);

create table wallet(
id serial primary key,
owner integer unique not null check (owner > 0) references users(id),
balance bigint check (balance > 0)
);

create table lot(
id serial primary key,
painting integer not null check (painting > 0) references painting(id),
start_date timestamp,
state state,
start_price bigint check (start_price>0),
seller integer check (seller > 0) references users(id)
);

create table end_date(
id serial primary key,
lot integer unique not null check (lot > 0) references lot(id),
expecting_date timestamp,
state boolean
);

create table payment(
id serial primary key,
source integer not null check (source > 0) references wallet(id),
destination integer not null check (destination > 0) references wallet(id),
sum bigint check (sum > 0)
);

create table deal(
id serial primary key,
sold_date integer unique check (sold_date > 0) references end_date(id),
customer integer check (customer > 0) references users(id),
payment integer unique not null check (payment > 0) references payment(id)
);