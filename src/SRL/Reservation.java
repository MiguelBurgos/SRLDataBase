/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MiguelAngel
 */
public class Reservation implements Serializable{

    private static final long serialVersionUID = 1L;
    private final String owner;
    
    private Spectacle show;
    private Seat selected;
    private List<Seat> preSold; 

    public Reservation(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public Spectacle getShow() {
        return show;
    }

    public Seat getSelected() {
        return selected;
    }

    public List<Seat> getPreSold() {
        return preSold;
    }

    public void setShow(Spectacle show) {
        this.show = show;
    }

    public void setSelected(Seat selected) {
        this.selected = selected;
    }

    public void setPreSold(List<Seat> preSold) {
        this.preSold = preSold;
    }

}
