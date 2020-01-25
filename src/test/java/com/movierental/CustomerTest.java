package com.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
  @Test
  public void statement() {
    Customer customer = setupCustomer();

    assertEquals("Rental Record for Michael Cera\n" +
        "\tScott Pilgrim\t9.5\n" +
        "\tFB #2\t21.0\n" +
        "\tHP #1\t12.0\n" +
        "Amount owed is 42.5\n" +
        "You earned 4 frequent renter points", customer.statement());
  }

  @Test
  public void htmlStatement() {
    Customer customer = setupCustomer();
    assertEquals("<h1>Rental Record for <b>Michael Cera</b></h1><br>" +
        "Scott Pilgrim 9.5<br>" +
        "FB #2 21.0<br>" +
        "HP #1 12.0<br>" +
        "Amount owed is <b>42.5</b><br>" +
        "You earned <b>4</b> frequent renter points", customer.htmlStatement());
  }

  private Customer setupCustomer() {
    Customer customer = new Customer("Michael Cera");
    Movie scottPilgrim = new Movie("Scott Pilgrim", Movie.REGULAR);
    Movie fb2 = new Movie("FB #2", Movie.NEW_RELEASE);
    Movie hp1 = new Movie("HP #1", Movie.CHILDRENS);
    Rental rental1 = new Rental(scottPilgrim, 7);
    Rental rental2 = new Rental(fb2, 7);
    Rental rental3 = new Rental(hp1, 10);
    customer.addRental(rental1);
    customer.addRental(rental2);
    customer.addRental(rental3);
    return customer;
  }
}