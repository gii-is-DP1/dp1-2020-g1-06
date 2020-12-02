-- Moderadores

-- moderador1
INSERT INTO users(username,password,enabled) VALUES ('moderador1','moderador1',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (1,'moderador1','moderador');
INSERT INTO actor(dtype,id,nombre,email,telefono,direccion,saldo,username) VALUES ('Moderador', 1, 'moderador numero 1','moderador1@gmail.com','954111111','calle del moderador, 1',0,'moderador1');
-- moderador2
INSERT INTO users(username,password,enabled) VALUES ('moderador2','moderador2',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (2,'moderador2','moderador');
INSERT INTO actor(dtype,id,nombre,email,telefono,direccion,saldo,username) VALUES ('Moderador', 2, 'moderador numero 2','moderador2@gmail.com','954222222','calle del moderador, 2',0,'moderador2');
-- moderador3
INSERT INTO users(username,password,enabled) VALUES ('moderador3','moderador3',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (3,'moderador3','moderador');
INSERT INTO actor(dtype,id,nombre,email,telefono,direccion,saldo,username) VALUES ('Moderador', 3, 'moderador numero 3','moderador3@gmail.com','954333333','calle del moderador, 3',0,'moderador3');

-- Organizaciones

-- organizacion1
INSERT INTO users(username,password,enabled) VALUES ('organizacion1','organizacion1',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (4,'organizacion1','organizacion');
INSERT INTO actor(dtype,id,nombre,email,telefono,direccion,saldo,username) VALUES ('Organizacion', 4, 'organizacion numero 1','organizacion1@gmail.com','954111111','calle de la organizacion, 1',0,'organizacion1');
-- organizacion2
INSERT INTO users(username,password,enabled) VALUES ('organizacion2','organizacion2',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (5,'organizacion2','organizacion');
INSERT INTO actor(dtype,id,nombre,email,telefono,direccion,saldo,username) VALUES ('Organizacion', 5, 'organizacion numero 2','organizacion2@gmail.com','954222222','calle de la organizacion, 2',0,'organizacion2');
-- organizacion3
INSERT INTO users(username,password,enabled) VALUES ('organizacion3','organizacion3',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (6,'organizacion3','organizacion');
INSERT INTO actor(dtype,id,nombre,email,telefono,direccion,saldo,username) VALUES ('Organizacion', 6, 'organizacion numero 3','organizacion3@gmail.com','954333333','calle de la organizacion, 3',0,'organizacion3');

-- Usuario

-- usuario1
INSERT INTO users(username,password,enabled) VALUES ('usuario1','usuario1',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (7,'usuario1','usuario');
INSERT INTO actor(dtype,id,nombre,email,telefono,direccion,saldo,username) VALUES ('Usuario', 7, 'usuario numero 1','usuario1@gmail.com','954111111','calle del usuario, 1',200,'usuario1');
-- usuario2
INSERT INTO users(username,password,enabled) VALUES ('usuario2','usuario2',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (8,'usuario2','usuario');
INSERT INTO actor(dtype,id,nombre,email,telefono,direccion,saldo,username) VALUES ('Usuario', 8, 'usuario numero 2','usuario2@gmail.com','954222222','calle del usuario, 2',10,'usuario2');
-- usuario3
INSERT INTO users(username,password,enabled) VALUES ('usuario3','usuario3',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (9,'usuario3','usuario');
INSERT INTO actor(dtype,id,nombre,email,telefono,direccion,saldo,username) VALUES ('Usuario', 9, 'usuario numero 3','usuario3@gmail.com','954333333','calle del usuario, 3',0,'usuario3');
