/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.dao;

import com.mysql.jdbc.Connection;
import com.sistema_bancario.model.pojo.Transaccion;
import com.sistema_bancario.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andre
 */
public class TransaccionDAO {
    
    private Transaccion transaccion;
    private Transaccion newtransaccion;
    private List<Transaccion> DaoAllTransaccion;
    private List<Transaccion> DaoSearchTransaccionList;
    
    public List<Transaccion> AllTransaccion(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            DaoAllTransaccion = session.createCriteria(Transaccion.class).list();
            session.getTransaction();
        } catch (Exception e) {
            
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return DaoAllTransaccion;
    }
    
    /**
     * Éste proceso es para listar las transacciones 
     * @param idCuentaPrincipal
     * @return 
     */
    
    public List <Transaccion> ListarTransaccionesCuentaPrincipal(Integer idCuentaPrincipal){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List <Transaccion> daoSearchList = new ArrayList<>();
        
        try {
            session.beginTransaction();
            Query query = session.createQuery("From Transaccion T where T.cuenta_idcuenta_principal =:idcuenta order by T.fecha");
            query.setParameter("idcuenta", idCuentaPrincipal);
            daoSearchList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        
        return daoSearchList;
    }
    
   public void Registrar_Transaccion(Integer id_cuenta_principal, Integer id_cuenta_2, Double cantidad){
       
       Session session = HibernateUtil.getSessionFactory().openSession();
       
   }
    
}
