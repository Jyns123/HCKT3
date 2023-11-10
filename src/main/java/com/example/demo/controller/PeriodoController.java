package com.example.demo.controller;

import com.example.demo.model.Periodo;
import com.example.demo.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/periodo")
public class PeriodoController {

    @Autowired
    private PeriodoRepository periodoRepository;

    @PostMapping
    public ResponseEntity<Periodo> create(@RequestBody Periodo details) {
        return ResponseEntity.ok(periodoRepository.save(details));
    }

    @GetMapping
    public ResponseEntity<Iterable<Periodo>> read() {
        return ResponseEntity.ok(periodoRepository.findAll());
    }

}
