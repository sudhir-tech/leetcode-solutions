package Strings;

public class ExcelSheetColumnTitle_168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust for 0-based index
            char currentChar = (char) ('A' + (columnNumber % 26));
            title.insert(0, currentChar); // Prepend the character
            columnNumber /= 26; // Move to the next "digit"
        }

        return title.toString();
    }
}
