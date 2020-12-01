-- Moderadores

-- moderador1
INSERT INTO users(username,password,enabled) VALUES ('moderador1','moderador1',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (1,'moderador1','moderador');
-- moderador2
INSERT INTO users(username,password,enabled) VALUES ('moderador2','moderador2',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (2,'moderador2','moderador');
-- moderador3
INSERT INTO users(username,password,enabled) VALUES ('moderador3','moderador3',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (3,'moderador3','moderador');

-- Organizaciones

-- organizacion1
INSERT INTO users(username,password,enabled) VALUES ('organizacion1','organizacion1',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (4,'organizacion1','organizacion');
-- organizacion2
INSERT INTO users(username,password,enabled) VALUES ('organizacion2','organizacion2',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (5,'organizacion2','organizacion');
-- organizacion3
INSERT INTO users(username,password,enabled) VALUES ('organizacion3','organizacion3',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (6,'organizacion3','organizacion');

-- Usuario

-- usuario1
INSERT INTO users(username,password,enabled) VALUES ('usuario1','usuario1',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (7,'usuario1','organizacion');
-- usuario2
INSERT INTO users(username,password,enabled) VALUES ('usuario2','usuario2',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (8,'usuario2','organizacion');
-- usuario3
INSERT INTO users(username,password,enabled) VALUES ('usuario3','usuario3',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (9,'usuario3','organizacion');
