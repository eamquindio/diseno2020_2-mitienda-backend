INSERT INTO stores (id, address, delivery, email, image, is_open, "name", "owner", "password", phone) VALUES(1, 'calle 13', true, 'tienda@gmail.com', 'img.jpg', true, 'mi tiendita', 'pepito', '32123', '312039221');

INSERT INTO users (id, email, "name", "password", phone, username) VALUES(1, 'email@hotmail.com', 'nombre', 'contraseña', '3113456049', 'nombreusuario');

INSERT INTO categories (id, icon, "name", id_store) VALUES(1, 'icon.png', 'frutas', 1);

INSERT INTO products (id, image, "name") VALUES(1, 'img.jpg', 'manzana');
INSERT INTO products (id, image, "name") VALUES(2, 'img.jpg', 'pera');
INSERT INTO products (id, image, "name") VALUES(3, 'img.jpg', 'piña');

INSERT INTO products_store (id, price, stock, id_category, id_product, id_store) VALUES(1, 100, 20, 1, 1, 1);
INSERT INTO products_store (id, price, stock, id_category, id_product, id_store) VALUES(2, 100, 20, 1, 2, 1);
INSERT INTO products_store (id, price, stock, id_category, id_product, id_store) VALUES(3, 100, 20, 1, 3, 1);


INSERT INTO orders (id,"date", state, id_store, id_user) VALUES(1,'2016-06-22 19:10:25-07','finished', 1, 1);

INSERT INTO order_products (id, quantity, state, id_order, id_product) VALUES(1, 4, 'ready', 1, 1);
INSERT INTO order_products (id, quantity, state, id_order, id_product) VALUES(2, 4, 'ready', 1, 2);
INSERT INTO order_products (id, quantity, state, id_order, id_product) VALUES(3, 4, 'ready', 1, 3);