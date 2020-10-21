INSERT INTO public.stores(id,"address",delivery,"email","image",is_open,"name","owner","password","phone") VALUES(2, '', false, '', '', false, '', '', '', '');
INSERT INTO public.products(id,"image","name") VALUES(1,'','');
INSERT INTO public.categories(id,"icon","name",id_store) VALUES(1,'','',2);
INSERT INTO public.products_store(id,price,stock,id_category,id_product,id_store) VALUES(4,0,2,1,1,2);
INSERT INTO public.shopping_carts(id,id_store,id_user,total_value) VALUES(1,2,null,100);