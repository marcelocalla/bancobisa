/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pbisa2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author M. Calla
 */
@Entity
public class tipo_transaccion {

@Id
@GeneratedValue( strategy=GenerationType.AUTO )
private Integer idtt;
private String descripcion;

    public tipo_transaccion() {
    }

    public tipo_transaccion(int idtt, String descripcion) {
        this.idtt = idtt;
        this.descripcion = descripcion;
    }

    public int getIdtt() {
        return idtt;
    }

    public void setIdtt(int idtt) {
        this.idtt = idtt;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }







    
}
