package domain;

import com.company.DirectorRepository;
import com.company.FilmRepository;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class PrintInformation {

    FilmRepository filmRepository = new FilmRepository();
    DirectorRepository directorRepository = new DirectorRepository();
    Scanner in = new Scanner(System.in);

    public void printFilms() {
        Collection<Film> films = filmRepository.getAllFilms();
        for (Film film : films) {
            System.out.println(film.getId() + " " + film.getDirector_id() + " " + film.getName() + " "
                    + film.getRelease_date() + " " + film.getGenre());
        }
    }

    public void printDirector() {
        Collection<Director> directors = directorRepository.getAllDirectors();
        for (Director director : directors) {
            System.out.println(director.getId() + " " + director.getFirst_name() + " " + director.getLast_name()
                    + " " + director.getBirth_date());
        }
    }

    public int printDirectorById() {
        System.out.println("Enter director id: ");
        int id = in.nextInt();
        Director director = directorRepository.getDirectorById(id);
        System.out.println(director.getFirst_name()
                + " " + director.getLast_name() + " " + director.getBirth_date());
        return id;
    }

    public Date printFilmByDate() {
        Date dateIn = null;
        System.out.println("Enter date in format dd.MM.yyyy: ");
        try {
            String dateString = in.nextLine();
            dateIn = new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
            for (Film film : filmRepository.getFilmsByDate(dateIn)) {
                System.out.println(film.getName() + " " + film.getRelease_date() + " " + film.getGenre());
            }

        } catch (ParseException e) {
            System.out.println("Error has been reached unexpectedly while parsing");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dateIn;
    }

    public void printDirectorAndFilms() {
        for (Film film : filmRepository.getFilmByDateAndId(printDirectorById(), printFilmByDate())) {
            System.out.println(film.getName() + " " + film.getRelease_date() + " " + film.getGenre());
        }

    }
}
