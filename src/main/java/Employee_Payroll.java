

import java.sql.*;
import java.util.Enumeration;

public class Employee_Payroll {
    public static void main(String[] args) {
        String jdbcurl="jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName="root";
        String password="3006";
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            con = DriverManager.getConnection(jdbcurl, userName, password);
            System.out.println("Connection is Succesful "+con);
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
