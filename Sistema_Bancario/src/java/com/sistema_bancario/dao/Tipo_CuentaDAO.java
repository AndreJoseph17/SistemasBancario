/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.dao;

import com.sistema_bancario.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andre
 */
public class Tipo_CuentaDAO {
    
    private Tipo_CuentaDAO tipoCuenta;
    private Tipo_CuentaDAO newtipoCuenta;
    private List<Tipo_CuentaDAO> DaoAllTipoCuenta;
    private List<Tipo_CuentaDAO> DaoSearchTipoCuenta;
    
    public List<Tipo_CuentaDAO> AllTiposCuenta(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            DaoAllTipoCuenta = session.createCriteria(Tipo_CuentaDAO.class).list();
            session.getTransaction().commit();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return DaoAllTipoCuenta;
    }
    
    public List<Tipo_CuentaDAO> SearchBy(String campo, String valor){
        
         Session session = HibernateUtil.getSessionFactory().openSession();
         List<Tipo_CuentaDAO> daoSearchList = new ArrayList<>();
         try {
            session.beginTransaction();
            Query query = session.createQuery("From Servicio S where S."+campo+" =: valor");
            query.setParameter("valor", valor);
            daoSearchList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            
            e.printStackTrace();
            session.getTransaction().rollback();
        }
         
         return daoSearchList;
    }
    
    public void agregarTipoCuenta (Tipo_CuentaDAO newtipoCuenta){

        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            session.merge(newtipoCuenta);
            session.flush();
            session.getTransaction().commit();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        session.close();
    }
    
    public void eliminarTipoCuenta(Tipo_CuentaDAO tipoCuenta){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(tipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }
        session.close();
    }
    
    public void actualizarTipoCuenta(Tipo_CuentaDAO tipoCuenta){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            session.update(tipoCuenta);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
}
