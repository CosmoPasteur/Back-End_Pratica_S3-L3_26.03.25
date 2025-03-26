package it.epicode.location;

import jakarta.persistence.EntityManager;

public class LocationDAO {

    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {

        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }

    public Location getById(Long id) {
        return em.find(Location.class, id);
    }

    public void delete(Long id) {

        em.getTransaction().begin();
        Location location = getById(id);
        if (location != null) {
            em.remove(location);
        }
        em.getTransaction().commit();
    }
}
