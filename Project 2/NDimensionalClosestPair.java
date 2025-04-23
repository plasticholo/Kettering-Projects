import java.util.*;
// Will Erickson
// CS-203
// Winter 2025


public class NDimensionalClosestPair 
{
    public static void main(String[] args) 
    {
        //Scanner to read number of points input as well as number of dimensions
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of points");
        int num_points = scan.nextInt();

        //exits if num_points is <2
        if(num_points <2)
        {
            System.out.println("Must have at least two points");
            return;
        }
    
        System.out.println("Enter the number of dimensions");
        int num_dimensions = scan.nextInt();

        //exits if num_dimensions <1
        if(num_dimensions<1)
        {
            System.out.println("Must have at least 1 dimension");
            return;
        }

        //initializing variables to be used for random placement of points
        Random random = new Random();
        double[][] points = new double[num_points][num_dimensions];

        //randomly places points
        for(int i=0; i<num_points; i++)
        {
            for (int j=0; j<num_dimensions; j++) 
            {
                points[i][j] = random.nextDouble()*1000;
            }
        }

        //Starts timer to time execution
        long  startTime = System.nanoTime();

        //calls recursive function to solve problem
        double[] result = closestPair(points, 0, num_points-1, num_dimensions);

        //Ends timer
        long endTime = System.nanoTime();
        
        //Prints solution as well as execution time
        System.out.println("Closest pair distance: " + result[0]);
        System.out.println("Execution Time: " + (endTime-startTime)+ " ns");

        //closes scanner
        scan.close();
    }


    //Recursive function to find the closest points (Using the Divide and Conquer method)
    public static double[] closestPair(double[][] points, int left, int right, int num_dimensions)
    {
        //Base case to end recursion
        if(right - left <= 3)
        {
            //sets minDistance to a high value so that it does not conflict
            double minDistance = Double.MAX_VALUE;

            //iterates through each point
            for(int i = left; i<=right; i++)
            {
                for(int j=i+1; j<=right; j++)
                {
                    //calculates distance
                    double distance = findDistance(points[i], points[j]);

                    //checks if this is the new smallest distance
                    if(distance<minDistance)
                    {
                        minDistance=distance;
                    }
                }
            }

            //returns the minimum distance
            return new double[]{minDistance};
        }

        //calculates middle
        int middle = (left+right)/2;

        //recursive calls for left then right halves
        double[] leftResult = closestPair(points, left, middle, num_dimensions);
        double[] rightResult = closestPair(points, middle+1, right, num_dimensions);

        //determines the smaller distance between left and right
        double minDist = Math.min(leftResult[0], rightResult[0]);

        //checks possible close pairs between the two halves
        for(int i=left; i <=middle; i++)
        {
            for(int j=middle+1; j <= right; j++)
            {
                //calculates distance
                double distance = findDistance(points[i], points[j]);
                
                //checks if this is the new smallest distance
                if(distance<minDist)
                {
                    minDist=distance;
                }
            }
        }

        //returns the minimum distance
        return new double[]{minDist};
    }

    //Fuction to find the distance between two points (Euclidean Distance) 
    public static double findDistance(double[] point1, double[] point2)
    {
        double sum=0;

        //iterates through each dimension
        for(int i=0; i<point1.length; i++)
        {
            sum += Math.pow(point1[i]-point2[i],2);
        }
        return Math.sqrt(sum);
    }
}
