/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pbisa2;

import com.example.pbisa2.model.Cuenta;
import com.example.pbisa2.model.Transaccion;
import com.example.pbisa2.model.transaccionCURDRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author M. Calla
 */
@Service
public class transaccionService {

    @Autowired
    transaccionCURDRepository transaccionRepository;

    public List<Transaccion> getAllTransaccion() {
        List<Transaccion> tm = new ArrayList<>();
        transaccionRepository.findAll().forEach(tm::add);
        return tm;
    }

    public void addTransaccion(Transaccion transaccion1) {
        transaccionRepository.save(transaccion1);
    }

    public void updateTransaccion(String id, Transaccion transaccion1) {
        transaccionRepository.save(transaccion1);
    }

    public Transaccion finById(Integer id) {
        Optional<Transaccion> otransaccion = transaccionRepository.findById(id);
        return otransaccion.get();

    }

    public List<Transaccion> findAllTransaccionById(Cuenta cu) {
        List<Transaccion> ltrans = transaccionRepository.findAllByCuenta(cu);
        return ltrans;
    }

    public double getSaldoCuenta(Cuenta cu) throws Exception {
        double mIngreso = 0d;
        double dEgreso = 0d;
        List<Transaccion> ltrans = this.findAllTransaccionById(cu);
        for (Transaccion l : ltrans) {
            if (l.getTipo_transaccion().getIdtt() == 1) {
                mIngreso = mIngreso + l.getMonto();

            }
            if (l.getTipo_transaccion().getIdtt() == 21) {
                dEgreso = dEgreso + l.getMonto();

            }
        }
        return mIngreso - dEgreso;
    }

}
