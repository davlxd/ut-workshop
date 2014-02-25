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
    private GuessNumber guessNumber;

    @Before
    public void setup() {
    }

    @Test
    public void mock_both_RandomNumberGenerate_and_CompareTwoNumbers_should_work() {
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generate()).thenReturn("1234");

        CompareTwoNumbers compareTwoNumbers = mock(CompareTwoNumbers.class);
        when(compareTwoNumbers.countAB("1234", "1234")).thenReturn("4A0B");

        guessNumber = new GuessNumber(compareTwoNumbers, randomNumberGenerator);

        assertThat(guessNumber.guess("1234")).isEqualTo("4A0B");

    }

    @Test
    public void mock_only_RandomNumberGenerate_should_work() {
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generate()).thenReturn("1234").thenReturn("2345");

        CompareTwoNumbers compareTwoNumbers = new CompareTwoNumbers();

        guessNumber = new GuessNumber(compareTwoNumbers, randomNumberGenerator);

        assertThat(guessNumber.guess("1234")).isEqualTo("4A0B");
        assertThat(guessNumber.guess("1234")).isEqualTo("0A3B");
    }
}
