/**
* FlowC.java
*
* @version   $Id: FlowC.java,v_1.0 2014/09/16 13:32:00
*
* @author    hhk9433 (Hrishikesh Karale)
* @author    ap8185 (Atir Petkar)
*
* Revisions:
*      Initial revision
*/



class FlowC
{
   static int[] numbers = { 3, 5, 6, 1, 0, -1, 22, 14, 5, 9, 0, 1, -1 };

   static boolean trueIfZero(double n) {
	return n == 0.0;
   }
   static boolean greaterZero(double n) {
	return n > 0.0;
   }
   static double aDividedByN(double a, double b)      {
	   
	return a / b;
	   
   }

   static int test_1(int n)	{
	if ( ++n == 1 )
		return 1;
	else if ( n-- == 1 )
		return 2;
	else if ( --n == 0 )
		return 3;
	else
		return 4;
   }
   static int test_2(int n)	{
        n = -1;
	while ( n < 4 )	{
		if ( n-- == -1 )
			n = 1;
		if ( ( n + 1 ) % 2 == 0 )
			n = 2;
		else if ( n == 3 )
			n = n++;
		n = n + n;
	}
	if ( ( n = 1 ) == 1 )
		n = 3;
	return n;
   }
   static int test_3(int a, int b)	{
	//if ( a < b )
		//return a;
	//else
		//return b;
	
	return (a<b?a:b);
	
   }
   static double test_4(double a, double b)	{
	  
	
 
	   
	   if  (trueIfZero(a) )
		return aDividedByN(b , a );
	  
	if  (greaterZero(a) | trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) || trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) & trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) && trueIfZero(a) )
		return aDividedByN(b , a );
	if  (! greaterZero(a) && ! trueIfZero(a) )
		return aDividedByN(b , a );
	if  ( greaterZero((int)a >>1 ) && trueIfZero(a) )
		return aDividedByN(b , a );
	if  ( greaterZero((int)a >>>1 ) && trueIfZero(a) )
		return aDividedByN(b , a );
	
	return 0;
   }


   public static void main(String args[])
   {  
	   

	// a) create 4 statements so such test_1 returns all possible values
	// is it possible to get all 4 possible values?
	// System.out.println("a:	test_1(0):	" + test_1(i) );
	   
	   
	   System.out.println("a:	test_1(0):	" + test_1(0) ); //a:	test_1(0):	1
	   System.out.println("a:	test_1(1):	" + test_1(1) ); //a:	test_1(1):	3
	   System.out.println("a:	test_1(2):	" + test_1(5) ); //a:	test_1(2):	4
	   
	   /* no it is not possible to get all 4 possible values
	    * 2nd condition is not executed in test_1 because -- is the post decrement operator,i.e it decrements the value of n 
	    * for the next statement and hence for "else if ( n-- == 1 )" to be true n should be 1 but that is true for the previous if  
	    * "if ( ++n == 1 )" which has a pre increment operator(it increments the value of n by 1 and assigns the value at that statement
	    * itself) and hence the 2nd if condition is not checked when value of n is 1
	    *   
	    */
	   
	 

	// b) explain the execution of test_2
	System.out.println("b:	test_2(2):	" + test_2(2) ); //OUTPUT-->      b:	test_2(2):	3
	
	/* for any input value of int n passed, for test_2, n = -1 always
	 * which makes the while condition (n<4) always true, which makes the 1st if condition "n-- == -1" true, and then n = 1;
	 * after that the next if condition "( n + 1 ) % 2 == 0 " is also true ,since (1+1)%2 = 0 which makes the value of n, n = 2;
	 * Later n = n + n; makes ==> n = 4  and the while loop breaks
	 * after that if condition "( ( n = 1 ) == 1 )" is executed, which contains assignment operator '=' and the value of n, n =1
	 * and the if condition is true, which makes the value of n = 3, which is returned
     */
	
	// c) simplyfiy test_3 by using a ?: statement
	/* 
	 * simplified test_3 method
	 * static int test_3(int a, int b)	
	 * {
	 *
	 *       return (a<b?a:b);
	 *
     *  }
     */
	System.out.println("c:	test_3(4,3):	" + test_3(4,3) ); // OUTPUT -->      c:	test_3(4,3):	3
	
	// d) find the minimum of all numbers in number by using one for loop
	int min = numbers[0];
	for (int i=0;i<numbers.length;i++)
	{
		if (min>numbers[i])
		min=numbers[i];
	}
	System.out.println("min is " + min);
	
	// e) test_4 wil not compile, why? Fix it?
	/*
	 *The function has return type double, in case all the if condition fails , since there is no return  
	 *defined for the function,there is no value returned and hence it throws an error. 
	 *it can be fixed by having a return statement added at the end of the
	 *method
	 */
	
	// create a/b pairs, so such all return statements are executed
	
	// is it possible to execute all  return statements.
	
	/*
	 * no it is not possible to execute all return statements
	 * for a = 0, the first if condition is true and hence the return statement of first if condition is executed
	 * for value of a = 1 or more
	 * 2nd and 3rd if condition is true and return of 2nd if condition is executed
	 * for value of a = -1 or less, only 6th if condition "if  (! greaterZero(a) && ! trueIfZero(a) )" is true and the
	 * return statement for 6th condition is executed
	 */
	System.out.println("e:	test_4(0, 2):	" + test_4(0, 2) ); // OUTPUT --> e:	test_4(0, 2):	Infinity
	System.out.println("e:	test_4(5, 2):	" + test_4(5, 2) ); // OUTPUT --> e:	test_4(5, 2):	0.4 
	System.out.println("e:	test_4(-5, 2):	" + test_4(-5, 2) );// OUTPUT --> e:	test_4(-5, 2):	-0.4

   }
}