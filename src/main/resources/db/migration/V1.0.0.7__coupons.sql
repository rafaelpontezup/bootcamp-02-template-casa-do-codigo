create table coupons (
    id  bigserial not null,
    code varchar(255),
    discount numeric(19, 2),
    valid_until date,
    primary key (id)
);

alter table coupons
    add constraint uk_coupon_code unique (code);
