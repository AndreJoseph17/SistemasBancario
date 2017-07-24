/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import com.sistema_bancario.dao.TransaccionDAO;
import com.sistema_bancario.model.pojo.Transaccion;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author EQUIPO
 */
@ManagedBean(name = "transaccionBean")
@ViewScoped
public class TransaccionBean {

    private Transaccion transaccion;
    private List<Transaccion> transacciones;
    
    /**
     * Creates a new instance of TransaccionBean
     */
    public TransaccionBean() {
        transaccion=new Transaccion();
    }

    /**
     * @return the transaccion
     */
    public Transaccion getTransaccion() {
        return transaccion;
    }

    /**
     * @param transaccion the transaccion to set
     */
    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    /**
     * @return the transacciones
     */
    public List<Transaccion> getTransacciones() {
        TransaccionDAO transaccionDao=new TransaccionDAO();
        transacciones=transaccionDao.AllTransaccion();
        return transacciones;
    }
    
    /**
     * @param transacciones the transacciones to set
     */
    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
    
    
    
    public void listarTransacciones(int idCuenta1){
      try{
          TransaccionDAO transaccionDao = new TransaccionDAO();
          transaccionDao.ListarTransaccionesCuentaPrincipal(idCuenta1);
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Transacciones encontradas"));
      }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Alerta", "Error"));
     
      }
       
    }
   
    /*
   public void registarTransaccion(int idCuenta 1, int idCuenta2, double valor){
       TransaccionDAO transaccionDao = new TransaccionDAO();
       transaccionDao.Registrar_Transaccion(idCuenta2, idCuenta2, valor);
       transaccion=new Transaccion();
   }*/
   
   
}
