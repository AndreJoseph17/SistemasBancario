/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.Cuenta;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
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
    
}
