/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pbisa2;

import com.example.pbisa2.model.Cuenta;
import com.example.pbisa2.model.Transaccion;
import com.example.pbisa2.model.tipo_transaccion;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author M. Calla
 */
@RestController
public class cuentaController {
    
    @Autowired
    cuentaService cuentaService_;
    
    @Autowired
    transaccionService transaccionService_;
    
    @RequestMapping(value = "/cuentas", method = RequestMethod.GET)
    public List<Cuenta> getAllCuentas() {
        return cuentaService_.getAllCuentas();
    }
    
    @RequestMapping(value = "/addCuenta", method = RequestMethod.POST)
    public void addTopic(@RequestBody Cuenta cuentanew) {
//transaccionService_
        Transaccion tra = new Transaccion();
        LocalDate localDate = LocalDate.now();
        tra.setCuenta(cuentanew);
        tra.setFecha(localDate);
        tra.setMonto(new Double("5000"));
        tra.setTipo_moneda(cuentanew.getTipo_moneda());
        tra.setTipo_transaccion(new tipo_transaccion(1, "Deposito de efectivo"));
        cuentaService_.addCuenta(cuentanew);
        transaccionService_.addTransaccion(tra);
    }
    
    @RequestMapping(value = "/updatetcuenta/{id}", method = RequestMethod.POST)
    public void updateTopic(@PathVariable String id, @RequestBody Cuenta cuentyau) {
        cuentaService_.updateCuenta(id, cuentyau);
    }
    
}
