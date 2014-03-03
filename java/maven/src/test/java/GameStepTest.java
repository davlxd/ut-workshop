import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void if_guess_and_user_input_matches_return_4A0B() {
        guessNumber = mock(GuessNumber.class);
        readUserInput = mock(ReadUserInput.class);

        gameStep = new GameStep(guessNumber, readUserInput);

        when(guessNumber.guess("1234")).thenReturn("4A0B");
        when(readUserInput.readLine()).thenReturn("1234");

        String ret = gameStep.step();
        assertThat(ret).isEqualTo("4A0B");
    }


}
