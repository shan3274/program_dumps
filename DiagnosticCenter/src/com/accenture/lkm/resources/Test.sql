create database if not exists diagnosticdb;
use diagnosticdb;

create table if not exits Test(
testID int primary key not null,
testName varchar(35),
charges double);

create table if not exists Bill(
billNo int primary key auto_increment,
patientName varchar(35) not null,
testID int references Test(testID),
dateOfCollection date,
paidAmount double
);

insert into Test(testId, testName, charges) values
(1001, "X-RAY REPORT", 200),
(1002, "ULTRASONOGRAPHY", 1200),
(1003, "ECG REPORT", 1000),
(1004, "EEG REPORT", 3000);

insert into Bill(billNo, patientName, testID, dateOfCollection, paidAmount) values
(5001, "Harry", 1003, "2020-06-01", 800),
(5002, "John", 1004, "2020-05-16", 200),
(5003, "Madam", 1001, "2020-04-08", 150);

commit;