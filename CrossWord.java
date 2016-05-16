/**
* Palindrome.java
*
* @version   $Id: Palindrome.java,v_1.0 2014/09/16 13:32:00
*
* @author    hhk9433 (Hrishikesh Karale)
* @author    ap8185 (Atir Petkar)
*
* Revisions:
*      Initial revision
*/

import java.util.*;
import java.io.*;

/**
 * This program solves a word puzzle using words from a given text file
 */

public class CrossWord
{
 
/**
 * initializes the crossword grid
 * @return initialized crossword grid
 */

 private char[][] initialize()
 {
	 
  char grid [][]=new char[13][13];	// local grid
  grid[0][0]='-'; grid[0][1]='-'; grid[0][2]='-';
  grid[0][3]='-'; grid[0][4]='-'; grid[0][5]='-';
  grid[0][12]='-'; grid[0][11]='-'; grid[0][10]='-';
  grid[0][9]='-'; grid[0][8]='-'; grid[0][7]='-';
  grid[12][0]='-'; grid[12][1]='-'; grid[12][2]='-';
  grid[12][3]='-'; grid[12][4]='-'; grid[12][5]='-';
  grid[12][12]='-'; grid[12][11]='-'; grid[12][10]='-';
  grid[12][9]='-'; grid[12][8]='-'; grid[12][7]='-';
  grid[1][0]='-'; grid[1][1]='-'; grid[1][2]='-';
  grid[1][3]='-'; grid[1][4]='-'; grid[1][12]='-';
  grid[1][11]='-'; grid[1][10]='-'; grid[1][9]='-';
  grid[1][8]='-';grid[11][0]='-'; grid[11][1]='-';
  grid[11][2]='-';grid[11][9]='-'; grid[11][8]='-';
  grid[11][3]='-'; grid[11][4]='-';grid[2][3]='-'; 
  grid[11][12]='-'; grid[11][11]='-'; grid[11][10]='-';
  grid[2][0]='-'; grid[2][1]='-'; grid[2][2]='-';
  grid[2][12]='-'; grid[2][11]='-'; grid[2][10]='-';
  grid[2][9]='-'; grid[10][0]='-'; grid[10][1]='-'; 
  grid[10][2]='-'; grid[10][3]='-'; grid[10][9]='-';
  grid[10][12]='-'; grid[10][11]='-'; grid[10][10]='-';
  grid[3][0]='-'; grid[3][1]='-'; grid[3][2]='-';
  grid[3][12]='-'; grid[3][11]='-'; grid[3][10]='-';
  grid[9][0]='-'; grid[9][1]='-'; grid[9][2]='-';
  grid[9][12]='-'; grid[9][11]='-'; grid[9][10]='-';
  grid[4][0]='-'; grid[4][1]='-';grid[5][0]='-';
  grid[4][12]='-'; grid[4][11]='-';grid[5][12]='-';
  grid[8][0]='-'; grid[8][1]='-'; grid[7][0]='-';
  grid[8][12]='-'; grid[8][11]='-'; grid[7][12]='-';
  grid[4][6]='-'; grid[5][5]='-'; grid[5][6]='-';
  grid[5][7]='-'; grid[6][4]='-'; grid[6][5]='-';
  grid[6][6]='-'; grid[6][7]='-'; grid[6][8]='-';
  grid[7][5]='-'; grid[7][6]='-'; grid[7][7]='-';
  grid[8][6]='-'; grid[1][5]='F'; grid[1][6]='U';
  grid[1][7]='N'; 

  return grid;
   
 }

 /**
  *displays the grid 
  * @param grid
  */
 
 private void display(char[][] grid)
 {

  for(int i=0; i<13; i++)
  {
   System.out.println();
   for (int j=0; j<13; j++)
    System.out.print(grid[i][j]+" ");
  }
  
 }

 /**
  * this method calculates the size of the word
  * that is to be inserted in the given position vertically
  * @param grid
  * @param row
  * @param column
  * @return size of word that could be inserted in the given column
  */
 
 private int wordSize(char[][] grid, int row, int column)
 {
	 
  int word_size=0; // max length of word that can be placed in the current position
  
  for(int i=row; i<13; i++)
   if(grid[i][column]!='-')	//checks for blank spaces
    word_size++;
   else
	break;
  
  return word_size;
  
 }
 
 /**
  * checks if the given position is already filled with a word
  * @param grid
  * @param row
  * @param column
  * @return boolean value
  */
 
