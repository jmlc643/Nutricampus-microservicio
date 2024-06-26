package com.upao.pe.microserviciodieta.servicios;


import com.upao.pe.microserviciodieta.modelos.HoraDia;
import com.upao.pe.microserviciodieta.repositorios.HoraDiaRepositorio;
import com.upao.pe.microserviciodieta.serializers.HoraDiaSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HoraDiaServicio {

    @Autowired
    HoraDiaRepositorio horaDiaRepositorio;

    // READ
    public List<HoraDiaSerializer> listarHoraDias(){return horaDiaRepositorio.findAll().stream().map(this::retornarHoraDiaSerializer).toList();}

    // CREATE
    public HoraDiaSerializer crearHoraDia(HoraDiaSerializer request){
        HoraDia horaDia = new HoraDia(null, request.getHora());
        return retornarHoraDiaSerializer(horaDiaRepositorio.save(horaDia));
    }

    //UPDATE
    public HoraDiaSerializer editarHoraDia(HoraDia request){
        Optional<HoraDia> horaDia = horaDiaRepositorio.findById(request.getIdHoraDia());
        if(horaDia.isEmpty()){
            throw new RuntimeException("No se encontra la hora del dia");
        }
        horaDia.get().setHora(request.getHora());
        horaDiaRepositorio.saveAndFlush(horaDia.get());
        return retornarHoraDiaSerializer(horaDia.get());
    }

    // DELETE
    public List<HoraDiaSerializer> eliminarHoraDia(Long id){
        Optional<HoraDia> horaDia = horaDiaRepositorio.findById(id);
        if(horaDia.isEmpty()){
            throw new RuntimeException("No se encuentra la hora del dia");
        }
        horaDiaRepositorio.delete(horaDia.get());
        return listarHoraDias();
    }

    // Mapear a serializer
    public HoraDiaSerializer retornarHoraDiaSerializer(HoraDia horaDia){
        return new HoraDiaSerializer(horaDia.getHora());
    }

    public HoraDia buscarHoraDia(String momentoDia) {
        Optional<HoraDia> horaDia = horaDiaRepositorio.findByHora(momentoDia);
        if(horaDia.isEmpty()){
            throw new RuntimeException(("No se encuentra la hora del dia"));
        }
        return horaDia.get();
    }
}
