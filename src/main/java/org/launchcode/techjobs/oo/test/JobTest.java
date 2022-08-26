package org.launchcode.techjobs.oo.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobTest {

    @Test
    public void test01SettingJobId() {
        Job jobA = new Job();
        Job jobB = new Job();
        System.out.println("a " + jobA.getId());
        System.out.println("b " + jobB.getId());
        assertNotEquals(jobA.getId(), jobB.getId());
    }

    @Test
    public void test02JobConstructorSetsAllFields() {
        Job jobC = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        System.out.println("c " + jobC.getId());
        assertTrue(jobC.getName() instanceof String);
        assertTrue(jobC.getEmployer() instanceof Employer);
        assertTrue(jobC.getLocation() instanceof Location);
        assertTrue(jobC.getPositionType() instanceof PositionType);
        assertTrue(jobC.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", jobC.getName());
        assertEquals("ACME", jobC.getEmployer().toString());
        assertEquals("Desert", jobC.getLocation().toString());
        assertEquals("Quality control", jobC.getPositionType().toString());
        assertEquals("Persistence", jobC.getCoreCompetency().toString());
    }

    @Test
    public void test03JobsForEquality() {
        Job jobD = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job jobE = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        System.out.println("d " + jobD.getId());
        System.out.println("e " + jobE.getId());
        assertNotEquals(jobD.getId(), jobE.getId());
    }

    // 5) toString tests
    @Test
    public void test04ToStringWrapsWithNewLine() {
        Job jobF = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        System.out.println("f " + jobF.getId());
        String jobToString = jobF.toString();
        assertEquals(jobToString.charAt(0), '\n');
        assertEquals(jobToString.charAt(jobToString.length()-1), '\n');
    }

    @Test
    public void test05ToStringContainsCorrectLabelsAndData() {
        Job jobG = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String jobToString = jobG.toString();
        String formattedJob = "\nID: 7" +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n";
        assertEquals(jobToString, formattedJob);
    }

    @Test
    public void test06ToStringHandlesEmptyField() {
        Job jobH = new Job("Product tester",
                new Employer(""),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String jobToString = jobH.toString();
        String formattedJob = "\nID: 8" +
                "\nName: Product tester" +
                "\nEmployer: Data not available" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n";
        assertEquals(jobToString, formattedJob);
    }

    @Test
    public void test07ToStringHandlesEmptyJob() {
        Job jobI = new Job();
        String jobToString = jobI.toString();
        String formattedJob = "\nOOPS! This job does not seem to exist.\n";
        assertEquals(jobToString, formattedJob);
    }

}
