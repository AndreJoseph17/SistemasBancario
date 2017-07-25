/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import com.sistema_bancario.dao.PropietarioCuentaDAO;
import com.sistema_bancario.model.pojo.Cuenta;
import com.sistema_bancario.model.pojo.PropietarioCuenta;
import java.awt.event.ActionEvent;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author andre
 */
@ManagedBean(name = "propietarioCuentaBean")
@ViewScoped
public class PropietarioCuentaBean implements Serializable {

    PropietarioCuenta usuario;
    List<PropietarioCuenta> usuarios;
    //private List<PropietarioCuenta> searchList;
    //private List<PropietarioCuenta> searchByRecordNoList;
    
    //PropietarioCuentaDAO userDao = new PropietarioCuentaDAO();
    
    public PropietarioCuentaBean(){
       usuario=new PropietarioCuenta();
    }
    
    public PropietarioCuenta inicializar(){
        setUsuario(new PropietarioCuenta());
        return getUsuario();
    }
  

    /**
     * @return the usuario
     */
    public PropietarioCuenta getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(PropietarioCuenta usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarios
     */
    public List<PropietarioCuenta> getUsuarios() {
        PropietarioCuentaDAO usuarioDao = new PropietarioCuentaDAO();
        usuarios=usuarioDao.AllUsers();
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<PropietarioCuenta> usuarios) {
        this.usuarios = usuarios;
    }
    
   public void agregarPropietario(){
      try{
          PropietarioCuentaDAO usuarioDao = new PropietarioCuentaDAO();
          usuarioDao.agregarPropietario(usuario);
          usuario=new PropietarioCuenta();
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro"));
      }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Alerta", "Error"));
     
      }
       
    }
   
   public void actualizarPropietario(){
       PropietarioCuentaDAO usuarioDao = new PropietarioCuentaDAO();
       usuarioDao.actualizarPropietario(usuario);
       usuario=new PropietarioCuenta();
   }
   
   public void eliminarPropietario(){
       PropietarioCuentaDAO usuarioDao = new PropietarioCuentaDAO();
       usuarioDao.eliminarPropietario(usuario);
       usuario=new PropietarioCuenta();
   }
   
   
   public void getIdUsuario(ActionEvent event){
       PropietarioCuentaDAO usuarioDao = new PropietarioCuentaDAO();
       RequestContext context = RequestContext.getCurrentInstance();
       FacesMessage message = null;
       boolean loggedIn = false;
       if(usuario.getLogin()!= null && usuario.getPassword() != null ){
           String idusuario = usuarioDao.getIdUsuario(usuario.getLogin(), usuario.getPassword());
           if(usuario != null){
               loggedIn = true;
               message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", idusuario);
           }else {
               loggedIn = false;
               message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Usuario inválido");
           }
       }else{
           message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Ingrese ambos campos");
       }
       FacesContext.getCurrentInstance().addMessage(null, message);
       context.addCallbackParam("IngresoCorrecto", loggedIn);
   }
   
   /*
   public String getIdUsuario(String login, String clave){
       String idUsuario=null;
       String redireccion=null;
       try {
            PropietarioCuentaDAO usuarioDao = new PropietarioCuentaDAO();
            idUsuario=usuarioDao.getIdUsuario(login, clave);
            redireccion="index"; 
            return idUsuario;
       } catch (Exception e) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Alerta", "Error"));
     
       }
       
       return redireccion; 
   }
    */
   
   public String listarItems(Set<Cuenta> items){
       String cadena="";
       for (Iterator<Cuenta> iterator = items.iterator(); iterator.hasNext();) {
            Cuenta next = iterator.next();
            cadena=next.getIdcuenta()+cadena;
        }
        return cadena;
   }

}
