package solvers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoinSums extends EulerSolver
{
  int[] coins = new int[] {200,100,50,20,10,5,2,1};
  @Override
  public void main()
  {
    printSolution(solve(200));
  }

  private int solve(int limit)
  {
      return solveInner(Arrays.stream(coins).boxed().collect(Collectors.toList()), limit, new StringBuilder());
  }

  private int solveInner(List<Integer> coins, int limit, StringBuilder sb)
  {
    int ret = 0;
    while(!coins.isEmpty())
    {
      Integer coin = coins.get(0);
      int diff = limit - coin;
      if(diff > 0)
      {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(coin).append(" ");
        List<Integer> coins2 = new ArrayList<>(coins);
        ret += solveInner(coins2, diff, sb2);
      }
      else if(diff == 0)
      {

        log(sb.toString() + " " + coin);
        ret += 1;
      }
      coins.remove(0);
    }
    return ret;
  }
}
