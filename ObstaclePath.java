// A Java program to count all possible paths
// from top left to bottom right
class ObstaclePath{

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] path = new int[m][n];
		
		System.out.print("Fist Column : ");
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1)  {
				path[i][0] = 0;
				//on the first column, if there is an obstacle, the rest are blocked. 
				//no need to continue.
				break;  
			} else
				path[i][0] = 1;
				System.out.print("  Grid ["+i+"]["+0+"]="+path[i][0]  );
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.print("First Row: ");
		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 1)  {
				path[0][j] = 0;
				//First row, once obstacle found, the rest are blocked.
				break; 
			} else
				path[0][j] = 1;
				System.out.print("   Grid["+0+"]["+j+"]="+path[0][j]  );
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("The matrix in the bottom right of First column and First row.");
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) 
					path[i][j] = 0;
				else
					path[i][j] = path[i-1][j] + path[i][j-1];  
					//path[i][j] stores the sume of the paths against to the current cell.
					
					System.out.print("   path["+i+"]["+j+"]="+path[i][j]  );
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------");
		return path[m-1][n-1];
	}
 
    public static void main(String args[])

    {
		int[][] grid =  { { 0, 0,0,0 }, { 0, 0,1, 0},{ 0, 0,0,0 }};  //3 x4 matrix. 3 rows and 4 colums.
		
		ObstaclePath zz = new ObstaclePath();
		System.out.println("-------------------------------------------------------------------");
        System.out.println("Number of paths: "+zz.uniquePathsWithObstacles(grid));
    }
}
 
