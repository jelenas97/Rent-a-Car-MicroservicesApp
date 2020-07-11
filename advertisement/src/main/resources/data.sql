insert into fuel_type(name, active)
values ('Petrol', 1);
insert into fuel_type(name, active)
values ('Gas', 1);
insert into fuel_type(name, active)
values ('Diesel', 1);


insert into car_brand(name, active)
values ('Lamborghini', 1);
insert into car_brand(name, active)
values ('Special', 1);
insert into car_brand(name, active)
values ('Brand 3', 1);

insert into car_model(name, active, car_brand_id)
values ('FKP 37', 1, 1);
insert into car_model(name, active, car_brand_id)
values ('Bat 39', 1, 2);
insert into car_model(name, active, car_brand_id)
values ('Model 3', 1, 3);

insert into car_class(name, active)
values ('Sport car', 1);
insert into car_class(name, active)
values ('Batman car', 1);
insert into car_class(name, active)
values ('Class 3', 1);


insert into transmission_type(name, active)
values ('Manual', 1);
insert into transmission_type(name, active)
values ('Automatic', 1);
insert into transmission_type(name, active)
values ('Semi-Automatic', 1);

insert into price_list(price_per_day, price_per_km, cdw, creator_id)
values (1000, 20, 100, 3);
insert into price_list(price_per_day, price_per_km, cdw, creator_id)
values (2000, 50, 200, 3);



insert into car(available_tracking, kid_seats, mileage, name, rate, car_brand_id, car_class_id,
                transmission_type_id, car_model_id)
values (1, 2, 1000, 'Sián', 5.0, 1, 1, 3, 1);

insert into advertisement( discount, place, kilometres_limit, car_id, owner_id, price_list_id, start_date, end_date)
values ( 20, 'Novi Sad', 5000, 1, 3, 1, '2020-05-03', '2020-10-03');

insert into car(available_tracking, kid_seats, mileage, name, rate, car_brand_id, car_class_id,
                transmission_type_id, car_model_id)
values (1, 0, 10000, 'Batmobile', 10.0, 2, 2, 2,2);

insert into advertisement( discount, place, kilometres_limit, car_id, owner_id, price_list_id, start_date, end_date)
values ( 10, 'Novi Sad', 5000, 2, 4, 2, '2020-05-03', '2020-10-03');
--
insert into car(available_tracking,kid_seats, mileage, name, rate, car_brand_id, car_class_id,
                transmission_type_id, car_model_id)
values (1, 0, 10000,'NOVO', 10.0, 1, 1, 1,1);

insert into advertisement( discount, place, kilometres_limit, car_id, owner_id, price_list_id, start_date, end_date)
values ( 20, 'Novi Sad', 5000, 3, 1, 1, '2020-05-03', '2020-10-03');
--
insert into car(available_tracking,kid_seats, mileage, name, rate, car_brand_id, car_class_id,
                transmission_type_id, car_model_id)
values (0, 3, 54000, 'BB-Gier', 9.0, 3, 3, 3,3);

insert into advertisement( discount, place, kilometres_limit, car_id, owner_id, price_list_id, start_date, end_date)
values ( 10, 'Novi Sad', 500000, 4, 3, 1, '2020-05-03', '2020-10-03');


insert into car(available_tracking, kid_seats, mileage, name, rate, car_brand_id, car_class_id,
                transmission_type_id, car_model_id)
values (1,0, 5040, 'Harper', 5.0, 1, 1, 3, 1);

insert into advertisement( discount, place, kilometres_limit, car_id, owner_id, price_list_id, start_date, end_date)
values ( 20, 'Novi Sad', 5000, 5, 3, 1, '2020-05-03', '2020-10-03');



insert into car(available_tracking, kid_seats, mileage, name, rate, car_brand_id, car_class_id,
                transmission_type_id, car_model_id)
values (1,0, 5040, 'Honys', 5.0, 1, 1, 3, 1);

insert into advertisement( discount, place, kilometres_limit, car_id, owner_id, price_list_id, start_date, end_date)
values (20, 'Novi Sad', 5000, 6, 3, 1, '2020-05-03', '2020-10-03');

insert into car(available_tracking,kid_seats, mileage, name, rate, car_brand_id, car_class_id,
                transmission_type_id, car_model_id)
values (1, 0, 5040, 'Ruops', 5.0, 1, 1, 3, 1);
insert into advertisement( discount, place, kilometres_limit, car_id, owner_id, price_list_id, start_date, end_date)
values ( 20, 'Novi Sad', 5000, 7, 3, 1, '2020-05-03', '2020-10-03');



insert into car_fuel_type(car_id, fuel_type_id)
values (1, 3);
insert into car_fuel_type(car_id, fuel_type_id)
values (2, 3);
insert into car_fuel_type(car_id, fuel_type_id)
values (3, 3);
insert into car_fuel_type(car_id, fuel_type_id)
values (4, 3);
insert into car_fuel_type(car_id, fuel_type_id)
values (3, 2);
insert into car_fuel_type(car_id, fuel_type_id)
values (4, 2);
insert into car_fuel_type(car_id, fuel_type_id)
values (5, 3);
insert into car_fuel_type(car_id, fuel_type_id)
values (6, 3);
insert into car_fuel_type(car_id, fuel_type_id)
values (7, 3);
insert into car_fuel_type(car_id, fuel_type_id)
values (5, 2);
insert into car_fuel_type(car_id, fuel_type_id)
values (6, 1);


insert into term (advertisement_id, canceled, end_date, report_written, start_date) values (1, 0, '2020-07-05', 0, '2020-07-01');
insert into term (advertisement_id, canceled, end_date, report_written, start_date) values (1, 0, '2020-07-21', 0, '2020-07-10');
insert into term (advertisement_id, canceled, end_date, report_written, start_date) values (1, 0, '2020-06-05', 0, '2020-06-01');
insert into term (advertisement_id, canceled, end_date, report_written, start_date) values (2, 0, '2020-07-10', 0, '2020-07-05');
insert into term (advertisement_id, canceled, end_date, report_written, start_date) values (2, 0, '2020-06-05', 0, '2020-06-01');