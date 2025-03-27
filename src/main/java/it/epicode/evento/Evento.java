package it.epicode.evento;

import it.epicode.locations.Location;
import it.epicode.partecipazioni.Partecipazione;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eventi")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 200, nullable = false)
    private String titolo;

    private LocalDate dataEvento;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private String tipoEvento;
    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni = new ArrayList<>();

    @ManyToOne
    private Location location;

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, String tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.partecipazioni = partecipazioni;
        this.location = location;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



    public Evento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
}
