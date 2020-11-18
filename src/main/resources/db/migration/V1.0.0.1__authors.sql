create table authors (
    id  bigserial not null,
    name varchar(255),
    email varchar(255),
    description varchar(400),
    created_at timestamp,
    primary key (id)
);

alter table authors
    add constraint uk_author_email unique (email);
