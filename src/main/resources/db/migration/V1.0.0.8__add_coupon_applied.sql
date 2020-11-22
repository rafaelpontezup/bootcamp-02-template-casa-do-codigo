alter table purchases
    add column coupon_id int8,
    add column discount numeric(19, 2),
    add column valid_until date;

alter table purchases
       add constraint FK4sqocqt2sv83kxdti1ebdc1aq
       foreign key (coupon_id)
       references coupons;
