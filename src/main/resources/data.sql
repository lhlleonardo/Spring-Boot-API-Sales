INSERT INTO public.manufacturer(
            manufacturer_id, name)
    VALUES (1, 'Nike');

 INSERT INTO public.product(
            product_id, barcode, description, name, unit_price, manufacturer_id)
 VALUES (1, '124436', 'Description product', 'Name product', 15.85, 1);
    