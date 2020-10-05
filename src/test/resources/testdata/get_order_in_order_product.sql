INSERT INTO products(id, image, "name")VALUES(3, 'IMAGEN.PNG', 'CARNE');
INSERT INTO orders(id, "date", state, id_store, id_user)VALUES(10, '03/06/20', 'APPROVED', 2, 5);
INSERT INTO public.order_products(id, quantity, state, id_order, id_product)VALUES(1, 12, 'PENDING', 10, 3);
