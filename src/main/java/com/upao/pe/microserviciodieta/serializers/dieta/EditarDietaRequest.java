package com.upao.pe.microserviciodieta.serializers.dieta;

import com.upao.pe.microserviciodieta.modelos.DietaComida;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EditarDietaRequest {
    private Long id;
    private int raciones;
    private List<DietaComida> dietaComidas;
}
