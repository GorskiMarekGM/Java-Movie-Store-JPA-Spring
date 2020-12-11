package pl.wsb.students.model;

import pl.wsb.students.model.enums.EMovieGenre;

import java.util.List;

public abstract class Movie {

    private String title;
    private String releaseYear;
    private EMovieGenre genre;
    private Director director;
    private List<Actor> actors;
    private int stock;

    public Movie(
            String title, String releaseYear, EMovieGenre genre,
            Director director, List<Actor> actors, int stock
    ) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.stock = stock;
    }

    public Movie(String title, int stock) {
        this.title = title;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public EMovieGenre getGenre() {
        return genre;
    }

    public void setGenre(EMovieGenre genre) {
        this.genre = genre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isAvailable() {
        return (this.stock > 0);
    }

    protected abstract int getPrice();

    protected abstract int getLoyaltyPoints();
}
