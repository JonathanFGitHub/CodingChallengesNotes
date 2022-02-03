import java.util.Stack;

public class ValidParenth {
//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    An input string is valid if:


//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.

    public static void main(String[] args) {
        ValidParenth vp = new ValidParenth();

        String testString = "[{()}]";
        //

        System.out.println(vp.validParen(testString));
    }

    private boolean validParen(String s) {
        Stack<Character> stack = new Stack<Character>();

        if(s.length() %2 == 1 || s.equals("")) {
            return false;
        }

        for( char character : s.toCharArray()) {
            if(character == '{' || character == '(' || character == '[' ) {
                stack.push(character);
            }

            if(character == '}' && stack.peek() == '{' ||
                    character == ')' && stack.peek() == '(' ||
                    character == ']' && stack.peek() == '[') {
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}
