package solvers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//PROBLEM 6
//The sum of the squares of the first ten natural numbers is,
//12 + 22 + ... + 102 = 385
//The square of the sum of the first ten natural numbers is,
//(1 + 2 + ... + 10)2 = 552 = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
public class SumSquareDifference extends EulerSolver

{
  @Override
  public void main()
  {
    printExample(squareDifference(10));
    printSolution(squareDifference(100));
  }

  private long squareDifference(int limit)
  {
    return 2*pairSum(Stream.iterate(1, n -> n+1).limit(limit).collect(Collectors.toList()));
  }

  private long pairSum(List<Integer> numbers)
  {
    if(numbers.isEmpty())
    {
      return 0;
    }
    int first = numbers.remove(0);
    return (first * numbers.stream().mapToInt(Integer::intValue).sum()) + pairSum(numbers);
  }
}
