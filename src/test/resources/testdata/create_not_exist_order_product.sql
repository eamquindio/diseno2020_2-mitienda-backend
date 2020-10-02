INSERT INTO stores(id, address, delivery, email, image, is_open, "name", "owner", "password", phone)VALUES(3, 'hola@gmail.com', true, 'hola.png', 'a', false, 'a', 'a', 'a', '1');
INSERT INTO users(id, email, "name", "password", phone, username)VALUES(7, 'a', 'a', 'a', '1', 'a');
INSERT INTO products(id, image, "name")VALUES(2, 'hola.png', 'product1');
INSERT INTO categories(id,icon, name, id_store)VALUES(10,'image.jpg', 'category1', 3);
INSERT INTO products_store(id, price, stock, id_category, id_product, id_store)VALUES(4, 20, 30, 10, 2, 3);
INSERT INTO orders(id, "date", state, id_store, id_user)VALUES(1, '20/12/2020', 'state1', 3, 7);