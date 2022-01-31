drop table if exists workers;
create table workers
(
    n_id       bigserial       primary key,
    n_name     varchar(200) not null,
    d_birthday date         not null,
    c_phone    varchar(15)  not null,
    c_mail     varchar(100),
    n_type     varchar(100),
    n_company_id int references companies,
    b_status   boolean default true
);

insert into workers (n_name, d_birthday, c_phone, c_mail,  n_company_id)
VALUES ('Крирлл', '03.07.1990', '+99362534073', 'k2@mail.ru', 1);

insert into workers (n_name, d_birthday, c_phone, c_mail,  n_company_id)
VALUES ('Саид', '03.07.1990', '+99362534073', 'said@mail.ru', 3);

-- ==================================================================

drop table if exists workers_types;
create table workers_types
(
  n_id int not null primary key ,
  n_types int not null ,
  comment varchar(200)
);

insert into workers_types values (1, 100, 'таможенный союз');
insert into workers_types values (2, 200, 'снг( это те кто по патенту работает) ');
insert into workers_types values (3, 300, 'гражданин РФ');
insert into workers_types values (4, 400, 'иностранцы со статусом рвп и внж');
insert into workers_types values (5, 500, 'иностранцы со статусом внж');

-- ====================================================================

drop table if exists companies;
create table companies
(
  n_id serial  not null primary key ,
  c_company_name varchar(100) not null ,
  c_additonal varchar(100)
);

insert into companies (c_company_name, c_additonal) VALUES ('OOO GOGO', 'какая-то комапния');
insert into companies (c_company_name, c_additonal) VALUES ('OOO TODO', 'какая-то комапния');

-- ==================================================================

drop table if exists users;
create table users
(
    n_id bigserial primary key ,
    c_fio varchar(100) not null ,
    c_login varchar(100) not null ,
    c_password varchar(100) not null ,
    c_phone varchar(20),
    c_mail varchar(100),
    c_role int references roles
);

insert into users(c_fio, c_login, c_password, c_role) values ('Менеджер Антон','man_anton','anton',1);
insert into users(c_fio, c_login, c_password, c_role) values ('Босс Боссович','boss','boss',3);


-- ==================================================================

drop table if exists roles;
create table roles
(
    id serial primary key ,
    c_role_name varchar(50) not null ,
    c_comment varchar(200)
);

insert into roles (c_role_name) values ('MANAGER');
insert into roles (c_role_name) values ('ADMIN');
insert into roles (c_role_name) values ('BOSS');

-- ==================================================================

drop table if exists users_roles;
create table users_roles
(

)