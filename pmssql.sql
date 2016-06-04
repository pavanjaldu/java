CREATE TABLE Discount(discountId INT PRIMARY KEY ,discountName VARCHAR(100),description VARCHAR(100),
discount_percentage DECIMAL(10,4),validThru DATE);


CREATE TABLE Category(category_Id INT PRIMARY KEY,category_Name VARCHAR(200),description VARCHAR(250));

CREATE TABLE SubCategory (sub_category_Id INT PRIMARY KEY,sub_category_Name VARCHAR(250),category_Id INT REFERENCES Category(category_Id));


CREATE TABLE Supplier(supplierId INT PRIMARY KEY,firstName VARCHAR(100),lastName VARCHAR(100),
address VARCHAR(250),city VARCHAR(50),state VARCHAR(50),
pincode VARCHAR(50),contactno VARCHAR(50));


CREATE TABLE Product(productId INT PRIMARY KEY AUTO_INCREMENT,productName VARCHAR(250),
description VARCHAR(250),
manufacturing_date DATE,
expiry_date DATE,max_retail_price DECIMAL(10,4),
category_Id INT REFERENCES Category(category_Id),
sub_category_Id INT REFERENCES SubCategory(sub_category_Id),
supplierId INT REFERENCES Supplier(supplierId),
quantity INT,ratings DECIMAL(8,2));


CREATE TABLE productDiscountTable(productId INT REFERENCES product(productId) ON DELETE CASCADE , discountId INT REFERENCES discount(discountId));

INSERT INTO Discount VALUES(123, 'Mega Offer', 'Mega offer From Jan to Feb', 12.4,'2019-01-15');

INSERT INTO Discount VALUES(333, 'Dewali Offer', 'Dewali offer ', 15.4,'2017-01-21');

INSERT INTO Discount VALUES(678, 'New Year Offer', 'New Year offer ', .50,'2016-12-12');

INSERT INTO Discount VALUES(1234, 'XMas Offer', 'Xmas offer ', .55,'2019-01-15');

INSERT INTO Discount VALUES(340, 'Pongal Offer', 'Pongal offer ', 12.78,'2019-01-15');




INSERT INTO Supplier VALUES(111, 'Tom', 'Jerry', 'North Avvenue', 'Chennai', 'Tamil Nadu', '600041', '6576575');

INSERT INTO Supplier VALUES(222, 'Jack', 'Thomson', 'South Avvenue', 'Chennai', 'Tamil Nadu', '600341', '78987978');

INSERT INTO Supplier VALUES(333, 'Kamal', 'Emi', 'West Avvenue', 'Chennai', 'Tamil Nadu', '600001', '787665765');

INSERT INTO Supplier VALUES(444, 'Annie', 'Kenn', 'EAST Avvenue', 'Pune', 'Maharastra', '600121', '5464565645');

INSERT INTO Supplier VALUES(555, 'Vimal', 'Desai', '7th Avvenue', 'Pune', 'Maharastr','600121', '87686787');

INSERT INTO Supplier VALUES(666, 'Bimal', 'Singh', '12th Avvenue', 'Pune', 'Maharastra', '600121', '12456767');




INSERT INTO Category VALUES(1, 'Electronics', 'Electronic Items');

INSERT INTO Category VALUES(2, 'Clothing', 'All Cloth Varity');

INSERT INTO Category VALUES(3, 'Health&Care', 'Health And Hospitality');

INSERT INTO Category VALUES(4, 'HouseHolds', 'HouseHold Items');

INSERT INTO Category VALUES(5, 'Sports', 'Games related Item');


INSERT INTO SubCategory VALUES(101, 'Mobile',1);

INSERT INTO SubCategory VALUES(102, 'PowerBank',1);

INSERT INTO SubCategory VALUES(103, 'Data Storage',1);

INSERT INTO SubCategory VALUES(201, 'T-Shirt',2);

INSERT INTO SubCategory VALUES(202, 'Kurta',2);

INSERT INTO SubCategory VALUES(203, 'Saree',2);

INSERT INTO SubCategory VALUES(204, 'Kids Wear',2);

INSERT INTO SubCategory VALUES(301, 'Diabetic Shoes',3);

INSERT INTO SubCategory VALUES(302, 'Diabetic Metre',3);

INSERT INTO SubCategory VALUES(303, 'Diabetic Shoes',3);


INSERT INTO SubCategory VALUES(401, "Dining Sets",4);

INSERT INTO SubCategory VALUES(402, 'Cooker',4);

INSERT INTO SubCategory VALUES(403, 'Knife',4);

INSERT INTO SubCategory VALUES(404, 'Glasses',4);


INSERT INTO SubCategory VALUES(501, 'Cricket Bat',5);10

INSERT INTO SubCategory VALUES(502, 'Cricket Ball',5);

INSERT INTO SubCategory VALUES(503, 'Hockey bat',5);


INSERT INTO SubCategory VALUES(504, 'Hockey Ball',5);

INSERT INTO SubCategory VALUES(505, 'Volley Ball',5);