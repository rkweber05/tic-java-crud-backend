package com.consumption.crud.controllers;

import com.consumption.crud.models.PessoaModel;
import com.consumption.crud.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin("*")
@AllArgsConstructor
public class PessoaController {

    private PessoaRepository repository;

    @GetMapping
    public ResponseEntity<List<PessoaModel>> pegaTodasAsPessoas(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PessoaModel> criaNovaPessoa(@RequestBody PessoaModel novaPessoa) {
        novaPessoa.setId(null);
        return new ResponseEntity<>(repository.save(novaPessoa), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PessoaModel> editaPessoa(@RequestBody PessoaModel novaPessoa) {
        return new ResponseEntity<>(repository.save(novaPessoa), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable Integer id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
