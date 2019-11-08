package solvers;

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

  public void log(String message)
  {
    if(verbose)
    {
      System.out.println(this.getClass().getSimpleName() + " - Log: " + message);
    }
  }
}
