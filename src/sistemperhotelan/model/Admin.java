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
public class Admin {
    private Karyawan worker;
    private String email;
    private String password;
    
    public Admin(String surel, String pass){
        email = surel;
        password = pass;
    }
    
    public void setKaryawan(Karyawan karyawan){
        worker = karyawan;
    }
    
    public Karyawan getKaryawan(){
        return worker;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String Surel){
        email = Surel;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String pass){
        password = pass;
    }
    
    public String[] getDataKaryawan(){
        String data[] = new String[5];
        data[0] = worker.getID();
        data[1] = worker.getNama();
        data[2] = worker.getGender();
        data[3] = worker.getHP();
        data[4] = worker.getPosisi();
        return data;
    }    
    
    public void info(){
        System.out.print("Admin");
    }
}
