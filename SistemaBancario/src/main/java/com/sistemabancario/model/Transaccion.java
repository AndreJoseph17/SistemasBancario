package com.sistemabancario.model;
// Generated 18/07/2017 16:11:11 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Transaccion generated by hbm2java
 */
@Entity
@Table(name="transaccion"
    ,catalog="bancodb"
)
public class Transaccion  implements java.io.Serializable {


     private String idtransaccion;
     private Cuenta cuentaByCuentaIdcuenta2;
     private Cuenta cuentaByCuentaIdcuentaPrincipal;
     private TipoTransaccion tipoTransaccion;
     private double cantidad;
     private Date fecha;
     private Set<Planilla> planillas = new HashSet<Planilla>(0);

    public Transaccion() {
    }

	
    public Transaccion(String idtransaccion, Cuenta cuentaByCuentaIdcuenta2, Cuenta cuentaByCuentaIdcuentaPrincipal, TipoTransaccion tipoTransaccion, double cantidad, Date fecha) {
        this.idtransaccion = idtransaccion;
        this.cuentaByCuentaIdcuenta2 = cuentaByCuentaIdcuenta2;
        this.cuentaByCuentaIdcuentaPrincipal = cuentaByCuentaIdcuentaPrincipal;
        this.tipoTransaccion = tipoTransaccion;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    public Transaccion(String idtransaccion, Cuenta cuentaByCuentaIdcuenta2, Cuenta cuentaByCuentaIdcuentaPrincipal, TipoTransaccion tipoTransaccion, double cantidad, Date fecha, Set<Planilla> planillas) {
       this.idtransaccion = idtransaccion;
       this.cuentaByCuentaIdcuenta2 = cuentaByCuentaIdcuenta2;
       this.cuentaByCuentaIdcuentaPrincipal = cuentaByCuentaIdcuentaPrincipal;
       this.tipoTransaccion = tipoTransaccion;
       this.cantidad = cantidad;
       this.fecha = fecha;
       this.planillas = planillas;
    }
   
     @Id 

    
    @Column(name="idtransaccion", unique=true, nullable=false, length=45)
    public String getIdtransaccion() {
        return this.idtransaccion;
    }
    
    public void setIdtransaccion(String idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cuenta_idcuenta_2", nullable=false)
    public Cuenta getCuentaByCuentaIdcuenta2() {
        return this.cuentaByCuentaIdcuenta2;
    }
    
    public void setCuentaByCuentaIdcuenta2(Cuenta cuentaByCuentaIdcuenta2) {
        this.cuentaByCuentaIdcuenta2 = cuentaByCuentaIdcuenta2;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cuenta_idcuenta_principal", nullable=false)
    public Cuenta getCuentaByCuentaIdcuentaPrincipal() {
        return this.cuentaByCuentaIdcuentaPrincipal;
    }
    
    public void setCuentaByCuentaIdcuentaPrincipal(Cuenta cuentaByCuentaIdcuentaPrincipal) {
        this.cuentaByCuentaIdcuentaPrincipal = cuentaByCuentaIdcuentaPrincipal;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipo_transaccion_idtipo_transaccion", nullable=false)
    public TipoTransaccion getTipoTransaccion() {
        return this.tipoTransaccion;
    }
    
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    
    @Column(name="cantidad", nullable=false, precision=22, scale=0)
    public double getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="transaccion")
    public Set<Planilla> getPlanillas() {
        return this.planillas;
    }
    
    public void setPlanillas(Set<Planilla> planillas) {
        this.planillas = planillas;
    }




}


