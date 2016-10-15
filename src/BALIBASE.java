
public class BALIBASE {
	
	public BALIBASE()
	{
		
	}
	
	public double Bali_Score(char [][] testAlign ,int testAlignColumn , char [][] refferenceAlign , int refferenceAlignColumn , int Rows)
	{
		System.out.println("Refference Align");
		
		for(int h = 0 ; h <Rows; h++)
		{
			for(int u =0 ; u< refferenceAlignColumn ; u++)
			{

					System.out.print(refferenceAlign[h][u]);
					System.out.print(" ");
				

			}
			System.out.println();
			
		}
		
		System.out.println("Test Align");
		
		for(int h = 0 ; h <Rows; h++)
		{
			for(int u =0 ; u< testAlignColumn ; u++)
			{

					System.out.print(testAlign[h][u]);
					System.out.print(" ");
			}
			System.out.println();
			
		}
		double Bali_ScoreSP = 0;
		
		int gt = (Rows*20)/100;
		int TotalSi = 0;
		int TotalSir = 0;
		System.out.println("GT");
		System.out.println(gt);
		for(int r = 0 ; r < refferenceAlignColumn ; r++)
		{
			int temprc = 0;
			int gaps = 0;
			System.out.println("Gap intialiazation value");
			System.out.println(gaps);
			while(temprc < Rows)
			{
				if(refferenceAlign[temprc][r] == '2')
				{
					gaps= gaps+1;
					System.out.println("Gap incrementing");
					System.out.println(gaps);
					System.out.println(refferenceAlign[temprc][r]);
				}
				temprc++;
			}
			System.out.println("Gap");
			System.out.println(gaps);
			if(gaps < gt)
			{
				for(int p = 0 ; p < Rows ; p++)
				{
					for(int q=p+1 ; q < Rows ; q++)
					{
						if(testAlign[p][r] == refferenceAlign[p][r] && testAlign[q][r] == refferenceAlign[q][r])
						{
							if(testAlign[p][r] != '2' && testAlign[q][r] != '2')
							{
							 	TotalSi++;
							}
						}
						if(refferenceAlign[p][r] != '2' && refferenceAlign[q][r] != '2')
						{
							TotalSir = TotalSir + 1;
						}
						
					}
				}
			}
			
			System.out.println("TotalSi");
			System.out.println(TotalSi);
			
			System.out.println("TotalSir");
			System.out.println(TotalSir);
		}
		Bali_ScoreSP = TotalSi/TotalSir;
		return Bali_ScoreSP;
	}

}
