import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import java.util.ArrayList;

public class Run {
	
	public static void main(String[] args) throws IOException
	{
		
		//List stringList = (List) new LinkedList<String>();
		char[] sequenceMatrix =new char[4000];
		for(int k=0 ; k<4000; k++)
		{
			sequenceMatrix[k] = '\0';
		}
		char decision ;
		String sequence = null;
		String  option= null;
		System.out.print("Enter the sequence line by line");
		boolean loop = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int j = 0;
		while(loop != false)
		{
	      try {
	    	  int i = 0;
	          sequence = br.readLine();
	          int length = sequence.length();
	          System.out.print(length);
	          while(i<length)
	          {
	        	  sequenceMatrix[j]= sequence.charAt(i);
	        	  i++;
	        	  j++;
	          }
	          sequenceMatrix[j] = '2';
	          
	          
	       } catch (IOException ioe) {
	          System.out.println("IO error trying to read your name!");
	          System.exit(1);
	       }
	       j++;
	       
			System.out.print("Do you want to enter another sequence if yes enter y if no enter n");
			 option = br.readLine();
			 
			 decision = option.charAt(0);
			 System.out.print(decision);
			if(decision == 'y'  || decision == 'Y')
			{
				loop=true;
			}
			else if(decision == 'n'  || decision == 'N')
			{
				loop=false;
			}
			else
			{
				System.out.print("Wrong Input");
			}
			
			
		}
		
		//System.out.print("exit");
		
		/*for(int f = 0 ; sequenceMatrix[f] != '\0' ; f++)
		{
			System.out.print(sequenceMatrix[f]);
		}*/
		int rows = 0;
		int length = 0;
		for(int k = 0; sequenceMatrix[k] != '\0' ; k++)
		{
			int templen = 0;
			
			while(sequenceMatrix[k] != '2')
			{
				k++;
				templen++;
			}
			rows++;
			if(length <= templen)
			{
				length = templen;
			}
		}
		
		
		double columntemp = 1.2*length;
		
		int columns = (int)columntemp;
		
		System.out.print(columns);
		System.out.print("*************");
		System.out.println();


		
		
		Chromosome [] ChromosomeGenration = new Chromosome[100];
		
		for(int y = 0; y<100 ; y++)
		{
			ChromosomeGenration[y] = new Chromosome(rows, columns);
		}
		
		
		
		for(int e = 0 ; e <100; e++)
		{
			ChromosomeGenration[e].Initialization(sequenceMatrix , rows , columns);
//			ChromosomeGenration[e].printing();
//			System.out.println("*******************");
			int k = ChromosomeGenration[e].calculateScore();
			System.out.println(ChromosomeGenration[e].getscore());
			System.out.println("*******************");		
		}
		
		LCS lcsprocessing = new LCS();
		
		lcsprocessing.CalculateLongestCsequence(ChromosomeGenration);
		
//        System.out.println("**********************************************");
//    	
//    	for(int h = 0 ; h< 100 ; h++)
//    	{
//	        System.out.println(ChromosomeGenration[h].getlongestSequence());
//    	}
		
		ArrayList<Chromosome> ChromosomeClust1 = new ArrayList<Chromosome>();
		ArrayList<Chromosome> ChromosomeClust2 = new ArrayList<Chromosome>();
		ArrayList<Chromosome> ChromosomeClust3 = new ArrayList<Chromosome>();
		ArrayList<Chromosome> ChromosomeClust4 = new ArrayList<Chromosome>();

		Clustering ChromosomeClustering = new Clustering();
		Evolution ClusterEvolution = new Evolution();
		
		int y = 0;
		while(y < 1000)
		{
			ChromosomeClustering.clusterAnalysis(ChromosomeClust1 , ChromosomeClust2 , ChromosomeClust3 , ChromosomeClust4 , ChromosomeGenration);
			ClusterEvolution.IntraClusterEvoultion(ChromosomeClust1, ChromosomeClust2, ChromosomeClust3, ChromosomeClust4);
			ClusterEvolution.InterClusterEvolution(ChromosomeClust1 , ChromosomeClust2 , ChromosomeClust3 , ChromosomeClust4 , ChromosomeGenration);		
			y++;
			System.out.println(y);
			System.out.println("***********************************************Iteration completes********************************************************************");
			ChromosomeClust1.clear();
			ChromosomeClust2.clear();
			ChromosomeClust3.clear();
			ChromosomeClust4.clear();	
		}
		
		int size = ChromosomeGenration.length;
	   
		for(int q = 0 ; q < size ; q++)
		{
			for(int h =0 ; h < size-1 ; h++)
	    	{
				if(ChromosomeGenration[h].getscore() > ChromosomeGenration[h+1].getscore())
				{
					Chromosome temp = new Chromosome(ChromosomeGenration[h].getRows() , ChromosomeGenration[h].getColumns());
					temp = ChromosomeGenration[h];
					ChromosomeGenration[h]=ChromosomeGenration[h+1];
					ChromosomeGenration[h+1] = temp;
				}
	    	}
		}
		
		System.out.println("Printing the chromosomes After algorithm run");
		for(int h = 0 ; h < 100 ; h++)
		{
			ChromosomeGenration[h].printing();
			System.out.println(ChromosomeGenration[h].getscore());
			System.out.println();

		}
    }
}