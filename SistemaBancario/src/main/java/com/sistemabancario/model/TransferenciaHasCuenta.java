package com.sistemabancario.model;
// Generated 18/07/2017 16:11:11 by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TransferenciaHasCuenta generated by hbm2java
 */
@Entity
@Table(name="transferencia_has_cuenta"
    ,catalog="bancodb"
)
public class TransferenciaHasCuenta  implements java.io.Serializable {


     private TransferenciaHasCuentaId id;
     private Cuenta cuenta;
     private String idCuentaBeneficiario;

    public TransferenciaHasCuenta() {
    }

	
    public TransferenciaHasCuenta(TransferenciaHasCuentaId id, Cuenta cuenta) {
        this.id = id;
        this.cuenta = cuenta;
    }
    public TransferenciaHasCuenta(TransferenciaHasCuentaId id, Cuenta cuenta, String idCuentaBeneficiario) {
       this.id = id;
       this.cuenta = cuenta;
       this.idCuentaBeneficiario = idCuentaBeneficiario;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="transferenciaIdtransferencia", column=@Column(name="transferencia_idtransferencia", nullable=false, length=45) ), 
        @AttributeOverride(name="cuentaIdcuenta", column=@Column(name="cuenta_idcuenta", nullable=false, length=45) ) } )
    public TransferenciaHasCuentaId getId() {
        return this.id;
    }
    
    public void setId(TransferenciaHasCuentaId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cuenta_idcuenta", nullable=false, insertable=false, updatable=false)
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    
    @Column(name="id_cuenta_beneficiario", length=45)
    public String getIdCuentaBeneficiario() {
        return this.idCuentaBeneficiario;
    }
    
    public void setIdCuentaBeneficiario(String idCuentaBeneficiario) {
        this.idCuentaBeneficiario = idCuentaBeneficiario;
    }




}


