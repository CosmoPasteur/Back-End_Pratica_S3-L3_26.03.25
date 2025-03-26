package it.epicode.partecipazione;

import it.epicode.enums.Stato;
import it.epicode.evento.Evento;
import it.epicode.persona.Persona;
import jakarta.persistence.*;


@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 100, nullable = false)
    private Persona persona;

    private Evento evento;

    @Column(nullable = false)
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

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
