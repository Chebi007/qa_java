import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected,  actual);
    }

    @Test
    public void testDoesHaveManeReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();
        boolean expected = true;
        assertEquals(expected,  actual);
    }

    @Test
    public void testDoesHaveManeReturnsFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean actual = lion.doesHaveMane();
        boolean expected = false;
        assertEquals(expected,  actual);
    }

    @Test
    public void testDoesHaveManeReturnsException() {
        try {
            Lion lion = new Lion("кто-то", feline);
            lion.doesHaveMane();
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        }
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected,  actual);
    }
}
