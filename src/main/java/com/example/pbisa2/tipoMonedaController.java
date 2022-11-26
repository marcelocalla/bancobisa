/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pbisa2;

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
public class tipoMonedaController {

    @Autowired
    tipoMonedaService tipoMonedaService_;

    @RequestMapping(value = "/tipomoneda", method = RequestMethod.GET)
    public List<tipo_moneda> getAllTopics() {
        return tipoMonedaService_.getAllTipoMoneda();
    }

    @RequestMapping(value = "/addtipomoneda", method = RequestMethod.POST)
    public void addTopic(@RequestBody tipo_moneda tipo_moneda_) {
        tipoMonedaService_.addTipoMoneda(tipo_moneda_);
    }

    @RequestMapping(value = "/updatetipomoneda/{id}", method = RequestMethod.POST)
    public void updateTopic(@PathVariable String id,@RequestBody tipo_moneda tipo_moneda_) {
        tipoMonedaService_.updateTopic(id,tipo_moneda_);
    }

}
