import java.util.ArrayList;
import java.util.Random;

public class Chromosome {
	
	char Matrix [][];
	private int Rows;
	private int Columns;
	private int Combinations;
	private String longestSequence;
	private int score;
	
	public Chromosome(int rows,int columns)
	{
		Matrix = new char[rows][columns];
		Rows = rows;
		Columns = columns;
		
		for(int i =0 ; i< Rows ; i++)
		{
			for(int j = i+1 ; j < Rows ; j++)
			{
				Combinations = Combinations+1;
			}
		}
	}
	
	public Chromosome()
	{
		
	}
	
	public void Initialization(char Array[] ,int rows , int columns)
	{
		int pointer = 0;
		for(int n =0 ; n < rows ; n++)
		{
			for(int m = 0 ; m < columns ; m++)
			{
				this.Matrix[n][m] = '2';
			}
		}
		

		int tempArray [] = new int[columns];
		
        int size = columns;


        
        for(int j = 0; j<rows ; j++)
        {
        	int h=0;
            ArrayList<Integer> list = new ArrayList<Integer>(size);
            for(int i = 0; i < size; i++) {
                list.add(i);
            }
            Random rand = new Random();
            while(list.size() > 0) {
                int index = rand.nextInt(list.size());
                tempArray[h]=list.remove(index);  
                h++;
            }
            
        /*    for(int f = 0; f<tempArray.length ; f++)
            {
            	int temp=0;
            	for(int q = 0 ; q<tempArray.length-1 ; q++)
            	{
            		if(tempArray[q] > tempArray[q+1])
            		{
            			temp = tempArray[q+1];
            			tempArray[q+1] = tempArray[q];
            			tempArray[q] = temp;
            		}
            	}
            }
    	*/
            
            int start = pointer;
            int tempLength = 0;
           while(Array[start] != '2')
           {
        	   tempLength++;
        	   start++;
           }
           
           int ArrayPositions[] = new int[tempLength];
           
           for(int r = 0 ; r < tempLength ; r++)
           {
        	   ArrayPositions[r] = tempArray[r];
           }    
           
           
           for(int f = 0; f<ArrayPositions.length ; f++)
           {
        	   int temp=0;
        	   for(int q = 0 ; q<ArrayPositions.length-1 ; q++)
        	   {
        		   if(ArrayPositions[q] > ArrayPositions[q+1])
        		   {
        			   temp = ArrayPositions[q+1];
        			   ArrayPositions[q+1] = ArrayPositions[q];
        			   ArrayPositions[q] = temp;
        		   }
        	   }
           }
           
           
           
           
            
            for(int  b=0 ; Array[pointer] != '2' ; b++)
            {
            	int pos = ArrayPositions[b];
            	this.Matrix[j][pos] = Array[pointer];
            	pointer++;
            }
            pointer++;
                   	
        }	
        this.score = this.calculateScore();
	}
	
	public int calculateScore()
	{
		int i = 0;
		int j = 0;
		int k = 0;		
		int gapCost = 0;
		int subsCost = 0;
		BlossumMatrix obj = new BlossumMatrix();
		
		while(i < Rows)
		{
			j=i+1;
			while(j < Rows)
			{
				k =0;
				while(k < Columns)
				{
					if(this.Matrix[i][k] !='2' && this.Matrix[j][k] !='2')
					{
						int indice1 = obj.getIndices(this.Matrix[i][k]);
						int indice2 = obj.getIndices(this.Matrix[j][k]);
						subsCost = subsCost + obj.getScore(indice1, indice2);
					}
					
					else if(this.Matrix[i][k] == '2' && this.Matrix[j][k] == '2')
					{
						gapCost = gapCost;
					}
				
					else if(this.Matrix[i][k] == '2' && this.Matrix[j][k] != '2' && k-1 == -1 )
					{
						gapCost = gapCost - 1;
					}
					
					else if(this.Matrix[i][k] != '2' && this.Matrix[j][k] == '2' && k-1 == -1 )
					{
						gapCost = gapCost - 1;
					}
					
					else if(this.Matrix[i][k] == '2' && this.Matrix[j][k] != '2' )
					{
						if(this.Matrix[i][k-1] != '2' && this.Matrix[j][k-1] != '2')
						{
							gapCost = gapCost - 1;
						}
						else if(this.Matrix[i][k-1] != '2' && this.Matrix[j][k-1] == '2')
						{
							gapCost = gapCost - 1;
						}
						else if(this.Matrix[i][k-1] == '2' && this.Matrix[j][k-1] == '2')
						{
							gapCost = gapCost - 1;
						}
						else
						{
							gapCost = gapCost;
						}
					}
					
					else if(this.Matrix[i][k] != '2' && this.Matrix[j][k] == '2' )
					{
						if(this.Matrix[i][k-1] != '2' && this.Matrix[j][k-1] != '2')
						{
							gapCost = gapCost - 1;
						}
						else if(this.Matrix[i][k-1] == '2' && this.Matrix[j][k-1] != '2')
						{
							gapCost = gapCost - 1;
						}
						else if(this.Matrix[i][k-1] == '2' && this.Matrix[j][k-1] == '2')
						{
							gapCost = gapCost - 1;
						}
						else
						{
							gapCost = gapCost;
						}
					}	
					k=k+1;
				}
				j = j + 1;
				Combinations = Combinations +1;
			}
			i = i + 1;
		}
		this.score = subsCost+gapCost;
		return subsCost + gapCost;
	}
	
	
	public void printing()
	{
		for(int h = 0 ; h <this.Rows; h++)
		{
			for(int u =0 ; u< this.Columns ; u++)
			{
				if(this.Matrix[h][u] == '2')
				{
					System.out.print("-");
					System.out.print(" ");
				}
				else
				{
					System.out.print(this.Matrix[h][u]);
					System.out.print(" ");
				}

			}
			System.out.println();
			
		}

	}
	
	public int getRows()
	{
		return this.Rows;
	}
	
	public int getColumns()
	{
		return this.Columns;
	}
	
	public int getCombinations()
	{
		return this.Combinations;
	}
	
	public String getlongestSequence()
	{
		return this.longestSequence;
	} 
	public void setRows(int rows)
	{
		 this.Rows = rows;
	}
	
	public void setColumns(int columns)
	{
		this.Columns = columns;
	}
	
	public void setCombinations(int combinations)
	{
		this.Combinations = combinations;
	}
	
	public void setlongestSequence(String lsequence)
	{
		 this.longestSequence = lsequence;
	} 
	
	public int getscore()
	{
		return this.score;
	}
	
    public char[][] getMatrix()
    {
    	return this.Matrix;
    }
    
    public void setMatrix(char matrix[][])
    {
    	this.Matrix = matrix;
    }
}
