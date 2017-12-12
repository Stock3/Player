package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import parsers.LocalDateDeserializer;
import parsers.LocalDateSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Player {
    @XStreamAsAttribute
    private int id;
    @XStreamAlias("firstName")
    private String firstName;
    @XStreamAlias("lastName")
    private String lastName;
    @XStreamAlias("dateOfBirthday")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfBirthday;
    @XStreamAlias("posistions")
    private List<Position> posistions;


    //конструктор з параметрами
    public Player(int id, String firstName, String lastName, LocalDate dateOfBirthday, List<Position> posistions) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirthday = dateOfBirthday;
        this.posistions = posistions;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", posistions=" + posistions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (id != player.id) return false;
        if (!firstName.equals(player.firstName)) return false;
        if (!lastName.equals(player.lastName)) return false;
        if (!dateOfBirthday.equals(player.dateOfBirthday)) return false;
        return posistions.equals(player.posistions);
    }


    //конструктор без параметрів
    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public List<Position> getPosistions() {
        return posistions;
    }

    public void setPosistions(List<Position> posistions) {
        this.posistions = posistions;
    }
}
