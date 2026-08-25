package com.example.registroestudiantes;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String carrera;
    private String email;

    public Estudiante() {}

    public Estudiante(String nombre, String carrera, String email) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}