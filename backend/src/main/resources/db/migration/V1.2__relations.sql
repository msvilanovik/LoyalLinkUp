CREATE TABLE if not exists clients_events
(
    id bigserial primary key,
    event_id bigserial not null,
    client_id bigserial not null,

    constraint client_id_fk  foreign key (client_id) references clients(client_id) on delete set null,
    constraint event_id_fk  foreign key (event_id) references events(event_id) on delete set null
);

CREATE TABLE if not exists favorites
(   favorites_id bigserial primary key,
    business_id bigserial not null,
    client_id bigserial not null,

    constraint client_id_fk  foreign key (client_id) references clients(client_id) on delete set null,
    constraint business_id_fk  foreign key (business_id) references businesses(business_id) on delete set null
);

CREATE TABLE if not exists points
(
    points_id bigserial primary key,
    business_id bigserial not null,
    client_id bigserial not null,
    loyal_points int,
    loyal_awards int,

    constraint client_id_fk  foreign key (client_id) references clients(client_id) on delete set null,
    constraint business_id_fk  foreign key (business_id) references businesses(business_id) on delete set null
);

