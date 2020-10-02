INSERT INTO users (id, email, "name", "password", phone, username) VALUES(1, '', '', '', '', '');

INSERT INTO stores (id, address, delivery, email, image, is_open, "name", "owner", "password", phone) VALUES(1, '', false, '', '', false, '', '', '', '');

INSERT INTO orders (id, state, id_store, id_user) VALUES(12, '', 1, 1);

INSERT INTO products_store (id, price, stock, id_store) VALUES(11, 2000, 10, 1);