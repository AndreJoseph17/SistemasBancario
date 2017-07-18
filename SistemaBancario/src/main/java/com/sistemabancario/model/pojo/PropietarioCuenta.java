package com.sistemabancario.model.pojo;
// Generated 18/07/2017 15:29:45 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PropietarioCuenta generated by hbm2java
 */
public class PropietarioCuenta  implements java.io.Serializable {


     private String idusuario;
     private String nombre;
     private String apellido;
     private Date fechaNacimiento;
     private String login;
     private String password;
     private Set<Telefono> telefonos = new HashSet<Telefono>(0);
     private Set<Email> emails = new HashSet<Email>(0);
     private Set<Email> emails_1 = new HashSet<Email>(0);
     private Set<Cuenta> cuentas = new HashSet<Cuenta>(0);

    public PropietarioCuenta() {
    }

	
    public PropietarioCuenta(String idusuario) {
        this.idusuario = idusuario;
    }
    public PropietarioCuenta(String idusuario, String nombre, String apellido, Date fechaNacimiento, String login, String password, Set<Telefono> telefonos, Set<Email> emails, Set<Email> emails_1, Set<Cuenta> cuentas) {
       this.idusuario = idusuario;
       this.nombre = nombre;
       this.apellido = apellido;
       this.fechaNacimiento = fechaNacimiento;
       this.login = login;
       this.password = password;
       this.telefonos = telefonos;
       this.emails = emails;
       this.emails_1 = emails_1;
       this.cuentas = cuentas;
    }
   
    public String getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Telefono> getTelefonos() {
        return this.telefonos;
    }
    
    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
    public Set<Email> getEmails() {
        return this.emails;
    }
    
    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }
    public Set<Email> getEmails_1() {
        return this.emails_1;
    }
    
    public void setEmails_1(Set<Email> emails_1) {
        this.emails_1 = emails_1;
    }
    public Set<Cuenta> getCuentas() {
        return this.cuentas;
    }
    
    public void setCuentas(Set<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }




}


