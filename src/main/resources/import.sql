insert into persona (id,address,email,last_name,name,phone)values (NULL, 'Leales' ,'CarlosRuiz@gmail.com','Ruiz', 'Carlos', '3816397808')
insert into persona (id,address,email,last_name,name,phone)values (NULL, 'Leales' ,'ZulemaRomano@gmail.com','Romano','Zulema', '3816233143')
insert into persona (id,address,email,last_name,name,phone)values (NULL, 'Leales' ,'JoseRuiz@gmail.com','Ruiz', 'Jose', '3814663721')

insert into vendedor (persona_id,legajo) values(2,'44588')
insert into vendedor (persona_id,legajo) values(3,'44589')

insert into cliente (persona_id) values (1)

insert into usuario (id,persona_id,username,password) values (null,1,'carlos','1234')
insert into usuario (id,persona_id,username,password) values (null,2,'Zuli','1234')
insert into usuario (id,persona_id,username,password) values (null,3,'Carlos','1234')
