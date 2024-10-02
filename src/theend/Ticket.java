package theend;

import java.io.Serializable;

public class Ticket implements Serializable{

    private int seatNumber;
    private String showTime;
    private double ticketPrice;
         int ticketNumber;
    /// this is about conscructer
    public Ticket(int seatNumber, String showTime, double ticketPrice, int ticketNumber) {
        this.seatNumber = seatNumber;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        this.ticketNumber=ticketNumber;
    }

    /// this is about getter and setter
   

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
      
    
    public String toString() {
        return "Ticket ID: " + ticketNumber +
                ", Seat Number: " + seatNumber +
                ", Show Time: " + showTime +
                ", Ticket Price: " + ticketPrice;
    }

}
