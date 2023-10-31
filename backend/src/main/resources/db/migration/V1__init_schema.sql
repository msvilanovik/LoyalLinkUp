CREATE TABLE if not exists clients
(
    client_id bigserial primary key,
    name    text,
    surname text,
    phone_number varchar
);
CREATE TABLE if not exists addresses
(
    address_id bigserial primary key,
    city_name    text,
    street_name text,
    street_number text
);

CREATE TABLE if not exists businesses
(
    business_id bigserial primary key,
    name    text,
    address bigserial not null,
    phone_number varchar,
    type_of_business text,
    constraint address_fk
        foreign key (address) references addresses(address_id) on delete set null
);
