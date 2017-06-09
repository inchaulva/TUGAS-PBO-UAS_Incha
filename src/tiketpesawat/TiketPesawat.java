/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketpesawat;

import java.util.Scanner;

/**
 *
 * @author incha
 */
public class TiketPesawat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        pesawatTiket entityObjk =new pesawatTiket();
        QueryTP tambah = new QueryTP();
        Scanner input=new Scanner(System.in);
        String nama,jwb,alamat;
        long id;
        
        System.out.println("SELAMAT DATANG DI tiket pesawat");
        System.out.println("Masukkan Biodata Anda :");
        System.out.print("Nama Lengkap :");nama = input.nextLine();
        System.out.print("Alamat :");alamat=input.nextLine();
        entityObjk.setNama(nama);
        entityObjk.setAlamat(alamat);
        tambah.Add(entityObjk);
        
        System.out.println("Apakah data anda ingin dilihat kan ? jawab ya/no");jwb=input.nextLine();
        if(jwb.equals("ya")){
        tambah.Show();
        }
        
        System.out.println("Apakah data anda ingin di rubah/di hapus kan ?\n"
                + "jawab lanjut : untuk rubah "
                + "\n jawab ok : untuk hapus");
        jwb=input.nextLine();
        
        if(jwb.equals("lanjut")){
            System.out.print("Nama :");nama = input.nextLine();
            System.out.print("Alamat :");alamat = input.nextLine();
            System.out.print("ID :");id=input.nextLong();
            tambah.update(id,nama,alamat);
            tambah.Show();
            
        }else if(jwb.equals("ok")){
            tambah.Show();
            System.out.print("Masukan ID :");id=input.nextLong();
            tambah.hapus(id);
            tambah.Show();
        }
        
    
        
    }
    
}
    
    

