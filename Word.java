

class Word {
    private String word;
    private boolean used;
        
    public Word ( String word ) {
        this.word = word;
        used = false;
    }
    
    public String getWord() {
        return word;
    }
    
    public boolean isUsed() {
        return used;
    }
    
    public void setUsed ( boolean isUsed ) {
        used = isUsed;
    }
    
    public String toString(){
        return word;
    }
}