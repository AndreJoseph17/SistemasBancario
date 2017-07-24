/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import com.sistema_bancario.model.pojo.TipoServicio;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author EQUIPO
 */
@Named(value = "tipoServicioBean")
@ViewScoped
public class TipoServicioBean implements Serializable{

    private TipoServicio tipoServicio;
    private List<TipoServicio> tipoServicios;
    
    
    /**
     * Creates a new instance of TipoServicioBean
     */
    public TipoServicioBean() {
        tipoServicio=new TipoServicio();
    }

    /**
     * @return the tipoServicio
     */
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    /**
     * @param tipoServicio the tipoServicio to set
     */
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return the tipoServicios
     */
    public List<TipoServicio> getTipoServicios() {
        return tipoServicios;
    }

    /**
     * @param tipoServicios the tipoServicios to set
     */
    public void setTipoServicios(List<TipoServicio> tipoServicios) {
        this.tipoServicios = tipoServicios;
    }
    
}
