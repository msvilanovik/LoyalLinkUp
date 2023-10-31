CREATE TABLE if not exists events
(
    event_id bigserial primary key,
    name    text,
    date_time timestamp,
    type_of_event text,
    capacity int,
    business_id bigserial,
    constraint business_fk
        foreign key (business_id) references businesses(business_id) on delete set null
);


CREATE TABLE if not exists reviews
(
    review_id bigserial primary key,
    date_time timestamp,
    comment text,
    grade int,
    business_id bigserial,
    client_id bigserial,
    event_id bigserial,

    constraint business_fk foreign key (business_id) references businesses(business_id) on delete set null,
    constraint client_id_fk foreign key (client_id) references clients(client_id) on delete set null,
    constraint event_id_fk foreign key (event_id) references events(event_id) on delete set null

);
