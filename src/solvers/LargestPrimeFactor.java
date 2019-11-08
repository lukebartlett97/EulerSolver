package solvers;

//PROBLEM 3
//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?
public class LargestPrimeFactor extends EulerSolver
{
  @Override
  public void main()
  {
    printExample(findLargestPrime(13195L));
    printSolution(findLargestPrime(600851475143L));
  }

  private long findLargestPrime(long num)
  {
    int counter = 2;
    while(counter < num)
    {
      if(num % counter == 0)
      {
        num = num / counter;
        counter = 1;
      }
      counter++;
    }
    return num;
  }
}
