package com.sarah.GerenciadorEventos.service;

import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {
    public void enviarNotificacao(String mensagem, String destinatario) {
        // Simulação de envio da notificação - log no console
        System.out.println("Notificação enviada para " + destinatario + ": " + mensagem);

    }
}
