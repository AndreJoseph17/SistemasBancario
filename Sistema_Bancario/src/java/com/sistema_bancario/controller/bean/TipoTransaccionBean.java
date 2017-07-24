/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import com.sistema_bancario.model.pojo.TipoTransaccion;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author EQUIPO
 */
@ManagedBean(name = "tipoTransaccionBean")
@ViewScoped
public class TipoTransaccionBean {

    private TipoTransaccion tipoTransaccion;
    private List<TipoTransaccion> tipoTransacciones;
    
    /**
     * Creates a new instance of TipoTransaccionBean
     */
    public TipoTransaccionBean() {
        tipoTransaccion= new TipoTransaccion();
    }

    /**
     * @return the tipoTransaccion
     */
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * @param tipoTransaccion the tipoTransaccion to set
     */
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * @return the tipoTransacciones
     */
    public List<TipoTransaccion> getTipoTransacciones() {
        return tipoTransacciones;
    }

    /**
     * @param tipoTransacciones the tipoTransacciones to set
     */
    public void setTipoTransacciones(List<TipoTransaccion> tipoTransacciones) {
        this.tipoTransacciones = tipoTransacciones;
    }
    
}
