import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.mockito.Mockito.*;

/**
 * Created by lxd on 2/3/14.
 */
public class GuessGameTest {
    private InputStream inputStream;
    private OutputStream outputStream;

    private GuessGame guessGame;

    @Before
    public void setup() {
        inputStream = mock(InputStream.class);
        outputStream = mock(OutputStream.class);
        guessGame = new GuessGame(inputStream, outputStream);
    }

    @Test
    public void when_game_start_print_welcome_message() throws IOException{
        guessGame.gameStart();
        verify(outputStream).write("Welcome!\n".getBytes());
    }

    @Test
    public void game_is_a_six_time_loop() throws IOException {
        guessGame.gameStart();
        verify(outputStream).write("Please input your guess(6):".getBytes());
        verify(outputStream).write("Please input your guess(1):".getBytes());
        verify(outputStream, never()).write("Please input your guess(0):".getBytes());
    }

}
