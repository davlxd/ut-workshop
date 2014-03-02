import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by lxd on 2/3/14.
 */
public class GuessGame {
    private InputStream inputStream;
    private OutputStream outputStream;
    private GameStep gameStep;

    public GuessGame(InputStream inputStream, OutputStream outputStream, GameStep gameStep) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.gameStep = gameStep;
    }

    public void gameStart() throws IOException{
        outputStream.write("Welcome!\n".getBytes());
        int count = 6;
        while (count > 0) {
            outputStream.write(("Please input your guess(" +count+"):").getBytes());
            if ("4A0B".equals(gameStep.step())) {
                return ;
            }
            count -= 1;
        }
    }
}
