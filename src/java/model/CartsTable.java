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
public class CartsTable {
    
    public static List<Carts> findAllCarts() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShopingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Carts> empList = null;
        try {
            empList = (List<Carts>) em.createNamedQuery("Carts.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return empList;
    }
    public static Carts findCartsById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShopingCartPU");
        EntityManager em = emf.createEntityManager();
        Carts emp = null;
        try {
            emp = em.find(Carts.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            emf.close();
        }
        return emp;
    }
    
    public static int updateCarts(Carts emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShopingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Carts target = em.find(Carts.class, emp.getId());
            if (target == null) {
                return 0;
            }
            target.setName(emp.getName());
            target.setRate(emp.getRate());
            target.setYears(emp.getYears());
            target.setPrice(emp.getPrice());
            target.setQty(emp.getQty());
            
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
    public static int removeCarts(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShopingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Carts target = em.find(Carts.class, id);
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
    
    
    public static int insertCarts(Carts cart) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShopingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Carts target = em.find(Carts.class, cart.getId());
            if (target != null) {
                return 0;
            }
            em.persist(cart);
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

    public static Carts findDvdById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
