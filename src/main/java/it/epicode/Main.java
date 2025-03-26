package it.epicode;



import it.epicode.enums.Sesso;
import it.epicode.evento.Evento;
import it.epicode.evento.EventoDAO;
import it.epicode.partecipazione.Partecipazione;
import it.epicode.partecipazione.PartecipazioneDAO;
import it.epicode.persona.Persona;
import it.epicode.persona.PersonaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

import it.epicode.enums.Stato;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);

        Evento evento = new Evento("Evento di prova", LocalDate.of(2024, 1, 1), "Descrizione evento di prova", "Type", 100);
        Evento evento2 = new Evento("Evento di prova 2", LocalDate.of(2024, 1, 1), "Descrizione evento di prova", "Type", 50);
        Evento evento3 = new Evento("Evento di prova 3", LocalDate.of(2024, 1, 1), "Descrizione evento di prova", "Type", 30);
        Evento evento4 = new Evento("Evento di prova 4", LocalDate.of(2024, 1, 1), "Descrizione evento di prova", "Type", 200);

        eventoDAO.save(evento);
        eventoDAO.save(evento2);
        eventoDAO.save(evento3);
        eventoDAO.save(evento4);

        PersonaDAO personaDAO = new PersonaDAO(em);
        Persona persona = new Persona("Luca", "Di Marco", "luca@diMarco.it", Sesso.M, LocalDate.of(1998, 1, 1), evento);
        Persona persona2 = new Persona("Mario", "Di Marco", "mario@diMarco.it", Sesso.M, LocalDate.of(1998, 1, 1), evento2);
        Persona persona3 = new Persona("Ginevra", "Di Marco", "Ginevra@diMarco.it", Sesso.F, LocalDate.of(1998, 1, 1), evento3);
        Persona persona4 = new Persona("Silvio", "Di Marco", "Silvio@diMarco.it", Sesso.M, LocalDate.of(1998, 1, 1), evento4);

        personaDAO.save(persona);
        personaDAO.save(persona2);
        personaDAO.save(persona3);
        personaDAO.save(persona4);

        System.out.println(personaDAO.getById(1L));

        personaDAO.delete(persona.getId());


        //PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        //Partecipazione partecipazione = new Partecipazione(persona, evento, Stato.PRENOTATO);
        //Partecipazione partecipazione2 = new Partecipazione(persona2, evento2, Stato.PRENOTATO);
        //Partecipazione partecipazione3 = new Partecipazione(persona3, evento3, Stato.PRENOTATO);
        //Partecipazione partecipazione4 = new Partecipazione(persona4, evento4, Stato.PRENOTATO);

        Evento eventoById = eventoDAO.getById(1L);
        System.out.println(eventoById);

        eventoDAO.delete(eventoById);

        System.out.println(eventoDAO.getById(1L));

        em.close();
        emf.close();

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        //EntityManager em = emf.createEntityManager();

        //EventoDAO eventoDAO = new EventoDAO(em);

        //Evento evento = new Evento("Evento di prova", LocalDate.of(2024, 1, 1), "Descrizione evento di prova", "Type", 100);
        //eventoDAO.save(evento);

        //Evento eventoById = eventoDAO.getById(1L);
        //System.out.println(eventoById);

        //eventoDAO.delete(eventoById);

        //System.out.println(eventoDAO.getById(1L));

        //em.close();
        //emf.close();


    }
}
