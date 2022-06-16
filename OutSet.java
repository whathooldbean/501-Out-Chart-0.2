import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* 
 * Essentially this class creates a Set of Outs. It contains no duplicates.  (This is only a problem when there are only 1 or 2 throws.)
 * 
 * Example:  (0 16)  T16  D16  will work just as well as (0 8) T16 D16.
 * 
 * */
 

public class OutSet {
    
    List<Out> outList = new LinkedList<Out>();  //This will eventually be a Set, i.e. contains no duplicates

    public OutSet() {
        
    }
    
    public void add(Out input) {
        
        Iterator<Out> iter = outList.iterator();
        
        if (outList.isEmpty()){
            outList.add(input);
        }
        
        else {
            int n = 0;
            int l = outList.size();
            
            while (iter.hasNext()) {
                Out curr = iter.next();            
                
                if (!((curr.firstMultiplier == input.firstMultiplier) && (curr.middleMultiplier == input.middleMultiplier) && 
                        (curr.lastMultiplier == input.lastMultiplier) && (curr.firstThrow == input.firstThrow) &&
                        (curr.middleThrow == input.middleThrow) && (curr.lastThrow == input.lastThrow))) {
                    n += 1;    
                }
            }
            if (n == l) { //got through whole list, i.e. this input is not in list
                outList.add(input);
            }
        }
        
    }
    
    public void printOutSet() {
          Iterator<Out> iter = outList.iterator();
          
          while (iter.hasNext()) {
              iter.next().printOut();
          }
    }
    
}
