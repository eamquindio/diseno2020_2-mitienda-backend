INSERT INTO public.users (id, email, "name", "password", phone, username) VALUES(1, 'email@hotmail.com', 'nombre', 'contraseña', '20000', 'nombreusuario');
INSERT INTO public.stores (id, "address", delivery, "email", "image", is_open, "name", "owner", "password", "phone") VALUES(1, 'address', false, 'email', 'image', false, 'name', 'owner', 'password', 'phone');
INSERT INTO shopping_carts (id,id_store,id_user) VALUES (1,1,1);

INSERT INTO public.categories (id, "icon", "name", id_store) VALUES(10,'icono','nombre',1);
INSERT INTO public.products (id, "image", "name") VALUES(1,'imagen','nombre');
INSERT INTO public.products_store (id, price, stock, id_category, id_product, id_store) VALUES(1,100,1000,10,1,1);
INSERT INTO public.products_store (id, price, stock, id_category, id_product, id_store) VALUES(2,200,2000,10,1,1);
INSERT INTO public.products_store (id, price, stock, id_category, id_product, id_store) VALUES(3,300,3000,10,1,1);

INSERT INTO public.shopping_cart_products (id, quantity, id_product_store,id_shopping_cart) VALUES(1,1,1,1);
INSERT INTO public.shopping_cart_products (id, quantity, id_product_store,id_shopping_cart) VALUES(2,5,2,1);
INSERT INTO public.shopping_cart_products (id, quantity, id_product_store,id_shopping_cart) VALUES(3,3,3,1);