/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd567.msabouri.web;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author Milad
 */
public abstract class AbstractController {
    protected FacesContext context;

    protected AbstractController() {
    }

    @PostConstruct
    public void postConstruct() {
        context = FacesContext.getCurrentInstance();
    }
}
