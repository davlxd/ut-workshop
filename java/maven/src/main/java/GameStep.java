import java.io.IOException;

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

    private boolean user_input_is_valid(String str) {
        if (str.length() != 4) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length() && i != j; j++) {
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }


        return true;
    }

    public String step() throws IOException {
        String userInput = readUserInput.readLine();
        if (!user_input_is_valid(userInput)) {
            return "";
        }
        return guessNumber.guess(userInput);
    }
}
