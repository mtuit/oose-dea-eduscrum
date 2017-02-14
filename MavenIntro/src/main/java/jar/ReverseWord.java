package jar;

public class ReverseWord {
    /**
     * 
     * @param word
     * @return The reversed String
     * @throws InvalidInputException
     */

    public static String reverseWord(String word) throws InvalidInputException {
        if (word == null) {
            throw new InvalidInputException();
        }
        int length = word.length();
        String resultString = "";
        for (int i = length - 1; i >= 0; i--) {
            resultString += word.charAt(i);
        }
        return resultString;
    }
}
