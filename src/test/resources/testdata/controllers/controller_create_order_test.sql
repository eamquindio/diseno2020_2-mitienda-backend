INSERT INTO users (id, email, "name", "password", phone, username) VALUES(1, '', '', '', '', '');

INSERT INTO stores (id, address, delivery, email, image, is_open, "name", "owner", "password", phone) VALUES(1, '', false, '', '', false, '', '', '', '');

INSERT INTO products_store (id, price, stock, id_store) VALUES(1, 2000, 10, 1);
INSERT INTO products_store (id, price, stock, id_store) VALUES(2, 3000, 20, 1);
INSERT INTO products_store (id, price, stock, id_store) VALUES(3, 4000, 30, 1);

INSERT INTO shopping_carts (id, id_store, id_user) VALUES(1, 1, 1);

INSERT INTO public.orders ("date", state, total_value, id_store, id_user) VALUES('2016-06-22 19:10:25-07', 'created', 2500, 1, 1);
INSERT INTO public.orders ("date", state, total_value, id_store, id_user) VALUES('2016-06-22 19:10:25-07', 'created', 3000, 1, 1);
INSERT INTO public.orders ("date", state, total_value, id_store, id_user) VALUES('2016-06-22 19:10:25-07', 'created', 5000, 1, 1);

INSERT INTO shopping_cart_products (id, quantity, id_product_store, id_shopping_cart) VALUES(1, 3, 1, 1);
INSERT INTO shopping_cart_products (id, quantity, id_product_store, id_shopping_cart) VALUES(2, 2, 2, 1);
INSERT INTO shopping_cart_products (id, quantity, id_product_store, id_shopping_cart) VALUES(3, 1, 3, 1);


