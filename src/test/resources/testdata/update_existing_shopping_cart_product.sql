INSERT INTO public.users (id, email, "name", "password", phone, username) VALUES(1, 'email@hotmail.com', 'nombre', 'contraseña', '20000', 'nombreusuario');
INSERT INTO public.stores (id, "address", delivery, "email", "image", is_open, "name", "owner", "password", "phone") VALUES(1, 'address', false, 'email', 'image', false, 'name', 'owner', 'password', 'phone');
INSERT INTO shopping_carts (id,id_store,id_user,total_value) VALUES (20,1,1,10000.0);

INSERT INTO public.categories (id, "icon", "name", id_store) VALUES(10,'icono','nombre',1);
INSERT INTO public.products (id, "image", "name") VALUES(1,'imagen','nombre');
INSERT INTO public.products_store (id, price, stock, id_category, id_product, id_store) VALUES(58,100,1000,10,1,1);
INSERT INTO public.shopping_cart_products (id, quantity, id_product_store,id_shopping_cart) VALUES(1,10,58,20);
