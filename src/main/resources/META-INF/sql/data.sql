INSERT INTO usuarios(nombre,userName,password) VALUES("Jose","joy@gmail.com",1234);
INSERT INTO usuarios(nombre,userName,password) VALUES("Pedro","pedro@gmail.com",1234);
INSERT INTO usuarios(nombre,userName,password) VALUES("Juan","juan@gmail.com",1234);

INSERT INTO roles(roleName) VALUES("ROLE_ADMIN");
INSERT INTO roles(roleName) VALUES("ROLE_USER");

INSERT INTO posts(nombre,categoria,post,imagen,fechaPost) VALUES("Cupcakes de vainilla","Cupcakes","Estos cupcakes","cupcake.jpg","2020-03-20");
INSERT INTO posts(nombre,categoria,post,imagen,fechaPost) VALUES("Macarons de café","Macarons","Este macaron","macaron.jpg","2020-03-19");
INSERT INTO posts(nombre,categoria,post,imagen,fechaPost) VALUES("Cheesecake de chocolate blanco","Cheesecakes","Esta cheesecake","cheesecake.jpg","2020-03-18");
INSERT INTO posts(nombre,categoria,post,imagen,fechaPost) VALUES("Brownie","Brownies","Este brownie","brownie.jpg","2020-03-17");
INSERT INTO posts(nombre,categoria,post,imagen,fechaPost) VALUES("Bizcocho de leche caliente","Bizcochos","Este bizcocho","bizcocho.jpg","2020-03-16");

INSERT INTO comentarios(comentario,fechaComentario,idUsuario,idPost) VALUES("Riquísima","2020-02-13",2,1);
INSERT INTO comentarios(comentario,fechaComentario,idUsuario,idPost) VALUES("El mejor cupcake","2020-02-13",2,2);
INSERT INTO comentarios(comentario,fechaComentario,idUsuario,idPost) VALUES("Tú sí que sabes","2020-02-13",3,3);
INSERT INTO comentarios(comentario,fechaComentario,idUsuario,idPost) VALUES("Vaya bomba!","2020-02-13",1,1);

INSERT INTO usuariosroles(idUsuario,idRol) VALUES(1,1);
INSERT INTO usuariosroles(idUsuario,idRol) VALUES(2,2);
INSERT INTO usuariosroles(idUsuario,idRol) VALUE(3,2);
