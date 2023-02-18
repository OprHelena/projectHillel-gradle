package ua.ithillet.lesson3;

public class WorkWithString {

    public int findSymbolOccurrence(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == symbol) {
                count = count + 1;
            }
        }
        return count;
    }

    public int findWordPosition(String source, String target) {
        if (source.contains(target)) {
            return source.indexOf(target, 0);
        }
        return source.indexOf(target);
    }

    public String stringReverse(String strForRevers) {
        char[] charArray = strForRevers.toCharArray();
        String rev = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            rev += charArray[i];
        }
        return rev;
    }

    public boolean isPalindrome(String str) {
        StringBuilder strModify = new StringBuilder(str.replace(" ", ""));
        return strModify.reverse().toString().equalsIgnoreCase(str.replace(" ", ""));
    }

}
