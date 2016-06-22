package Week5;
import java.io.*;
import java.util.*;

public class Scrabble {
	 public static void main(String args[]){
	        
	        FileIO reader = new FileIO();
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Enter your letters:");
	        String letters= scan.nextLine();
	        
	        //load in dictionary words as a String array
	        String[] inputs = reader.load("C:/Users/User/OneDrive/Second Year/Semester 2/CS211/src/Week5/Dict1.txt");  
	        //make array containg words found
	        String wordsFound[]= new String[1000];
	        
	        int position=0;
	        for(int i=0;i<inputs.length;i++){
	        //call check method to check if any matches found
	        boolean check1=WordChecker(inputs[i],letters);
	        //if words are found add them to the wordsFound array
	        if(check1)
	        	{
	        	wordsFound[position]=inputs[i];
	        	position++;
	        	}
	        }
	        
	        System.out.println();
	        
	        //sort wordsFound array by length
	        for(int j=0; j<wordsFound.length;j++)
	        {
	            for (int i=j+1 ; i<wordsFound.length; i++)
	            {
	            	if(wordsFound[i]==null){
	            		
	            	}
	            else if(wordsFound[i].length()>wordsFound[j].length())
	                {
	                    String temp= wordsFound[j];
	                    wordsFound[j]= wordsFound[i]; 
	                    wordsFound[i]=temp;


	                }
	            }
	        }
        	System.out.println("Here are the top 10 suggestions:");
	        for(int i=0;i<11;i++){
	        	System.out.print(wordsFound[i]+ "\n");
	        }
	       
	        
//	        scan.close();
	 }
	 public static boolean WordChecker(String input, String letters){
		 
		 //turn both input string and letter string to a char array
		 char [] inputArray=input.toCharArray();
		 char [] letterArray=letters.toCharArray();
		 
		 for(int i=0;i<inputArray.length;i++){
			 for(int x=0;x<letterArray.length;x++){
				 if(inputArray[i]==letterArray[x]){
					 inputArray[i]='X';
					 letterArray[x]='X';
				 }	 
			 }
		 }
		 
		 int index=1;
		 for(int i=0;i<inputArray.length;i++)
		 {
			 if(inputArray[i]=='X')
			 {
				 index++;
			 }
			 	if(index==inputArray.length)
			 	{
				 return true;
			 	}
		 }
		  return false;
	 }
	}