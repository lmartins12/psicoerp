package com.psico.erp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = {"sessoes"})
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String historico;

    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private Psicologo psicologo;

    @OneToMany(mappedBy = "paciente")
    private List<Sessao> sessoes;
}
