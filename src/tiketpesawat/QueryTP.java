/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketpesawat;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author incha
 */
public class QueryTP {
     public void Add (Object object){
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("tiketPesawatPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
                em.persist(object);
                em.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
        } finally {
                em.close();
        }
    }
    
    public void update(long id,String nama,String alamat){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("tiketPesawatPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        em.createQuery("UPDATE pesawatTiket e SET e.nama=?1,e.alamat?2, WHERE e.id?3",pesawatTiket.class)
                .setParameter(1, nama)
                .setParameter(2, alamat)
                .setParameter(3,id)
                .executeUpdate();       
        em.getTransaction().commit();
  }
    
    
public void hapus(long id){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("tiketPesawatPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        int hapusyu=em.createQuery("DELETE FROM pesawatTiket e WHERE e.id=:par").setParameter("par", id).executeUpdate();
        em.getTransaction().commit();
}
  public void Show() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("tiketPesawatPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM pesawatTiket e");
        List<pesawatTiket> result = query.getResultList();
        for (pesawatTiket e : result) {
                 
                 System.out.println("ID AGEN :"+ e.getId()+ "\n NAMA :" + e.getNama()+"\n Alamat :"+ e.getAlamat());   
        }
  }}
