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
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCuenta;
    private LocalDate fecha;
    private String usuario;
    private String estado;

    @ManyToOne
    private cliente cliente;

    @ManyToOne
    private tipo_moneda tipo_moneda;

    @ManyToOne
    private sucursal sucursal;

    public Cuenta() {
    }

    public Cuenta( LocalDate fecha, String usuario, String estado, cliente cliente, tipo_moneda tipo_moneda, sucursal sucursal) {
 
        this.fecha = fecha;
        this.usuario = usuario;
        this.estado = estado;
        this.cliente = cliente;
        this.tipo_moneda = tipo_moneda;
        this.sucursal = sucursal;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public tipo_moneda getTipo_moneda() {
        return tipo_moneda;
    }

    public void setTipo_moneda(tipo_moneda tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    public sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(sucursal sucursal) {
        this.sucursal = sucursal;
    }




}
