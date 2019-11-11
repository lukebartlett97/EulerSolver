import solvers.*;

public class Main
{
  private static final boolean VERBOSE = true;
  public static void main(String[] args) throws IllegalAccessException, InstantiationException
  {
    solveEuler(CoinSums.class);
  }

  private static void solveAllEuler() throws InstantiationException, IllegalAccessException
  {
    solveEuler(Multiples3and5.class);
    solveEuler(EvenFibonacci.class);
    solveEuler(LargestPrimeFactor.class);
    solveEuler(LargestPalindrome.class);
    solveEuler(SmallestMultiple.class);
    solveEuler(SumSquareDifference.class);
    solveEuler(LargePrime.class);
    solveEuler(LargestProductInSeries.class);
    solveEuler(PythagoreanTriplet.class);
    solveEuler(SumOfPrimes.class);
    solveEuler(LargeFibonnacci.class);
    solveEuler(PowerOfTwoSum.class);
    solveEuler(LargeSum.class);
    solveEuler(LargestProductGrid.class);
    solveEuler(MaxTrianglePath.class);
    solveEuler(SelfPower.class);
    solveEuler(LatticePaths.class);
    solveEuler(CoinSums.class);
  }

  private static void solveEuler(Class solverClass) throws IllegalAccessException, InstantiationException
  {
    EulerSolver solver = (EulerSolver) solverClass.newInstance();
    solver.main(VERBOSE);
  }
}
