


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


/*
 * This program finds the no of palindromes in the given file
 * It also prints the palindromes and finds the count of palindromes in the given file
 */


import java.io.File;
import java.util.Scanner;

public class Palindrome
{

	
	public static void main (String[] args)
	{
		
		
		try 
		{
			int count_of_palindrome = 0;
			Scanner sc  = new Scanner( new File("palindrome_1.txt"));
			System.out.println("The palindromes in the file are as follows");
			while ( sc.hasNext() )
			{
				
				  String input = sc.nextLine();
			      int next_char = 0;
		          String input_mod ;
		          String input_rev  ;
		          input = input.replaceAll("[^a-zA-Z0-9]", "");                      /*place only alphabets and numbers in input string
		                                                                               and remove all spaces,punctuations etc.*/
	         	  input_mod = input;                                                 /*input_mod is used to modify input string to find 
	         	                                                                       palindromes*/
		          input_rev = new StringBuffer(input_mod).reverse().toString();      /*input_rev is used to store the reverse of the input
                                                                                       input string*/
		          
	              for (int i = input.length() ; i > 2 ; i-- )                        /*for loop to make the input string 
	            	                                                                   combinations */ 
	            	                                                                 
	              {
	            	
	     	          for (int j = 0 ; (i - j) > 2 ; j++ )                           /*for loop to make input_mod combinations 
	     	        	                                                               for a particular input string*/
	     	          {
	     	     
	     	              if (input_mod.toLowerCase().equals(input_rev.toLowerCase())) //true if string is palindrome
	     	              { 
	     	            	  
	     	                 ++count_of_palindrome;  
	     	                 System.out.println(count_of_palindrome+") "+ input_mod);  // display palindrome string
	     	                 
	     	              } 
	           
	     	              input_mod = input_mod.substring(0,(input_mod.length()) -1);  /*substring of input_mod from start till 
	     	                                                                             2nd last character of input_mod*/
                          input_rev = (new StringBuffer(input_mod).reverse()).toString(); //reverse function is not defined for string
	     	             
	     	          }
	       
	                  ++next_char;
	     	          input_mod = input.substring(next_char);                          /*substring from the value of next_char
	     	                                                                             in input string*/
	                  input_rev = new StringBuffer(input_mod).reverse().toString();    //reverse of the new input_mod 
	                  
	               }
	     	   
			 }
			
             System.out.println ("no of palindromes : " + count_of_palindrome);	
             sc.close();
		    
		 }
		
		 catch ( Exception e )	
		{
			
	             System.err.println("Something went wrong!");
		    
		}

    }
	
	
	

}