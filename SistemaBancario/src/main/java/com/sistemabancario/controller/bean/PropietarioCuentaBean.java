/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemabancario.controller.bean;

import com.sistemabancario.dao.PropietarioCuentaDAO;
import com.sistemabancario.model.PropietarioCuenta;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author andre
 */
@Named(value = "propietarioCuentaBean")
@Dependent
public class PropietarioCuentaBean implements Serializable {

    private List<PropietarioCuenta> userList;
    private List<PropietarioCuenta> searchList;
    private List<PropietarioCuenta> searchByRecordNoList;
    
    PropietarioCuentaDAO userDao = new PropietarioCuentaDAO();
    PropietarioCuenta user = new PropietarioCuenta();
    PropietarioCuenta newuser = new PropietarioCuenta();
    
    public List<PropietarioCuenta> getUsers(){
        userList = userDao.AllUsers();
        return userList;
    }
    
    public void agregarPropietario(){
        
        //String Remark = newuser.get
    }
    
    /**
     * Creates a new instance of PropietarioCuentaBean
     */
    public PropietarioCuentaBean() {

    }

}
