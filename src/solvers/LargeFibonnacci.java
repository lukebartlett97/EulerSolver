package solvers;

import java.math.BigDecimal;
//PROBLEM 25
//The Fibonacci sequence is defined by the recurrence relation:
//Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
//Hence the first 12 terms will be:
//F1 = 1
//F2 = 1
//F3 = 2
//F4 = 3
//F5 = 5
//F6 = 8
//F7 = 13
//F8 = 21
//F9 = 34
//F10 = 55
//F11 = 89
//F12 = 144
//The 12th term, F12, is the first term to contain three digits.
//What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
public class LargeFibonnacci extends EulerSolver
{

  @Override
  public void main()
  {
    printExample(getIndexOfFibonnacciWithDigits(3));
    printSolution(getIndexOfFibonnacciWithDigits(1000));
  }

  int getIndexOfFibonnacciWithDigits(int digits)
  {
    int index = 2;
    BigDecimal val1 = BigDecimal.ONE;
    BigDecimal val2 = BigDecimal.ONE;
    BigDecimal temp;
    while(val2.toString().length() < digits)
    {
      temp = val2;
      val2 = val2.add(val1);
      val1 = temp;
      index++;
    }
    log("Value = " + val2.toString());
    return index;
  }
}
