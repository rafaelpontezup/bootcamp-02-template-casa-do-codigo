create table categories (
    id  bigserial not null,
    name varchar(255),
    primary key (id)
);

alter table categories
    add constraint uk_category_name unique (name);
