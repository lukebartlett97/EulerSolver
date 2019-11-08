package solvers;

import java.util.ArrayList;
import java.util.List;
//PROBLEM 10
//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//Find the sum of all the primes below two million.
public class SumOfPrimes extends EulerSolver
{
  @Override
  public void main()
  {
    printExample(findPrimeSum(10));
    printExample(findPrimeSum(10_000));
    printSolution(findPrimeSum(2_000_000));
  }

  private static long findPrimeSum(int limit)
  {
    int counter = 3;
    long acc = 2;
    List<Integer> primes = new ArrayList<>();
    primes.add(2);
    while(counter < limit)
    {
      boolean isPrime = true;
      for(Integer prime : primes)
      {
        if(counter % prime == 0)
        {
          isPrime = false;
          break;
        }
      }
      if(isPrime)
      {
        primes.add(counter);
        acc += isPrime ? counter : 0;
      }
      counter+= 2;
    }
    return acc;
  }
}
