package com.psico.erp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "psicologo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "psicologo")
    private List<Sessao> sessoes;
}
