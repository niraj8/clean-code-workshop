package com.movierental;

public class TextStatement {

  public String create(String customerName, Rentals rentals) {
    String result = "Rental Record for " + customerName + "\n";
    for (Rental rental : rentals) {
      result += "\t" + rental.getMovie().getTitle() + "\t" + rental.amount() + "\n";
    }
    result += "Amount owed is " + rentals.totalAmount() + "\n";
    result += "You earned " + rentals.totalFRP() + " frequent renter points";
    return result;
  }

}