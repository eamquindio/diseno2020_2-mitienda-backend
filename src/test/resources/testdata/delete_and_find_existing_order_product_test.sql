INSERT INTO users (id, email, "name", "password", phone, username) VALUES(1, '', '', '', '', '');

INSERT INTO stores (id, address, delivery, email, image, is_open, "name", "owner", "password", phone) VALUES(1, '', false, '', '', false, '', '', '', '');

INSERT INTO orders (id, state, id_store, id_user) VALUES(1, '', 1, 1);

INSERT INTO products_store (id, price, stock, id_store) VALUES(1, 2000, 10, 1);

INSERT INTO order_products (id, quantity, state, id_order, id_product) VALUES(1, 21, '', 1, 1);
