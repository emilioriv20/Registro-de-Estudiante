package com.example.registroestudiantes;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findByNombreContainingIgnoreCaseOrCarreraContainingIgnoreCase(String nombre, String carrera);
}