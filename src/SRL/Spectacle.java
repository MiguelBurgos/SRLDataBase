/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MiguelAngel
 */
public class Spectacle {

    private final int id;

    private String name;
    private Date date;
    private ArrayList<Seat> seats;

    public Spectacle(int id, String name, Date fecha) {
        this.id = id;
        this.name = name;
        this.date = fecha;
        this.seats = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date fecha) {
        this.date = fecha;
    }

    public void setSeats(ArrayList<Seat> asientos) {
        this.seats = asientos;
    }

}
