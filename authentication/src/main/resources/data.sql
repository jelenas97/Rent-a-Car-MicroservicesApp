insert into authority (name)
values ('ROLE_CLIENT');
insert into authority (name)
values ('ROLE_AGENT');
insert into authority (name)
values ('ROLE_COMPANY');
insert into authority (name)
values ('ROLE_ADMIN');
insert into users(type, password, username, email, status, first_name, last_name, address)
values ('CLIENT', '$2a$10$yNKbCm5ETrM/bNnJMcmIxe/95qU6vpqnxn2/i9pAv5PZsrPbnJLvK', 'petar', 'jekibp@gmail.com', 'ACTIVE', 'Petar', 'Petrovic', 'Balzakova 15');
insert into users(type, password, username, email, status, first_name, last_name, address)
values ('CLIENT', '$2a$10$yNKbCm5ETrM/bNnJMcmIxe/95qU6vpqnxn2/i9pAv5PZsrPbnJLvK', 'nikola', 'petar.curcin97@gmail.com',
        'ACTIVE', 'Nikola', 'Nikolic', 'Balzakova 70');
insert into users(type, password, username, email, status, first_name, last_name, address, business_registration_number)
values ('AGENT', '$2a$10$yNKbCm5ETrM/bNnJMcmIxe/95qU6vpqnxn2/i9pAv5PZsrPbnJLvK', 'agent', 'kkk@gmail.com', 'ACTIVE', 'Agent', 'Agentski', 'Balzakova 30', '555');
insert into users(type, password, username, email, status, first_name, last_name, address, business_registration_number)
values ('AGENT', '$2a$10$yNKbCm5ETrM/bNnJMcmIxe/95qU6vpqnxn2/i9pAv5PZsrPbnJLvK', 'agent2', 'mmm@gmail.com',
        'ACTIVE', 'Nenad', 'Nenadovic', 'Balzakova 15', '161');
insert into users(type, password, username, email, status, first_name, last_name, address)
values ('ADMIN', '$2a$10$yNKbCm5ETrM/bNnJMcmIxe/95qU6vpqnxn2/i9pAv5PZsrPbnJLvK', 'admin', 'ppp@gmail.com', 'ACTIVE', 'Bojan', 'Bojanic', 'Balzakova 15');
insert into user_authority(user_id, authority_id)
values(1, 1);
insert into user_authority(user_id, authority_id)
values(2, 1);
insert into user_authority(user_id, authority_id)
values(3, 2);
insert into user_authority(user_id, authority_id)
values(4, 2);
insert into user_authority(user_id, authority_id)
values(5, 4);
