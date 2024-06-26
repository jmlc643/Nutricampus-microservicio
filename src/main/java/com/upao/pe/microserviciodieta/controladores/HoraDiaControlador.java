package com.upao.pe.microserviciodieta.controladores;


import com.upao.pe.microserviciodieta.modelos.HoraDia;
import com.upao.pe.microserviciodieta.serializers.HoraDiaSerializer;
import com.upao.pe.microserviciodieta.servicios.HoraDiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hora-dia")
//@CrossOrigin
public class HoraDiaControlador {

    @Autowired private HoraDiaServicio horaDiaServicio;

    @GetMapping("/listar/")
    public List<HoraDiaSerializer> listarHoraDias(){
        return horaDiaServicio.listarHoraDias();
    }

    @PostMapping("/crear/")
    public HoraDiaSerializer crearHoraDia(@RequestBody HoraDiaSerializer request){
        return horaDiaServicio.crearHoraDia(request);
    }

    @PutMapping("/editar/")
    public HoraDiaSerializer editarHoraDia(@RequestBody HoraDia request){
        return horaDiaServicio.editarHoraDia(request);
    }

    @DeleteMapping("/eliminar/")
    public List<HoraDiaSerializer> eliminarHoraDia(@RequestBody Long id){
        return horaDiaServicio.eliminarHoraDia(id);
    }
}
