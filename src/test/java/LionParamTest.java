import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParamTest {

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][] {
                { "Самец" },
                { "Самка" },
        };
    }

    private final String sex;

    @Mock
    Feline feline;

    public LionParamTest(String sex) {
        this.sex = sex;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateLion() throws Exception {
        Lion lion = new Lion(sex, feline);
    }
}
