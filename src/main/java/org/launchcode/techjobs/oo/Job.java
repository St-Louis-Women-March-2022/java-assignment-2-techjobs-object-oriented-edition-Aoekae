package org.launchcode.techjobs.oo;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
        ArrayList<String> addedVariables = new ArrayList<>();
        ArrayList<String> totalVariables = new ArrayList<>();
        String text = "\n";
        String emptyCheck = "" + "\n";

        //setting the array for later printing
        listOfParameters[0]= "ID: ";
        listOfParameters[1] = "Name: ";
        listOfParameters[2] = "Employer: ";
        listOfParameters[3] = "Location: ";
        listOfParameters[4] = "Position Type: ";
        listOfParameters[5] = "Core Competency: ";

        //setting the list of fields I'll use to check the data

        String idString = this.getId() + "\n";
        String nameString = this.getName() + "\n";
        String employerString = this.getEmployer() + "\n";
        String locationString = this.getLocation() + "\n";
        String positionTypeString = this.getPositionType() + "\n";
        String skillString = this.getCoreCompetency() + "\n";

        //adding variables to totalVariables in string format for checking via iteration

        totalVariables.add(idString);
        totalVariables.add(nameString);
        totalVariables.add(employerString);
        totalVariables.add(locationString);
        totalVariables.add(positionTypeString);
        totalVariables.add(skillString);

        //setting the id into addedVariables
//       //if fields exist, iterate through and add the variables to the addedVariables arraylist
//        if (nameString!= emptyCheck && employerString != emptyCheck && locationString!=emptyCheck && positionTypeString!=emptyCheck && skillString!=emptyCheck) {
            for (int index = 0; index < totalVariables.size(); index++) {
                if (totalVariables.get(index).equals(emptyCheck)) {
                    totalVariables.set(index, "Data Not Available" + "\n");
                }
                addedVariables.add(totalVariables.get(index));
                text += listOfParameters[index] + addedVariables.get(index);

            }
//        System.out.println(text);
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
