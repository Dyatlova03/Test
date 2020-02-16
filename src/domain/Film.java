package domain;

import java.util.Date;

public class Film {
    int id;
    int director_id;
    String name;
    Date release_date;
    String genre;

    public Film(int id, int director_id, String name, Date release_date, String genre) {
        this.id = id;
        this.director_id = director_id;
        this.name = name;
        this.release_date = release_date;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public int getDirector_id() {
        return director_id;
    }

    public String getName() {
        return name;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public String getGenre() {
        return genre;
    }
}
