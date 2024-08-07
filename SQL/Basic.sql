create table Student(name int,Dept varchar(10),Marks_Scored int); select * from Student;

alter table Student add column Regno int, add column Year int; select * from Student;
alter table Student change name Name int; select * from Student;
alter table Student change Name Name varchar(10) ; select * from Student;

insert into Student values("Sudeep","CSE",90,51,2004),("Sreeram","CSE",89,46,2004); select * from Student;
insert into Student (Name,Regno) values("Sridhanish",45),("Praveen",63); select * from Student;

update Student set Marks_Scored=90 where Marks_Scored=89; select * from Student;
update Student set Marks_Scored=90; select * from Student;
update Student set Marks_Scored=95 where Name="Sudeep"; select * from Student;

delete from Student where `Dept`="CSE"; select * from Student;
delete from Student where `Regno`=63; select * from Student;
delete from Student; select * from Student;

truncate table Student;

drop table Student;


