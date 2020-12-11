package pl.wsb.students.model;

import pl.wsb.students.model.enums.EMovieGenre;

import java.util.List;

public class DVDMovie extends Movie {

    private final int PRICE = 10;
    private final int LOYALTY_POINTS = 5;

    public DVDMovie(
            String title, String releaseYear, EMovieGenre genre,
            Director director, List<Actor> actors, int stock
    ) {
        super(title, releaseYear, genre, director, actors, stock);
    }

    public DVDMovie(String title, int stock) {
        super(title, stock);
    }

    @Override
    protected int getPrice() {
        return PRICE;
    }

    @Override
    protected int getLoyaltyPoints() {
        return LOYALTY_POINTS;
    }
}
