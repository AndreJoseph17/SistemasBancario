/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.Transaccion;
import com.sistemabancario.util.HibernateUtil;
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
    
    /**
     * Aquí se registra las transacciones
     */ 
    
    public void agregarTransaccion(Transaccion newtransaccion){

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            /**
             * Se registra la transacción en la cuenta principal
             */
            session.beginTransaction();
            String idcuenta1 = newtransaccion.getCuentaByCuentaIdcuentaPrincipal().getIdcuenta();
            String hql = "select saldo from Cuenta C where C.idcuenta = "+idcuenta1;
            Query query = session.createQuery(hql);
            List<Double> resultado = query.list();
            Double saldoAnterior = 1.0;
            if(resultado.get(0) != null){
                saldoAnterior = resultado.get(0);
            }
            Double saldoPosterior = saldoAnterior + newtransaccion.getCantidad();
            
            session.merge(newtransaccion);
            
            /**
             * Se registra la segunda transacción
             */
            double cantidad2 = newtransaccion.getCantidad();
            Date fecha2 = newtransaccion.getFecha();
            String cuentaprincipal = newtransaccion.getCuentaByCuentaIdcuenta2().getIdcuenta();
            Integer idTipo_transaccion = 2;
            
            
            
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }
}
