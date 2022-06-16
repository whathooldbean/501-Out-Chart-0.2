Welcome to 501 Out Chart v. 0.2!
    __________ ___   ____        __     ________               __  __
   / ____/ __ <  /  / __ \__  __/ /_   / ____/ /_  ____ ______/ /_/ /
  /___ \/ / / / /  / / / / / / / __/  / /   / __ \/ __ `/ ___/ __/ / 
 ____/ / /_/ / /  / /_/ / /_/ / /_   / /___/ / / / /_/ / /  / /_/_/  
/_____/\____/_/   \____/\__,_/\__/   \____/_/ /_/\__,_/_/   \__(_) v. 0.2  
                                                                    
While there are plenty of 501/301 Out Charts out there these days, two things seemed to be lacking to me: 
1. They always give the “most efficient” way to go out.  However, often there are equally efficient ways 
   to go out. This program shows every possible way to go out.
2. This may be a personal preference of mine, but I always like to go out on a 2^n. This way, if I miss 
   the double and hit the single, I can always use my next turn to go out on 2^(n-1).  This program 
   prioritizes its results to put these at the top of the list if there are any.

New in this version:
• The entire structure is different: 
    - Now, instead of storing everything as a String, they are stored as Out objects in what I've called an OutSet. 
      The reason for this is that, in a future update, there will be a search feature using Expressions, 
      Expression Trees, etc. to be able to search the outputs.
      Example Expressions:       "lastThrow = D16 & numberOfThrows = 2" 
      "numberOfThrows <= 2 & middleMultiplier != 3 & middleMultiplier !=2" (i.e. all outputs that are at most one single throw before the double out). 
      "!(firstMultiplier = 1 | middleMultiplier = 1).Coming soon:
• The aforementioned Expression Tree Search Filter.• A GUI.
• A Scorer Program that will all you to enter in the enter in your turn’s score and in return the program
  will keep both players’ scores and list the possible outs below each player.


Copyright 2022 whathooldbean. Free to use and edit.  If you do edit this, please get in touch with me and 
please also credit yourself where you have done this. 
Credit for Title Font: <http://patorjk.com/software/taag/>

Files:
1. OutChart.java - run this to use the program.
2. Out.java - an Out object: stores necessary data to keep track of possible Outs.
3. OutSet.java - This Class is a de facto Set that stores one of every possible out (i.e. no duplicates).  Again, in a future update, this will be traversed by a Search algorithm and Expression Tree Factory to find only the outs the user wants.
