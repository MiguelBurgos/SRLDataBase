/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DBManagement.SRLRepository;
import SRL.Seat;
import SRL.Spectacle;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author MiguelAngel
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            SRLRepository repo = new SRLRepository();
            List<Spectacle> spectacle = repo.readSpectacles();
            
            for (Iterator<Spectacle> iterator = spectacle.iterator(); iterator.hasNext();) {
                Spectacle next = iterator.next();
                List<Seat> seats = next.getSeats();
                for (Iterator<Seat> iterator1 = seats.iterator(); iterator1.hasNext();) {
                    Seat next1 = iterator1.next();
                    System.out.println(next1.getId() + "    " + next1.isAvailable());
                    
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
