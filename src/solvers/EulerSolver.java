package solvers;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EulerSolver
{
  boolean verbose = false;
  public abstract void main();

  public void main(boolean verbose)
  {
    this.verbose = verbose;
    main();
  }

  public void printSolution(int solution)
  {
    System.out.println("Solution for " + this.getClass().getSimpleName() + " = " + solution);
  }

  public void printExample(int solution)
  {
    System.out.println("Example Solution for " + this.getClass().getSimpleName() + " = " + solution);
  }

  public void printSolution(long solution)
  {
    System.out.println("Solution for " + this.getClass().getSimpleName() + " = " + solution);
  }

  public void printExample(long solution)
  {
    System.out.println("Example Solution for " + this.getClass().getSimpleName() + " = " + solution);
  }

  public void printSolution(String solution)
  {
    System.out.println("Solution for " + this.getClass().getSimpleName() + " = " + solution);
  }

  public void printExample(String solution)
  {
    System.out.println("Example Solution for " + this.getClass().getSimpleName() + " = " + solution);
  }

  public void log(String message)
  {
    if(verbose)
    {
      System.out.println(this.getClass().getSimpleName() + " - Log: " + message);
    }
  }

  protected String intListToString(List<List<Integer>> square)
  {
    List<List<BigDecimal>> bdSquare = square.stream().map(list -> list.stream().map(BigDecimal::new).collect(Collectors.toList())).collect(Collectors.toList());
    return bigDecimalListToString(bdSquare);
  }

  protected String longListToString(List<List<Long>> square)
  {
    List<List<BigDecimal>> bdSquare = square.stream().map(list -> list.stream().map(BigDecimal::new).collect(Collectors.toList())).collect(Collectors.toList());
    return bigDecimalListToString(bdSquare);
  }

  protected String bigDecimalListToString(List<List<BigDecimal>> square)
  {
    StringBuilder sb = new StringBuilder();
    for (List<BigDecimal> row : square)
    {
      for(BigDecimal num : row)
      {
        sb.append(num.toString()).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
