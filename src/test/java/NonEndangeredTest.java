import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NonEndangeredTest {
    @Rule
    public  DatabaseRules database = new DatabaseRules();

    @Test
    public void NonEndangered_instantiatesCorrectly_true(){
        NonEndangered testAnimal = new NonEndangered("hyena");
        assertEquals(testAnimal instanceof NonEndangered,true);
    }
    @Test
    public void NonEndangered_instantiatesWithName_String(){
        NonEndangered testAnimal = new NonEndangered("hyena");
        assertEquals("hyena",testAnimal.getName());
    }
    @Test
    public void equals_returnTrueIfAnimalNamesAreTrue_True(){
        NonEndangered firstAnimal = new NonEndangered("hyena");
        NonEndangered secondAnimal = new NonEndangered("hyena");
        assertTrue(firstAnimal.equals(secondAnimal));
    }
    @Test
    public void save_savesNonEndangeredAnimalIntoDatabase(){
        NonEndangered testAnimal = new NonEndangered("hyena");
        testAnimal.save();
        assertTrue(NonEndangered.all().get(0).equals(testAnimal));
    }
    @Test
    public void saves_savesAssignsIdToNonEndangeredAnimal_int(){
        NonEndangered testAnimal = new NonEndangered("hyena");
        testAnimal.save();
        NonEndangered saveAnimal = NonEndangered.all().get(0);
        assertEquals(testAnimal.getId(),saveAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfNonEndangeredAnimals_true(){
        NonEndangered firstAnimal = new NonEndangered("hyena");
        firstAnimal.save();
        NonEndangered secondAnimal = new NonEndangered("bees");
        secondAnimal.save();
        assertEquals(true,NonEndangered.all().get(0).equals(firstAnimal));
        assertEquals(true, NonEndangered.all().get(1).equals(secondAnimal));
    }
    @Test
    public void find_trueNonEndangeredAnimalsWithSameId_firstAnimal(){
        NonEndangered firstAnimal = new NonEndangered("hyena");
        firstAnimal.save();
        NonEndangered secondAnimal = new NonEndangered("bees");
        secondAnimal.save();
        assertEquals(NonEndangered.find(firstAnimal.getId()),firstAnimal);
    }
}
