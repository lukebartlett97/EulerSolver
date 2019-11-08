package solvers;

import java.util.Arrays;
//PROBLEM 9
//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//a2 + b2 = c2
//For example, 32 + 42 = 9 + 16 = 25 = 52.
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.
public class PythagoreanTriplet extends EulerSolver
{
  @Override
  public void main()
  {
    printExample(getTripletProduct(12));
    printSolution(getTripletProduct(1000));
  }

  private int getTripletProduct(int sum)
  {
    return Arrays.stream(getTriplet(sum)).reduce(1, (x, y) -> x*y);
  }

  private int[] getTriplet(int sum)
  {
    for(int a = 1; a < sum; a++)
    {
      int bLimit = (sum - a + 1) / 2;
      for(int b = a + 1; b < bLimit; b++)
      {
        int c = sum - a - b;
        if(a*a + b*b == c*c)
        {
          log("Found triplet for limit " + sum + ": " + a + ", " + b + ", " + c);
          return new int[] {a, b, c};
        }
      }
    }
    return new int[0];
  }


}
