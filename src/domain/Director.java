package domain;

import java.util.Date;

public class Director {
    int id;
    String first_name;
    String last_name;
    Date birth_date;

    public Director(int id, String first_name, String last_name, Date birth_date) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

}
