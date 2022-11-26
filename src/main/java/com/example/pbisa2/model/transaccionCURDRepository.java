/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.pbisa2.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author M. Calla
 */
public interface transaccionCURDRepository extends CrudRepository<Transaccion, Integer>{
    List<Transaccion> findAllByCuenta(Cuenta cu);    
}
