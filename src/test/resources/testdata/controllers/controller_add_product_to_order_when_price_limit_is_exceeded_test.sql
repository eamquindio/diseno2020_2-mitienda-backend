
INSERT INTO public.users(id, email, "name", "password", phone, username)VALUES(1, '1@1.1', 'Uno', '1', '1', 'usuario1');

INSERT INTO public.stores(id, address, delivery, email, image, is_open, "name", "owner", "password", phone)VALUES(1, 'direccion1', true, '1@1.1', 'img.png', true, 'Uno', 'UnoOwner', '123','1');

INSERT INTO public.orders(id, "date", state, total_value, id_store, id_user)VALUES(1, '01/01/2020', 'created', 300, 1, 1);

INSERT INTO public.categories(id, icon, "name", id_store)VALUES(1, 'icon.png', 'categoria1', 1);
INSERT INTO public.categories(id, icon, "name", id_store)VALUES(2, 'icon.png', 'categoria2', 1);
INSERT INTO public.categories(id, icon, "name", id_store)VALUES(3, 'icon.png', 'categoria2', 1);

INSERT INTO public.products(id, image, "name")VALUES(1, 'imagen.png', 'producto1');
INSERT INTO public.products(id, image, "name")VALUES(2, 'imagen.png', 'producto2');
INSERT INTO public.products(id, image, "name")VALUES(3, 'imagen.png', 'producto3');

INSERT INTO public.products_store(id, price, stock, id_category, id_product, id_store)VALUES(1, 100, 10, 1, 1, 1);
INSERT INTO public.products_store(id, price, stock, id_category, id_product, id_store)VALUES(2, 200, 20, 2, 2, 1);
INSERT INTO public.products_store(id, price, stock, id_category, id_product, id_store)VALUES(3, 300, 20, 2, 3, 1);

INSERT INTO public.order_products(id, quantity, state, id_order, id_product)VALUES(10, 1, 'created', 1, 1);
INSERT INTO public.order_products(id, quantity, state, id_order, id_product)VALUES(15, 2, 'created', 1, 2);