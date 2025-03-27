package it.epicode.partecipazioni;

import it.epicode.enums.Stato;
import it.epicode.evento.Evento;
import it.epicode.persone.Persona;
import jakarta.persistence.*;


@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato;


    public Partecipazione(long id, Persona persona, Evento evento, Stato stato) {
        this.id = id;
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public Partecipazione() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}
