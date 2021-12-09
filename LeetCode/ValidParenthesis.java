
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.equals("()") || s.equals("{}") ||s.equals("[]")) {
            return true;
        }
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        stack.push(arr[0]);
        for (int i = 1; i < s.length(); i++) {
            if ("({[".indexOf(arr[i]+"") != -1) {
                stack.push(arr[i]);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (arr[i] == ')' && stack.peek() != '(') {
                return false;
            }
            if (arr[i] == '}' && stack.peek() != '{') {
                return false;
            }
            if (arr[i] == ']' && stack.peek() != '[') {
                return false;
            }
            stack.pop();
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
