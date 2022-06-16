import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class OutChart {
    
    private static int[] dartBoardAreas = new int[21];
    private static Map<Integer, String> DTMap = new HashMap<Integer, String>();
    
    private static void initializeDartBoardAreas() {
        
        dartBoardAreas[0] = 16;
        dartBoardAreas[1] = 8;
        dartBoardAreas[2] = 4;
        dartBoardAreas[3] = 2;
        dartBoardAreas[4] = 1;
        dartBoardAreas[5] = 18;
        dartBoardAreas[6] = 15;
        dartBoardAreas[7] = 12;
        dartBoardAreas[8] = 9;
        dartBoardAreas[9] = 6;
        dartBoardAreas[10] = 3;
        dartBoardAreas[11] = 20;
        dartBoardAreas[12] = 10;
        dartBoardAreas[13] = 5;
        dartBoardAreas[14] = 14;
        dartBoardAreas[15] = 7;
        dartBoardAreas[16] = 19;
        dartBoardAreas[17] = 17;
        dartBoardAreas[18] = 13;
        dartBoardAreas[19] = 11;
        dartBoardAreas[20] = 25;   
    }
    
    private static void initializeDTMap() {
        DTMap.put(1, "");
        DTMap.put(2, "D");
        DTMap.put(3, "T");
    }

    
    private static void printOpening() {
        System.out.println("Welcome to \n"
                + "    __________ ___   ____        __     ________               __  __\n"
                + "   / ____/ __ <  /  / __ \\__  __/ /_   / ____/ /_  ____ ______/ /_/ /\n"
                + "  /___ \\/ / / / /  / / / / / / / __/  / /   / __ \\/ __ `/ ___/ __/ / \n"
                + " ____/ / /_/ / /  / /_/ / /_/ / /_   / /___/ / / / /_/ / /  / /_/_/  \n"
                + "/_____/\\____/_/   \\____/\\__,_/\\__/   \\____/_/ /_/\\__,_/_/   \\__(_) v. 0.2  \n"
                + "                                                                    "
                + ""
                + "\n"
                + "While there are plenty of 501/301 Out Charts out there these days, two things seemed to be lacking to me:\n"
                + "1. They always give the “most efficient” way to go out.  However, often there are equally efficient ways \n"
                + "   to go out. This program shows every possible way to go out.\n"
                + "2. This may be a personal preference of mine, but I always like to go out on a 2^n. This way, if I miss \n"
                + "   the double and hit the single, I can always use my next turn to go out on 2^(n-1).  This program \n"
                + "   prioritizes its results to put these at the top of the list if there are any.\n"
                + "\n"
                + "New in this version:\n"
                + "• The entire structure is different: \n"
                + "    - Now, instead of storing everything as a String, they are stored as Out objects in what I've called an OutSet. \n"
                + "      The reason for this is that, in a future update, there will be a search feature using Expressions, \n"
                + "      Expression Trees, etc. to be able to search the outputs.\n"
                + "      Example Expressions: "
                + "      \"lastThrow = D16 & numberOfThrows = 2\" \n"
                + "      \"numberOfThrows <= 2 & middleMultiplier != 3 & middleMultiplier !=2\" (i.e. all outputs that are at most one single throw before the double out). \n"
                + "      \"!(firstMultiplier = 1 | middleMultiplier = 1)."
                + ""
                + "Coming soon:\n"
                + "• The aforementioned Expression Tree Search Filter."
                + "• A GUI.\n"
                + "• A Scorer Program that will all you to enter in the enter in your turn’s score and in return the program\n"
                + "  will keep both players’ scores and list the possible outs below each player."
                + "\n"
                + "\n"
                + "\n"
                + "Copyright 2022 whathooldbean. Free to use and edit.  If you do edit this, please get in touch with me and \n"
                + "please also credit yourself where you have done this. \n"
                + "Credit for Title Font: <http://patorjk.com/software/taag/>"
                + "\n\n");
        
    }
    
    private static void printPossibleOuts(int targetScore) {
        
        OutSet output = new OutSet();
        
        int n = targetScore;
        int lastThrow;
        int middleThrow;
        int firstThrow;
        int lastMultiplier;
        int middleMultiplier;
        int firstMultiplier;
        
        for (int i = 0; i <= 20; i++) {  //Last Throw
            lastThrow = dartBoardAreas[i];
            lastMultiplier = 2;
            
            for (int j = 0; j <= 20; j++) { //First Throw (see below)
                firstThrow = dartBoardAreas[j];
                for (firstMultiplier = 0; firstMultiplier <= 3; firstMultiplier++) {
                  
                    for (int k = 0; k <= 20; k++) {  //Middle Throw (for spacing reasons, we want middle throw to be preferred)
                        middleThrow = dartBoardAreas[k];
                        for (middleMultiplier = 0; middleMultiplier <= 3; middleMultiplier++) {
                            
                            int difference = (n - (lastThrow * lastMultiplier) - (middleThrow * middleMultiplier) - (firstThrow * firstMultiplier));
                            
                            if (difference == 0 && !(middleMultiplier == 0 && firstMultiplier != 0)) { // This is an out!
                                /* Also: the second part of this prevents repeats when the firstThrow and MiddleThrow are the same:
                                  e.g. "T1  __  D1   and  "__  T1 D1".  This ensures they both do not go into
                                  the Set, with a preference for MiddleThrow to be shown (this is more
                                  æsthetic to the eye, and clearer as to how many throws there are). */
                                
                                if (!(middleThrow == 25 && middleMultiplier == 3) && !(firstThrow == 25 && firstMultiplier == 3)) { //Can't have Triple Bullseye
                                    if (firstMultiplier == 0)
                                        firstThrow = 16;
                                    if (middleMultiplier == 0)
                                        middleThrow = 16;
                                    Out currentOut = new Out(firstMultiplier, middleMultiplier, lastMultiplier, firstThrow, middleThrow, lastThrow);
                                    
                                    output.add(currentOut);
                                    
                                }   
                            }
                        }
                    }
                }
            }
        }
        output.printOutSet();
    }

    public static void main(String[] args) {
        initializeDartBoardAreas();
        initializeDTMap();
        
        printOpening();
        
        System.out.println("Please type in the target score: ");
        
        Scanner scnr = new Scanner(System.in);
        
        int score = scnr.nextInt();
        
        while (score < 2) {
            System.out.println("Error: Score must be above 1. Please enter in a valid Score");
            score = scnr.nextInt();
        }
        
        printPossibleOuts(score);
        

    }








}