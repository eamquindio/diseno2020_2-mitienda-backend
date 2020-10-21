
INSERT INTO public.users(id, email, "name", "password", phone, username)VALUES(3, 'jose123.luis@gmail.com', 'Manuel', '123', '3054567656', 'manuelito');

INSERT INTO public.stores(id, address, delivery, email, image, is_open, "name", "owner", "password", phone)VALUES(2, 'carrera 20', true, 'jose123.luis@gmail.com', 'imagen.png', true, 'Jose', 'Pedrito', '123','3105679723');

INSERT INTO public.orders(id, "date", state, total_value, id_store, id_user)VALUES(1, '2020-02-09', 'pending', 100, 2, 3);


INSERT INTO public.categories(id, icon, "name", id_store)VALUES(10, 'icon.png', 'pedro', 2);

INSERT INTO public.products(id, image, "name")VALUES(5, 'imagen.png', 'Margarita');

INSERT INTO public.products(id, image, "name")VALUES(77, 'imagen.png', '1000');

INSERT INTO public.products_store(id, price, stock, id_category, id_product, id_store)VALUES(4, 200, 21, 10, 5, 2);

INSERT INTO public.products_store(id, price, stock, id_category, id_product, id_store)VALUES(66, 200, 21, 10, 77, 2);

INSERT INTO public.order_products(id, quantity, state, id_order, id_product)VALUES(88, 10, 'created', 1, 4);