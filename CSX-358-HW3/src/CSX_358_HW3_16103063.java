
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CSX_358_HW3_16103063 {
	
	//Function to Sort the Keywords using Bubble Sort.
	static void sortKeyWords(String[] key){
		int i,j,xch;
		for(i = 0; i < (key.length - 1); i++)
	     {
	    	 xch = 0;
	    	 for(j = 0; j < (key.length - i -1); j++)
	    	 {
	    		 if(key[j].compareTo(key[j+1]) > 0)
	    		 {
	    			 String temp = key[j];
	    			 key[j] = key[j+1];
	    			 key[j+1] = temp;
	    			 xch++;
	    		 }
	    	 }
	    	 if(xch == 0)
	    		 break;
	     }
		
	}
	// Function to check If the line of code is Comment or not.
	static int checkComment(String t){
		String ch = t;
		t = t.replaceAll("\\s{2,}"," ").trim();
		String[] temp = t.split(" ");
		if(Arrays.asList(temp).contains("//"))
		{
			if(temp[0] == "//" )
				return 0;          //complete comment
			else
			{
				int index = ch.indexOf("//", -1);
				return index;    //comment after code (i.e like this line 41.)
			}
		}
		else
			return -1;   // no comment found.
	}

	public static void main(String[] args)throws Exception{
		
		File input_1 = new File("C:\\Users\\Rajan\\Desktop\\16103063\\CSX-358-HW3\\csx-351-hw3-rajanlaskotra-master\\HW3-unsorted-keywords.txt");    // Read Input KeyWords File
		File input_2 = new File("C:\\Users\\Rajan\\Desktop\\16103063\\CSX-358-HW3\\csx-351-hw3-rajanlaskotra-master\\HW3-input-code.txt");   //Read Code File
		Scanner inp_1 = new Scanner(input_1);
		Scanner inp_2 = new Scanner(input_1);
		Scanner inp_3 = new Scanner(input_2);
		
		int lines = 0 ;
		// count Keywords
		while(inp_1.hasNextLine()){
			inp_1.nextLine();
			lines++;  
		}
		inp_1.close();
		
		String[] key = new String[lines];
		int i = 0;
		// store keyWords in Array of String
		while(inp_2.hasNextLine()){
			key[i++] = inp_2.nextLine();
		}
		
		sortKeyWords(key);
		
        int keysFound,lineCount;
        keysFound = 0; lineCount = 1;
		while(inp_3.hasNextLine())
		{
			String s = inp_3.nextLine(); 
			s = s.replaceAll("[^\\w\\s//]"," ");        // replace all special chars except alphanumeric,spaces & '//' with single whitespace.
			//s = s.replaceAll("\\s{2,}"," ").trim();   //replace all more than one whitespace into one space & trim() clears whitespace at beg. and end.
			
			int ch = checkComment(s);
			if(ch == 0){
		        lineCount++;
				continue;
			}
			if(ch != -1)
			{
				s = s.substring(0, ch+1);
			}
	
			String[] str = s.split(" "); 
			int loc = 0;
	        boolean flag = true;                      // Flag to resolve the multiple keyWords on Single line 
			for(int j = 0; j < str.length; j++)
			{
				 if(Arrays.asList(key).contains(str[j]))     //method to check if str[i] String is in key Array 
				 {
					  if(flag)
					  {
					      System.out.print("Line "+lineCount+": "+str[j]+"("+loc+") ");    //for First keyword on line
					      flag = false;
					  }
					  else
						  System.out.print(str[j]+"("+loc+") ");     //for second & other keywords
					  
					  keysFound++;
			      }
				  loc = loc + str[j].length()+1;         //for setting position of keywords(column no.) 
		    }
			
			if(!flag)
			     System.out.println();
	       lineCount++;
		}
		
		System.out.println("\nNumber of KeyWords Found : "+keysFound);
		
		inp_2.close();
		inp_3.close();
	}
}
