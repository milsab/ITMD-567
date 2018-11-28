/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd567.msabouri.web;

import edu.iit.sat.itmd567.msabouri.domain.Buyer;
import edu.iit.sat.itmd567.msabouri.domain.Offer;
import edu.iit.sat.itmd567.msabouri.domain.OrderFood;
import edu.iit.sat.itmd567.msabouri.service.BuyerService;
import edu.iit.sat.itmd567.msabouri.service.OrderService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Milad
 */
@Named
@SessionScoped
public class BuyerController extends AbstractController implements Serializable{

    private static final Logger LOG = Logger.getLogger(BuyerController.class.getName());
    
    private Buyer buyer;
    private OrderFood order;
    private String qty;
    
    
    @EJB
    private BuyerService buyerSvc;
    
    @EJB
    private OrderService orderSvc;

    @Inject
    private LoginController loginController;

    
    @PostConstruct
    private void postConstructor(){
        super.postConstruct();
        LOG.info("Inside BuyerController postConstructor");        
        buyer = buyerSvc.findByUserName(loginController.getRemoteUser());
        order = new OrderFood();
    }
       
    // action methods here
    public void doAddOrder(Offer offer, String qty){
        BigDecimal price = 
                new BigDecimal(1 * (offer.getUnitPrice().intValue()));
        this.order.setOrderDate(new Date());
        this.order.setBuyer(buyer);
        this.order.setOffer(offer);
        this.order.setPrice(price);
//        this.order.setQuantity(qyt);
        
        orderSvc.create(order);
        
        
    }

    /**
     * Get the value of buyer
     *
     * @return the value of buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Set the value of buyer
     *
     * @param buyer new value of buyer
     */
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

}
