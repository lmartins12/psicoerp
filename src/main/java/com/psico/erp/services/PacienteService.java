package com.psico.erp.services;

import com.psico.erp.entities.Paciente;
import com.psico.erp.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(Long id, Paciente updatedPaciente) {
        Paciente existentPaciente = pacienteRepository.findById(id).orElse(null);
        if (existentPaciente != null) {
            existentPaciente.setNome(updatedPaciente.getNome());
            existentPaciente.setDataNascimento(updatedPaciente.getDataNascimento());
            existentPaciente.setEndereco(updatedPaciente.getEndereco());
            existentPaciente.setTelefone(updatedPaciente.getTelefone());
            existentPaciente.setHistorico(updatedPaciente.getHistorico());
            existentPaciente.setPsicologo(updatedPaciente.getPsicologo());
            return pacienteRepository.save(existentPaciente);
        }
        return null;
    }

    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
