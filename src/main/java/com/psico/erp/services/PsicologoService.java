package com.psico.erp.services;

import com.psico.erp.entities.Psicologo;
import com.psico.erp.repositories.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsicologoService {

    @Autowired
    private PsicologoRepository psicologoRepository;

    public List<Psicologo> listAllPsicologos() {
        return psicologoRepository.findAll();
    }

    public Psicologo getPsicologoById(Long id) {
        return psicologoRepository.findById(id).orElse(null);
    }

    public Psicologo createPsicologo(Psicologo psicologo) {
        return psicologoRepository.save(psicologo);
    }

    public Psicologo updatePsicologo(Long id, Psicologo updatedPsicologo) {
        Psicologo existentPsicologo = this.getPsicologoById(id);

        if (existentPsicologo != null) {
            existentPsicologo.setNome(updatedPsicologo.getNome());
            existentPsicologo.setUsuario(updatedPsicologo.getUsuario());
            existentPsicologo.setSenha(updatedPsicologo.getSenha());
            existentPsicologo.setEspecializacoes(updatedPsicologo.getEspecializacoes());

            return psicologoRepository.save(existentPsicologo);
        }
        return null;
    }

    public void deletePsicologo(Long id) {
        Psicologo existentPsicologo = this.getPsicologoById(id);

        if (existentPsicologo != null) {
            psicologoRepository.deleteById(id);
        }
    }

}
