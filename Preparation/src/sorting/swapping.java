package sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class swapping {
     
static int count=0;
public static void main(String[] args)
{
int a[] = {6,1,3,5,4,7};
String s2 = "aaaaaaaaaaaaaaabbbbbbbbbbbbbbbb";
String s1="bbbbbbbbbbbbbbbbaaaaaaaaaaaaaaa";

count=0; // counter to count the number of words formed
System.out.println(findMinimumStringMovement(s1,s2));
}

public static int findMinimumStringMovement(String a, String b) {
    int moves = 0;
    char[] aChar = a.toCharArray();
    char[] bChar = b.toCharArray();
    char cChar;

    if (aChar != bChar) {
        for (int i = 0; i < aChar.length; i++) {
            for (int j = i + 1; j < aChar.length; j++) {
                if (aChar[i] != bChar[i]) {
                    /*
                     * It checks if some character from the array of aChar
                     * is same as other character from the array of B and if
                     * it's j less then the length of the array. If it's
                     * true, then swap the characters and count moves
                     */
                    if (aChar[j] == bChar[i] && j < aChar.length) {
                        for (int k = j; k > i; k--) {
                            cChar = aChar[k];
                            aChar[k] = aChar[k - 1];
                            aChar[k - 1] = cChar;
                            moves++;
                        }
                       
                    } else if (aChar[aChar.length - 1] == bChar[i]) {
                        if (i == 0) {
                            cChar = aChar[aChar.length - 1];
                            aChar[aChar.length - 1] = aChar[i];
                            aChar[i] = cChar;
                            moves++;
                        } else if (i < (aChar.length - 1) / 2) {
                            for (int k = i; k > 0; k--) {
                                cChar = aChar[k];
                                aChar[k] = aChar[k - 1];
                                aChar[k - 1] = cChar;
                                moves++;
                            }
                            cChar = aChar[i];
                            aChar[i] = aChar[aChar.length - 1];
                            aChar[aChar.length - 1] = cChar;
                        }
                    } else if (bChar[bChar.length - 1] == aChar[i]) {
                        if (i == 0) {
                            cChar = bChar[bChar.length - 1];
                            bChar[bChar.length - 1] = bChar[i];
                            bChar[i] = cChar;
                            moves++;
                        } else if (i < (aChar.length - 1) / 2) {
                            for (int k = i; k > 0; k--) {
                                cChar = aChar[k];
                                aChar[k] = aChar[k - 1];
                                aChar[k - 1] = cChar;
                                moves++;
                            }
                            cChar = aChar[i];
                            aChar[i] = aChar[aChar.length - 1];
                            aChar[aChar.length - 1] = cChar;
                            moves++;
                        }
                       
                    } else {
                        if (aChar[j] != aChar[i] && j < aChar.length) {
                            if (aChar[j] == bChar[j]) {
                                cChar = bChar[j];
                                bChar[j] = bChar[i];
                                bChar[i] = cChar;
                                moves++;
                            }
                            cChar = aChar[j];
                            aChar[j] = aChar[i];
                            aChar[i] = cChar;
                            moves++;
                        } else if (bChar[j] != bChar[i] && j < aChar.length) {
                            if (aChar[j] == bChar[j]
                                    && aChar[j] != aChar[i]) {
                                cChar = aChar[j];
                                aChar[j] = aChar[i];
                                aChar[i] = cChar;
                                moves++;
                            }
                            cChar = bChar[j];
                            bChar[j] = bChar[i];
                            bChar[i] = cChar;
                            moves++;
                        }
                    }
                    /*
                     * At the end, if arrays are equal, then it is done.
                     */
                    if (aChar == bChar) {
                        break;
                    }
                }
            }
        }
    }
    return moves;
}
}
 