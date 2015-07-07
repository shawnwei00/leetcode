/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows 
 * like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 */

public class ZigZagConversion {
	
    public String convert(String s, int numRows) {
        if (s == null || numRows == 1) return s;
        
        int countPerZig = 2 * numRows - 2;
        int zigCount = s.length() / countPerZig + 1;
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < zigCount; j++) {
                if (i == 0 || i == numRows - 1) {
                    int index = j * countPerZig + i;
                    if (index < s.length()) {
                        sb.append(s.charAt(index));
                    }
                } else {
                    int index1 = j * countPerZig + i;
                    int index2 = j * countPerZig + countPerZig - i;
                    if (index1 < s.length()) {
                        sb.append(s.charAt(index1));
                    }
                    if (index2 < s.length()) {
                        sb.append(s.charAt(index2));
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
}