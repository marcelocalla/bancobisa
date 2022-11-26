/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pbisa2;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author M. Calla
 */
@Entity
@Table(name="tipo_moneda")
public class tipo_moneda {

@Id
@GeneratedValue( strategy=GenerationType.AUTO )
private Integer idMoneda;
private String descripcion;

    public tipo_moneda() {
    }

    public tipo_moneda(int idMoneda, String descripcion) {
        this.idMoneda = idMoneda;
        this.descripcion = descripcion;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    
}
