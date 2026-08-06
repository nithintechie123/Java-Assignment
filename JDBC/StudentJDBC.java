// 1. Write a Java program that performs the following:
// i)creates a database table named Student that will hold the name of the
// student(sname),roll number(srollno) and marks(smarks).
// ii)inserts three rows into the Student table.
// iii)retrieves and displays all rows from the Student table.
// iv)retrieves information about the students who have secured more than
// 50 marks.
// v)increases the marks of all the students who scored less than 50 by 4.
// vi)deletes the information about the student with roll number 1008.

import java.sql.*;

public class studentJDBC{
    
    static final String DB_URL="jdbc:mysql://localhost:3306/StudentDB";

    //Database Username and Password
    static final String USER="root";
    static final String PASS="password";

    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt=conn.createStatement();

            //(i) Create Student Table
            String createTable=
                    "CREATE TABLE IF NOT EXISTS Student("+
                    "sname VARCHAR(50)," +
                    "srollno INT PRIMARY KEY," +  "smarks INT)";
            
                    stmt.executeUpdate(createTable);
                    System.out.println("Student table created successfully");
            //(ii)Insert Three Rows
            stmt.executeUpdate("INSERT INTO Student VALUES('Rahul',1001,80)");
            stmt.executeUpdate("INSERT INTO Student VALUES('Anjali',1008,45)");
            stmt.executeUpdate("INSERT INTO Student VALUES('Ramesh',1010,60)");

            System.out.println("3 Records Inserted Successfully");

            //(iii) Display All Rows
            System.out.println("\nAll Students:");
            ResultSet rs=stmt.executeQuery("SELECT * FROM Student");

            while(rs.next()){
                System.out.println(
                    rs.getString("sname")+" "+
                    rs.getInt("srollno") + " "+
                    rs.getInt("smarks")
                );
            }

            //(iv)Students Scoring More than 50
            System.out.println("\nStudents Scoring More than 50:");

            rs=stmt.executeQuery("SELECT * FROM Student WHERE smarks>50");

            while(rs.next()){
                System.out.println(
                    rs.getString("sname")+" "+
                    rs.getInt("srollno")+" "+
                    rs.getInt("smarks")
                );
            }

            //(v)Increase Marks by 4

            int rows=stmt.executeUpdate("UPDATE Student SET smarks=smarks+4 WHERE smarks<50");

            System.out.println("\nMarks Updated for "+rows+" Student(s).");

            //Display Updated Records
            System.out.println("\nUpdated Student Table:");

            rs=stmt.executeQuery(("SELECT * FROM Student"));

            while(rs.next()){
                System.out.println(
                        rs.getString("sname") + "  " +
                        rs.getInt("srollno") + "  " +
                        rs.getInt("smarks"));
            }

            //(vi)Delete Student with Roll No.1008
            rows=stmt.executeUpdate("DELETE FROM Student WHERE srollno=1008");

            System.out.println("\nDeleted "+ rows + "Record.");

            //Final Table
            System.out.println("\nFinal Student Table:");

            rs=stmt.executeQuery("SELECT * FROM Student");
            while(rs.next()){
                System.out.println(
                    rs.getString("sname")+ " "+
                    rs.getInt("srollno")+ " " +
                    rs.getInt("smarks")
                );
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}








