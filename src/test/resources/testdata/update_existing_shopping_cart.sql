INSERT INTO public.users (id, email, "name", "password", phone, username) VALUES(20, 'email', 'nombre', 'contraseña', 'telefono', 'nombreusuario');
INSERT INTO public.users (id, email, "name", "password", phone, username) VALUES(22, 'email', 'nombre', 'contraseña', 'telefono', 'nombreusuario');

INSERT INTO public.stores (id, "address", delivery, "email", "image", is_open, "name", "owner", "password", "phone") VALUES(30, 'address', false, 'email', 'image', false, 'name', 'owner', 'password', 'phone');
INSERT INTO shopping_carts(id,id_store,id_user,total_value) VALUES (1,30,20,10000.0);