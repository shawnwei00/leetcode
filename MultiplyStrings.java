/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 *
 */

public class MultiplyStrings {
	
    public String multiply(String num1, String num2) {
        int[] n1 = toArray(num1);
        int[] n2 = toArray(num2);
        int[] result = multiply(n1, n2);
        return toString(result);
    }
    
    public int[] toArray(String str) {
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i) - '0';
        }
        return result;
    }
    
    public String toString(int[] array) {
        StringBuffer sb = new StringBuffer();
        boolean startZero = true;
        for (int i = 0; i < array.length; i++) {
            if (startZero && array[i] == 0) continue;
            if (startZero && array[i] > 0) {
                startZero = false;
            }
            sb.append(array[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    public int[] multiply(int[] num1, int[] num2) {
        int[] result = new int[num1.length + num2.length];
        for (int i = num1.length - 1; i >= 0; i--) {
            for (int j = num2.length - 1; j >= 0; j--) {
                int position = i + j + 1;
                int n = num1[i] * num2[j] + result[position];
                int carrier = n / 10;
                n = n % 10;
                
                while (carrier > 0) {
                    result[position] = n;
                    position--;
                    n = carrier + result[position];
                    carrier = n / 10;
                    n = n % 10;
                }
                
                result[position] = n;
            }
        }
        return result;
    }
}