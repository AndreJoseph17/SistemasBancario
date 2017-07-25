/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.dao;

import com.sistema_bancario.model.pojo.PropietarioCuenta;
import java.util.List;

/**
 *
 * @author EQUIPO
 */
public interface UsuarioFacadeLocal {
    
    void create(PropietarioCuenta propietarioCuenta);
    
    void edit(PropietarioCuenta propietarioCuenta);
    
    void remove(PropietarioCuenta propietarioCuenta);
    
    PropietarioCuenta find(Object id);
    
    List<PropietarioCuenta> findAll();
    
    List<PropietarioCuenta> findRange(int[] range);
    
    int count();
    

    
}
