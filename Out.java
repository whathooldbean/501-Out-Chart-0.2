import java.util.HashMap;
import java.util.Map;

public class Out {
    int firstMultiplier, middleMultiplier, lastMultiplier, firstThrow, middleThrow, lastThrow;
    
    
    public Out() {
        
    }

    public Out(int firstM, int middleM, int lastM, int firstT, int middleT, int lastT) {
        firstMultiplier = firstM;
        middleMultiplier = middleM;
        lastMultiplier = lastM;
        firstThrow = firstT;
        middleThrow = middleT;
        lastThrow = lastT;
    }
    
    public void printOut() {
        Map<Integer, String> DTMap = new HashMap<Integer, String>();
        
        DTMap.put(1, " " );
        DTMap.put(2, "D");
        DTMap.put(3, "T");
        
        final int FIRST_END = 3, MIDDLE_END = 7, LAST_END = 11;
        StringBuilder s = new StringBuilder("           ");
        String firstThrowS = "", middleThrowS = "", lastThrowS = "";

        if (firstMultiplier != 0){ //Don't print anything if there is nothing
            if (firstThrow != 25) { // (Print B for 25
                firstThrowS = (DTMap.get(firstMultiplier) + firstThrow);
            }
            else {
                firstThrowS = (DTMap.get(firstMultiplier) + "B");
            }

        }
        if (middleMultiplier != 0) {
            if (middleThrow != 25) { // (Print bull for 25
                middleThrowS = (DTMap.get(middleMultiplier) + middleThrow);
            }
            else {
                middleThrowS = (DTMap.get(middleMultiplier) + "B");
            }
        }
        if (lastThrow != 25)
            lastThrowS = ("D" + lastThrow);
        else
            lastThrowS = ("D" + "B");

        s.replace(FIRST_END - firstThrowS.length(), FIRST_END, firstThrowS);
        s.replace(MIDDLE_END - middleThrowS.length(), MIDDLE_END, middleThrowS);
        s.replace(LAST_END - lastThrowS.length(), LAST_END, lastThrowS);
        
        System.out.println(s);
    }
    
    public void printOut3() {
        
    }
    
    
}
