/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;



import java.io.File;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Felix Hübinette
 */
public class Start {

    private static InfDB db;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       File databas = new File("HOGDB.FDB");

        try {   
            
            db = new InfDB(databas.getAbsolutePath());
            
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "ERROR:" + ex);
        }

        new Login(db).setVisible(true);
    }

//    public static boolean connectDB(){
//        
//        
//        try{
//            File file = new File("HOGDB (1).FDB");
//            System.out.println("Path to database file: " + file.getAbsolutePath());       
//            
//            databas = new InfDB(file.getAbsolutePath());
//            System.out.println("Connected to database.");          
//            return true;
//        }
//        catch (InfException ex) {
//            System.out.println(ex.getMessage());
//            JOptionPane.showMessageDialog(null, "Could not connect to database.");
//            return false;               
//        }
//    
//    }
}
