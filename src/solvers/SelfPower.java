package solvers;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class SelfPower extends EulerSolver
{
  @Override
  public void main()
  {
    printExample(solve(10));
    printSolution(solve(1000));
  }

  private String solve(int limit)
  {
    String answer =  getSumOfSelfPowers(limit).toString();
    log(answer);
    return answer.substring(answer.length() - 10);
  }

  private BigDecimal getSumOfSelfPowers(int limit)
  {
    return Stream.iterate(1,n -> n+1).limit(limit).map(x -> new BigDecimal(x).pow(x)).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
  }
}
