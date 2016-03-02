/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL;

/**
 *
 * @author MiguelAngel
 */
public class Reservation {

    private String owner;
    private Spectacle show;
    private Seat seat;

    public Reservation(String owner, Spectacle show, Seat seat) {
        this.owner = owner;
        this.show = show;
        this.seat = seat;
    }

    public String getOwner() {
        return owner;
    }

    public Spectacle getShow() {
        return show;
    }

    public Seat getSeat() {
        return seat;
    }


}
