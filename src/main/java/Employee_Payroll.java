

import java.sql.*;
import java.util.Enumeration;

public class Employee_Payroll {
    public static void main(String[] args) {
        String jdbcurl="jdbc:mysql://localhost:3306/payroll_service?useSSL=false";                  //storing user details in variable
        String userName="root";
        String password="3006";
        Connection con;
        Statement statement;
        try{                                                                                    //try catch method to catch any exception occurs
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            con = DriverManager.getConnection(jdbcurl, userName, password);
            System.out.println("Connection is Succesful "+con);
            statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from employee_payroll");
            while(resultSet.next()){                                                            //using while loop printing employee data
                String name = resultSet.getString("name");
                String date = resultSet.getString("start_date");

                System.out.print(name+"   "+date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        listDrivers();
    }

    /**
     * listDrivers() method to list the Drivers
     * */
    public static void listDrivers(){
        Enumeration<Driver> driverEnumeration= DriverManager.getDrivers();
        while(driverEnumeration.hasMoreElements()){
            Driver driver= (Driver) driverEnumeration.nextElement();
            System.out.println("  "+driverEnumeration.getClass().getName());
        }
    }
}
