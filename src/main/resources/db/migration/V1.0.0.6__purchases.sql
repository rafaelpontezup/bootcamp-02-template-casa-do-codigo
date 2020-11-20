create table purchases (
    id  bigserial not null,
    address varchar(255),
    cep varchar(255),
    city varchar(255),
    complement varchar(255),
    document varchar(255),
    email varchar(255),
    name varchar(255),
    phone varchar(255),
    status varchar(255),
    surname varchar(255),
    country_id int8 not null,
    state_id int8,
    primary key (id)
);

create table purchase_items (
    purchase_id int8 not null,
    book_id int8,
    price numeric(19, 2),
    quantity int4 not null
);

alter table purchases
   add constraint FKmsy8nlhtypr7cyn88gch3vwyw
   foreign key (country_id)
   references countries;

alter table purchases
   add constraint FK9sd99xcal52tr2g340acxaw70
   foreign key (state_id)
   references states;

alter table purchase_items
   add constraint FKkr5i9sxtumc0uf1iml618td5d
   foreign key (book_id)
   references books;

alter table purchase_items
   add constraint FKhcski0jcuja0o3vhb7o15yqvi
   foreign key (purchase_id)
   references purchases;
