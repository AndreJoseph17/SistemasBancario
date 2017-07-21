/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.dao;

import com.sistema_bancario.model.pojo.Transaccion;
import com.sistema_bancario.util.HibernateUtil;
import java.util.Date;
import java.util.List;
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
    
    
}
