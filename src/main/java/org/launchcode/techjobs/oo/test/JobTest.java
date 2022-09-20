package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job test = new Job("job", new Employer("Boss"), new Location("Place"), new PositionType("Test"), new CoreCompetency("Skill"));
        assertEquals(test.toString().charAt(0), '\n');
        assertEquals(test.toString().charAt(test.toString().length()-1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job test = new Job("Job", new Employer("Boss"), new Location("Place"), new PositionType("Test"), new CoreCompetency("Skill"));
        assertEquals(test.toString(), "\nID: "+ test.getId() +"\n" + "Name: Job\n"+"Employer: Boss\n"+"Location: Place\n"+"Position Type: Test\n"+"Core Competency: Skill\n");

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test = new Job("", new Employer("Boss"), new Location("Place"), new PositionType("Test"), new CoreCompetency("Skill"));
        assertEquals(test.toString(),"\nID: "+ test.getId() +"\n" + "Name: Data Not Available\n"+"Employer: Boss\n"+"Location: Place\n"+"Position Type: Test\n"+"Core Competency: Skill\n");
    }
}