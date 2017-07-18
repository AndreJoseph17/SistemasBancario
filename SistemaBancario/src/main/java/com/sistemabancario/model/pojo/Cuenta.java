package com.sistemabancario.model.pojo;
// Generated 18/07/2017 16:11:11 by Hibernate Tools 4.3.1


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

/**
 * Cuenta generated by hbm2java
 */
@Entity
@Table(name="cuenta"
    ,catalog="bancodb"
)
public class Cuenta  implements java.io.Serializable {


     private String idcuenta;
     private PropietarioCuenta propietarioCuenta;
     private TipoCuenta tipoCuenta;
     private Double saldo;
     private Boolean activa;
     private Set<TransferenciaHasCuenta> transferenciaHasCuentas = new HashSet<TransferenciaHasCuenta>(0);
     private Set<Transaccion> transaccionsForCuentaIdcuenta2 = new HashSet<Transaccion>(0);
     private Set<Servicio> servicios = new HashSet<Servicio>(0);
     private Set<Transaccion> transaccionsForCuentaIdcuentaPrincipal = new HashSet<Transaccion>(0);

    public Cuenta() {
    }

	
    public Cuenta(String idcuenta, PropietarioCuenta propietarioCuenta, TipoCuenta tipoCuenta) {
        this.idcuenta = idcuenta;
        this.propietarioCuenta = propietarioCuenta;
        this.tipoCuenta = tipoCuenta;
    }
    public Cuenta(String idcuenta, PropietarioCuenta propietarioCuenta, TipoCuenta tipoCuenta, Double saldo, Boolean activa, Set<TransferenciaHasCuenta> transferenciaHasCuentas, Set<Transaccion> transaccionsForCuentaIdcuenta2, Set<Servicio> servicios, Set<Transaccion> transaccionsForCuentaIdcuentaPrincipal) {
       this.idcuenta = idcuenta;
       this.propietarioCuenta = propietarioCuenta;
       this.tipoCuenta = tipoCuenta;
       this.saldo = saldo;
       this.activa = activa;
       this.transferenciaHasCuentas = transferenciaHasCuentas;
       this.transaccionsForCuentaIdcuenta2 = transaccionsForCuentaIdcuenta2;
       this.servicios = servicios;
       this.transaccionsForCuentaIdcuentaPrincipal = transaccionsForCuentaIdcuentaPrincipal;
    }
   
     @Id 

    
    @Column(name="idcuenta", unique=true, nullable=false, length=45)
    public String getIdcuenta() {
        return this.idcuenta;
    }
    
    public void setIdcuenta(String idcuenta) {
        this.idcuenta = idcuenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_idusuario", nullable=false)
    public PropietarioCuenta getPropietarioCuenta() {
        return this.propietarioCuenta;
    }
    
    public void setPropietarioCuenta(PropietarioCuenta propietarioCuenta) {
        this.propietarioCuenta = propietarioCuenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipo_cuenta_idtipo_cuenta", nullable=false)
    public TipoCuenta getTipoCuenta() {
        return this.tipoCuenta;
    }
    
    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    
    @Column(name="saldo", precision=22, scale=0)
    public Double getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    
    @Column(name="activa")
    public Boolean getActiva() {
        return this.activa;
    }
    
    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuenta")
    public Set<TransferenciaHasCuenta> getTransferenciaHasCuentas() {
        return this.transferenciaHasCuentas;
    }
    
    public void setTransferenciaHasCuentas(Set<TransferenciaHasCuenta> transferenciaHasCuentas) {
        this.transferenciaHasCuentas = transferenciaHasCuentas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuentaByCuentaIdcuenta2")
    public Set<Transaccion> getTransaccionsForCuentaIdcuenta2() {
        return this.transaccionsForCuentaIdcuenta2;
    }
    
    public void setTransaccionsForCuentaIdcuenta2(Set<Transaccion> transaccionsForCuentaIdcuenta2) {
        this.transaccionsForCuentaIdcuenta2 = transaccionsForCuentaIdcuenta2;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuenta")
    public Set<Servicio> getServicios() {
        return this.servicios;
    }
    
    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuentaByCuentaIdcuentaPrincipal")
    public Set<Transaccion> getTransaccionsForCuentaIdcuentaPrincipal() {
        return this.transaccionsForCuentaIdcuentaPrincipal;
    }
    
    public void setTransaccionsForCuentaIdcuentaPrincipal(Set<Transaccion> transaccionsForCuentaIdcuentaPrincipal) {
        this.transaccionsForCuentaIdcuentaPrincipal = transaccionsForCuentaIdcuentaPrincipal;
    }




}


