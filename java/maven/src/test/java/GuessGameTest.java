import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.mockito.Mockito.verify;

/**
 * Created by lxd on 2/3/14.
 */
public class GuessGameTest {
    private InputStream inputStream;
    private OutputStream outputStream;

    private GuessGame guessGame;

    @Before
    private void setup() {
        guessGame = new GuessGame(inputStream, outputStream);
    }

    @Test
    public void when_game_start_print_welcome_message() throws IOException{
        guessGame.gameStart();
        verify(outputStream).write("Welcome!\n".getBytes());
    }

}
