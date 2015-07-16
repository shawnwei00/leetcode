import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly 
 * L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in 
 * each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of 
 * spaces on a line do not divide evenly between words, the empty slots on the left will be 
 * assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example,
 * 
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * 
 * [
 * 	"This    is    an",
 * 	"example  of text",
 * 	"justification.  "
 * ]
 *
 */

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int totalLength = 0;
        List<String> result = new ArrayList<String>();
        int leftIndex = 0;
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == words.length - 1) {
                if ((totalLength + word.length()) > maxWidth) {
                    result.add(evenDistribute(Arrays.copyOfRange(words, leftIndex, i), maxWidth));
                    result.add(lastLine(Arrays.copyOfRange(words, i, i+1), maxWidth));
                } else {
                    result.add(lastLine(Arrays.copyOfRange(words, leftIndex, i+1), maxWidth));
                }
            } else {
                if ((totalLength + word.length()) > maxWidth) {
                    result.add(evenDistribute(Arrays.copyOfRange(words, leftIndex, i), maxWidth));
                    leftIndex = i;
                    totalLength = 0;
                    i--;
                } else {
                    totalLength += (word.length() + 1);
                }
            }
        }
        
        return result;
    }
    
    public String evenDistribute(String[] words, int maxWidth) {
        StringBuffer sb = new StringBuffer();
        
        if (words.length == 1) {
            sb.append(words[0]);
            sb.append(getSpaces(maxWidth - words[0].length()));
            return sb.toString();
        }
        
        int totalLength = 0;
        for (int i = 0; i < words.length; i++) {
            totalLength += words[i].length();
        }
        
        int totalSpace = maxWidth - totalLength;
        int spaceCount = totalSpace / (words.length - 1);
        int extra = totalSpace % (words.length - 1);
        
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            sb.append(getSpaces(spaceCount));
            if (i < extra) {
                sb.append(" ");
            }
        }
        
        return sb.toString().trim();
    }
    
    public String lastLine(String[] words, int maxWidth) {
        StringBuffer sb = new StringBuffer();
        
        if (words.length == 1) {
            sb.append(words[0]);
            sb.append(getSpaces(maxWidth - words[0].length()));
            return sb.toString();
        }
        
        int totalLength = 0;
        for (int i = 0; i < words.length; i++) {
            totalLength += words[i].length();
        }
        
        int extra = maxWidth - totalLength - (words.length - 1);
        
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                sb.append(words[i]);
            } else {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        
        sb.append(getSpaces(extra));
        return sb.toString();
    }
    
    private String getSpaces(int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}