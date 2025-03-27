package it.epicode.persone;

import it.epicode.enums.Sesso;
import it.epicode.partecipazioni.Partecipazione;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String cognome;

    @Column(length = 100, nullable = false)
    private String email;

    private LocalDate dataNascita;

    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    List<Partecipazione> listaPartecipazioni = new ArrayList<>();

    public Persona(long id, String nome, String cognome, String email, LocalDate dataNascita, Sesso sesso, String listaPartecipazioni) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.listaPartecipazioni = listaPartecipazioni;
    }

    public Persona() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }


}
