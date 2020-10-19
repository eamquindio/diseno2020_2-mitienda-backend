INSERT INTO public.stores(id, address, delivery, email, image, is_open, "name", "owner", "password", phone)VALUES(2, 'carrera 20', true, 'jose123.luis@gmail.com', 'imagen.png', true, 'Jose', 'Pedrito', '123','3105679723');
INSERT INTO public.users(id, email, "name", "password", phone, username)VALUES(3, 'jose123.luis@gmail.com', 'Manuel', '123', '3054567656', 'manuelito');
INSERT INTO public.categories(id, icon, "name", id_store)VALUES(1, 'icon.png', 'pedro', 2);
INSERT INTO public.products(id, image, "name")VALUES(5, 'image.png', 'Margarita');
INSERT INTO shopping_carts (id,id_store,id_user,total_value) VALUES (1,2,3,100.0);
