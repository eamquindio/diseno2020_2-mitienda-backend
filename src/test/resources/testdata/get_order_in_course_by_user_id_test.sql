INSERT INTO users (id, email, "name", "password", phone, username) VALUES(1, '', '', '', '', '');

INSERT INTO stores (id, address, delivery, email, image, is_open, "name", "owner", "password", phone) VALUES(1, '', false, '', '', false, '', '', '', '');

INSERT INTO orders (id, state, id_store, id_user) VALUES(1, 'in_progress', 1, 1);
INSERT INTO orders (id, state, id_store, id_user) VALUES(2, 'finished', 1, 1);
INSERT INTO orders (id, state, id_store, id_user) VALUES(3, 'finished', 1, 1);
INSERT INTO orders (id, state, id_store, id_user) VALUES(4, 'created', 1, 1);