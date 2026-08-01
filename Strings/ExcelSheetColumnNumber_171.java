package Strings;

public class ExcelSheetColumnNumber_171 {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char currentChar = columnTitle.charAt(i);
            int currentValue = currentChar - 'A' + 1; // Convert character to its corresponding value
            result = result * 26 + currentValue; // Update the result
        }
        return result;
    }
}
