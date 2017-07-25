/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.dao;

import com.sistema_bancario.model.pojo.PropietarioCuenta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author EQUIPO
 */

@Stateless
public class UsuarioFacade implements UsuarioFacadeLocal{
    @PersistenceContext(unitName = "primePU")
    
    private EntityManager em;
    
    public EntityManager getEntityManager() {
        return em;
    }

      
    public PropietarioCuenta iniciarSesion(){
        PropietarioCuenta propietario=null;
        String consulta;
        try {
            consulta="SELECT p FROM PropietarioCuenta p p.propietario=1 ? and p.clave=2?";
            Query query= em.createQuery(consulta);
            List<PropietarioCuenta> lista=query.getResultList();
            if (!lista.isEmpty()){
                propietario=lista.get(0);
            }
        } catch (Exception e) {
                
            
        }finally{
            em.close();
        }
        return propietario;
    }
            
    
    @Override
    public void create(PropietarioCuenta propietarioCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(PropietarioCuenta propietarioCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(PropietarioCuenta propietarioCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PropietarioCuenta find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PropietarioCuenta> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PropietarioCuenta> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
