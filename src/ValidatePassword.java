import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ValidatePassword {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("Please input a password: ");
        }
        String password = args[0];
        if (password.length() < 8 || password.length() > 16) {
            System.out.println("Password must contain 8 to 16 characters!");
            System.exit(0);
        } else {
            Set<Character> upperCaseAlphabet = new HashSet<>();
            for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
                upperCaseAlphabet.add((char) i);
            }
            Set<Character> lowerCaseAlphabet = new HashSet<>();
            for (int i = (int) 'a'; i <= (int) 'z'; i++) {
                lowerCaseAlphabet.add((char) i);
            }
            Set<Character> numSet = new HashSet<>();
            for (int i = (int) '0'; i <= (int) 'z'; i++) {
                numSet.add((char) i);
            }
            Set<Character> specialSymbolSet = new HashSet<>();
            String specialSymbols = "~!@#$%^&*()-=+_";
            for (char c : specialSymbols.toCharArray()) {
                specialSymbolSet.add(c);
            }
            Map<String, Integer> characterCount = new TreeMap<>();
            String key;
            for (char c : password.toCharArray()) {
                if (upperCaseAlphabet.contains(c)) {
                    key = "upperLetter";
                    if (characterCount.containsKey(key)) {
                        characterCount.put(key, characterCount.get(key) + 1);
                    } else {
                        characterCount.put(key, 1);
                    }
                } else if (lowerCaseAlphabet.contains(c)) {
                    key = "lowerLetter";
                    if (characterCount.containsKey(key)) {
                        characterCount.put(key, characterCount.get(key) + 1);
                    } else {
                        characterCount.put(key, 1);
                    }
                } else if (numSet.contains(c)) {
                    key = "number";
                    if (characterCount.containsKey(key)) {
                        characterCount.put(key, characterCount.get(key) + 1);
                    } else {
                        characterCount.put(key, 1);
                    }
                } else if (specialSymbolSet.contains(c)) {
                    key = "specialSymbol";
                    if (characterCount.containsKey(key)) {
                        characterCount.put(key, characterCount.get(key) + 1);
                    } else {
                        characterCount.put(key, 1);
                    }
                } else {
                    System.out.println("Your password contains \"" + c + "\", which is not allowed.");
                    System.exit(0);
                }
            }
            if (characterCount.size() >= 3) {
                System.out.println("Good job! Your password is valid!");
            } else {
                System.out.println("Your password is not valid, please try again.");
            }
        }
    }
}