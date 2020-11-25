/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sarun
 */
public class DvdTable {
    
    public static List<Dvd> findAllDvd() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShopingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Dvd> empList = null;
        try {
            empList = (List<Dvd>) em.createNamedQuery("Dvd.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return empList;
    }
    public static Dvd findDvdById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShopingCartPU");
        EntityManager em = emf.createEntityManager();
        Dvd emp = null;
        try {
            emp = em.find(Dvd.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            emf.close();
        }
        return emp;
    }
    
    public static int updateDvd(Dvd emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShopingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Dvd target = em.find(Dvd.class, emp.getId());
            if (target == null) {
                return 0;
            }
            target.setName(emp.getName());
            target.setRate(emp.getRate());
            target.setYears(emp.getYears());
            target.setPrice(emp.getPrice());
            
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
        
    }
    public static int removeDvd(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShopingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Dvd target = em.find(Dvd.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    
    
    public static int insertDvd(Dvd emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShopingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Dvd target = em.find(Dvd.class, emp.getId());
            if (target != null) {
                return 0;
            }
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    

}
