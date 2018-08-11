import java.io.*;
import java.util.*;

class CSX_358_HW1_16103063 {
	
	public static void main(String[] args)throws Exception
   {
	   File input = new File("/home/rajan/Desktop/HW1/HW1-data.txt");    //input file.
	   File output = new File("/home/rajan/Desktop/HW1/HW1-output-16103063.txt");    //output file.
	   Scanner sc = new Scanner(input);   //load inputStream.
	   PrintWriter printer = new PrintWriter(output);  //load outputStream.
	   
	   String s,temp1,temp2;
	   temp1 = "Stdnt Id  Ex  ------- Assignments ---------  Tot  Mi  Fin  CL  Pts  Per  Gr";
	   temp2 = "--------  --  -----------------------------  ---  --  ---  --  ---  ---  --";
	   printer.println(temp1);
	   printer.println(temp2);
	   int avgPoints=0, maxPoints=0,num=0;
	   
	   while(sc.hasNextLine())
	   {
		   s=sc.nextLine();
		   Student object = new Student();
		   object.cal(s);
		   //String merge = Arrays.toString(object.assgmt).replace(", "," ").replace("[","").replace("]","");
	
		   printer.print(String.format("%08d",object.stdnt_ID)+"  "+object.ex+"  ");
		   
		   for(int i = 0;i < 10; i++)
		      printer.print(String.format("%02d",object.assgmt[i]) + " ");
		   
		   printer.println(" " + object.total+"  "+object.midterm+"   "+object.finalp+"  "+String.format("%02d",object.codep)+"  "+object.points+"   "+object.per+"   "+object.grade+" ");
		   
		   if(object.points > maxPoints)
			     maxPoints = object.points;
		   avgPoints += object.points;
		   
		   num++;
	   }
	   
	   printer.println();
	   avgPoints = (avgPoints / num );
	   printer.println("Average total point percent of all students: " + avgPoints);
	   printer.println("Number of A's = " + Student.gradesCount[0]);
	   printer.println("Number of B's = " + Student.gradesCount[1]);
	   printer.println("Number of C's = " + Student.gradesCount[2]);
	   printer.println("Number of D's = " + Student.gradesCount[3]);
	   printer.println("Number of F's = " + Student.gradesCount[4]);
	   printer.println();
	   printer.println("Maximum Points = " + maxPoints);
	   
	   sc.close();
	   printer.close();
   }
	
}

