create database if not exists m3_c07;
use m3_c07;
-- tạo bảng
create table student(
id int primary key auto_increment,
`name` varchar(50)
);
alter table student add primary key(id);
alter table student modify column id int auto_increment;

-- lấy dữ liệu
select * from student;
select name from student;

-- thêm dữ liệu
insert into student(id,`name`) values(1,"chánh1");
insert into student values(1,"chánh1");
insert into student(`name`) values("chánh1");
insert into student(id,`name`)
values(2,"chánh2"),(3,"chánh3");

-- delete 
delete from student where id =3;
update student set name ='chánh3' where id =3;

-- xoá bảng
drop table student;
drop database m3_c07;


