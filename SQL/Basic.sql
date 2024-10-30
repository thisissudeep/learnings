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




CREATE TABLE Student (Name VARCHAR(20), Regno INT);

INSERT INTO Student VALUES ("Sudeep", 51);

ALTER TABLE Student ADD COLUMN Student_id INT;

UPDATE Student SET Student_id=51 WHERE Name="Sudeep";

INSERT INTO Student VALUES ("Vignesh", 22, 21);

DELIMITER //
CREATE PROCEDURE get_Student()
BEGIN
	SELECT * FROM Student
    WHERE Student_id=51;
    
    SELECT Name FROM Student
    WHERE Student_id=21;
END //
DELIMITER ;
DROP PROCEDURE get_Student;

DELIMITER $$
CREATE PROCEDURE get_Student2(IN Reg INT, IN id INT)
BEGIN
	SELECT * from Student WHERE Regno=Reg;
    SELECT Regno from Student WHERE Student_id=id;
    SELECT * FROM Student ORDER BY Name ASC;
END $$
DELIMITER ;

CREATE VIEW Student_All_Regno AS
SELECT Name , Regno, Student_id
FROM Student;

CALL get_Student2(51,21);

SELECT * FROM Student_All_Regno
ORDER BY Name DESC

DROP VIEW Student_All_Regno;





CREATE TABLE Students1 (Name VARCHAR(10), Regno INT);
INSERT INTO Students1 VALUES ("Sudeep", 51),("Vijay", 22);

CREATE TABLE Students2 (Hobby VARCHAR(25), Regno INT);
INSERT INTO Students2 VALUES ("Watching Tech News", 51),("Playing Cricket", 21);

CREATE TABLE Students3 AS
SELECT s1.Name, s1.Regno, s2.Hobby
FROM Students1 s1
LEFT JOIN Students2 s2 ON s1.Regno=s2.Regno
UNION
SELECT s1.Name, s2.Regno, s2.Hobby
FROM Students1 s1
RIGHT JOIN Students2 s2 ON s1.Regno=s2.Regno;

CREATE VIEW Students_View AS
SELECT Hobby
FROM Students2;

SELECT * FROM Students3;
select * from Students_View;

