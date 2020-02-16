package com.company;

import domain.PrintInformation;

import java.util.*;

public class Run {
    public void choice(){

        PrintInformation printInformation = new PrintInformation();

        System.out.println("Make a choice: " + "\n" + "1) List movies" + "\n" + "2) List of directors"
                + "\n" + "3) Find director by ID" + "\n" + "4) Find movies released after a certain date" + "\n" +
                "5) Find a movie of a certain producer that was released after a certain date" + "\n" + "6) Exit");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();


        switch (i) {
            case 1:
                printInformation.printFilms();
                choice();
                break;
            case 2:
                printInformation.printDirector();
                choice();
                break;
            case 3:
                printInformation.printDirectorById();
                choice();
                break;
            case 4:
                printInformation.printFilmByDate();
                choice();
                break;
            case 5:
                printInformation.printDirectorAndFilms();
                choice();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Вы ввели неверное значение");
                choice();
                break;
        }
    }
}
