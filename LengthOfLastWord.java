public class LengthOfLastWord {

    /*
        Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.

        A word is a maximal substring consisting of non-space characters only.

         Input:
          s = "Hello World"
         Output:
          5

         Input:
          Input: s = "   fly me   to   the moon  "
         Output:
          4

         Input:
          "luffy is still joyboy"
         Output:
          6
    */


    public static void main(String[] args) {
        LengthOfLastWord lotw = new LengthOfLastWord();

        String s1 = "Hello World";
        System.out.println(s1 + ":");
        System.out.println(lotw.lengthOfLastWordBad(s1));
        System.out.println("\n");

        String s2 = "   fly me   to   the moon               ";
        System.out.println(s2 + ":");
        System.out.println(lotw.lengthOfLastWordBad(s2));
        System.out.println("\n");

        String s3 = "luffy is still joyboy";
        System.out.println(s3 + ":");
        System.out.println(lotw.lengthOfLastWordBad(s3));
        System.out.println("\n");
    }

    /*
      STEPS:
      1. Separate string into independent words.
      2. Figure out which word is last.
      3. return last words length.

    * */
    public int lengthOfLastWord(String s) {
        String[] strArr = s.split(" ");
        return strArr[strArr.length - 1].length();
    }

    //(Jon want's to figure out second to last word as well)
    public int lengthOfSecondToLastWord(String s) {
        String[] strArr = s.split(" ");
        if(strArr.length < 2) {
            return -1;
        }
        return strArr[strArr.length - 2].length();
    }

    /*
      STEPS THE BAD WAY:
      1. Parse through string backwards.
      2. When you hit first character start counter.
      3. When you hit next space return counter.
    */

    public int lengthOfLastWordBad(String s) {
        int result = 0;
        String trimStr = s.trim();
        for(int i = trimStr.length() - 1; i >= 0; i--) {
            if(trimStr.charAt(i) == ' ') {
                return result;
            }
            else {
                result++;
            }
        }
        return result;
    }


}
