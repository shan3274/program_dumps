
-- Table Script goes here.
DROP DATABASE IF EXISTS springmvcmock; 
create database springmvcmock; 
use springmvcmock;  
create table if not exists Customer(  
customerId int(10) auto_increment,      
customerName varchar(20),      
billingDate date,     
bill double(10,2),     
customerType varchar(3), 
PRIMARY KEY(customerId)); 

create table customerTypes( 
customerType varchar(3),   
minimumBill double(10,2),
maximumBill double(10,2),  
PRIMARY KEY(customerType)); 

insert into Customer values      
(1001,'Jack','2018-01-12',6000,'P'),    
(1002,'Mark','2019-04-10',3000,'G');     

insert into CustomerTypes values      
('S',1001,2000),      
('G',2001,5000),   
('P',5001,10000); 