import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by lxd on 3/3/14.
 */
public class GameStepTest {
    private GameStep gameStep;
    private GuessNumber guessNumber;
    private ReadUserInput readUserInput;

    @Before
    public void setup() {
        guessNumber = mock(GuessNumber.class);
        readUserInput = mock(ReadUserInput.class);

        gameStep = new GameStep(guessNumber, readUserInput);
    }

    @Test
    public void if_guess_and_user_input_matches_return_4A0B() throws IOException {
        when(guessNumber.guess("1234")).thenReturn("4A0B");
        when(readUserInput.readLine()).thenReturn("1234");

        String ret = gameStep.step();
        assertThat(ret).isEqualTo("4A0B");
    }

    @Test
    public void will_return_empty_if_user_input_invalid() throws IOException {
        when(readUserInput.readLine()).thenReturn("12324");

        String ret = gameStep.step();
        assertThat(ret).isEmpty();
    }

    @Test
    public void will_return_empty_if_user_input_not_all_invalid() throws IOException {
        when(readUserInput.readLine()).thenReturn("12id");

        String ret = gameStep.step();
        assertThat(ret).isEmpty();
    }

    @Test
    public void will_return_empty_if_user_input_duplicate_digit() throws IOException {
        when(readUserInput.readLine()).thenReturn("1223");

        String ret = gameStep.step();
        assertThat(ret).isEmpty();
    }


}
