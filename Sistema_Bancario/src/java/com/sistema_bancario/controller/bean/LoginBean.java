/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import com.sistema_bancario.dao.PropietarioCuentaDAO;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
/**
 *
 * @author andre
 */
@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{

    /**
     * Creates a new instance of LoginBean
     */
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /*    
    public void getIdUsuario(ActionEvent event){
       PropietarioCuentaDAO usuarioDao = new PropietarioCuentaDAO();
       RequestContext context = RequestContext.getCurrentInstance();
       FacesMessage message = null;
       boolean loggedIn = false;
       if(login != null && password != null ){
           String idusuario = usuarioDao.getIdUsuario(login, password);
           
           if(idusuario != null){
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
   */
    public void getIdUsuario(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(login != null && login.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", login);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    } 
}
