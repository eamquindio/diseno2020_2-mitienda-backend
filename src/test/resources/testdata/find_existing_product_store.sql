INSERT INTO products(id, image, "name")VALUES(2, 'hola.png', 'product1');
INSERT INTO stores(id, address, delivery, email, image, is_open, "name", "owner", "password", phone)VALUES(3, 'hola@gmail.com', true, 'hola.png', 'a', false, 'a', 'a', 'a', '1');
INSERT INTO categories(id,icon, name, id_store)VALUES(10,'image.jpg', 'category1', 3);
INSERT INTO public.products_store(id, price, stock, id_category, id_product, id_store)VALUES(6, 1110, 10, 10, 2, 3);