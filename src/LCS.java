import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
	
    public LCS() 
    {
    	
    }
    
    
    public void CalculateLongestCsequence(Chromosome Array[])
    {
    	String lcs = "";
    	String lcsfinal = "";
    	int loop = Array.length;
		char temparray1[] = new char[Array[0].getColumns()];
		char temparray2[] = new char[Array[0].getColumns()];
    	for(int y =0 ;  y<loop ; y++)
    	{
    		
    		System.out.println(y);
			Array[y].printing();
			System.out.println("*******************");
    		for(int e = 0; e<Array[0].getColumns() ; e++)
    		{
    			temparray1[e] = '\0';
    			temparray2[e] = '\0';
    		}
    		System.out.println(y);
    		
    		for(int p = 0 ;p < Array[0].getRows() ; p++)
    		{
    			System.out.println(p);    			
    			for(int q=p+1; q < Array[0].getRows();q++)
    			{
    				System.out.println(q);
    				for(int k = 0 ;k < Array[0].getColumns(); k++)
    				{
    					temparray1[k] = Array[y].Matrix[p][k];
    					temparray2[k] = Array[y].Matrix[q][k];
    				}
					String X = new String(temparray1);
					String Y = new String(temparray2); 
					lcs = this.longestCsequence(X,Y);
					if(lcsfinal.length() < lcs.length())
					{
						lcsfinal = lcs;
					}
					else
					{
						lcsfinal = lcsfinal;
					}
			        System.out.println(lcs);
    			}
    		}
    		Array[y].setlongestSequence(lcsfinal);
    		lcsfinal = "";
    	}
    	
//        System.out.println("**********************************************");
//    	
//    	for(int h = 0 ; h< loop ; h++)
//    	{
//	        System.out.println(Array[h].getlongestSequence());
//    	}
    }
     
    public String longestCsequence(String X , String Y)
    {
    	String x = X;
    	String y = Y;
        int M = x.length();
        int N = y.length();

        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        // recover LCS itself and print it to standard output
        String lcs ="";
        int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
            	if(x.charAt(i) == '2')
            	{
            		i++;
            		j++;	
            	}
            	else
            	{
            		lcs += x.charAt(i);
            		i++;
            		j++;
            	}
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        return lcs;
    }

}
