/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author JR&Maggi
 */
public class Validering {
        private InfDB databas;

    public Validering(){
    connectDB();
    }
    
    
     public boolean textNotEmpty(JTextField passwordFeild){
        if(passwordFeild.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Textfältet tomt!");
        passwordFeild.requestFocus();
        return false;
        }
     return true;   
    }
     public boolean textNotEmpty(JTextField textField, String message){
         if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, message);
            textField.requestFocus();
            return false;
         }
         return true;
     }
     public boolean LoginSuccesAdmin(JTextField user, JPasswordField password){
     try{
        char[] passw = password.getPassword();
        String pass =new String (passw);
        String userName = user.getText();
        String admin = databas.fetchSingle("SELECT ADMINISTRATOR FROM LARARE WHERE EFTERNAMN = '" + userName + "'");
        String lararLosen = databas.fetchSingle("SELECT LOSENORD FROM LARARE WHERE EFTERNAMN = '" + userName + "'");
 
       if(admin!= null && pass!= null && !pass.isEmpty()&& !admin.isEmpty())
        {
       
       if(pass.contains(lararLosen) && admin.equals("T")) {
           return true;
        }     
     }
        else {
          
     return false;
       }
     }
    
     
    catch(InfException ex){
         
        return false;
             }
         
     return false;
     }

     public boolean LoginSuccessLare(JTextField user, JPasswordField password){
         try{
        char[] passw = password.getPassword();
        String pass =new String (passw);
        String userName = user.getText();
        String admin = databas.fetchSingle("SELECT ADMINISTRATOR FROM LARARE WHERE EFTERNAMN = '" + userName + "'");
        String lararLosen = databas.fetchSingle("SELECT LOSENORD FROM LARARE WHERE EFTERNAMN = '" + userName + "'");
       if (admin!= null && pass!= null && !pass.isEmpty() && !admin.isEmpty())
        {
         if (pass.contains(lararLosen) && admin.equals("F")) {
            return true;
     }
        }
       else{
          
           return false;
                   }
          }

          catch(InfException ex){
        return false;
             }
         return false;
     }

     
     private void connectDB(){
        try
        {
           databas = new InfDB("C:\\Hogwarts Projekt\\HOGDB (1).FDB");
           System.out.println("Lyckads");

        }
        catch(InfException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}



