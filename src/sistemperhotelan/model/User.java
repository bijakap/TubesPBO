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
    private int nomor_kamar;
    private String password;
    
    public User(String pass, int nomor){
        password = pass;
        nomor_kamar = nomor;
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
     
    public int getNomorKamar(){
        return nomor_kamar;
    }
    
    public void setNomorKamar(int nomor){
        nomor_kamar = nomor;
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
