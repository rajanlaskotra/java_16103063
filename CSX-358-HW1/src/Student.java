public class Student {
    long stdnt_ID;
    int ex;
    int[] assgmt=new int[10];
    int midterm,finalp,codep;
    int points,total;
    int per;
    char grade;
    static int[] gradesCount = new int[5];   //default 0 otherwise use Arrays.fill(gradesCount,0);   Count no. of occurence of diff. Grades
    Student(){
    	total=0;
    }
    void cal(String s)throws NumberFormatException {
        s = s.replace("  "," ").replace(", "," ");
    	String str[] = s.split(" ");                //split each spaced Integer into String array. 
    	stdnt_ID = Long.parseLong(str[0]);          //convert str[0] to long. i.e student ID.
    	ex = Integer.parseInt(str[1]);             //convert str[1] to int.   i.e exercise points.
    	int j=0;
    	for(int i=2;i<12;i++){
    		assgmt[j] = Integer.parseInt(str[i]);
    		total+=assgmt[j];
    		j++;
    	}
    	midterm = Integer.parseInt(str[12]);
    	finalp = Integer.parseInt(str[13]);
    	codep = Integer.parseInt(str[14]);
    	points = ex+ total + midterm + finalp + codep;
    	grades(points);
    	
}
     void grades(int points){
    	 per = Math.round(((float) points/420)*100);
    	 if(per >= 90){
    		 grade = 'A';
    		 gradesCount[0]++;
    	 }
    	 else if(per>=78 && per<=89){
    		 grade = 'B';
    		 gradesCount[1]++;
    	 }
    	 else if(per>=62 && per<=77){
    		 grade = 'C';
    		 gradesCount[2]++;
    	 }
    	 else if(per>=46 && per<=61){
    		 grade = 'D';
    		 gradesCount[3]++;
    	 }
    	 else{
    		 grade = 'F';
    		 gradesCount[4]++;
    	 }
     }
     
}
