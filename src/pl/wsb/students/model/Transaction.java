package pl.wsb.students.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {

    private List<Movie> movies = new ArrayList<>();
    private Date date;
    private double amount = 0;
    private int soldDVDs = 0;
    private int soldBluRays = 0;
    private int loyaltyPoints = 0;
    private Customer customer;

    public Transaction(Customer customer) {
        this.customer = customer;
        this.date = new Date();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getSoldDVDs() {
        return soldDVDs;
    }

    public void setSoldDVDs(int soldDVDs) {
        this.soldDVDs = soldDVDs;
    }

    public int getSoldBluRays() {
        return soldBluRays;
    }

    public void setSoldBluRays(int soldBluRays) {
        this.soldBluRays = soldBluRays;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean addMovie(Movie movie) {
        if (movie == null) {
            return false;
        }// stock check
        if (!movie.isAvailable()) {
            return false;
        }   //if
        // increasing the transaction amount
        this.amount += movie.getPrice();
        // increasing the loyalty points
        this.loyaltyPoints += movie.getLoyaltyPoints();// increasing the number of movies sold
        if (movie instanceof DVDMovie) {
            this.soldDVDs++;
        } else {
            this.soldBluRays++;
        }// adding movie to the sold movies list
        this.movies.add(movie);
        return true;
    }

}
