
public class grawzycie2 {

	public static int lsasiadow(int p, int l, int x, int y, int plan[][]) {
		
		
		int sasiedzi = 0;
			
		for(int i = l-1; i <= l+1; i++) {
				
			if(i < 0 || i > y-1) 
				continue;
			
			for(int j = p-1; j <= p+1; j++) {
				
				if(j < 0 || j > x-1 || (i == l && j == p)) 
					continue;
				
				if(plan[i][j]==1)
					sasiedzi++;
			}
		}
					
		return sasiedzi;
	}


	public static void main(String[] args) {
			
		int plan[][];
		
		int x = 4;
		int y = 4;
		
		int iloscGeneracji = 5;
		
		plan = new int[y][x];
		
		for (int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				plan[i][j]=0;
			}
		}
			
		plan[1][0] = 1;
		plan[2][1] = 1;
		plan[3][1] = 1;
		plan[3][0] = 1;
		plan[1][1] = 1;
		plan[2][3] = 1;
		plan[2][2] = 1;
		
				
		for (int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				System.out.print(plan[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		int plan2[][] = new int [y][x];
		
		for(int k=0;k<iloscGeneracji; k++) {
			for (int i=0; i<y;i++) {
				for (int j=0;j<x;j++) {
					if(plan[i][j]==1) {
						if(lsasiadow(j,i,x,y,plan)==2||lsasiadow(j,i,x,y,plan)==3)
							plan2[i][j]=1;
						else 
							plan2[i][j]=0;
					}
					else {
						if(lsasiadow(j,i,x,y,plan)==3)
							plan2[i][j]=1;
						else 
							plan2[i][j]=0;
					}
				}
			}
			
			plan = plan2;
			
			for (int i=0;i<y;i++) {
				for(int j=0;j<x;j++) {
					System.out.print(plan[i][j]);
				}
				System.out.println();
			}
			
			System.out.println();
		}
	}	
}		
