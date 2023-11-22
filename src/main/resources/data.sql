-- tea
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (1, 'Green Milk Tea', 'tea', 'imageGreenTea.png', 50,40,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (2, 'Oolong Tea', 'tea', 'imageOolong.png', 60,35,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (3, 'Jasmine Tea', 'tea', 'imageJasmine.png', 70,35,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (4, 'Taiwanese Milk tea', 'tea', 'imageTaiwanese.png', 80,40,'active');

-- dessert
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (5, 'Croffle', 'dessert', 'Croffle.png', 50,35,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (6, 'Chese Cake', 'dessert', 'CheseCake.png', 50,55,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (7, 'Chocolate Cake', 'dessert', 'ChocolateCake.png', 50,55,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (8, 'Coconut Cake', 'dessert', 'Coconut Cake.png', 50,55,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (9, 'Almond Croissant', 'dessert', 'AlmondCroissant.png', 50,35,'active');

-- coffee
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (10, 'Mocha', 'coffee', 'Mocha.png', 50,40,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (11, 'Americano Orange', 'coffee', 'Americano Orange.png', 50,60,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (12, 'Americano', 'coffee', 'Americano.png', 50,40,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (13, 'Esspresso', 'coffee', 'Esspresso.png', 50,40,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (14, 'Cappuccino', 'coffee', 'Cappuccino.png', 50,40,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (15, 'Macchiato', 'coffee', 'Macchiato.png', 50,40,'active');

--smoothie
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (16, 'Mixed Berry Smoothie', 'smoothie', 'Mixed Berry Smoothie.png', 50,65,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (17, 'Blueberry Smoothie', 'smoothie', 'Blueberry Smoothie.png', 50,55,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (18, 'Strawberry Smoothie', 'smoothie', 'Strawberry Smoothie.png', 50,55,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (19, 'Mango Smoothie', 'smoothie', 'Mango Smoothie.png', 50,55,'active');
INSERT INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price,dishStatus) VALUES (20, 'Peach Smoothie', 'smoothie', 'Peach Smoothie.png', 50,55,'active');

--mat
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (1, 'milk', 20, 80);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (2, 'greenTea leaf', 30, 60);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (3, 'OolongTea leaf', 40, 55);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (4, 'JasmineTea leaf', 50, 60);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (5, 'TaiwaneseTea leaf', 70, 70);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (6, 'mango', 50, 80);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (7, 'peach', 70, 100);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (8, 'coffee bean', 20, 60);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (9, 'coffee powder', 60, 60);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (10, 'yogurt', 70, 100);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (11, 'ice cube', 90, 20);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (12, 'apple', 50, 40);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (13, 'pineapple', 10, 50);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (14, 'banana', 2, 35);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (15, 'strawberry', 6, 90);
INSERT INTO Material (id, mat_name, mat_amount, matPrice) VALUES (16, 'sugar', 8, 30);

-- user table
INSERT INTO user (id, userName) VALUES (1, 'table01');
INSERT INTO user (id, userName) VALUES (2, 'table02');
INSERT INTO user (id, userName) VALUES (3, 'table03');
INSERT INTO user (id, userName) VALUES (4, 'table04');
INSERT INTO user (id, userName) VALUES (5, 'table05');