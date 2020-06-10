INSERT INTO Categories(category)
    VALUES('Elektronika');
INSERT INTO Categories(category)
    VALUES('Buitine technika');
INSERT INTO Categories(category)
    VALUES('Maisto prekes');
INSERT INTO Categories(category)
    VALUES('Knygos');
INSERT INTO Categories(category)
    VALUES('Irankiai');



INSERT INTO Items(item_name, item_category, description, item_value, price_for_day, item_picture_id, ITEM_CATEGORIES_CATEGORIES_ID) VALUES('Atsuktuvas', 'Irankiai', 'Puikiai suka', 12.50, 3.5, 'https://www.lemona.lt/LIUSE/Images/9SD-201A.jpg', 5);
INSERT INTO Items(item_name, item_category, description, item_value, price_for_day, item_picture_id, ITEM_CATEGORIES_CATEGORIES_ID) VALUES('Graztas', 'Irankiai', 'Puikiai grezia', 150.50, 30.23, 'https://lh3.googleusercontent.com/proxy/SkCIsgHlEKQ1GvJ_TEWnYJC5X3k4sKCQYmmI_k4GkzIMPdnRcX-IJ0ZLR6wT-7DwpvfA13YIWilyqkPra7YD6g1dEYbtQKUsJk7P0uhrxldnsFrxzp4f2I4MZ5Z18nOB', 5);
INSERT INTO Items(item_name, item_category, description, item_value, price_for_day, item_picture_id, ITEM_CATEGORIES_CATEGORIES_ID) VALUES('Plaktukas', 'Irankiai', 'Puikiai kala', 12.50, 15.24, 'https://www.bausa.lt/image/cache/data/bausa_db/products/3253561515057/5ba10cc9a98e6-500x500.jpg', 5);
INSERT INTO Items(item_name, item_category, description, item_value, price_for_day, item_picture_id, ITEM_CATEGORIES_CATEGORIES_ID) VALUES('Vinis', 'Irankiai', 'Puikiai laiko', 2.50, 0.51, 'https://matuok24.lt/image/cache/data/59_0-500x500.jpg', 5);
INSERT INTO Items(item_name, item_category, description, item_value, price_for_day, item_picture_id, ITEM_CATEGORIES_CATEGORIES_ID) VALUES('Baravykas', 'Maistas', 'Skanus', 1.50, 0.89, 'https://img.diena.lt/sites/default/files/styles/500x500/public/Klaipeda/img_2704.jpg?itok=xyFK8exh', 3);

INSERT INTO Users(user_id, username, password, name, last_name)
    VALUES(1, 'user', '{bcrypt}$2y$12$A7x.2lPxE6YdV8ed6OYbDucRiod32wqMF9JNerE.wq4glQWaIjRnO', 'John', 'Doe');
INSERT INTO Users(user_id, username, password, name, last_name)
    VALUES(2, 'admin', '{bcrypt}$2y$12$A7x.2lPxE6YdV8ed6OYbDucRiod32wqMF9JNerE.wq4glQWaIjRnO', 'Bill', 'Gates');

INSERT INTO Roles(role_id, role) VALUES(1, 'CUSTOMER');
INSERT INTO Roles(role_id, role) VALUES(2, 'ADMIN');

INSERT INTO Users_Roles(user_id, role_id) VALUES(1, 1);
INSERT INTO Users_Roles(user_id, role_id) VALUES(2, 2);