 private boolean isFilled( char[][] grid, int row, int column)
 {
	 
  int count=0;
  CrossWord cw= new CrossWord();
  int word_size=cw.wordSize(grid, row, column);
  
  for( int i=0;i<word_size; i++)
   if( grid[row+i][column]!=' ')
    count++;
  
  if(count==0)
   return true;
  else
   return false;
 
 }
 
 /**
  * this method generates possible list of words
  *  that could be plaed in the current position 
  * @param grid
  * @param row
  * @param column
  * @param word_size
  * @param word
  * @return ArrayList<String> containing possible list of words
  */
 
 private ArrayList<String> wordList(char[][] grid, int row, int column, int word_size, ArrayList<String> word)
 {
	 
  int duplicate_counter=0;
  ArrayList<String> word_holder=new ArrayList<String> ();
  
  for(String str: word)
  {
    int count=0;
   
    for(int i=0; i<str.length(); i++)	//eliminates Single quote and characters after it using substring()
     if(str.charAt(i)==(char)(39))
     {
      str=str.substring(0,i);
      break;
     }
  
    for(int i=0; i<str.length(); i++)	//counts alphabets already present in the column of our current position
     if(grid[row+i][column]!=' ')
      count++;
   
    if(str.length()==word_size)
    {

     for(int j=0; j<word_size; j++)	// compares and keeps a count of common alphabets present in our string and our grid position
      if(grid[row+j][column]==str.charAt(j)) 
		duplicate_counter++;
     
     if(duplicate_counter==count)	//if no of alphabets already present match acommon alphabets then word is stored in word_list
	  word_holder.add(str);
     
    }
   }
  
  return word_holder;
  
 }
 
 /**
  *this method puts words in the current position and removes it from the word_list
  * @param grid
  * @param row
  * @param column
  * @param word_size
  * @param word_list
  * @return char[][]
  */
 
 private char[][] fill(char[][] grid, int row, int column, int word_size, ArrayList<String> word_list)
 {
	 
  CrossWord cw=new CrossWord();
  String str= word_list.get(0);
  
  if(row==9 && column==7 )
   return grid;
  
  if(!cw.isFilled(grid, row, column))
   for(int i=0; i<word_size; i++)
    grid[row+i][column]=str.charAt(i);
  
  cw.display(grid);
  System.out.println();
  word_list.remove(str);
  
  if(++column==13)
  {
   ++row;
   column=0;
  }
  
  return grid;
 
 }
 
 /**
  * this method scans the current grid and calls methods to get
  * word_size, word_list and for filling words in the grid
  * @param grid
  * @param row
  * @param column
  * @param word
  * @return grid to the main function
  */
 
 private char[][] scan(char[][] grid, int row, int column, ArrayList<String> word)
 {
	
  int word_size=0;
  CrossWord cw= new CrossWord();
  ArrayList<String> word_list= new ArrayList<String> ();
  
  for( int i=row; i<13; i++)	
   for( int j=column; j<13; j++)
	if( grid[i][j]!='-'&& cw.isFilled(grid, i, j)==false)	//checks if position id empty and ready to be filled
	{
	 word_size=cw.wordSize( grid, i, j);	//calls wordSize() gets size of word for current position as return
	 word_list=cw.wordList( grid, i, j, word_size, word);
	 grid=cw.fill( grid, i, j, word_size, word_list);
	}
	
  return grid;
  
 }
 
 /**
  * this is the main method of our class which reads a text file and
  * then calls methods to initialize, display and scan the grid
  * it also checks for Exceptions generated during the reading of the text file.
  * and prints the final solved crossword
  * @param args
  */
 
 public static void main( String args[])
 {
 
  String str=null;
  char crossword [][]=new char[13][13];
  ArrayList<String> words= new ArrayList<String>();
  CrossWord crossWordObject= new CrossWord();

  try
  {
   BufferedReader br= new BufferedReader(new FileReader("Words.txt"));
  
   while( (str=br.readLine())!=null)	//stores words from text file to our arraylist word
    words.add(str.toUpperCase());
   
   br.close();
  }
  
  catch( Exception e)
  {
   System.out.println("Error Reading File");
  }
   
  crossword=crossWordObject.initialize();
  crossWordObject.display(crossword);
  crossword=crossWordObject.scan(crossword,0,0, words);
  
  System.out.println("\n\nFINAL PUZZLE:");
  crossWordObject.display(crossword);
 }
}