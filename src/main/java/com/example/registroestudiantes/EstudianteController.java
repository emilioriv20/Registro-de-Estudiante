package com.example.registroestudiantes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteController {

    private final EstudianteRepository repository;

    public EstudianteController(EstudianteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Estudiante> listar(@RequestParam(required = false) String buscar) {
        if (buscar != null && !buscar.isBlank()) {
            return repository.findByNombreContainingIgnoreCaseOrCarreraContainingIgnoreCase(buscar, buscar);
        }
        return repository.findAll();
    }

    @PostMapping
    public Estudiante guardar(@RequestBody Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Long id, @RequestBody Estudiante datos) {
        return repository.findById(id).map(est -> {
            est.setNombre(datos.getNombre());
            est.setCarrera(datos.getCarrera());
            est.setEmail(datos.getEmail());
            return ResponseEntity.ok(repository.save(est));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}