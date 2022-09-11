package org.launchcode.techjobs.oo;

import java.lang.reflect.Array;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    //  Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String[] listOfParameters = new String[6];
        String[] listOfVariables = new String[6];
        String text = "\n";

        listOfParameters[0]= "ID: ";
        listOfParameters[1] = "Name: ";
        listOfParameters[2] = "Employer: ";
        listOfParameters[3] = "Location: ";
        listOfParameters[4] = "Position Type: ";
        listOfParameters[5] = "Core Competency: ";

        listOfVariables[0]= this.getId() + "\n";
        listOfVariables[1]= this.getName() + "\n";
        listOfVariables[2]= this.getEmployer() + "\n";
        listOfVariables[3]= this.getLocation() + "\n";
        listOfVariables[4]= this.getPositionType() + "\n";
        listOfVariables[5]= this.getCoreCompetency() + "\n";



        if ((listOfVariables[0] == "" + "\n") && (listOfVariables[1] == "" + "\n") && (listOfVariables[2] == "" + "\n") && (listOfVariables[3] == "" + "\n") && (listOfVariables[4] == "" + "\n")&& (listOfVariables[5] == "" + "\n")) {
            return "OOPS! This job does not seem to exist.";
        } else {

            for (int index = 0; index < listOfVariables.length; index++) {
                if (listOfVariables[index].equals("" + "\n")) {
                    listOfVariables[index] = "Data Not Available" + "\n";
                }
                text += listOfParameters[index] + listOfVariables[index];

            }
        }
        return text;
    }


    // Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
