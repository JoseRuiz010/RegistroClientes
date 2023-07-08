insert into persona (id,address,email,last_name,name,phone)values (NULL, 'Leales' ,'CarlosRuiz@gmail.com','Ruiz', 'Carlos', '3816397808')
insert into persona (id,address,email,last_name,name,phone)values (NULL, 'Leales' ,'ZulemaRomano@gmail.com','Romano','Zulema', '3816233143')
insert into persona (id,address,email,last_name,name,phone)values (NULL, 'Leales' ,'JoseRuiz@gmail.com','Ruiz', 'Jose', '3814663721')

insert into vendedor (persona_id,legajo) values(2,'44588')
insert into vendedor (persona_id,legajo) values(3,'44589')

insert into cliente (persona_id) values (1)

insert into usuario (id,persona_id,username,password) values (null,1,'carlos','1234')
insert into usuario (id,persona_id,username,password) values (null,2,'Zuli','1234')
insert into usuario (id,persona_id,username,password) values (null,3,'Carlos','1234')


insert into marca (id, nombre) values (null,"Pepsi");
insert into marca (id, nombre) values (null,"Fanta");
insert into marca (id, nombre) values (null,"7UP");
insert into marca (id, nombre) values (null,"Coca Cola");
insert into marca (id, nombre) values (null,"Mirinda");
insert into marca (id, nombre) values (null,"Secco");

insert into producto (id, nombre, descripcion,precio, imagen,marca_id) values (null,"Pepsi 2L", "Pepsi 2L", 500, null,1);
insert into producto (id, nombre, descripcion,precio, imagen,marca_id) values (null,"Pepsi 3L", "Pepsi 3L", 700, null,1);
insert into producto (id, nombre, descripcion,precio, imagen,marca_id) values (null,"Coca cola 2L", "Coca Cola 2L", 900, null,4);
insert into producto (id, nombre, descripcion,precio, imagen,marca_id) values (null,"Mirinda 2L", "Mirinda 2L", 500, null,5);
insert into producto (id, nombre, descripcion,precio, imagen,marca_id) values (null,"Fanta 2L", "Fanta 2L", 950, null,2);