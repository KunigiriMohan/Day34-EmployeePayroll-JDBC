

import java.sql.*;
import java.util.Enumeration;

public class Employee_Payroll {
    public static void main(String[] args) {
        String jdbcurl="jdbc:mysql://localhost:3306/payroll_service?useSSL=false";                  //storing user details in variable
        String userName="root";
        String password="3006";
        Connection con;


        try{                                                                                    //try catch method to catch any exception occurs
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            con = DriverManager.getConnection(jdbcurl, userName, password);
            System.out.println("Connection is Succesful "+con);

            PreparedStatement stmt =con.prepareStatement("select name,start_date from employee_payroll where start_date between cast('2021-01-01' as date) and date(now());");
            ResultSet resultSet=stmt.executeQuery();

            while(resultSet.next()){                                                            //using while loop printing employee data
                String name2 = resultSet.getString("name");
                String date = resultSet.getString("start_date");

                System.out.println(name2+" joining date "+date);
            }
            con.close();
        }
        catch (Exception e)
        {
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
