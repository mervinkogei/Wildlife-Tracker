import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingTest {
    @Rule
    public DatabaseRules database = new DatabaseRules();

    @Test
    public void Sightings_instantiatesCorrectly_true(){
        Sightings testSightings = new Sightings("Park 1","Kogei",1);
        assertEquals(testSightings instanceof Sightings, true);
    }
    @Test
    public void getLocation_instantiatesWithLocation_String(){
        Sightings testSighting = new Sightings("Park 1","kogei",1);
        assertEquals("Park 1",testSighting.getLocation());
    }
    @Test
    public void getLocation_instantiatesWithRangerName_String(){
        Sightings testSightings = new Sightings("Park 1","Kogei",1);
        assertEquals("Kogei",testSightings.getRangerName());
    }
    @Test
    public void getLocation_instantiatesWithAnimalId_int(){
        Sightings testSightings = new Sightings("Park 1","Kogei",1);
        assertEquals(1, testSightings.getAnimalId());
    }
    @Test
    public void equals_returnsTrueSightingsObjectsAreTrue_true(){
        Sightings firstSighting = new Sightings("park 1","Kogei",1);
        Sightings secondSighting = new Sightings("Park 1","Kogei",1);
        assertTrue(firstSighting.equals(secondSighting));
    }
    @Test
    public void save_savesSightingsObjectsIntoDatabase(){
        Sightings testSighting = new Sightings("Park 1","Kogei",1);
        testSighting.save();
        assertEquals(true,Sightings.all().get(0).equals(testSighting));
    }
    @Test
    public void all_returnAllObjectsOfSightingsClass_true(){
        Sightings firstSighting = new Sightings("park 1","Kogei",1);
        firstSighting.save();
        Sightings secondSighting = new Sightings("Park 1","Kogei",1);
        secondSighting.save();
        assertEquals(true,Sightings.all().get(0).equals(firstSighting));
        assertEquals(true,Sightings.all().get(1).equals(secondSighting));
    }
    @Test
    public void save_assignsIdToSaveObjects(){
        Sightings testSightings = new Sightings("Park 1", "Kogei",1);
        testSightings.save();
        Sightings savedSightings = Sightings.all().get(0);
        assertEquals(testSightings.getId(),savedSightings.getId());
    }
    @Test
    public void find_returnsAllObjectsWithProvidedId_secondSighting(){
        Sightings firstSighting = new Sightings("Park 1","Kogei",1);
        firstSighting.save();
        Sightings secondSighting = new Sightings("Park 1","Kogei",1);
        secondSighting.save();
        assertEquals(Sightings.find(secondSighting.getId()),secondSighting);

    }
}
