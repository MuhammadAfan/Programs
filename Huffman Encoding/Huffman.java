package Week4;

import java.util.*;

public class Huffman{

    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       int sum=0;
       
       System.out.print("Enter your sentence: ");
       String sentence = in.nextLine();
       String binaryString="";      //this stores the string of binary code
       
       
       for(int i=0; i < sentence.length(); i++){        //go through the sentence
           int decimalValue = (int)sentence.charAt(i);      //convert to decimal
           String binaryValue = Integer.toBinaryString(decimalValue);      //convert to binary
           for(int j=7;j>binaryValue.length();j--){
               binaryString+="0";           //this loop adds in those pesky leading zeroes
            }
           binaryString += binaryValue+" "; //add to the string of binary
           sum++;
           
       }
       System.out.println(binaryString);    //print out the binary
       
              
       int[] array = new int[256];      //an array to store all the frequencies
       
       for(int i=0; i < sentence.length(); i++){    //go through the sentence
           array[(int)sentence.charAt(i)]++;    //increment the appropriate frequencies
           
       }
       
       
       PriorityQueue < Tree >  PQ = new PriorityQueue < Tree >() ;  //make a priority queue to hold the forest of trees    
        
       
       for(int i=0; i<array.length; i++){ //go through frequency array
           if(array[i]>0){ //print out non-zero frequencies - cast to a char
                System.out.println("'"+(char)i+"' appeared "+array[i]+((array[i] == 1) ? " time" : " times"));
     
               //FILL THIS IN:
                
              //MAKE THE FOREST OF TREES AND ADD THEM TO THE PQ
                //create a new Tree         
                         Tree treez = new Tree();
                //set the cumulative frequency of that Tree
                         treez.frequency = array[i];
                         treez.root = new Node();

                         Node myNode = new Node();
                 //insert the letter as the root node         
                         myNode.letter = (char)i;
                         treez.root = myNode;
                //add the Tree into the PQ
                         PQ.add(treez);
            }
        }
        
        
        while(PQ.size()>1){             //while there are two or more Trees left in the forest

        	  //combines tree
        	         
        	         Tree firstTree = PQ.poll();
        	         Tree secondTree = PQ.poll();
        	         Tree comboTree = new Tree();

        	         comboTree.root = new Node();
        	         comboTree.frequency= firstTree.frequency + secondTree.frequency;

        	         if(firstTree.frequency < secondTree.frequency)
        	         {
        	             //if the firstTree is less than the secondTree make firstTree as left node or leftChild
        	             //and then secondTree be the rightChild or node
        	             comboTree.root.rightChild = secondTree.root;
        	             comboTree.root.leftChild = firstTree.root;
        	         }

        	         else
        	         {

        	             comboTree.root.rightChild = firstTree.root;
        	             comboTree.root.leftChild = secondTree.root;
        	         }
        	         //add them together into a tree
        	         PQ.add(comboTree);

        	//FILL THIS IN:

        	         //IMPLEMENT THE HUFFMAN ALGORITHM

        	         //when you're making the new combined tree, don't forget to assign a default root node (or else you'll get a null pointer exception)
        	         //if you like, to check if everything is working so far, try printing out the letter of the roots of the two trees you're combining


        }
        System.out.println();

        Tree HuffmanTree = PQ.poll();   //now there's only one tree left - get its codes
        
        //FILL THIS IN
        int totalLength=0;
        String theCode;

        //get all the codes for the letter and print them out
        for (int i=0; i<sentence.length(); i++)
        {
            //call the getCode() method on the HuffmanTree Tree object for each letter in the sentence
            theCode = HuffmanTree.getCode(sentence.charAt(i));
            //print out all the info
            System.out.print(theCode +" ");
            
           totalLength += theCode.length()-1;


        }
        sum = sum*7;
        System.out.println();
       double d=((double) totalLength/sum)*100;
       double answer = Math.round(d);
         System.out.println(totalLength+" "+ " / "+ sum + " = "+ (answer)+"%");

    }      
}