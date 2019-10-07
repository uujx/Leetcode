
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                resStack.push(res);
                res = "";
                count = 0;
            } else if (ch == ']') {
                int times = countStack.pop();
                String tmpStr = resStack.pop();
                res = tmpStr + String.join("", Collections.nCopies(times, res));
            } else {
                res += ch;
            }
        }
        
        return res;
    }
}
