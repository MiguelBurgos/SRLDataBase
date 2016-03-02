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
public class Seat {

    private final int number;

    private boolean available;

    public Seat(int number, boolean state) {
        this.number = number;
        this.available = state;
    }

    public Seat(int number) {
        this.number = number;
        this.available = true;
    }

    public int getNumber() {
        return number;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}