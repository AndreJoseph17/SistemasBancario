/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import Model.PropietarioCuenta;
import java.util.List;

/**
 *
 * @author EQUIPO
 */

@ManagedBean
@ViewScoped
public class PropietarioCuentaBean {
    
    /**
     * Creates a new instance of PropietarioCuentaBean
     */
    
    private PropietarioCuenta propietario;
    private List<PropietarioCuenta> propietarios;

    public PropietarioCuentaBean() {
        propietario=new PropietarioCuenta();
    }

    /**
     * @return the propietario
     */
    public PropietarioCuenta getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(PropietarioCuenta propietario) {
        this.propietario = propietario;
    }

    /**
     * @return the propietarios
     */
    public List<PropietarioCuenta> getPropietarios() {
        return propietarios;
    }

    /**
     * @param propietarios the propietarios to set
     */
    public void setPropietarios(List<PropietarioCuenta> propietarios) {
        this.propietarios = propietarios;
    }
    
    
}
