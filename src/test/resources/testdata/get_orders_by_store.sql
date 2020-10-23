INSERT INTO public.users (id, email, "name", "password", phone, username) VALUES(1, 'email@hotmail.com', 'nombre', 'contraseña', '3113456049', 'nombreusuario');

INSERT INTO public.stores (id, address, delivery, email, image, is_open, "name", "owner", "password", phone) VALUES(1, 'carrera 21', true, 'tiendita@gmail.com', 'imagen', false, 'La tiendita', 'Don pepe', '0841', '3215439000');

INSERT INTO public.products (id, image, "name") VALUES(1, 'imagen', 'nombre');

INSERT INTO public.categories (id, icon, "name", id_store) VALUES(1, 'icono', 'frutas', 1);

INSERT INTO public.products_store (id, price, stock, id_category, id_product, id_store) VALUES(1, 500, 30, 1, 1, 1);



INSERT INTO public.orders (id, "date", state, id_store, id_user) VALUES(1, '2020-10-22 19:10:25-07', 'finished', 1, 1);
INSERT INTO public.orders (id, "date", state, id_store, id_user) VALUES(2, '2020-10-15 19:10:25-07', 'finished', 1, 1);
INSERT INTO public.orders (id, "date", state, id_store, id_user) VALUES(3, '2016-06-22 19:10:25-07', 'finished', 1, 1);
