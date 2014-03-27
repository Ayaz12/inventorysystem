/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ayaz
 */
public class Vendor {
    
    private String name;
    private String number;
    private String City;
    private String address;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/inventorysystem";

    static final String USER = "root";
    static final String PASS = "123456";
   
    
    public Vendor(String name, String number, String address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }

    public Vendor() {
    }

    
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
   
    public static void main(String[] arg) throws SQLException
    {
        Connection con = null;
        Statement stat = null;
   try{
       Class.forName("com.mysql.jdbc.Driver");
       
       System.out.println("Connecting to database..");
       con = DriverManager.getConnection(DB_URL, USER, PASS);
       
       System.out.println("Creating statement..");
       stat = con.createStatement();
       
       String sql;
       sql = ("SELECT id ,name, address, number FROM vendor");
       ResultSet rs = stat.executeQuery(sql);
   
       while(rs.next())
       {
           int id = rs.getInt("id");
           String name = rs.getString("name");
           String number = rs.getString("number");
           String address = rs.getString("address");
         
                   
           
           System.out.print(" ID: " + id);
           System.out.print(" name: " + name);
           System.out.print(" address: " + address);
           System.out.println(" number: " + number);
           
       }
       rs.close();
       con.close();
       stat.close();
   } catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
     
      try{
         if(stat!=null)
            stat.close();
      }catch(SQLException se){
      }
      try{
         if(con!=null)
            con.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   
   }
                  
       }
   
   
    

