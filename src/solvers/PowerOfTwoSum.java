package solvers;

import java.math.BigDecimal;
import java.util.Arrays;
//PROBLEM 16
//2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//What is the sum of the digits of the number 2^1000?
public class PowerOfTwoSum extends EulerSolver
{

  @Override
  public void main()
  {
    printExample(getSumOfPower(15));
    printSolution(getSumOfPower(1000));
  }

  private int getSumOfPower(int power)
  {
    BigDecimal value = new BigDecimal(2).pow(power);
    return Arrays.stream(mapToIntArray(value.toString().toCharArray())).sum();
  }

  private int[] mapToIntArray(char[] chars)
  {
    int[] longs = new int[chars.length];
    for(int i = 0; i < chars.length; i++)
    {
      longs[i] = Character.getNumericValue(chars[i]);
    }
    return longs;
  }
}
