import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    Feline feline;

    @Test
    public void checkSound() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("", "Мяу", cat.getSound());
    }

    @Test
    public void checkFood() throws Exception {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Кот ест только других животных", List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
