import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class AB {
    public static void main(String[] a) {
        int[][] t = { { 3, 2 }, { 2, 0 }, { 5, 8 }, { 10, 12 }, { 2, 1 }, { 3, 0 }, { 3, 1 }, { 3, 3 }, { 4, 3 },
                { 5, 6 }, { 6, 0 }, { 7, 16 }, { 8, 7 }, { 9, 1 }, { 10, 12 }, { 11, 16 }, { 12, 8 }, { 13, 29 },
                { 14, 67 }, { 15, 21 }, { 16, 97 }, { 17, 14 }, { 18, 20 }, { 19, 46 }, { 20, 20 }, { 21, 80 },
                { 22, 69 }, { 23, 36 }, { 24, 102 }, { 25, 242 }, { 26, 122 }, { 27, 85 }, { 28, 20 }, { 29, 22 },
                { 30, 273 }, { 31, 146 }, { 32, 213 }, { 33, 155 }, { 34, 458 }, { 35, 481 }, { 36, 452 }, { 37, 288 },
                { 38, 332 }, { 39, 58 }, { 40, 240 }, { 41, 218 }, { 42, 186 }, { 43, 207 }, { 44, 266 }, { 45, 169 },
                { 46, 377 }, { 47, 774 }, { 48, 359 }, { 49, 97 }, { 50, 590 }, { 49, 600 }, { 49, 601 }, { 50, 625 },
                { 50, 626 }, { 50, 1225 }, { 7, 11 }, { 9, 17 }, { 50, 401 }, { 35, 219 }, { 50, 117 }, { 12, 13 },
                { 5, 5 }, { 6, 7 }, { 8, 11 }, { 50, 599 }, { 50, 623 }, { 50, 67 }, { 10, 0 }, { 5, 7 }, { 10, 1 },
                { 49, 599 }, { 10, 11 }, { 10, 13 }, { 7, 7 }, { 50, 1220 }, { 5, 1 }, { 12, 26 }, { 50, 565 },
                { 40, 10 }, { 50, 501 }, { 50, 636 } };
        /*System.out.println(createString(3, 2));
        System.out.println(createString(2, 0));
        System.out.println(createString(5, 8));
        System.out.println(createString(10, 12));
        System.out.println(createString(50, 25*25));
        System.out.println(createString(50, 501));
        for (int i = 0; i < 50; i++) {
            System.out.print(i % 10);
        }*/
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i][0] + " " + t[i][1] + " " + createString(t[i][0], t[i][1]));
        }
    }

    public static String putChar(String str, int idx, char ch) {
        char[] myNameChars = str.toCharArray();
        myNameChars[idx] = ch;
        str = String.valueOf(myNameChars);
        return str;
    }

    public static String createString(int N, int K) {
        //initialize with all 'A'
        String str = String.join("", Collections.nCopies(N, "A"));
        if (K == 0) {
            return str;
        }
        int combi = 0;
        int nB = 0;
        //keep insert 'B' until too many combinations
        for (int i = N - 1 - nB; i > 0; i--) {
            int nA = N - nB;
            if (combi - nB * nA + (nB + 1) * (nA - 1) == K) {
                str = putChar(str, i, 'B');
                return str;
            }else if (combi - nB * nA + (nB + 1) * (nA - 1) < K) {
                str = putChar(str, i, 'B');
                combi = combi - nB * nA + (nB + 1) * (nA - 1);
                nB++;
            } else { // too many combinations
                //the index that another 'B' supposed to go
                int goodIdx = K - combi + nB;
                //if the position is not 'A' 
                if (str.charAt(goodIdx) != 'A') {
                    //not possible
                    return "";
                }
                // or else put a 'B' there and return
                str = putChar(str, goodIdx, 'B');
                return str;
            }
        }
        //put all B in still not enough
        return "";
    }

}