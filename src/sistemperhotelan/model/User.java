/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemperhotelan.model;

/**
 *
 * @author bijak
 */
public class User {
    private Tamu tamu;
    private String password;
    
    public User(String pass){
        password = pass;
    }
    
    public void setTamu(Tamu guest){
        tamu = guest;
    }
    
    public Tamu getTamu(){
        return tamu;
    }
    
    public String getPassword(){
        return password;
    }
    
     public void setPassword(String pass){
        password = pass;
    }
    
     
    public String[] getDataKaryawan(){
        String data[] = new String[3];
        data[0] = tamu.getID();
        data[1] = tamu.getNama();
        data[2] = tamu.getHP();
        return data;
    }    
    
    public void info(){
        System.out.print("Tamu");
    }
}
