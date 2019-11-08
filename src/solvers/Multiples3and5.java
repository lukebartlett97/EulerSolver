package solvers;
//PROBLEM 1
//If we list all the natural numbers below 10 that are multiples of 3 or 5,
//we get 3, 5, 6 and 9. The sum of these multiples is 23.
//Find the sum of all the multiples of 3 or 5 below 1000.
public class Multiples3and5 extends EulerSolver
{
  public void main()
  {
    printExample(sumMultiples(10));
    printSolution(sumMultiples(1000));
  }

  public int sumMultiples(int limit)
  {
    int acc = 0;
    for (int i = 1; i < limit; i++)
    {
      if(i%3==0 || i%5==0)
      {
        acc += i;
      }
    }
    return acc;
  }
}
