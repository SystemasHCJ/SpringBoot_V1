/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.web.servicio;

import com.app.web.entidad.empleado;
import java.util.List;

/**
 *
 * @author calle
 */
public interface EmpleadoServicio {

    public List<empleado> listartodoslosempleados();

    public empleado guardarEmpleado(empleado empleado);
    
    public empleado obtenerEmpeladoPorId(Long id);
    
    public empleado actualizarEmpleado(empleado empleado);
    
    public void eliminarEmpleado(Long id);

}
