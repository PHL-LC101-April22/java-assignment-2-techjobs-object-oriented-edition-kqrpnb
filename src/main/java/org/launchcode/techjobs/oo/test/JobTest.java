package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobA = new Job();
        Job jobB = new Job();
        assertNotEquals(jobA.getId(), jobB.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobC = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
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
    public void testJobsForEquality() {
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
        assertNotEquals(jobD.getId(), jobE.getId());
    }

}
