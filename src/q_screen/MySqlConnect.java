/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q_screen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Support
 */
public class MySqlConnect {
    Connection conn=null;
    public static Connection ConnectDB(){
                      try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:Mysql://10.3.2.248:3306/queuing","root","");
  //JOptionPane.showMessageDialog(null,"connected");
            return conn;
            
        }
        catch(ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            return null;
        }
        }
}
