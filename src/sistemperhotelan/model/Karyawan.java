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
public abstract class Karyawan implements Interface_Karyawan{
    private String id_karyawan;
    private String nama_karyawan;
    private String gender_karyawan;
    private String no_hp;
    
    public Karyawan(String id, String nama, String gender, String no){
        id_karyawan = id;
        nama_karyawan = nama;
        gender_karyawan = gender;
        no_hp = no;
    }
    
    public String getID(){
        return id_karyawan;
    }
    
    public String getNama(){
        return nama_karyawan;
    }
    
    public String getGender(){
        return gender_karyawan;
    }
    
    public String getHP(){
        return no_hp;
    }
}
