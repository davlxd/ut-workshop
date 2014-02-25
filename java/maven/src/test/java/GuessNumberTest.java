import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by xdli on 2/25/14.
 */
public class GuessNumberTest {

    @Before
    public void setup() {
    }

    /**
     * Unit integrate test
     */
    @Test
    public void mock_both_RandomNumberGenerate_and_CompareTwoNumbers_should_work() {
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generate()).thenReturn("1234");

        CompareTwoNumbers compareTwoNumbers = mock(CompareTwoNumbers.class);
        when(compareTwoNumbers.countAB("1234", "1234")).thenReturn("4A0B");

        GuessNumber guessNumber = new GuessNumber(compareTwoNumbers, randomNumberGenerator);

        assertThat(guessNumber.guess("1234")).isEqualTo("4A0B");
    }


    /**
     * Real integrate test
     */
    @Test
    public void integrate_test_RandomNumberGenerate_and_CompareTwoNumbers_should_work() {
        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4);

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(random);
        CompareTwoNumbers compareTwoNumbers = new CompareTwoNumbers();

        GuessNumber guessNumber = new GuessNumber(compareTwoNumbers, randomNumberGenerator);
        assertThat(guessNumber.guess("1234")).isEqualTo("4A0B");
    }
}
