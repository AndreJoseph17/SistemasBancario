/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.TipoServicio;
import com.sistemabancario.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andre
 */
public class Tipo_ServicioDAO {
    
    private TipoServicio tipoServ;
    private TipoServicio newTipoServ;
    private List <TipoServicio> DaoAllTipoServ;
    private List <TipoServicio> DaoSearchTipoServList;
    
    public List <TipoServicio> AllTipoServ(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            DaoAllTipoServ = session.createCriteria(TipoServicio.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally{
            session.close();
        }
        return DaoAllTipoServ;
     
    }
    
    public List<TipoServicio> SearchBy(String campo, String valor){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List <TipoServicio> daoSearchList = new ArrayList<>();
        try{
            session.beginTransaction();  
            Query qu = session.createQuery("From TipoServicio tp where tp."+campo+" =: valor"); //User is the entity not the table  
            qu.setParameter("valor", valor);  
            daoSearchList = qu.list();  
            int count = daoSearchList.size();  
            session.getTransaction().commit(); 
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return daoSearchList;
    }
    
    public void agregarTipoServ(TipoServicio newtipo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();  
            session.merge(newtipo);  
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public void eliminarTipoServicio(TipoServicio tipoServ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();  
            session.delete(tipoServ);  
            session.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();  
            session.getTransaction().rollback(); 
        }
        session.close();
    }
    
    public void actualizarTipoServ(TipoServicio tipoServ){
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            session.beginTransaction();  
            session.update(tipoServ);  
            session.flush();  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();  
    }
    
}
