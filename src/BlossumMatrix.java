import java.util.Hashtable;


public class BlossumMatrix {
	
	int blossummatrix[][] = {{9,-1,-1,-3,0,-3,-3,-3,-4,-3,-3,-3,-3,-1,-1,-1,-1,-2,-2,-2},
			                 {-1,4,1,-1,1,0,1,0,0,0,-1,-1,0,-1,-2,-2,-2,-2,-2,-3},
			                 {-1,1,5,-1,0,-2,0,-1,-1,-1,-2,-1,-1,-1,-1,-1,0,-2,-2,-2},
			                 {-3,-1,-1,7,-1,-2,-2,-1,-1,-1,-2,-2,-1,-2,-3,-3,-2,-4,-3,-4},
			                 {0,1,0,-1,4,0,-2,-2,-1,-1,-2,-1,-1,-1,-1,-1,0,-2,-2,-3},
			                 {-3,0,-2,-2,0,6,0,-1,-2,-2,-2,-2,-2,-3,-4,-4,-3,-3,-3,-2},
			                 {-3,1,0,-2,-2,0,6,1,0,0,1,0,0,-2,-3,-3,-3,-3,-2,-4},
			                 {-3,0,-1,-1,-2,-1,1,6,2,0,-1,-2,-1,-3,-3,-4,-3,-3,-3,-4},
			                 {-4,0,-1,-1,-1,-2,0,2,5,2,0,0,1,-2,-3,-3,-2,-3,-2,-3},
			                 {-3,0,-1,-1,-1,-2,0,0,2,5,0,1,1,0,-3,-2,-2,-3,-1,-2},
			                 {-3,-1,-2,-2,-2,-2,1,-1,0,0,8,0,-1,-2,-3,-3,-3,-1,2,-2},
			                 {-3,-1,-1,-2,-1,-2,0,-2,0,1,0,5,2,-1,-3,-2,-3,-3,-2,-3},
			                 {-3,0,-1,-1,-1,-2,0,-1,1,1,-1,2,5,1,-3,-2,-2,-3,-2,-3},
			                 {-1,-1,-1,-2,-1,-3,-2,-3,-2,0,-2,-1,1,5,1,2,1,0,-1,-1},
			                 {-1,-2,-1,-3,-1,-4,-3,-3,-3,-3,-3,-3,-3,1,4,2,3,0,-1,-3},
			                 {-1,-2,-1,-3,-1,-4,-3,-4,-3,-2,-3,-2,-2,2,2,4,1,0,-1,2},
			                 {-1,-2,0,-2,0,-3,-3,-3,-2,-2,-3,-3,-2,1,3,1,4,-1,-1,-3},
			                 {-2,-2,-2,-4,-2,-3,-3,-3,-3,-3,-1,-3,-3,0,0,0,-1,6,3,1},
			                 {-2,-2,-2,-3,-2,-3,-2,-3,-2,-1,2,-2,-2,-1,-1,-1,-1,3,7,2},
			                 {-2,-3,-2,-4,-3,-2,-4,-4,-3,-2,-2,-3,-3,-1,-3,-2,-3,1,2,11}
	                        };
	Hashtable<Character, Integer> indices
	     = new Hashtable<Character, Integer>();
	
	public BlossumMatrix()
	{
		indices.put('C', 0);
		indices.put('S', 1);
		indices.put('T', 2);
		indices.put('P', 3);
		indices.put('A', 4);
		indices.put('G', 5);
		indices.put('N', 6);
		indices.put('D', 7);
		indices.put('E', 8);
		indices.put('Q', 9);
		indices.put('H', 10);
		indices.put('R', 11);
		indices.put('K', 12);
		indices.put('M', 13);
		indices.put('I', 14);
		indices.put('L', 15);
		indices.put('V', 16);
		indices.put('F', 17);
		indices.put('Y', 18);
		indices.put('W', 19);
		indices.put('c', 0);
		indices.put('s', 1);
		indices.put('t', 2);
		indices.put('p', 3);
		indices.put('a', 4);
		indices.put('g', 5);
		indices.put('n', 6);
		indices.put('d', 7);
		indices.put('e', 8);
		indices.put('q', 9);
		indices.put('h', 10);
		indices.put('r', 11);
		indices.put('k', 12);
		indices.put('m', 13);
		indices.put('i', 14);
		indices.put('l', 15);
		indices.put('v', 16);
		indices.put('f', 17);
		indices.put('y', 18);
		indices.put('w', 19);		
	}
	
	public void PrintMatrix()
	{	
		for(int i = 0; i<20;i++)
		{
			for(int j = 0 ; j<20 ; j++)
			{
				System.out.print(this.blossummatrix[i][j]);
			}
			System.out.println();
		}				
	}
	
	public int getIndices(char a)
	{
		Integer n = this.indices.get(a);
		return n;
	}
	
	public int getScore(int indice1 ,int indice2)
	{
		return this.blossummatrix[indice1][indice2];
	}

	public int CalculateMatrixScore(char Matrix[][] , int Rows , int Columns)
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
					if(Matrix[i][k] !='2' && Matrix[j][k] !='2')
					{
						int indice1 = obj.getIndices(Matrix[i][k]);
						int indice2 = obj.getIndices(Matrix[j][k]);
						subsCost = subsCost + obj.getScore(indice1, indice2);
					}
					
					else if(Matrix[i][k] == '2' && Matrix[j][k] == '2')
					{
						gapCost = gapCost;
					}
				
					else if(Matrix[i][k] == '2' && Matrix[j][k] != '2' && k-1 == -1 )
					{
						gapCost = gapCost - 1;
					}
					
					else if(Matrix[i][k] != '2' && Matrix[j][k] == '2' && k-1 == -1 )
					{
						gapCost = gapCost - 1;
					}
					
					else if(Matrix[i][k] == '2' && Matrix[j][k] != '2' )
					{
						if(Matrix[i][k-1] != '2' && Matrix[j][k-1] != '2')
						{
							gapCost = gapCost - 1;
						}
						else if(Matrix[i][k-1] != '2' && Matrix[j][k-1] == '2')
						{
							gapCost = gapCost - 1;
						}
						else if(Matrix[i][k-1] == '2' && Matrix[j][k-1] == '2')
						{
							gapCost = gapCost - 1;
						}
						else
						{
							gapCost = gapCost;
						}
					}
					
					else if(Matrix[i][k] != '2' && Matrix[j][k] == '2' )
					{
						if(Matrix[i][k-1] != '2' && Matrix[j][k-1] != '2')
						{
							gapCost = gapCost - 1;
						}
						else if(Matrix[i][k-1] == '2' && Matrix[j][k-1] != '2')
						{
							gapCost = gapCost - 1;
						}
						else if(Matrix[i][k-1] == '2' && Matrix[j][k-1] == '2')
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
			}
			i = i + 1;
		}
		
		return subsCost + gapCost;
	}
}
