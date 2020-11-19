create table countries (
    id  bigserial not null,
    name varchar(255),
    primary key (id)
);

alter table countries
    add constraint uk_country_name unique (name);
