import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndangeredTest {
    @Rule
    public DatabaseRules database = new DatabaseRules();

    @Test
    public void endangered_instantiatesCorrectly_true(){
        Endangered testAnimal = new Endangered("Elephant","okay","young");
        assertEquals(testAnimal instanceof Endangered,true);
    }
    @Test
    public void endangered_instantiatesWithAnimalName_String(){
        Endangered testAnimal = new Endangered("Elephant","okay","young");
        assertEquals("Elephant",testAnimal.getName());
    }
    @Test
    public void endangered_instantiatesWithAnimalHealth_String(){
        Endangered testAnimal = new Endangered("Elephant","okay","young");
        assertEquals("okay",testAnimal.getHealth());
    }
    @Test
    public void endangered_instantiatesWithAgeOfAnimal_String(){
        Endangered testAnimal = new Endangered("Elephant","okay","young");
        assertEquals("young",testAnimal.getAge());
    }
    @Test
    public void save_savesEndangeredAnimalObjectsIntoDb(){
        Endangered testAnimal = new Endangered("Elephant","okay","young");
        testAnimal.save();
        assertTrue(Endangered.all().get(0).equals(testAnimal));
    }
    @Test
    public void all_returnsAllInstancesOfEndangeredAnimals_true(){
        Endangered firstAnimal = new Endangered("Elephant","okay","young");
        firstAnimal.save();
        Endangered secondAnimal = new Endangered("Elephant","okay","young");
        secondAnimal.save();
        assertEquals(true,Endangered.all().get(0).equals(firstAnimal));
        assertEquals(true,Endangered.all().get(1).equals(secondAnimal));
    }
    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondAnimal(){
        Endangered firstAnimal = new Endangered("Elephant","okay","young");
        firstAnimal.save();
        Endangered secondAnimal = new Endangered("Elephant","okay","young");
        secondAnimal.save();
        assertEquals(Endangered.find(secondAnimal.getId()),secondAnimal);
    }
}
