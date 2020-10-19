INSERT INTO public.users (id, email, "name", "password", phone, username) VALUES(1, 'email@hotmail.com', 'nombre', 'contraseña', '3113456049', 'nombreusuario');

INSERT INTO public.stores (id, address, delivery, email, image, is_open, "name", "owner", "password", phone) VALUES(1, 'calle 12', false, 'tienda@gmail.com', 'img.jpg', true, 'la tiendita', 'pepito', '32132', '3113456789');


INSERT INTO public.orders ("date", state, id_store, id_user) VALUES('2016-06-22 19:10:25-07', 'in course', 1, 1);
