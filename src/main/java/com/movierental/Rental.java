package com.movierental;

public class Rental {

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public double amount() {
    double amount = 0.0;

    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        amount += 2;
        if (daysRented > 2) amount += (daysRented - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        amount += daysRented * 3;
        break;
      case Movie.CHILDRENS:
        amount += 1.5;
        if (daysRented > 3)
          amount += (daysRented - 3) * 1.5;
        break;
    }
    return amount;
  }
  public int points() {
    if (isBonusApplicable()) return 2;
    return 1;
  }

  private boolean isBonusApplicable() {
    return (movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1;
  }

}