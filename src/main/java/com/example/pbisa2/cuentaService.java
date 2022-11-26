/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pbisa2;


import com.example.pbisa2.model.Cuenta;
import com.example.pbisa2.model.cuentaCURDRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author M. Calla
 */
@Service
public class cuentaService {
    @Autowired
    private cuentaCURDRepository cuentaRepository;

    public List<Cuenta> getAllCuentas() {
        List<Cuenta> tm = new ArrayList<>();
        cuentaRepository.findAll().forEach(tm::add);
        return tm;
    }

    public void addCuenta(Cuenta cuenta1) {
        cuentaRepository.save(cuenta1);
    }

    public void updateCuenta(String id, Cuenta cuenta1) {
        cuentaRepository.save(cuenta1);
    }




    
}
