package com.sarah.GerenciadorEventos.service;

import com.sarah.GerenciadorEventos.model.Evento;
import com.sarah.GerenciadorEventos.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final NotificacaoService notificacaoService;

    public EventoService(EventoRepository eventoRepository, NotificacaoService notificacaoService) {
        this.eventoRepository = eventoRepository;
        this.notificacaoService = notificacaoService;
    }

    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    public Evento salvar(Evento evento) {
        Evento eventoSalvo = eventoRepository.save(evento);

        // Enviar notificação ao salvar o evento
        notificacaoService.enviarNotificacao(
            "Novo evento criado: " + eventoSalvo.getNome(),
            "sarahenaile@gmail.com" 
        );

        return eventoSalvo;
    }

    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Evento não encontrado")
        );
    }

    public void excluir(Long id) {
        eventoRepository.deleteById(id);

        // Enviar notificação ao excluir o evento
        notificacaoService.enviarNotificacao(
            "O evento com ID " + id + " foi excluído.",
            "sarahenaile@gmail.com" 
        );
    }
}
