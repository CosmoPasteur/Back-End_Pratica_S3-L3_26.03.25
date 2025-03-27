package it.epicode;

import it.epicode.enums.Sesso;
import it.epicode.enums.TipoEvento;
import it.epicode.evento.Evento;
import it.epicode.evento.EventoDAO;
import it.epicode.locations.Location;
import it.epicode.locations.LocationDAO;
import it.epicode.partecipazioni.Partecipazione;
import it.epicode.partecipazioni.PartecipazioneDAO;
import it.epicode.persone.Persona;
import it.epicode.persone.PersonaDAO;
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
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);

        em.getTransaction().begin();
        Location l = new Location(null, "Palazzo pitti", "Roma", null);
        locationDAO.insert(l);

        Evento e = new Evento(null, "Evento 1", LocalDate.of(2021, 1, 1), "Concerto vasco rossi", TipoEvento.PUBBLICO,1000,null, l);
        eventoDAO.insert(e);

        Persona p = new Persona( null, "Mario", "Rossi", "mario.rossi@epicode.it",  LocalDate.of(1990, 1, 1), Sesso.M, null);
        personaDAO.insert(p);

        Partecipazione partecipazione = new Partecipazione(null,  p, e, Stato.CONFERMATO);
        partecipazioneDAO.insert(partecipazione);


        em.getTransaction().commit();


        em.close();
        emf.close();



    }
}
