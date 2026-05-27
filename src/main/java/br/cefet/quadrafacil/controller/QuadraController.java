package br.cefet.quadrafacil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus; // ✅ import adicionado

import br.cefet.quadrafacil.model.Quadra;
import br.cefet.quadrafacil.repository.QuadraRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/quadra")
public class QuadraController {
    private QuadraRepository repository;

    public QuadraController(QuadraRepository repository) {
        this.repository = repository;
    }



    @GetMapping("")
    public List<Quadra> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Quadra getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("")
    public Quadra alterarQuadra(@RequestBody Quadra quadra) {
        if (quadra.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id é obrigatório");
        }

        repository.save(quadra);
        return quadra;
    }

    @PostMapping("")
    public Quadra inserir(@RequestBody Quadra quadra) {
        quadra.setId(null);
        repository.save(quadra);
        return quadra;
    }

    @DeleteMapping("/{id}")
    public Quadra excluirQuadra(@PathVariable Long id) {
        Quadra quadra = repository.findById(id).orElse(null);
        if (quadra == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quadra com id:" + id + " não encontrada");
        }
        repository.delete(quadra);
        return quadra;
    }

    /*
     * @DeleteMapping("/{id}")
     * public Quadra excluir(@PathVariable Long id) {
     * Quadra ret = null;
     * for (int i = 0; i < quadrasList.size(); i++) {
     * Quadra entAux = quadrasList.get(i);
     * if (entAux != null && entAux.getId() == id) {
     * ret = entAux;
     * quadrasList.remove(i);
     * break;
     * }
     * 
     * }
     * return ret;
     * }
     * 
     * @PutMapping("")
     * public Quadra alterar(@RequestBody Quadra quadra) {
     * for (int i = 0; i < quadrasList.size(); i++) {
     * Quadra entAux = quadrasList.get(i);
     * if (entAux != null && entAux.getId() == quadra.getId()) {
     * quadrasList.remove(i);
     * quadrasList.add(quadra);
     * break;
     * }
     * 
     * }
     * return quadra;
     * }
     */

}