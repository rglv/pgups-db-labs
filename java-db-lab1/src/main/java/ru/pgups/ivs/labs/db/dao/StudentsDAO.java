package ru.pgups.ivs.labs.db.dao;

import ru.pgups.ivs.labs.db.model.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class StudentsDAO {
    private DataSource dataSource;

    public StudentsDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> getAllStudents() {
        List<Student> studentsList = new LinkedList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENTS ORDER BY \"RECORD_BOOK_NUM\"");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                studentsList.add(readObject(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentsList;
    }

    public Student get(long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM STUDENTS WHERE id = ?");
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return readObject(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Student readObject(ResultSet rs) throws SQLException {
        Student s = new Student();
        s.setId(rs.getLong("id"));
        s.setName(
                rs.getString("surname") + " "
                        + rs.getString("name") + " "
                        + rs.getString("patronymic")
        );
        s.setStudId(rs.getString("RECORD_BOOK_NUM"));
        java.sql.Date birthday = rs.getDate("BIRTHDAY");
        if (birthday != null) {
            s.setBirthday(new Date(birthday.getTime()));
        }
        return s;
    }
}
