/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd567.msabouri.service;

import edu.iit.sat.itmd567.msabouri.domain.Offer;
import edu.iit.sat.itmd567.msabouri.domain.Seller;
import edu.iit.sat.itmd567.msabouri.web.LoginController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Milad
 */
@Named
@Stateless
public class OfferService extends AbstractService<Offer> {

    SellerService sellerSvc = new SellerService();

    /**
     *
     */
    public OfferService() {
        super(Offer.class);
    }

    @Override
    public List<Offer> findAll() {
        return getEntityManager().createNamedQuery("Offer.findAll", Offer.class).getResultList();
    }

    public List<Offer> findByUserName(String username) {
        return getEntityManager().createNamedQuery("Offer.findByUsername", Offer.class).setParameter("username", username).getResultList();
    }

    
    public void create(Offer offer, String username) {
//        Seller seller = sellerSvc.findIdByUserName(username);
        Seller seller = new Seller("milad", "milad", "ms", new Date());
        offer.setSeller(seller);
        super.create(offer);
    }

}
