import java.util.HashMap;

public class RomanToInteger {

    /*
        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

        For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
        The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead,
        the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine,
        which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given a roman numeral, convert it to an integer.

        Example 1:
            Input: s = "III"
            Output: 3
            Explanation: III = 3.
        Example 2:
            Input: s = "LVIII"
            Output: 58
            Explanation: L = 50, V= 5, III = 3.

        Example 3:
            Input: s = "MCMXCIV"
            Output: 1994
            Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
    */

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();

        String s1 = "III";
        System.out.println(s1);
        System.out.println(romanToInteger.romanToInt(s1));

        String s2 = "LVIII";
        System.out.println(s2);
        System.out.println(romanToInteger.romanToInt(s2));

        String s3 = "MCMXCIV";
        System.out.println(s3);
        System.out.println(romanToInteger.romanToInt(s3));
    }

    /*
    STEPS:
        1. Create a Map to assign keys=> roman numerals values => their numeric value.
        2. Iterate through string right to left <--
     */

    public int romanToInt(String s) {
        int result = 0;
        int previousValue = -1;

        HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        for (int i = s.length() - 1; i >= 0; i--) {
            int valueOfChar = romanMap.get(s.charAt(i));
            if(valueOfChar >= previousValue) {
                result += valueOfChar; 
            }
            else {
                result -= valueOfChar;
            }
            previousValue = valueOfChar;
        }

        return result;


        //Walk through of what is happening:
        /*
            EX:MCMXCIV
            We start at 'v' 
            valueofChar(5) > previousValue(-1) --> yes
            Result --> 5
            Previous value is now 5
            ------------------------
            Now we are at 'I'
            valueofChar(1) > previousValue(5) --> no, 1 is not greater than 5
            Result --> 5 - 1 =  4. Result is now 4
            Previous value is now 1
            ------------------------
             Now we are at 'C'
            valueofChar(100) > previousValue(1) --> Yes, greater than 1
            Result --> 4 + 100 = 104. Result is now 104
            Previous value is now 100
             ------------------------
             Now we are at 'X'
            valueofChar(10) > previousValue(100) --> No, 10 not greater than 100
            Result --> 104 - 10 --> 94. Result is now 94
            Previous value is now 10
             ------------------------
             Now we are at 'M'
            valueofChar(1000) > previousValue(10) --> Yes, 1000 is greater than 10
            Result --> 94 + 1000 --> 1094. Result is now 1094
            Previous value is now 1000
              ------------------------
             Now we are at 'C'
            valueofChar(100) > previousValue(1000) --> No, 100 is not greater than 1000
            Result --> 1094 - 100 = 994. Result = 994
            Previous value is now 100
            -----------------------------
             Now we are at 'M'
            valueofChar(1000) > previousValue(100) --> Yes, 1000 is greater than 100
            Result --> 994 + 1000 = 1994. Result is 1994
            Previous value is now 1000
            ----------------------------
            For loop is now over and returns result. 1994
        */ 
    }


    //Going through string left to right
    public int romanToIntLeftToRight(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int total = 0;
        
        //EXP:MCMXCIV (7 elements) --> Starts at index 0, and up to index 5. Index 6 is added at the end of for loop. 
        //length() - 1 would grab the index value of 6 which is the 'v'. but because we use a '<' symbol it goes up to index 5
        //Remember the '<' symbol that makes it stop at index 5
        //get(s.charAt(i)) --> 'get' grabs the key and gives the user the value. So it gets the character and returns its value
        for(int i = 0; i < s.length() - 1; i++){
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                total -= romanMap.get(s.charAt(i));
            }
            else{
                total+= romanMap.get(s.charAt(i));
            }
            
        }
        total += romanMap.get(s.charAt(s.length() - 1)); //Getting the value at index 6. That value is 5.
        return total; 
        
    }

    //Walk through
    /*
    EX:MCMXCIV
            We start at 'M' 
            romanMap.get(s.charAt(i)) --> (1000) < romanMap.get(s.charAt(i + 1)) --> (100) | No, 1000 is not less than 100
            Total: 1000 (Add)
            -----------------------------------
             Iterated thorugh and now at 'C' 
             Is C< M --> yes, it is less than M
            romanMap.get(s.charAt(i)) --> (100) < romanMap.get(s.charAt(i + 1)) --> (1000) | Yes, 100 less than 1000 so subtract 
            Total: 1000 - 100 = 900
            -----------------------------------         
             Iterated thorugh and now at 'M' 
             Is M < X --> No
            romanMap.get(s.charAt(i)) --> (1000) < romanMap.get(s.charAt(i + 1)) --> (10) | No, 1000 is not less than 10 so add 
            Total: 900 + 1000 = 1900
            -----------------------------------         
             Iterated thorugh and now at 'X' 
             Is X < C --> Yes
            romanMap.get(s.charAt(i)) --> (10) < romanMap.get(s.charAt(i + 1)) --> (100) | Yes, 10 is less than 100 so subtract 
            Total: 1900 - 10 = 1890
            -----------------------------------         
             Iterated thorugh and now at 'C' 
             Is C < I --> No
            romanMap.get(s.charAt(i)) --> (100) < romanMap.get(s.charAt(i + 1)) --> (1) | No, 100 is not less than 1 so Add 
            Total: 1890 + 100 = 1990
            -----------------------------------         
             Iterated thorugh and now at 'I' 
             Is I < V --> Yes
            romanMap.get(s.charAt(i)) --> (1) < romanMap.get(s.charAt(i + 1)) --> (5) | Yes, 1 is less than 5 so subtract 
            Total: 1990 - 1 = 1989
            ----------------------------------
            Loop ends and we add last character value to total 'v'
            1989 + 5 = 1994
            Return total: 1994

    */


}