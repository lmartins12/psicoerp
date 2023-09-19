package com.psico.erp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = {"pacientes", "sessoes"})
public class Psicologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private String especializacoes;

    @OneToMany(mappedBy = "psicologo")
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "psicologo")
    private List<Sessao> sessoes;
}
