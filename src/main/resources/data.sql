-- tea
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (1, 'Green Milk Tea', 'tea', 'imageGreenTea.png', 50,40);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (2, 'Oolong Tea', 'tea', 'imageOolong.png', 60,35);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (3, 'Jasmine Tea', 'tea', 'imageJasmine.png', 70,35);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (4, 'Taiwanese Milk tea', 'tea', 'imageTaiwanese.png', 80,40);

-- dessert
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (5, 'Croffle', 'dessert', 'Croffle.png', 50,35);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (6, 'Chese Cake', 'dessert', 'CheseCake.png', 50,55);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (7, 'Chocolate Cake', 'dessert', 'ChocolateCake.png', 50,55);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (8, 'Coconut Cake', 'dessert', 'Coconut Cake.png', 50,55);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (9, 'Almond Croissant', 'dessert', 'AlmondCroissant.png', 50,35);

-- coffee
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (10, 'Mocha', 'coffee', 'Mocha.png', 50,40);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (11, 'Americano Orange', 'coffee', 'Americano Orange.png', 50,60);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (12, 'Americano', 'coffee', 'Americano.png', 50,40);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (13, 'Esspresso', 'coffee', 'Esspresso.png', 50,40);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (14, 'Cappuccino', 'coffee', 'Cappuccino.png', 50,40);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (15, 'Macchiato', 'coffee', 'Macchiato.png', 50,40);

--smoothie
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (16, 'Mixed Berry Smoothie', 'smoothie', 'Mixed Berry Smoothie.png', 50,65);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (17, 'Blueberry Smoothie', 'smoothie', 'Blueberry Smoothie.png', 50,55);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (18, 'Strawberry Smoothie', 'smoothie', 'Strawberry Smoothie.png', 50,55);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (19, 'Mango Smoothie', 'smoothie', 'Mango Smoothie.png', 50,55);
INSERT IGNORE INTO Dishes (id, dish_name, dishtype, dish_picture, dish_stock,dish_price) VALUES (20, 'Peach Smoothie', 'smoothie', 'Peach Smoothie.png', 50,55);

--mat
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (1, 'milk', 20);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (2, 'greenTea leaf', 30);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (3, 'OolongTea leaf', 40);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (4, 'JasmineTea leaf', 50);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (5, 'TaiwaneseTea leaf', 70);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (6, 'mango', 50);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (7, 'peach', 70);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (8, 'coffee bean', 20);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (9, 'coffee powder', 60);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (10, 'yogurt', 70);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (11, 'ice cube', 90);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (12, 'apple', 50);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (13, 'pineapple', 10);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (14, 'banana', 2);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (15, 'strawberry', 6);
INSERT IGNORE INTO Material (id, mat_name, mat_amount) VALUES (16, 'sugar', 8);

-- user table
INSERT IGNORE INTO user (id, userName) VALUES (1, 'table01');
INSERT IGNORE INTO user (id, userName) VALUES (2, 'table02');
INSERT IGNORE INTO user (id, userName) VALUES (3, 'table03');
INSERT IGNORE INTO user (id, userName) VALUES (4, 'table04');
INSERT IGNORE INTO user (id, userName) VALUES (5, 'table05');