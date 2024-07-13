import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    Lion lion;

    @Before
    public void init() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(5);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        lion = new Lion("Самка", feline);
    }

    @Test
    public void testHaveMane() {
        Assert.assertFalse("Самка не должна иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testNotSupportedSexLion() {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Механо", feline);
        });
        Assert.assertEquals("Попытка создать льва несуществующего пола", exception.getMessage(), "Используйте допустимые значения пола животного - самей или самка");
    }

    @Test
    public void testKittensCount() {
        int expectedKittens = 3;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittens);
        Assert.assertEquals(expectedKittens, lion.getKittens());
    }

    @Test
    public void testFoodIsMeat() throws Exception {
        Assert.assertEquals("Львы едят только других животных", List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

}
