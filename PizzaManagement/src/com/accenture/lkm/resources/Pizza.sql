 create database pizza_db;
 use pizza_db;
 
 create table IF NOT EXISTS Pizza(
pizzaId int(11) NOT NULL AUTO_INCREMENT,
pizzaName varchar(20),
price double, PRIMARY KEY(pizzaId)
 );
 
 insert into pizza (pizzaId,pizzaName,price) values
  (1001,'XYZVegS',200),
  (1002,'XYZVegM',400),
   (1003,'XYZVegL',600),
   (1004,'XYZNonVegS',400);

 create table pizza_order
( 
orderId int primary key auto_increment,
customerName varchar(30),
contactNumber varchar(10),
pizzaId int references pizza(pizzaId),
numberOfPiecesOrdered int,
bill double
);

INSERT INTO pizza_order(orderId, customerName, contactNumber, pizzaId, numberOfPiecesOrdered, bill) VALUES
    (5001, "Michael", "1234567890", 1001, 1 , 200),
    (5002, "Jonas", "7845123690", 1001, 2 , 400),
    (5003, "Martha", "9876543210", 1003, 1 , 600),
    (5004, "Adam", "5412821154", 1004, 2 , 800);
    
 commit;