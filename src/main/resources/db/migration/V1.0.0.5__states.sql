create table states (
    id  bigserial not null,
    name varchar(255),
    country_id int8 not null,
    primary key (id)
);

alter table states
    add constraint uk_state_name unique (name);

alter table states
    add constraint FKskkdphjml9vjlrqn4m5hi251y
    foreign key (country_id)
    references countries;
