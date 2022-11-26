/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pbisa2;

import com.example.pbisa2.model.tipomonedaCURDRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author M. Calla
 */
@Service
public class tipoMonedaService {

    @Autowired
    private tipomonedaCURDRepository tipomonedarepo;

    public List<tipo_moneda> getAllTipoMoneda() {
        List<tipo_moneda> tm = new ArrayList<>();
        tipomonedarepo.findAll().forEach(tm::add);
        return tm;
    }

    public void addTipoMoneda(tipo_moneda topic) {
        tipomonedarepo.save(topic);
    }

    public void updateTopic(String id, tipo_moneda topic) {
        tipomonedarepo.save(topic);
    }

}
