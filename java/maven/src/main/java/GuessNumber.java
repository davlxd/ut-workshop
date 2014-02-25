/**
 * Created by xdli on 2/25/14.
 */
public class GuessNumber {
    private CompareTwoNumbers compareTwoNumbers;
    private RandomNumberGenerator randomNumberGenerator;

    public GuessNumber() {
    }

    public String guess(String guess) {
        String challenge = randomNumberGenerator.generate();
        return compareTwoNumbers.countAB(challenge, guess);
    }


    public void setCompareTwoNumbers(CompareTwoNumbers compareTwoNumbers) {
        this.compareTwoNumbers = compareTwoNumbers;
    }

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }
}
