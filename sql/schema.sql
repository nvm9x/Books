create table author
(
    id              serial8,
    author_name     varchar(20),
    author_lastname varchar(20),
    primary key (id)

);

drop table if exists author;

drop table if exists books;

drop table if exists author_book;

create table books(
                      id serial8,
                      book_name varchar(20),
                      published date not null,
                      primary key (id)

);


create table author_book(
    id serial8,
                            author_id int8 not null,
                            books_id int8 not null,
                            primary key (id),
                            foreign key (books_id) references books (id),
                            foreign key (author_id) references author(id)
);


insert into author(author_name, author_lastname)
values ('Илья', 'Ильф'),
       ('Евгений', 'Петров'),
       ('Аркадий', 'Стругацкий'),
       ('Борис', 'Стругацкий'),
       ('Стивен', 'Кинг'),
       ('Питер', 'Страуб');

insert into books( book_name, published)
values
       ('1001 день', '1929-01-21'),
       ('Пикник на обочине', '1972-02-02'),
       ('Трудно быть богом', '1963-10-11'),
       ('Талисман', '1984-05-06'),
       ('Черный дом', '1985-06-07');

insert into author_book(author_id, books_id)
values
       (2,2),
       (3,3),
       (4,3),
       (4,4),
       (5,5),
       (6,6);
