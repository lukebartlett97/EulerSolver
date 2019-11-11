package solvers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LatticePaths extends EulerSolver
{

  @Override
  public void main()
  {
    printExample(solve(2));
    printSolution(solve(20));
  }

  private String solve(int limit)
  {
    List<List<BigDecimal>> square = prepareSquare(limit+1);
    for(int i = 1; i <= limit; i++)
    {
      for(int j = 1; j <= limit; j++)
      {
        square.get(i).add(square.get(i).get(j-1).add(square.get(i-1).get(j)));
      }
    }
    log("\n" + bigDecimalListToString(square));
    return square.get(limit).get(limit).toString();
  }

  private List<List<BigDecimal>> prepareSquare(int limit)
  {
    List<List<BigDecimal>> square = new ArrayList<>();
    List<BigDecimal> firstLine = new ArrayList<>();
    for(int i = 0; i<limit; i++)
    {
      firstLine.add(BigDecimal.ONE);
    }
    square.add(firstLine);
    for(int i = 0; i<limit-1; i++)
    {
      List<BigDecimal> otherLine = new ArrayList<>();
      otherLine.add(BigDecimal.ONE);
      square.add(otherLine);
    }
    log("\n" + bigDecimalListToString(square));
    return square;
  }
}
