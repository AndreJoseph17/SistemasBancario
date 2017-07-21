/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.PropietarioCuenta;
import com.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andre
 */
public class PropietarioCuentaDAO {
    
    private PropietarioCuenta user;
    private PropietarioCuenta newuser;
    private List<PropietarioCuenta> DaoAllUsers;
    private List<PropietarioCuenta> DaoSearchUserList;
    
    public List<PropietarioCuenta> AllUsers(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            DaoAllUsers = session.createCriteria(PropietarioCuenta.class).list();
            int count = DaoAllUsers.size();
            
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return DaoAllUsers;
    }
    
    public List<PropietarioCuenta> SearchByRecordNo(String RecordNo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PropietarioCuenta> daoSearchList = new ArrayList<>();
        
        try{
            session.beginTransaction();
            Query query = session.createQuery("From PropietarioCuenta PC where PC.recordNo =:recordNo");
            query.setParameter("recordNo", RecordNo);
            daoSearchList = query.list();
            int count = daoSearchList.size();
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        return daoSearchList;
    }
    
    /**
     * Ingreso de un nuevo usuario a la tabla PropietarioCuenta
     */
    public void agregarPropietario(PropietarioCuenta newuser){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            String id = newuser.getIdusuario();
            //Aquí se viene lo chido :v 
            session.beginTransaction();
            session.merge(newuser);
            session.flush();
            System.out.println("El id del nuevo usuario es: "+newuser.getIdusuario());
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            
        }
        session.close();
        
    }
    
    public void eliminarPropietario(PropietarioCuenta user){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(user);
            session.delete(user);
            session.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public void actualizarPropietario(PropietarioCuenta user){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(user);
            session.flush();
            session.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
}
