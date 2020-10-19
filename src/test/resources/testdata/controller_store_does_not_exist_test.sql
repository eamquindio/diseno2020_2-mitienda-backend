
INSERT INTO public.users(id, email, "name", "password", phone, username)VALUES(3, 'jose123.luis@gmail.com', 'Manuel', '123', '3054567656', 'manuelito');
INSERT INTO public.categories(id, icon, "name", id_store)VALUES(1, 'icon.png', 'pedro', null);
INSERT INTO public.products(id, image, "name")VALUES(5, 'image.png', 'Margarita');
INSERT INTO shopping_carts (id,id_store,id_user,total_value) VALUES (1,null,3,100.0);
INSERT INTO public.products_store(id, price, stock, id_category, id_product, id_store)VALUES(4, 200, 21, 1, 5, null);