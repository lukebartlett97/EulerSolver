package solvers;

//PROBLEM 4
//A palindromic number reads the same both ways.
//The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//Find the largest palindrome made from the product of two 3-digit numbers.
public class LargestPalindrome extends EulerSolver
{
  @Override
  public void main()
  {
    printExample(bruteForce(100));
    printSolution(bruteForce(1000));
  }

  public long bruteForce(int limit)
  {
    long largest = 0L;
    for (int i = 1; i < limit; i++)
    {
      for (int j = i; j < limit; j++)
      {
        long product = i*j;
        if(product > largest)
        {
          String forward = Long.toString(product);
          StringBuffer backward = new StringBuffer(forward);
          backward.reverse();
          if (backward.toString().equals(forward))
          {
            largest = product;
          }
        }
      }

    }
    return largest;
  }
}
