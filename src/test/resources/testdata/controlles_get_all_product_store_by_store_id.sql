INSERT INTO public.stores(id, address, delivery, email, image, is_open, "name", "owner", "password", phone)VALUES(2, 'carrera 20', true, 'jose123.luis@gmail.com', 'imagen.png', true, 'Jose', 'Pedrito', '123','3105679723');
INSERT INTO public.categories(id, icon, "name", id_store)VALUES(1, 'icon.png', 'pedro', 2);
INSERT INTO public.products(id, image, "name")VALUES(5, 'image.png', 'Margarita');
INSERT INTO public.products_store(id, price, stock, id_category, id_product, id_store)VALUES(4, 200, 21, 1, 5, 2);