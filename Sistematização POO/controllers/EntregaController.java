package com.aula.entrega.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aula.entrega.dtos.EntregaDto;
import com.aula.entrega.models.EntregaModel;
import com.aula.entrega.repositories.EntregaRepository;

import jakarta.validation.Valid;

@RestController
public class EntregaController {

    @Autowired
    EntregaRepository entregaRepository;

    @PostMapping("/entrega")
    public ResponseEntity<EntregaModel> salvar(@RequestBody @Valid EntregaDto entregaDto) {
        var entregaModel = new EntregaModel();
        BeanUtils.copyProperties(entregaDto, entregaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(entregaRepository.save(entregaModel));
    }
    
    @GetMapping("/entrega")
    public ResponseEntity<List<EntregaModel>> listar() {
        List<EntregaModel> entregaList = entregaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(entregaList);
    }
 
    @GetMapping("/entrega/{id}")
    public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id){
        Optional<EntregaModel> entrega = entregaRepository.findById(id);
        if(entrega.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entrega.get());
    }

    @PutMapping("/entrega/{id}")
    public ResponseEntity<Object> updateEntrega(@PathVariable(value="id") Integer id,
                                                        @RequestBody @Valid EntregaDto entregaDto) {
        Optional<EntregaModel> entrega = entregaRepository.findById(id);
        if(entrega.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para edição.");
        }
        var entregaModel = entrega.get();
        BeanUtils.copyProperties(entregaDto, entregaModel);
        return ResponseEntity.status(HttpStatus.OK).body(entregaRepository.save(entregaModel));
    }
    
    @DeleteMapping("/entrega/{id}")
    public ResponseEntity<Object> deleteEntrega(@PathVariable(value="id") Integer id) {
        Optional<EntregaModel> entrega = entregaRepository.findById(id);
        if(entrega.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para exclusão.");
        }
        entregaRepository.delete(entrega.get());
        return ResponseEntity.status(HttpStatus.OK).body("Entregador excluído com sucesso.");
    }



}
