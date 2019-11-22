import org.junit.Test;
import org.junit.*;
import org.sql2o.*;
import static org.junit.Assert.*;


//import static junit.framework.TestCase.assertTrue;
//import static org.junit.Assert.assertEquals;

public class AnimalsTest {
    @Test
    public void getName_AnimalsInstantiatesWithName_Elephant() {
        Animals testAnimals = new Animals(1, "Elephant");
        assertEquals("Elephant", testAnimals.getName());
    }
    @Test
    public void getId_AnimalsInstantiatesWithId_Id() {
        Animals testAnimals = new Animals(1, "Elephant");
        assertEquals(1, testAnimals.getId());
    }
//    @Test
//    public void equals_returnsTrueIfAnimalsAndEndangeredAnimalAreSame_true() {
//        Animals sightAnimals = new Animals(1, "Elephant");
//        Animals EndangeredAnimals = new Animals(1, "Elephants");
//        assertTrue(sightAnimals.equals(EndangeredAnimals));
//    }
@Test
public void save_insertsObjectIntoDatabase_Animals() {
    Animals testAnimals = new Animals(1, "Elephant");
    testAnimals.save();
    assertTrue(Animals.all().get(0).equals(testAnimals));
}
}
