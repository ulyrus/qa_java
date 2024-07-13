import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;

    @Test
    public void predatorFoodIsOtherAnimals() throws Exception {
        List<String> felineFood = feline.getFood("Хищник");
        Assert.assertEquals("Хищник ест только других животных", List.of("Животные", "Птицы", "Рыба"), felineFood);
    }

    @Test
    public void familyIsFeline()  {
        String family = feline.getFamily();
        Assert.assertEquals("Некорректное семейство", family, "Кошачьи");
    }

    @Test
    public void testKittensCountDefault()  {
        int kittensCount = feline.getKittens();
        Assert.assertEquals("Количество котят по умолчанию", kittensCount, 1);
    }

    @Test
    public void testKittensCount()  {
        int expected = 5;
        int kittensCount = feline.getKittens(expected);
        Assert.assertEquals("Количество котят(кастомное)", kittensCount, expected);
    }
}
