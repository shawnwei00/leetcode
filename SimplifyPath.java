import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * 
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * click to show corner cases.
 * 
 * Corner Cases:
 * 
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * 
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".

 */

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null) return null;
        
        String[] folders = path.split("\\/");
        Stack<String> stack = new Stack<String>();
        
        for (int i = 0; i < folders.length; i++) {
            String folder = folders[i];
            if (folder.equals(".") || folder.equals("")) continue;
            if (stack.isEmpty() && folder.equals("..")) continue;
            if (!stack.isEmpty() && folder.equals("..")) {
                stack.pop();
            } else {
                stack.push(folder);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, "/");
            sb.insert(0, stack.pop());
        }
        
        sb.insert(0, "/");
        
        return sb.toString().substring(0, sb.length() - 1);
    }
}