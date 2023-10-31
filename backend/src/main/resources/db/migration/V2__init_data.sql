insert into clients(name,surname,phone_number) values
                                                   ('Damjan','Boskovski','075447837'),
                                                   ('Marija','Siljanovska','072312322'),
                                                   ('Monika','Svilanovikj','075123432'),
                                                   ('Tamara','Simikj','078321932'),
                                                   ('Donce','Bojcev','075213332');

insert into addresses(city_name, street_name, street_number) values
                                                                 ('Skopje','Orce Nikolov', '105'),
                                                                 ('Tetovo' ,'Pariska ulica', '12'),
                                                                 ('Ohrid','Samoilova ulica', '1');

insert into businesses(name,phone_number,address,type_of_business) values
                                                                       ('Nadzak','023128113',1, 'RESTAURANT'),
                                                                       ('Netaville','021343321',2, 'CAFFE'),
                                                                       ('Public Room','023122233',3, 'BAR');


insert into events(name,date_time,type_of_event,capacity,business_id) values
                                                                          ('Retro 80s party','01.01.2023', 'THEME_PARTY', 100, 2),
                                                                          ('Retro 90s party','02.01.2023', 'AFTERPARTY', 100, 3),
                                                                          ('Easy family brunch!','10.01.2023', 'BRUNCH', 50, 1);
