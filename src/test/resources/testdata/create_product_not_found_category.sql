INSERT INTO public.stores (id, address, delivery, email, image, is_open, "name", "owner", "password", phone) VALUES(1, 'calle 13', true, 'tienda@gmail.com', 'img.jpg', true, 'mi tiendita', 'pepito', '32123', '312039221');
INSERT INTO public.categories(id,icon, name, id_store)VALUES(2, 'image.jpg', 'category1', 1);
INSERT INTO public.products(id, image, "name")VALUES(3, 'hola.png', 'product1');