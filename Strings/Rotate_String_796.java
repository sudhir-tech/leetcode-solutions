package Strings;

public class Rotate_String_796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String concatenated = s + s;
        return concatenated.contains(goal);
    }
    
}
