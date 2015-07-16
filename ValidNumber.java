/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * 
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 *
 */

public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        if (s.startsWith("e") || s.startsWith("E") || s.endsWith("e") || s.endsWith("E")) return false;
        
        String[] strings = s.split("e|E");
        if (strings.length > 2) return false;
        if (strings.length == 2) return isNumberWithoutE(strings[0]) && isInteger(strings[1]);
        return isNumberWithoutE(strings[0]);
    }
    
    public boolean isIntegerWithoutSign(String s) {
        if (s == null || s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }
        return true;
    }
    
    public boolean isIntegerWithSign(String s) {
        if (s == null || s.length() <= 1) return false;
        if (s.charAt(0) != '+' && s.charAt(0) != '-') return false;
        return isIntegerWithoutSign(s.substring(1));
    }
    
    public boolean isInteger(String s) {
        return isIntegerWithoutSign(s) || isIntegerWithSign(s);
    }
    
    public boolean isFloatWithoutSign(String s) {
        if (s == null || s.length() <= 1) return false;
        if (s.startsWith(".")) return isIntegerWithoutSign(s.substring(1));
        if (s.endsWith(".")) return isIntegerWithoutSign(s.substring(0, s.length()-1));
        String[] strings = s.split("\\.");
        if (strings.length != 2) return false;
        return isIntegerWithoutSign(strings[0]) && isIntegerWithoutSign(strings[1]);
    }
    
    public boolean isFloatWithSign(String s) {
        if (s == null || s.length() <= 1) return false;
        if (s.charAt(0) != '+' && s.charAt(0) != '-') return false;
        return isFloatWithoutSign(s.substring(1));
    }
    
    public boolean isFloat(String s) {
        return isFloatWithoutSign(s) || isFloatWithSign(s);
    }
    
    public boolean isNumberWithoutE(String s) {
        return isInteger(s) || isFloat(s);
    }
    
}