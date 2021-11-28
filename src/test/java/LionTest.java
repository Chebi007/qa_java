import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
    public void testGetKittens() {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected,  actual);
    }

    @Test
    public void testDoesHaveManeReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец");
        boolean actual = lion.doesHaveMane();
        boolean expected = true;
        assertEquals(expected,  actual);
    }

    @Test
    public void testDoesHaveManeReturnsFalse() throws Exception {
        Lion lion = new Lion("Самка");
        boolean actual = lion.doesHaveMane();
        boolean expected = false;
        assertEquals(expected,  actual);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testDoesHaveManeThrowsException() throws Exception {
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        new Lion("кто-то");
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected,  actual);
    }
}
