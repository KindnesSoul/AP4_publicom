/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m.arakelian
 */
public class Connexion {
    
    private static String url = "jdbc:mysql://172.28.1.4:3306/ap4_publicom";//"jdbc:mysql://localhost:3306/ap4_publicom
    private static String user = "ap4";//ap4
    private static String pass = "ap4";//ap4
    private static Connection con = null;
    
    public static Connection getConnection() {
        if(con == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            }catch (Exception ex){
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }  
}
