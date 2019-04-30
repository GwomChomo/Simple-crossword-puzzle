import java.awt.Point;
import java.util.*;
import java.io.*;

public class Cross
{
   public static void main(String[] args) throws FileNotFoundException, IOException{
       Cross cross = new Cross();       
       ArrayList<String>wordsFromFile = new ArrayList<String>();
       ArrayList<Word> crossWords = new ArrayList<Word>();
       char[][] matrix = null;

        try {
            matrix =create2DIntMatrixFromFile("C:/Users/Gwom HP/Documents/Work/3rd Year/Sem 2/Data Structures and Algorithms/cmgwo1_P1/Problem3/Template.txt");
            wordsFromFile = readWords();  
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       
       Space[]slots = {
           new Space(new Point(1,1), new Point(0, 1), 4),
           new Space(new Point(1, 1), new Point(1, 0), 3),
           new Space(new Point(1, 2), new Point(1, 0), 3),
           new Space(new Point(1, 3), new Point(1, 0), 3),
           new Space(new Point(1, 4), new Point(1, 0), 5),
           new Space(new Point(1,6), new Point(1, 0), 9),
           new Space(new Point(1,6), new Point(0, 1), 4),
           new Space(new Point(1,7), new Point(1, 0), 4),
           new Space(new Point(1, 8), new Point(1, 0), 3),
           new Space(new Point(1, 9), new Point(1, 0), 5),
           new Space(new Point(1,11), new Point(1, 0), 9),
           new Space(new Point(1,11), new Point(0, 1), 3),
           new Space(new Point(1,12), new Point(1, 0), 4),
           new Space(new Point(1,13), new Point(1,0), 4),
           new Space(new Point(2,1), new Point(0, 1), 4),
           new Space(new Point(2,6), new Point(0, 1), 4),
           new Space(new Point(2,11), new Point(0, 1), 3),
           new Space(new Point(3,1), new Point(0, 1), 9),
           new Space(new Point(3,5), new Point(1, 0), 4),
           new Space(new Point(3,11), new Point(0, 1), 3),
           new Space(new Point(4,4), new Point(0, 1), 4),
           new Space(new Point(4,9), new Point(0, 1), 5),
           new Space(new Point(4,10), new Point(1, 0), 4),
           new Space(new Point(5,1), new Point(0, 1), 6),
           new Space(new Point(5,1), new Point(1, 0), 4),
           new Space(new Point(5,2), new Point(1, 0), 4),
           new Space(new Point(5,3), new Point(1, 0), 9),
           new Space(new Point(5,8), new Point(1, 0), 9),
           new Space(new Point(5,8), new Point(0, 1), 4),
           new Space(new Point(6,1), new Point(0, 1), 3),
           new Space(new Point(6,5), new Point(0, 1), 4),
           new Space(new Point(6,7), new Point(1, 0), 3),
           new Space(new Point(6,10), new Point(0, 1), 4),
           new Space(new Point(6,12), new Point(1, 0), 4),
           new Space(new Point(6,13), new Point(1, 0), 4),
           new Space(new Point(7,1), new Point(0, 1), 4),
           new Space(new Point(7,4), new Point(1, 0), 4),
           new Space(new Point(7,6), new Point(0, 1), 3),
           new Space(new Point(7,10), new Point(0, 1), 4),
           new Space(new Point(8,1), new Point(0, 1), 4),
           new Space(new Point(8,6), new Point(0, 1), 4),
           new Space(new Point(8,9), new Point(1, 0), 4),
           new Space(new Point(8,11), new Point(0, 1), 3),
           new Space(new Point(9,3), new Point(0, 1), 4),
           new Space(new Point(9,5), new Point(1, 0), 5),
           new Space(new Point(9,8), new Point(0, 1), 6), 
           new Space(new Point(9,10), new Point(1, 0), 5),
           new Space(new Point(10,1), new Point(0, 1), 5),
           new Space(new Point(10,1), new Point(1, 0), 4),
           new Space(new Point(10,2), new Point(1, 0), 4),
           new Space(new Point(10,7), new Point(1, 0), 4),
           new Space(new Point(10,7), new Point(0, 1), 4),
           new Space(new Point(11,1), new Point(0, 1), 3),
           new Space(new Point(11,5), new Point(0, 1), 9),
           new Space(new Point(11,6), new Point(1, 0), 3),
           new Space(new Point(11,11), new Point(1, 0), 3),
           new Space(new Point(11,12), new Point(1, 0), 3),
           new Space(new Point(11,13), new Point(1, 0), 3),
           new Space(new Point(12,1), new Point(0, 1), 3),
           new Space(new Point(12,5), new Point(0, 1), 4),
           new Space(new Point(12,10), new Point(0, 1), 4),
           new Space(new Point(13,1), new Point(0, 1), 3),
           new Space(new Point(13,5), new Point(0, 1), 4),
           new Space(new Point(13,10), new Point(0, 1), 4)      
        };
        
        
        for(int i = 0;i<wordsFromFile.size();i++){
           crossWords.add(new Word(wordsFromFile.get(i)));
       }
       
       Solver solve = new Solver(matrix, slots, crossWords);
       solve.solve();
       solve.showResult();
       
    }
    
    public static char[][] create2DIntMatrixFromFile(String filename) throws FileNotFoundException, IOException {
        char[] array;
        char[][] matrix = null;
        BufferedReader scan = null;
        String thisLine;
        
        try{
         scan = new BufferedReader(new FileReader(filename)); 
         thisLine = scan.readLine();
        array =thisLine.toCharArray();
        
        matrix = new char[array.length][array.length];
           scan = new BufferedReader(new FileReader(filename));
           
           for(int row=0;row<matrix.length;row++){
               thisLine = scan.readLine();
               array = thisLine.toCharArray(); 
               System.out.print(" * ");
               for(int col=0;col<matrix.length;col++){
                   matrix[col][row] = array[col];
                   System.out.print(matrix[col][row] + " * ");
               }
               System.out.println();
           }
           
      }
       catch(FileNotFoundException fnf){
          System.out.println("Here we are");
      }
          
           
           

  
        return matrix;
    }
    
    public static ArrayList<String>readWords()throws FileNotFoundException, IOException{
        ArrayList<String> words = new ArrayList<>();
        String filePath = "C:/Users/Gwom HP/Documents/Work/3rd Year/Sem 2/Data Structures and Algorithms/cmgwo1_P1/Problem3/Word_List.txt";
       try{
          
           FileReader fileReader = new FileReader(filePath);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           String line = "";
           while((line = bufferedReader.readLine()) !=null){
               words.add(line);
           
           }
           bufferedReader.close();
        }
        catch(IOException ioe){
            System.out.println(
                "Error reading file '" 
                + filePath + "'"); 
       }
        return words;
    }

}



