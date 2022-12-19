/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.servicio;

import com.app.web.entidad.empleado;
import com.app.web.repositorio.EmpleadoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author calle
 */
@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio repositorio;

    @Override
    public List<empleado> listartodoslosempleados() {
        return repositorio.findAll();
    }

    @Override
    public empleado guardarEmpleado(empleado empleado) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repositorio.save(empleado);
    }

    public empleado obtenerEmpeladoPorId(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repositorio.findById(id).get();
    }

    @Override
    public empleado actualizarEmpleado(empleado empleado) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return repositorio.save(empleado);
    }

    public void eliminarEmpleado(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        repositorio.deleteById(id);
    }

   

}
