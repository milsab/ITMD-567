/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.msabouri.web;

import edu.iit.sat.itmd4515.msabouri.domain.Buyer;
import edu.iit.sat.itmd4515.msabouri.domain.OrderFood;
import edu.iit.sat.itmd4515.msabouri.service.BuyerService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Milad
 */
@Named
@RequestScoped
public class BuyerController extends AbstractController{

    private static final Logger LOG = Logger.getLogger(BuyerController.class.getName());
    
    private Buyer buyer;
    private OrderFood order;
    
    @EJB
    private BuyerService buyerSvc;

    @Inject
    private LoginController loginController;
    
    @PostConstruct
    private void postConstructor(){
        super.postConstruct();
        LOG.info("Inside BuyerController postConstructor");        
        buyer = buyerSvc.findByUserName(loginController.getRemoteUser());
        order = new OrderFood();
    }
    
    // helper method
//    public String getShowDiscJockeysFormatted(RadioShow show){
//        List<String> names = new ArrayList<>();
//        for(DiscJockey dj : show.getDiscJockeys()){
//            names.add(dj.getName());
//        }
//        return String.join(",", names);
//    }
    
    // action methods here
//    public String doViewShow(RadioShow show){
//        this.radioShow = show;
//        LOG.info("We are about to view the information for radio show " + radioShow.toString());
//        return "/dj/viewShow";
//    }

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

}
