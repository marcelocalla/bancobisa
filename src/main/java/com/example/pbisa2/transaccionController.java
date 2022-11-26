/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pbisa2;

import com.example.pbisa2.model.Transaccion;
import com.example.pbisa2.model.transaccionCURDRepository;
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
public class transaccionController {

    @Autowired
    transaccionService transaccionService_;

    @RequestMapping(value = "/transacciones", method = RequestMethod.GET)
    public List<Transaccion> getAllTransaccion() {
        return transaccionService_.getAllTransaccion();
    }

    @RequestMapping(value = "/addTransaccion", method = RequestMethod.POST)
    public void addTopic(@RequestBody Transaccion tnew) {
        transaccionService_.addTransaccion(tnew);
    }

    @RequestMapping(value = "/updatettransaccion/{id}", method = RequestMethod.POST)
    public void updateTopic(@PathVariable String id, @RequestBody Transaccion tran) {
        transaccionService_.updateTransaccion(id, tran);
    }

    @RequestMapping(value = "/depositardinero", method = RequestMethod.POST)
    public void updatedineroDeposito(@RequestBody Transaccion tran) throws Exception {
        try {
            // 1  validamos moneda 
            if (tran.getTipo_moneda() == null) {
                throw new Exception("Verifique la moneda de transaccion!!");
            }
            transaccionService_.addTransaccion(tran);
        } catch (Exception error) {
            System.out.println("Error :" + error);
            throw new Exception("Error " + error);
        }

    }

    @RequestMapping(value = "/retirordinero", method = RequestMethod.POST)
    public void updateRetirodinero(@RequestBody Transaccion tran) throws Exception {
        try {
            double d = transaccionService_.getSaldoCuenta(tran.getCuenta());
            if (d <= 0) {
                throw new Exception("No tiene saldo!!");
            }
            transaccionService_.addTransaccion(tran);
        } catch (Exception error) {
            System.out.println("Error :" + error);
            throw new Exception("Error " + error);
        }

    }

   @RequestMapping(value = "/consultasaldo", method = RequestMethod.POST)
    public double gtesaldo(@RequestBody Transaccion tran) throws Exception {
        try {
            double d = transaccionService_.getSaldoCuenta(tran.getCuenta());
            if (d <= 0) {
                throw new Exception("No tiene saldo!!");
            }
            return d;
        } catch (Exception error) {
            System.out.println("Error :" + error);
            throw new Exception("Error " + error);
        }

    }
   @RequestMapping(value = "/gethistorico", method = RequestMethod.GET)
    public List<Transaccion> getHistoriaTransa(@RequestBody Transaccion tran) throws Exception {
        try {
            List<Transaccion> ltrans = transaccionService_.findAllTransaccionById(tran.getCuenta());
            return ltrans;
        } catch (Exception error) {
            System.out.println("Error :" + error);
            throw new Exception("Error " + error);
        }

    }

}
