/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.dao;

import com.sistema_bancario.model.pojo.PropietarioCuenta;
import com.sistema_bancario.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
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
    
    public List<PropietarioCuenta> SearchByRecordNo(String campo, String valor){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PropietarioCuenta> daoSearchList = new ArrayList<>();
        
        try{
            session.beginTransaction();
            Query query = session.createQuery("From PropietarioCuenta PC where PC."+campo+" =:valor");
            query.setParameter("valor", valor);
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
    /**
     * Método para obtener el id del usuario con login y clave
     * @param login
     * @param clave
     * @return 
     */
    
    public String getIdUsuario (String login, String clave){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String userId = "";
        try{
            String hql = " select idusuario from PropietarioCuenta pc"
                    + " where pc.login =:usuario and pc.password =:clave ";
            
            Query query = session.createQuery(hql);
            query.setParameter("usuario",login);
            query.setParameter("clave",clave);
            List<String> lista = null;
            lista = (List<String>)query.list();
            userId = lista.get(0);
            session.flush();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        //session.close();
        return userId;
        
    }
    
}
