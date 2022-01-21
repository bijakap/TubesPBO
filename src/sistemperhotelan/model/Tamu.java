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
public class Tamu {
    private String id_tamu;
    private String nama_tamu;
    private String no_hp;
    
    public Tamu(String id, String nama, String no){
        id_tamu = id;
        nama_tamu = nama;
        no_hp = no;
    }
    
    public String getID(){
        return id_tamu;
    }
    
    public String getNama(){
        return nama_tamu;
    }
    
    public String getHP(){
        return no_hp;
    }
}
