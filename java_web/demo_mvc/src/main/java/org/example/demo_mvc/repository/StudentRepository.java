package org.example.demo_mvc.repository;


import jakarta.servlet.ServletOutputStream;
import org.example.demo_mvc.connect_db.ConnectDB;
import org.example.demo_mvc.dto.StudentDto;
import org.example.demo_mvc.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private final String SELECT_ALL ="select s.*,c.name as class_name from student s join class c on s.class_id = c.id;";
    private final String INSERT_INTO ="insert into student(name,gender,score,class_id) values(?,?,?,?);";
    @Override
    public List<StudentDto> findAll() {
        List<StudentDto> studentList = new ArrayList<>();

        try ( Connection connection = ConnectDB.getConnectDB();){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float score = resultSet.getFloat("score");
                String className = resultSet.getString("class_name");
                studentList.add( new StudentDto(id,name,gender,score,className));
            }
        } catch (SQLException e) {
            System.out.println("lỗi lấy dữ liệu");
        }

        return studentList;
    }

    @Override
    public boolean add(Student student) {

        try (Connection connection = ConnectDB.getConnectDB();){
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setFloat(3,student.getScore());
            preparedStatement.setInt(4,student.getClassId());
           int effectRow = preparedStatement.executeUpdate();
           return effectRow ==1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("lỗi lấy dữ liệu");
        }
        return false;
    }
}
