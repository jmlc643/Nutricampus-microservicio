package com.upao.pe.microserviciodieta.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comida", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
@Entity
public class Comida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_comida")
    private Long idComida;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @OneToMany(mappedBy = "comida")
    private List<DietaComida> dietaComidas;
}
