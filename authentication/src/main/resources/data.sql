insert into authority (name)
values ('ROLE_CLIENT');
insert into authority (name)
values ('ROLE_AGENT');
insert into authority (name)
values ('ROLE_COMPANY');
insert into authority (name)
values ('ROLE_ADMIN');

insert into users(type, password, username, email, status, first_name, last_name, address)
values ('CLIENT', '$2a$10$yNKbCm5ETrM/bNnJMcmIxe/95qU6vpqnxn2/i9pAv5PZsrPbnJLvK', 'petar', 'pera@gmail.com', 'ACTIVE', 'Petar', 'Petrovic', 'Balzakova 15');
insert into users(type, password, username, email, status, first_name, last_name, address)
values ('ADMIN', '$2a$10$yNKbCm5ETrM/bNnJMcmIxe/95qU6vpqnxn2/i9pAv5PZsrPbnJLvK', 'admin', 'admin@gmail.com', 'ACTIVE', 'Bojan', 'Bojanic', 'Balzakova 15');

insert into user_authority(user_id, authority_id)
values(1, 1);
insert into user_authority(user_id, authority_id)
values(2, 4);

