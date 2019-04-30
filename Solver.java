

import java.util.ArrayList;
import java.awt.Point;

public class Solver
{
    private final char SPACE = '1';
    private final char FILLED = '0';
    ArrayList<Word> words = new ArrayList<Word>();
    char[][] template;
    int [][]letterUsage;
    Space [] slots;
    int numBacktracks;

    public Solver(char [][] template, Space [] slots, ArrayList<Word> words)
    {
  
        this.template = new char[template.length][template.length];
        this.slots = new Space[slots.length];
        this.slots = slots;
        this.template = template;
        this.words = words;
        
    }
   
    

    private void reset() {
        letterUsage = new int[template.length][template.length];
        numBacktracks = 0;     
    }
    
     public void solve() {
        reset();
        
        if (populateBoard(0)) {
            System.out.println("Solution found!");
           System.out.println("Backtracks: " + numBacktracks);
        }
        else {
            System.out.println("No solution found!");
            System.out.println("Backtracks: " + numBacktracks);
        }
    }
    

    private boolean populateBoard ( int slot ) {

        if ( slot == slots.length ) {
            return true;
        }
             
        // Loop through all the words, to find a slot

        for (Word word : words ) {
        

          //Word is added to the crossword board if it is unused and if it fits in the slot
            if (itFits(word, slots[slot]) ) {
                addToSlot(word, slots[slot]);
                //recursively call the method with a new slot to try another word, which would lead to the base case
                // i.e all slots have been filled
                if ( populateBoard(slot + 1) ) {
                    return true;
                }
                
                removeFromSlot(word, slots[slot]);
            }
            
        }
        
        //if all the words have been tried and have led to backtracks ie none fits in this slot
        // return false, as solution was not found
        
        numBacktracks++;
        return false;
    }
    
  
    private boolean itFits ( Word w, Space slot ) {
        
        //Check if the word is unused and its length matches the length of the slot. If it doesn't, return false
            if ( w.getWord().length() != slot.getLength()  ||  w.isUsed()) { 
                 return false;
            }
         
       
        
        
        
        // If the above condition is false, the starting axis of the slot is gotten.
        // If there is a word there and the letters at the corresponding axis do not match, the word cannot go in, so return false

        
        Point axis = new Point(slot.getStart());
    
        for( int i = 0; i < slot.getLength(); i++ ) {
       
            if ( template[axis.x][axis.y] != SPACE &&
               template[axis.x][axis.y]!=w.getWord().charAt(i) ){
                return false;    
            }
            
            //otherwise move to the next position in that slot
            axis.x += slot.getDirection().x;
            axis.y += slot.getDirection().y;
        }
        
       
        
        return true;
    }
    

    private void addToSlot (Word w, Space slot ) {
        Point axis = new Point(slot.getStart());
             
        for ( int i = 0; i < slot.getLength(); i++ ) {         
        
            // Put each letter from the word into this slot of
            // the puzzle:
            
            template[axis.x][axis.y] = w.getWord().charAt(i) ;
            
            // Record the fact that one more word is now using the
            // letter at this axis:
            letterUsage[axis.x][axis.y]++;
            
            // Advance to the next axis in the slot:
            
            axis.x += slot.getDirection().x;
            axis.y += slot.getDirection().y;
        }

        
        w.setUsed(true);
    }
    
   
    private void removeFromSlot ( Word w, Space slot ) {
        Point axis = new Point(slot.getStart());
        
        for ( int i = 0; i < slot.getLength(); i++ ) { 
        
            // One fewer word is now using the letter at this axis:
            
            letterUsage[axis.x][axis.y]--;
                       
            // If no words are now using this letter, clear it:
            
            if ( letterUsage[axis.x][axis.y] == 0 ) {
                template[axis.x][axis.y] = SPACE;
            }
            
            // Advance to the next axis in the slot:
            
            axis.x += slot.getDirection().x;
            axis.y += slot.getDirection().y;
        }
        
        // Mark the word as UNUSED -- ie., available to be placed 
        // elsewhere in the puzzle:
            
        w.setUsed(false);
    }
    
    public void showResult() {
        
        for ( int row = 0; row < template.length; row++ ) {
            System.out.print("   ");
            for ( int col = 0; col < template[row].length; col++ ) {
                System.out.print(template[col][row] + "   ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
