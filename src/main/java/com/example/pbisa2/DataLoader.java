/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pbisa2;

import com.example.pbisa2.model.tipomonedaCURDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.example.pbisa2.model.*;
import com.example.pbisa2.tipo_moneda;
import java.time.LocalDate;
import java.util.Optional;

/**
 *
 * @author M. Calla
 */
@Component
public class DataLoader implements ApplicationRunner {

    private tipomonedaCURDRepository tipomonedaRepository;
    private tipo_transaccionCURDRepository tipo_transaccionRepository;// tipo_transaccion
    private clienteCURDRepository clienteRepository;
    private cuentaCURDRepository cuentRepository;
    private sucursalCURDRepository sucursalRepository;
    private transaccionCURDRepository transaccionRepository;

    @Autowired
    public DataLoader(tipomonedaCURDRepository tipomonedaRepository,
            tipo_transaccionCURDRepository tipo_transaccionRepository,
            clienteCURDRepository clienteRepository,
            cuentaCURDRepository cuentRepository,
            sucursalCURDRepository sucursalRepository,
            transaccionCURDRepository transaccionRepository
    ) {
        this.tipomonedaRepository = tipomonedaRepository;
        this.tipo_transaccionRepository = tipo_transaccionRepository;
        this.clienteRepository = clienteRepository;
        this.cuentRepository = cuentRepository;
        this.sucursalRepository = sucursalRepository;
        this.transaccionRepository = transaccionRepository;

    }

    public void run(ApplicationArguments args) {
        Integer tmId = tipomonedaRepository.save(new tipo_moneda(1, "Bolivianos")).getIdMoneda();
        tipomonedaRepository.save(new tipo_moneda(2, "Dolares"));
        Integer inTT = tipo_transaccionRepository.save(new tipo_transaccion(1, "Deposito de efectivo")).getIdtt();
        Optional<tipo_transaccion> lTitt = tipo_transaccionRepository.findById(inTT);
        tipo_transaccionRepository.save(new tipo_transaccion(2, "Retiro de efectivo"));
        cliente cl = new cliente("ALBETO", "AGUILAR", "LARCO", "CALLE 25", "aguilar@yahoo.com");
        Integer idCl = clienteRepository.save(cl).getIdCliente();
        Optional opc = clienteRepository.findById(idCl);
        Optional<tipo_moneda> opcl = tipomonedaRepository.findById(tmId);

        Integer idSuc = sucursalRepository.save(new sucursal(1, "Sucursal Villa Fatima", "calle yancachi")).getIdSucursal();
        Optional<sucursal> opcS = sucursalRepository.findById(idSuc);

        LocalDate localDate = LocalDate.now();
        Integer idCuenta = cuentRepository.save(new Cuenta(localDate, "ADMIN", "ACTIVE", (cliente) opc.get(), (tipo_moneda) opcl.get(), (sucursal) opcS.get())).getIdCuenta();
        Optional<Cuenta> cuentass = cuentRepository.findById(idCuenta);
        transaccionRepository.save(new Transaccion(localDate, "ADMIN", new Double("5000d"), "INIT", (tipo_transaccion) lTitt.get(), (Cuenta) cuentass.get(),opcl.get()));

    }

}
