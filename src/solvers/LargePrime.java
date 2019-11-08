package solvers;

import java.util.ArrayList;
import java.util.List;

//PROBLEM 7
//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//What is the 10,001st prime number?
public class LargePrime extends EulerSolver
{
  @Override
  public void main()
  {
    printExample(getPrime(6));
    printSolution(getPrime(10001));
  }
  private int getPrime(int limit)
  {
    List<Integer> primes = new ArrayList<>();
    int counter = 2;
    while(limit > 0)
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
        limit -= 1;
      }
      counter++;
    }
    return primes.get(primes.size()-1);
  }
}
