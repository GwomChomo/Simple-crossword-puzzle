

import java.awt.Point;

class Space {
    private Point start;
    private Point direction;
    private int length;
        
    public Space (Point start, Point direction, int length ) {
        this.start = start;
        this.direction = direction;
        this.length = length;
    }
    
    public Point getStart() {
        return start;
    }
    
    public Point getDirection() {
        return direction;
    }
    
    public int getLength() {
        return length;
    }
    
    public String toString(){
        return "length " + length +  " " + "Start " + start + " direction"  + direction; 
    }
}

