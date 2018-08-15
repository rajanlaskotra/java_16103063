import java.io.*;
import java.util.Scanner;
public class CSX_358_HW2_16103063 {

	public static void main(String[] args)throws Exception {
		
	File input_1 = new File("C:\\Users\\Rajan\\Desktop\\16103063\\CSX-358-HW2\\csx-351-hw2-rajanlaskotra-master\\HW2-dictionary.txt");    //First input File.
	File input_2 = new File("C:\\Users\\Rajan\\Desktop\\16103063\\CSX-358-HW2\\csx-351-hw2-rajanlaskotra-master\\HW2-keywords.txt");    //Second Input File.
    FileWriter output = new FileWriter("C:\\Users\\Rajan\\Desktop\\16103063\\CSX-358-HW2\\csx-351-hw2-rajanlaskotra-master\\HW2-output-16103063.txt");  //Output File.
    Scanner inp_1 = new Scanner(input_1);
    Scanner inp_2 = new Scanner(input_2);
    
    String[] dict = new String[16000];
    String[] keys = new String[84];
    int i=0,j=0;
    
    // Storing File 1 in Dict Array.
    while(inp_1.hasNextLine())
       dict[i++] = inp_1.nextLine();
    
    //Storing File 2 in keys Array.
     while(inp_2.hasNextLine())
    	keys[j++] = inp_2.nextLine();
     
     /*Arrays.sort(dict);
     Arrays.sort(keys);*/
     
     int xch;
     //Sorting Dict. Array Using Bubble Sort.
     for(i = 0; i < (dict.length - 1); i++)
     {
    	 xch = 0;
    	 for(j = 0; j < (dict.length - i -1); j++)
    	 {
    		 if(dict[j].compareTo(dict[j+1]) > 0)
    		 {
    			 String temp = dict[j];
    			 dict[j] = dict[j+1];
    			 dict[j+1] = temp;
    			 xch++;
    		 }
    	 }
    	 if(xch == 0)
    		 break;
     }
   //Sorting Keys. Array Using Bubble Sort.
     for(i = 0; i < (keys.length - 1); i++)
     {
    	 xch = 0;
    	 for(j = 0; j < (keys.length - i -1); j++)
    	 {
    		 if(keys[j].compareTo(keys[j+1]) > 0)
    		 {
    			 String temp = keys[j];
    			 keys[j] = keys[j+1];
    			 keys[j+1] = temp;
    			 xch++;
    		 }
    	 }
    	 if(xch == 0)
    		 break;
     }
   
     int counter = 0;
     int temp;
     //Printing the Desired Output to Output File.
     for(i = 0;i < keys.length; i++)
     {
    	 temp = 0;
    	 for(j = 0;j < dict.length; j++)
    	 {
    		 if(!(keys[i].equals(dict[j])))
    		    temp++;
    	 }
    	 if(temp == dict.length)
    	 {
    		 output.write("Keyword not found: "+ keys[i]+ "\r\n");
    		 counter++;
    	 }
     }
     
    output.write("\r\n");
    output.write("Number of keywords not found: "+ counter);
    inp_1.close();
    inp_2.close();
    output.close();
	}

}
