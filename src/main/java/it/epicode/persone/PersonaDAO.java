package it.epicode.persone;

import jakarta.persistence.EntityManager;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Persona e) {
        em.persist(e);
    }

    public void update(Persona e) {
        em.merge(e);
    }

    public void delete(Long id) {
        Persona e = findById(id);
        em.remove(e);
    }

    public Persona findById(Long id) {
        return em.find(Persona.class, id);
    }

    //public void save(Persona persona) {

        //em.getTransaction().begin();
        //em.persist(persona);
        //em.getTransaction().commit();
    //}

    //public Persona getById(Long id) {
        //return em.find(Persona.class, id);
    //}

    //public void delete(Long id) {

        //em.getTransaction().begin();
        //Persona persona = getById(id);
        //if (persona != null) {
            //em.remove(persona);
        //}
        //em.getTransaction().commit();
    //}
}
