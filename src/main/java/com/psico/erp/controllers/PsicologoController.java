package com.psico.erp.controllers;

import com.psico.erp.entities.Psicologo;
import com.psico.erp.services.PsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/psicologos")
public class PsicologoController {

    @Autowired
    private PsicologoService psicologoService;

    @GetMapping
    public List<Psicologo> listAllPsicologos() {
        return psicologoService.listAllPsicologos();
    }

    @GetMapping("/{id}")
    public Psicologo getPsicologoById(@PathVariable Long id) {
        return psicologoService.getPsicologoById(id);
    }

    @PostMapping
    public Psicologo createPsicologo(Psicologo psicologo) {
        return psicologoService.createPsicologo(psicologo);
    }

    @PutMapping("/{id}")
    public Psicologo updatePsicologo(@PathVariable Long id, @RequestBody Psicologo psicologo) {
        return psicologoService.updatePsicologo(id, psicologo);
    }

    @DeleteMapping("/{id}")
    public void deletePsicologo(@PathVariable Long id) {
        psicologoService.deletePsicologo(id);
    }

}
