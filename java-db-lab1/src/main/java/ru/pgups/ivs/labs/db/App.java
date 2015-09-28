package ru.pgups.ivs.labs.db;

import org.postgresql.ds.PGPoolingDataSource;
import ru.pgups.ivs.labs.db.dao.StudentsDAO;
import ru.pgups.ivs.labs.db.model.Student;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;


public class App
{
    public static DataSource createDataSource() {
        PGPoolingDataSource poolingDataSource = new PGPoolingDataSource();
        poolingDataSource.setDataSourceName("Lab 1 data source");

        poolingDataSource.setServerName("localhost");
        poolingDataSource.setDatabaseName("java-db-lab1");
        poolingDataSource.setUser("postgres");
        poolingDataSource.setPassword("postgres");
        poolingDataSource.setMaxConnections(8);
        poolingDataSource.setInitialConnections(2);
        return poolingDataSource;
    }

    public static void main( String[] args ) throws SQLException {
        System.out.println("Hello World! This is lab1 example for java-db course.");

        DataSource dataSource = createDataSource();

        StudentsDAO studentsDAO = new StudentsDAO(dataSource);

        System.out.println("= = = = = Students list = = = = = =");
        List<Student> students = studentsDAO.getAllStudents();
        for (Student student : students) {
            System.out.println(String.format("%s (%02d): %s %s",
                    student.getStudId(), student.getId(), student.getName(),
                    student.getBirthday() != null ?
                            " [" + SimpleDateFormat.getDateInstance().format(student.getBirthday()) + "]"
                            : ""));
        }
    }

}
