/**
 * Created by lxd on 23/2/14.
 */
public class XAXB2 {
    public String count(String challenge, String guess) {
        int count = 0;
        for (int i = 0; i < challenge.length(); i++) {
            if (challenge.charAt(i) == guess.charAt(i)) {
                count += 1;
            }
        }
        return count + "A" + "0B";
    }
}
