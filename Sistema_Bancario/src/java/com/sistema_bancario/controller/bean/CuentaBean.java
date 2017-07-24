/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import com.sistema_bancario.dao.CuentaDAO;
import com.sistema_bancario.model.pojo.Cuenta;
import com.sistema_bancario.model.pojo.Servicio;
import com.sistema_bancario.model.pojo.Transaccion;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author EQUIPO
 */
@ManagedBean(name = "cuentaBean")
@ViewScoped
public class CuentaBean implements Serializable{

    private Cuenta cuenta;
    private List<Cuenta> cuentas; 
    
    
    public CuentaBean() {
        cuenta=new Cuenta();
    }
    
    public Cuenta inicializar(){
        setCuenta(new Cuenta());
        return getCuenta();
    }

    /**
     * @return the cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the cuentas
     */
    public List<Cuenta> getCuentas() {
        CuentaDAO cuentaDao=new CuentaDAO();
        cuentas=cuentaDao.AllCuentas();
        return cuentas;
    }

    /**
     * @param cuentas the cuentas to set
     */
    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    
    
    public void agregarCuenta(){
      try{
          CuentaDAO cuentaDao = new CuentaDAO();
          cuentaDao.agregarCuenta(cuenta);
          cuenta=new Cuenta();
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro"));
      }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Alerta", "Error"));
     
      }
       
    }
   
   public void actualizarCuenta(){
       CuentaDAO cuentaDao = new CuentaDAO();
       cuentaDao.actualizarCuenca(cuenta);
       cuenta=new Cuenta();
   }
   
   public void eliminarPropietario(){
       CuentaDAO cuentaDao = new CuentaDAO();
       cuentaDao.eliminarCuenta(cuenta);
       cuenta=new Cuenta();
   }
   
   public String listarItemsServicio(Set<Servicio> items){
       String cadena="";
       for (Iterator<Servicio> iterator = items.iterator(); iterator.hasNext();) {
            Servicio next = iterator.next();
            cadena=next.getTipoServicio()+cadena;
        }
        return cadena;
   }
   
   public String listarItemsTransaccion(Set<Transaccion> items){
       String cadena="";
       for (Iterator<Transaccion> iterator = items.iterator(); iterator.hasNext();) {
            Transaccion next = iterator.next();
            cadena=next.getIdtransaccion()+cadena;
        }
        return cadena;
   }
}
