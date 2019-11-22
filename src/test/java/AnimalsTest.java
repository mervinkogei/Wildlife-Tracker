import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalsTest {
    @Test
    public void getName_personInstantiatesWithName_Henry() {
        Animals testAnimals = new Animals(1, "Elphant");
        assertEquals("1", testAnimals.getName());
    }
}
