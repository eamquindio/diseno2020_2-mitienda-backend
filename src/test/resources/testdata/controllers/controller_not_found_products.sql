INSERT INTO users (id, email, "name", "password", phone, username) VALUES(1, '', '', '', '', '');

INSERT INTO stores (id, address, delivery, email, image, is_open, "name", "owner", "password", phone) VALUES(1, '', false, '', '', false, '', '', '', '');

INSERT INTO shopping_carts (id, id_store, id_user) VALUES(1, 1, 1);