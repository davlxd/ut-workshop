/**
 * Created by xdli on 2/25/14.
 */
public class GuessNumber {
    private CompareTwoNumbers compareTwoNumbers;
    private RandomNumberGenerator randomNumberGenerator;

    public GuessNumber(CompareTwoNumbers compareTwoNumbers, RandomNumberGenerator randomNumberGenerator) {
        this.compareTwoNumbers = compareTwoNumbers;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String guess(String guess) {
        String challenge = randomNumberGenerator.generate();
        return compareTwoNumbers.countAB(challenge, guess);
    }
}
