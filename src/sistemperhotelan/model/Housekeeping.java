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
public class Housekeeping extends Karyawan{
    private String posisi;
    
    public Housekeeping(String id, String nama, String gender, String no, String pos){
        super(id,nama,gender,no);
        posisi = pos;
    }
    
    @Override
    public String getPosisi(){
        return posisi;
    }
    
    @Override
    public void info(){
        System.out.print("Housekeeping");
    }
}
