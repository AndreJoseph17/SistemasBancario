/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.dao;

import com.sistema_bancario.model.pojo.Servicio;
import com.sistema_bancario.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import org.hibernate.Query;
import org.hibernate.Session;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author andre
 */

/**
 * Mapeo de procedimiento almacenado - registrar_pago_servicio
 */
@NamedStoredProcedureQuery(
        name = "registrar_pago_servicio",
        procedureName = "registrar_pago_servicio",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "valor_pagar"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "id_planilla"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "id_servicio"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "id_cuenta_principal"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "valor_retorno")})

public class ServicioDAO {
    
    private Servicio servicio;
    private Servicio newservicio;
    private List<Servicio> DaoAllServicio;
    private List<Servicio> DaoSearchServiciosList;
    
    

    public List<Servicio> AllServicios(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            
            session.beginTransaction();
            DaoAllServicio = session.createCriteria(Servicio.class).list();
            session.getTransaction().commit();
               
        } catch (Exception e) {
            
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return DaoAllServicio;
    }
    
    public List<Servicio> SearchBy (String campo, String valor){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Servicio> daoSearchList = new ArrayList<>();
        try{
            session.beginTransaction();
            Query query = session.createQuery("From Servicio S where S."+campo+" =: valor");
            query.setParameter("valor", valor);
            daoSearchList = query.list();
            session.getTransaction().commit();
        }catch(Exception e){
            
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return daoSearchList;
    }
    
    public void agregarServicio(Servicio newservicio){

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            /**
             * Aquí se agrega el servicio
             */
            session.beginTransaction();
            session.merge(newservicio);
            session.flush();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public void eliminarServicio(Servicio servicio){

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(servicio);
            session.getTransaction().commit();
        } catch (Exception e) {
            
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }
        session.close();
    }
    
    public void actualizarServicio(Servicio servicio){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            session.update(servicio);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
    
}
