package it.epicode.evento;

import jakarta.persistence.EntityManager;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        em.persist(evento);
    }

    public Evento getById(Long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento evento) {
        em.remove(evento);
    }



}
