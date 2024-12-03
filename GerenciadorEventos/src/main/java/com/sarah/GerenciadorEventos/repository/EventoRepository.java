package com.sarah.GerenciadorEventos.repository;


import com.sarah.GerenciadorEventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
   
}

