INSERT INTO public.categories(id, icon, "name", id_store)VALUES(1, 'icon.png', 'pedro', null);
INSERT INTO public.products(id, image, "name")VALUES(5, 'image.png', 'Margarita');
INSERT INTO public.products_store(id, price, stock, id_category, id_product, id_store)VALUES(4, 200, 21, 1, 5, null);