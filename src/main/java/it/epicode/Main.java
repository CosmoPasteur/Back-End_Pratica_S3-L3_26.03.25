package it.epicode;



import it.epicode.evento.Evento;
import it.epicode.evento.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);

        Evento evento = new Evento("Evento di prova", LocalDate.of(2024, 1, 1), "Descrizione evento di prova", "Type", 100);
        eventoDAO.save(evento);

        Evento eventoById = eventoDAO.getById(1L);
        System.out.println(eventoById);

        eventoDAO.delete(eventoById);

        //em.getTransaction().begin();
        //inserimento evento
        //Evento evento2 = new Evento("Evento di prova", LocalDate.of(2024, 1, 1), "Descrizione evento di prova", "Type", 100);
        //em.persist(evento2);
        //em.getTransaction().commit();

        //em.close();
        //emf.close();

    }
}
//EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
//EntityManager em = emf.createEntityManager();
//Evento evento = new Evento();