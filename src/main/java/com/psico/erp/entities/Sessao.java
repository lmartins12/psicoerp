package com.psico.erp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(exclude = {"paciente", "psicologo"})
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    private String notaRegistro;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private Psicologo psicologo;
}
