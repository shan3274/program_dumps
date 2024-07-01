
-- Table Script goes here.
create database jagograhak;
use jagograhak;

create table CompliantType(
     compliantTypeId int primary key,
     compliantTypeName varchar(50) not null
     );
     
create table Compliant(
     compliantId int(10) primary key auto_increment,
     customerName varchar(50) not null,
     description varchar(100),
     dateOfIncidence date,
     amount double,
     compliantTypeId int(10) references CompliantType(compliantTypeId)
     );
     
insert into CompliantType values (1001,'Quality-related'),
(1002,'Cost-related'),
(1003,'Delivery-related'),
(1004,'Wait Time-related');

insert into Compliant values
(1,'Vikram Seth','Quality is not as expected','2018-01-22',30000.0,1001),
(2,'Adira','Overcharged on bill than actual price','2019-01-12',50000.0,1002),
(3,'Aadidev','Wrong Product delivered','2020-01-24',70000.0,1003);

commit;

