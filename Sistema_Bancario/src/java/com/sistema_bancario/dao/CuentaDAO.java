/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.dao;

import com.sistema_bancario.model.pojo.Cuenta;
import com.sistema_bancario.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andre
 */
public class CuentaDAO {

    private Cuenta cuenta;
    private Cuenta newcuenta;
    private List<Cuenta> DaoAllCuentas;
    private List<Cuenta> DaoSearchCuentaList;

    public List<Cuenta> AllCuentas() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            DaoAllCuentas = session.createCriteria(Cuenta.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {

            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return DaoAllCuentas;
    }
    
    public List <Cuenta> SearchBy(String campo, String valor){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List <Cuenta> daoSearchList = new ArrayList<>();
        try {
            session.beginTransaction();
            Query query = session.createQuery("From Cuenta C where C."+campo+" =: valor");
            query.setParameter("valor", valor);
            daoSearchList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return daoSearchList;
    }
    
    public void agregarCuenta(Cuenta newcuenta ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           /**
            * Aquí se ingresa la cuenta
            */
            session.beginTransaction();
            session.merge(newcuenta);
            session.flush();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public  void eliminarCuenta(Cuenta cuenta){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            cuenta.setActiva(Boolean.FALSE);
            session.beginTransaction();
            session.update(cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void actualizarCuenca(Cuenta cuenta){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            session.update(cuenta);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        session.close();
    }
}
