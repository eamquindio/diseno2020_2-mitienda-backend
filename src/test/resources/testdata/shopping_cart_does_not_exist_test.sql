INSERT INTO public.stores(id,"address",delivery,"email","image",is_open,"name","owner","password","phone") VALUES(1, '', false, '', '', false, '', '', '', '');
INSERT INTO public.users(id,email,"name","password",phone,username) VALUES(1,'','','','','carlos');
INSERT INTO public.products(id,"image","name") VALUES(1,'','');
INSERT INTO public.categories(id,"icon","name",id_store) VALUES(1,'','',1);
INSERT INTO public.products_store(id,price,stock,id_category,id_product,id_store) VALUES(1,0,2,1,1,1);
