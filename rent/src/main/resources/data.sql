insert into requests_holder(id, bundle)
VALUES (1, true);
insert into requests_holder(id, bundle)
VALUES (2, true);
insert into requests_holder(id, bundle)
VALUES (3, false);

insert into requests_holder(id, bundle)
VALUES (4, false);

insert into requests_holder(id, bundle)
VALUES (5, false);

insert into requests_holder(id, bundle)
VALUES (6, false);


insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (2, 1, '2020-06-15T22:00', 'PENDING', '2020-06-03T22:00', 4, 1, '2020-06-18T12:28:09.063');
insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (2, 1, '2020-06-22T22:00', 'RESERVED', '2020-06-12T22:00', 5,1, '2020-06-18T12:28:09.063');
insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (2, 1, '2020-06-20T22:00', 'PAID', '2020-06-25T22:00', 6,1, '2020-06-18T12:28:09.063');
insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (2, 1, '2020-05-19T22:00', 'PAID', '2020-05-13T22:00', 6,1, '2020-06-18T12:28:09.063');

insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (1, 1,'2020-07-19T22:00', 'RESERVED', '2020-06-17T22:00',  1, 1, '2020-06-18T12:28:09.063');
insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (1, 1,'2020-07-21T22:00', 'PENDING', '2020-06-20T22:00',  1, 1, '2020-06-18T12:28:09.063');
insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (1, 1,'2020-07-29T22:00', 'RESERVED', '2020-06-27T22:00', 1, 1, '2020-06-18T12:28:09.063');


insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (2, 1,'2020-07-19T22:00', 'PENDING', '2020-06-17T22:00', 2, 1, '2020-06-18T12:28:09.063');
insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (2, 1,'2020-07-21T22:00', 'PENDING', '2020-06-20T22:00',  2, 1, '2020-06-18T12:28:09.063');
insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (2, 1,'2020-08-04T22:00', 'PENDING', '2020-06-30T22:00',  2, 1, '2020-06-18T12:28:09.063');


insert into rent_request(advertisement_id, sender_id,end_date_time , rent_request_status, start_date_time, requests_id,version, created)
values (3, 1,'2020-08-26T22:00', 'PENDING', '2020-07-03T22:00', 2, 1, '2020-06-18T12:28:09.063');




