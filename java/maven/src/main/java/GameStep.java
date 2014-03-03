/**
 * Created by lxd on 2/3/14.
 */
public class GameStep {
    private GuessNumber guessNumber;
    private ReadUserInput readUserInput;

    public GameStep(GuessNumber guessNumber, ReadUserInput readUserInput) {
        this.guessNumber = guessNumber;
        this.readUserInput = readUserInput;
    }

    public String step() {
        String userInput = readUserInput.readLine();
        return guessNumber.guess(userInput);
    }
}
