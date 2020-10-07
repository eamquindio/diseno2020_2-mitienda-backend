INSERT INTO public.stores (id, address, delivery, email, image, is_open, "name", "owner", "password", phone) VALUES(1, 'calle 13', true, 'tienda@gmail.com', 'img.jpg', true, 'mi tiendita', 'pepito', '32123', '312039221');

INSERT INTO public.users (id, email, "name", "password", phone, username) VALUES(1, 'email@hotmail.com', 'nombre', 'contraseña', '3113456049', 'nombreusuario');

INSERT INTO public.categories (id, icon, "name", id_store) VALUES(1, 'icon.png', 'frutas', 1);

INSERT INTO public.products (id, image, "name") VALUES(1, 'img.jpg', 'manzana');


INSERT INTO public.products_store (id, price, stock, id_category, id_product, id_store) VALUES(1, 100, 20, 1, 1, 1);


INSERT INTO public.orders (id, "date", state, id_store, id_user) VALUES(22, '2016-06-22 19:10:25-07', 'IN COURSE', 1, 1);


INSERT INTO public.order_products (id,quantity, state, id_order, id_product) VALUES(2, 3, 'CANCELED', 22, 1);