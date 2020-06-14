insert into requests_holder(id, bundle)
VALUES (1, true);
insert into requests_holder(id, bundle)
VALUES (2, false);
insert into rent_request(end_date_time, rent_request_status, start_date_time, advertisement_id, requests_id, sender_id,
                         version)
values ('2020-05-19T22:00', 'PENDING', '2020-05-17T22:00', 1, 1, 1, 1);
insert into rent_request(end_date_time, rent_request_status, start_date_time, advertisement_id, requests_id, sender_id,
                         version)
values ('2020-05-22T22:00', 'PENDING', '2020-05-20T22:00', 1, 2, 1, 1);
insert into rent_request(end_date_time, rent_request_status, start_date_time, advertisement_id, requests_id, sender_id,
                         version)
values ('2020-05-28T22:00', 'PENDING', '2020-05-26T22:00', 1, 2, 1, 1);
insert into rent_request(end_date_time, rent_request_status, start_date_time, advertisement_id, requests_id, sender_id,
                         version)
values ('2020-05-23T22:00', 'PENDING', '2020-05-21T22:00', 1, 2, 1, 1);
insert into rent_request(end_date_time, rent_request_status, start_date_time, advertisement_id, requests_id, sender_id,
                         version)
values ('2020-05-27T22:00', 'PENDING', '2020-05-23T22:00', 1, 2, 1, 1);
insert into rent_request(end_date_time, rent_request_status, start_date_time, advertisement_id, requests_id, sender_id,
                         version)
values ('2020-05-29T22:00', 'PENDING', '2020-05-26T22:00', 1, 2, 1, 1);
insert into rent_request(end_date_time, rent_request_status, start_date_time, advertisement_id, requests_id, sender_id,
                         version)
values ('2020-05-25T22:00', 'PENDING', '2020-05-23T22:00', 1, 2, 1, 1);

