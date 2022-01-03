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
public class Kamar {
    private String tipe;
    private int nomor;
    private String lantai;
    private String status;
    
    public Kamar(String type, int number, String floor, String Status){
        this.tipe = type;
        this.nomor = number;
        this.lantai = floor;
        this.status = Status;
    }
    
    public String getTipe(){
        return this.tipe;
    }
    
    public int getNomor(){
        return this.nomor;
    }
    
    public String getLantai(){
        return this.lantai;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public void setStatus(String Stats){
        this.status = Stats;
    }
    
    public void info(){
        System.out.println(this.tipe);
        System.out.println(this.nomor);
        System.out.println(this.lantai);
        System.out.println(this.status);
    }
}
