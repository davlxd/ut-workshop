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
            outputStream.write(("Please input your guess(" + count + "):").getBytes());
            String stepRet = gameStep.step();
            if ("4A0B".equals(stepRet)) {
                outputStream.write("Congratulations!\n".getBytes());
                return ;
            } else if ("".equals(stepRet)) {
                outputStream.write("User Input invalid!\n".getBytes());
            } else {
                outputStream.write((stepRet+"\n").getBytes());
            }
            count -= 1;
        }
    }
}
