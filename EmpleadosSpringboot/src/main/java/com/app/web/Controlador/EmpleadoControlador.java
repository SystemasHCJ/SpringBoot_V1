/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.Controlador;

import com.app.web.entidad.empleado;
import com.app.web.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author calle
 */
@Controller
public class EmpleadoControlador {

    @Autowired
    private EmpleadoServicio servicio;

    @GetMapping({"/empleados", "/"})
    public String ListarEmpleados(Model modelo) {
        modelo.addAttribute("empleados", servicio.listartodoslosempleados());
        return "empleados";
    }

    @GetMapping("/empleados/nuevo")
    public String MostrarFormularioCrearEmpleado(Model modelo) {
        empleado empleado = new empleado();
        modelo.addAttribute("empleado", empleado);
        return "crear_empleado";
    }

    @PostMapping("/empleados")
    public String GuardarEmpleadoNuevo(@ModelAttribute("empleado") empleado empleado) {
        servicio.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("empleado", servicio.obtenerEmpeladoPorId(id));
        return "editar_empleado";
    }

    @PostMapping("/empleados/{id}")
    public String actualizarEmpleado(@PathVariable Long id,
            @ModelAttribute("empleado") empleado empleado, Model modelo) {

        empleado empleadoExistente = servicio.obtenerEmpeladoPorId(id);
        empleadoExistente.setPk_iud_empleado(id);
        empleadoExistente.setNom_empleado(empleado.getNom_empleado());
        empleadoExistente.setApellido_paterno_empleado(empleado.getApellido_paterno_empleado());
        empleadoExistente.setApellido_materno_empleado(empleado.getApellido_materno_empleado());
        empleadoExistente.setNum_nomina_empleado(empleado.getNum_nomina_empleado());

        servicio.actualizarEmpleado(empleadoExistente);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        servicio.eliminarEmpleado(id);
        return "redirect:/empleados";
    }

}
