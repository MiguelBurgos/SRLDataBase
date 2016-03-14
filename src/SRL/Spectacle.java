/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MiguelAngel
 */
public class Spectacle implements Serializable{

    private static final long serialVersionUID = 1L;
    private final int id;

    private String name;
    private Date date;
    private Map<Integer, Seat> seats;

    public Spectacle(int id, String name, Date fecha) {
        this.id = id;
        this.name = name;
        this.date = fecha;
        this.seats = new HashMap<>();
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

    public List<Seat> getSeats() {
        List<Seat> seatsList = new ArrayList<>(seats.values());
        return seatsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date fecha) {
        this.date = fecha;
    }

    public void setSeats(List<Seat> seats) {
        for (Iterator<Seat> iterator = seats.iterator(); iterator.hasNext();) {
            Seat next = iterator.next();
            System.out.println(next.getId());
            this.seats.put(next.getId(), next);   
        }
    }

}
