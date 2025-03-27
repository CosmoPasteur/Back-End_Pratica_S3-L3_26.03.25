package it.epicode.locations;

import jakarta.persistence.EntityManager;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Location e) {
        em.persist(e);
    }

    public void update(Location e) {
        em.merge(e);
    }

    //public void save(Location location) {

        //em.getTransaction().begin();
        //em.persist(location);
        //em.getTransaction().commit();
    //}

    public Location findById(Long id) {
        return em.find(Location.class, id);
    }

    public void delete(Long id) {

        Location e = findById(id);
        em.remove(e);
        //em.getTransaction().begin();
        //Location location = getById(id);
        //if (location != null) {
            //em.remove(location);
        //}
        //em.getTransaction().commit();
    }
}
