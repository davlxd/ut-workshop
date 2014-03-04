/**
 * Created by xdli on 2/25/14.
 */
public class GuessNumber {
    private CompareTwoNumbers compareTwoNumbers;
    private String challenge;

    public GuessNumber(CompareTwoNumbers compareTwoNumbers, RandomNumberGenerator randomNumberGenerator) {
        this.compareTwoNumbers = compareTwoNumbers;
        this.challenge = randomNumberGenerator.generate();
    }

    public String guess(String guess) {
        return compareTwoNumbers.countAB(challenge, guess);
    }
}
