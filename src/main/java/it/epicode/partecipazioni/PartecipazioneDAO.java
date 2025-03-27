package it.epicode.partecipazioni;

import jakarta.persistence.EntityManager;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Partecipazione e) {
        em.persist(e);
    }

    public void update(Partecipazione e) {
        em.merge(e);
    }

    public void delete(Long id) {
        Partecipazione e = findById(id);
        em.remove(e);
    }

    public Partecipazione findById(Long id) {
        return em.find(Partecipazione.class, id);
    }

    //public void save(Partecipazione partecipazione) {

        //em.getTransaction().begin();
        //em.persist(partecipazione);
        //em.getTransaction().commit();
    //}

    //public Partecipazione getById(Long id) {
        //return em.find(Partecipazione.class, id);
    //}

    //public void delete(long id) {

        //em.getTransaction().begin();
        //Partecipazione partecipazione = getById(id);
        //if (partecipazione != null) {
            //em.remove(partecipazione);
        //}
        //em.getTransaction().commit();
    //}
}
