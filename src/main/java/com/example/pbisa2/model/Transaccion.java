/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pbisa2.model;

import com.example.pbisa2.tipo_moneda;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author M. Calla
 */
@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTransaccion;
    private LocalDate fecha;
    private String usuario;
    private Double monto;
    private String resultado;

    @ManyToOne
    private tipo_transaccion tipo_transaccion;

    @ManyToOne
    private Cuenta cuenta;

    @ManyToOne
    private tipo_moneda tipo_moneda;

    public Transaccion() {
    }

    public Transaccion(LocalDate fecha, String usuario, Double monto, String resultado, tipo_transaccion tipo_transaccion, Cuenta cuenta, tipo_moneda tipo_moneda_) {

        this.fecha = fecha;
        this.usuario = usuario;
        this.monto = monto;
        this.resultado = resultado;
        this.tipo_transaccion = tipo_transaccion;
        this.cuenta = cuenta;
        this.tipo_moneda = tipo_moneda_;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public tipo_transaccion getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(tipo_transaccion tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public tipo_moneda getTipo_moneda() {
        return tipo_moneda;
    }

    public void setTipo_moneda(tipo_moneda tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

}
