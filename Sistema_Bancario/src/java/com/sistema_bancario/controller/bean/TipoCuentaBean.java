/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import com.sistema_bancario.model.pojo.TipoCuenta;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author EQUIPO
 */
@ManagedBean(name = "tipoCuentaBean")
@ViewScoped
public class TipoCuentaBean {

    private TipoCuenta tipoCuenta;
    private List<TipoCuenta> tipoCuentas;
    
    
    public TipoCuentaBean() {
    }

    /**
     * @return the tipoCuenta
     */
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * @param tipoCuenta the tipoCuenta to set
     */
    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /**
     * @return the tipoCuentas
     */
    public List<TipoCuenta> getTipoCuentas() {
        return tipoCuentas;
    }

    /**
     * @param tipoCuentas the tipoCuentas to set
     */
    public void setTipoCuentas(List<TipoCuenta> tipoCuentas) {
        this.tipoCuentas = tipoCuentas;
    }
    
}
