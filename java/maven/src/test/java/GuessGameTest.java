import org.junit.Before;
import org.junit.Test;

import javax.management.monitor.GaugeMonitor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import static org.mockito.Mockito.*;

/**
 * Created by lxd on 2/3/14.
 */
public class GuessGameTest {
    private InputStream inputStream;
    private OutputStream outputStream;

    private GameStep gameStep;

    private GuessGame guessGame;

    @Before
    public void setup() {
        inputStream = mock(InputStream.class);
        outputStream = mock(OutputStream.class);
        gameStep = mock(GameStep.class);
        guessGame = new GuessGame(inputStream, outputStream, gameStep);
    }

    @Test
    public void when_game_start_print_welcome_message() throws IOException{
        guessGame.gameStart();
        verify(outputStream).write("Welcome!\n".getBytes());
    }

    @Test
    public void game_is_a_six_time_loop() throws IOException {
        when(gameStep.step()).thenReturn("0A0B");
        guessGame.gameStart();

        verify(outputStream).write("Please input your guess(6):".getBytes());
        verify(outputStream).write("Please input your guess(1):".getBytes());
        verify(outputStream, never()).write("Please input your guess(0):".getBytes());
    }

    @Test
    public void game_will_terminal_if_user_guess_matches() throws IOException {
        when(gameStep.step()).thenReturn("0A0B").thenReturn("4A0B");
        guessGame.gameStart();

        verify(outputStream).write("Please input your guess(6):".getBytes());
        verify(outputStream).write("Please input your guess(5):".getBytes());
        verify(outputStream, never()).write("Please input your guess(4):".getBytes());
    }
    @Test
    public void user_guess_matches_at_sixth_time() throws IOException {
        when(gameStep.step())
                .thenReturn("0A0B")
                .thenReturn("0A0B")
                .thenReturn("0A0B")
                .thenReturn("0A0B")
                .thenReturn("0A0B")
                .thenReturn("4A0B");
        guessGame.gameStart();

        verify(outputStream).write("Please input your guess(6):".getBytes());
        verify(outputStream).write("Please input your guess(5):".getBytes());
        verify(outputStream).write("Please input your guess(1):".getBytes());
        verify(outputStream).write("Congratulations!\n".getBytes());
        verify(outputStream, never()).write("Please input your guess(0):".getBytes());
    }

    @Test
    public void prompt_if_user_input_invalid() throws IOException {
        when(gameStep.step()).thenReturn("0A0B").thenReturn("");
        guessGame.gameStart();

        verify(outputStream).write("Please input your guess(6):".getBytes());
        verify(outputStream).write("Please input your guess(5):".getBytes());
        verify(outputStream, atLeastOnce()).write("User Input invalid!\n".getBytes());
    }

    @Test
    public void integrate_test() throws IOException {
        inputStream = mock(InputStream.class);
        outputStream = mock(OutputStream.class);

        CompareTwoNumbers compareTwoNumbers = new CompareTwoNumbers();
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generate()).thenReturn("1234");
        GuessNumber guessNumber = new GuessNumber(compareTwoNumbers, randomNumberGenerator);

        ReadUserInput readUserInput = mock(ReadUserInput.class);
        gameStep = new GameStep(guessNumber, readUserInput);

        guessGame = new GuessGame(inputStream, outputStream, gameStep);

        when(readUserInput.readLine()).thenReturn("4321").thenReturn("").thenReturn("1234");

        guessGame.gameStart();

        verify(outputStream).write("Welcome!\n".getBytes());
        verify(randomNumberGenerator).generate();

        verify(outputStream).write("Please input your guess(6):".getBytes());
        verify(outputStream).write("0A4B\n".getBytes());
        verify(outputStream).write("Please input your guess(5):".getBytes());
        verify(outputStream).write("User Input invalid!\n".getBytes());
        verify(outputStream).write("Please input your guess(4):".getBytes());
        verify(outputStream).write("Congratulations!\n".getBytes());
        verify(outputStream, never()).write("Please input your guess(3):".getBytes());



    }



}
