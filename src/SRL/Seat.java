/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL;

import java.io.Serializable;

/**
 *
 * @author MiguelAngel
 */
public class Seat implements Serializable{

    private static final long serialVersionUID = 1L;
    private final int number;

    private Integer state;

    public Seat(int number, Integer state) {
        this.number = number;
        this.state = state;
    }

    public Seat(int number) {
        this.number = number;
        this.state = 1;
    }

    public int getId() {
        return number;
    }

    public Integer getState() {
        return state;
    }

    public void setAvailable() {
        this.state = 1;
    }
    
    public void setOccupied(){
        this.state = 2;
    }
    
    public void setSelected(){
        this.state = 3;
    }

}

