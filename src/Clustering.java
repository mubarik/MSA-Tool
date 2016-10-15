import java.util.ArrayList;
import java.util.Random;
public class Clustering {

	public Clustering()
	{
		
	}
	
	public void clusterAnalysis(ArrayList<Chromosome> ChromosomeClust1 ,ArrayList<Chromosome> ChromosomeClust2 , ArrayList<Chromosome> ChromosomeClust3 , ArrayList<Chromosome> ChromosomeClust4 , Chromosome Chromosomes[])
	{
		int size = Chromosomes.length;
		
      Chromosome [] tempchromosomes = new Chromosome[size];
      
      for(int k = 0 ; k < size ; k++)
      {
    	  tempchromosomes[k] = Chromosomes[k];
      }
      
      
      // Sorting
      for(int q = 0 ; q < size ; q++)
      {
    	for(int h =0 ; h < size-1 ; h++)
    	{
    		Chromosome temp = new Chromosome(tempchromosomes[h].getRows(),tempchromosomes[h].getColumns());
    		if(tempchromosomes[h].getscore() < tempchromosomes[h+1].getscore())
    		{
    			temp = tempchromosomes[h];
    			tempchromosomes[h] = tempchromosomes[h+1];
    			tempchromosomes[h+1] = temp;
    		}
    	}
      }
      
//      for(int k = 0 ; k < size ; k++)
//      {
//    	  System.out.println("*********************");
//    	  System.out.println(tempchromosomes[k].getscore());
//      }
      
      int binsize = size/4;
      
      Chromosome [] bin1 = new Chromosome[binsize];
      Chromosome [] bin2 = new Chromosome[binsize];
      Chromosome [] bin3 = new Chromosome[binsize];
      Chromosome [] bin4 = new Chromosome[binsize];
      
      // Making Bins
      
	  int bin1count = 0;
	  int bin2count = 0;
	  int bin3count = 0;
	  int bin4count = 0;
      
      for(int g = 0 ; g < size ; g++)
      {

    	  if(g < 25)
    	  {
    		  bin1[bin1count] = tempchromosomes[g];
    		  bin1count++;
    	  }
    	  else if( g >=25 && g < 50)
    	  {
    		  bin2[bin2count]= tempchromosomes[g];
    		  bin2count++;
    	  }
    	  else if(g >=50 && g <75)
    	  {
    		  bin3[bin3count] = tempchromosomes[g];
    		  bin3count++;
    	  }
    	  else
    	  {
    		  bin4[bin4count] = tempchromosomes[g];
    		  bin4count++;
    	  }  	      	  
      }
      
//      System.out.println("Cluster Analysis BIn insering : Chromsosome printing");
//      
//      for(int p = 0; p<25 ; p++)
//      {
//     	 bin1[p].printing();
//      }
      
      int[] randomSequence = new int[25];
      Random randomNumbers = new Random();

      for (int j = 0; j < randomSequence.length; j++ ) 
      {
          if (j == 0) 
          { // seed first entry in array with item 0
              randomSequence[j] = 0; 
          } 
          else 
          { // for all other items...
              int pointer = randomNumbers.nextInt(j + 1);
              randomSequence[j] = randomSequence[pointer]; 
              randomSequence[pointer] = j;
          } // end if...else
      } // end for
      System.out.println();
      
      int[] randomSequence1 = new int[25];
      Random randomNumbers1 = new Random();

      for (int p = 0; p < randomSequence1.length; p++ ) 
      {
          if (p == 0) 
          { // seed first entry in array with item 0
              randomSequence1[p] = 0; 
          } 
          else 
          { // for all other items...
              // choose a random pointer to the segment of the
              // array already containing items
              int pointer = randomNumbers1.nextInt(p + 1);
              randomSequence1[p] = randomSequence1[pointer]; 
              randomSequence1[pointer] = p;
          } // end if...else
      } // end for
      
      System.out.println();
      int[] randomSequence2 = new int[25];
      Random randomNumbers2 = new Random();

      for (int g = 0; g < randomSequence2.length; g++ ) 
      {
          if (g == 0) 
          { // seed first entry in array with item 0
              randomSequence2[g] = 0; 
          } else 
          { // for all other items...
              // choose a random pointer to the segment of the
              // array already containing items
              int pointer = randomNumbers2.nextInt(g + 1);
              randomSequence2[g] = randomSequence2[pointer]; 
              randomSequence2[pointer] = g;
          } // end if...else
      } // end for      
      System.out.println();
      int[] randomSequence3 = new int[25];
      Random randomNumbers3 = new Random();
      for (int t = 0; t < randomSequence3.length; t++ ) 
      {
          if (t == 0) 
          { // seed first entry in array with item 0
              randomSequence3[t] = 0; 
          } 
          else { 
              int pointer = randomNumbers3.nextInt(t + 1);
              randomSequence3[t] = randomSequence3[pointer]; 
              randomSequence3[pointer] = t;
          } // end if...else
      } // end for

//      for(int r = 0 ; r<25 ; r++)
//      {
//    	  System.out.println(randomSequence3[r]);  
//      }
      
      
      int[] randomSequence4 = new int[5];
      Random randomNumbers4 = new Random();

      for (int q = 0; q < randomSequence4.length; q++ ) 
      {
          if (q == 0) 
          { // seed first entry in array with item 0
              randomSequence4[q] = 0; 
          } 
          else 
          { // for all other items...
              // choose a random pointer to the segment of the
              // array already containing items
              int pointer = randomNumbers4.nextInt(q + 1);
              randomSequence4[q] = randomSequence4[pointer]; 
              randomSequence4[pointer] = q;
          } // end if...else
      } // end for
      
      int y = 0;
      int bin1counter =0;
      int bin2counter =0;
      int bin3counter = 0;
      int bin4counter = 0;
      
      int clust1=0;
      int clust2=0;
      int clust3 =0;
      int clust4 = 0;
      
     while( y<25)
     {
    	 if(y == 24)
    	 {
        	 ChromosomeClust1.add(bin1[randomSequence[bin1counter]]);
        	 bin1counter++;
        	 clust1++;
        	 ChromosomeClust2.add(bin2[randomSequence1[bin2counter]]);
        	 bin2counter++;
        	 clust2++;
        	 ChromosomeClust3.add(bin3[randomSequence2[bin3counter]]);
        	 bin3counter++;
        	 clust3++;
        	 ChromosomeClust4.add(bin4[randomSequence3[bin4counter]]);
        	 bin4counter++;
        	 clust4++;
        	 y++;
    	 }
    	 else
    	 {
    		 ChromosomeClust1.add(bin1[randomSequence[bin1counter]]);
    		 bin1counter++;
    		 clust1++;
    		 ChromosomeClust1.add(bin2[randomSequence1[bin2counter]]);
    		 bin2counter++;
    		 clust1++;
    		 ChromosomeClust1.add(bin3[randomSequence2[bin3counter]]);
    		 bin3counter++;
    		 clust1++;
    		 ChromosomeClust1.add(bin4[randomSequence3[bin4counter]]);
    		 bin4counter++;
    		 clust1++;
    		 y++;
    	 
    		 ChromosomeClust2.add(bin1[randomSequence[bin1counter]]);
    		 bin1counter++;
    		 clust2++;
    		 ChromosomeClust2.add(bin2[randomSequence1[bin2counter]]);
    		 bin2counter++;
    		 clust2++;
    		 ChromosomeClust2.add(bin3[randomSequence2[bin3counter]]);
    		 bin3counter++;
    		 clust2++;
    		 ChromosomeClust2.add(bin4[randomSequence3[bin4counter]]);
    		 bin4counter++;
    		 clust2++;
    		 y++;
    		 ChromosomeClust3.add(bin1[randomSequence[bin1counter]]);
    		 bin1counter++;
    		 clust3++;
    		 ChromosomeClust3.add(bin2[randomSequence1[bin2counter]]);
    		 bin2counter++;
    		 clust3++;
    		 ChromosomeClust3.add(bin3[randomSequence2[bin3counter]]);
    		 bin3counter++;
    		 clust3++;
    		 ChromosomeClust3.add(bin4[randomSequence3[bin4counter]]);
    		 bin4counter++;
    		 clust3++;
    		 y++;
    		 ChromosomeClust4.add(bin1[randomSequence[bin1counter]]);
    		 bin1counter++;
    		 clust4++;
    		 ChromosomeClust4.add(bin2[randomSequence1[bin2counter]]);
    		 bin2counter++;
    		 clust4++;
    		 ChromosomeClust4.add(bin3[randomSequence2[bin3counter]]);
    		 bin3counter++;
    		 clust4++;
    		 ChromosomeClust4.add(bin4[randomSequence3[bin4counter]]);
    		 bin4counter++;
    		 clust4++;
    		 y++;
    	 }
    	 
     }
      
	}
	
	
}
