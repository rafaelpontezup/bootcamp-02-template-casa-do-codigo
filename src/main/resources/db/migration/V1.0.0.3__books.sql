create table books (
    id  bigserial not null,
    abstract varchar(500),
    isbn varchar(255),
    pages int4 not null check (pages>=100),
    price numeric(19, 2) not null check (price>=20),
    published_at date not null,
    summary varchar(255),
    title varchar(255),
    author_id int8 not null,
    category_id int8 not null,
    primary key (id)
);

alter table books
    add constraint uk_book_title unique (title);

alter table books
    add constraint uk_book_isbn unique (isbn);

alter table books
    add constraint FKfjixh2vym2cvfj3ufxj91jem7
    foreign key (author_id)
    references authors;

alter table books
    add constraint FKleqa3hhc0uhfvurq6mil47xk0
    foreign key (category_id)
    references categories;
