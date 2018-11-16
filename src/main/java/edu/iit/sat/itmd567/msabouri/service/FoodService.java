/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd567.msabouri.service;

import edu.iit.sat.itmd567.msabouri.domain.Food;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Milad
 */
@Named
@Stateless
public class FoodService extends AbstractService<Food> {

    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager em;

    /**
     *
     */
    public FoodService() {
        super(Food.class);
    }

    /**
     *
     * @param food the food that you want to create in persistence unit
     */
    public void create(Food food) {
        em.persist(food);
    }

    /**
     *
     * @param food the food that you want to update in persistence unit
     */
    public void update(Food food) {
        em.merge(food);
    }

    /**
     *
     * @param food the food that you want to remove
     */
    public void remove(Food food) {
        em.remove(em.merge(food));
    }

    /**
     * Find the food by id
     *
     * @param id the id for the food
     * @return food
     */
    public Food findById(Long id) {
        return em.find(Food.class, id);
    }

    /**
     *
     * @return all food
     */
    @Override
    public List<Food> findAll() {
        return getEntityManager().createNamedQuery("Food.findAll", Food.class).getResultList();
    }

}
