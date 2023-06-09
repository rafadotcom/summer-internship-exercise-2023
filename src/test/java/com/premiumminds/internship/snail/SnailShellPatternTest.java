package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest1Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { {} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest2Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2 }, { 8, 6 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 6, 8 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest4Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 6, 2, 3, 5 }, 
                       { 8, 9, 4, 0 }, 
                       { 5, 9, 4, 7 },
                       { 7, 1, 5, 3 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 6, 2, 3, 5, 0, 7, 3, 5, 1, 7, 5, 8, 9, 4, 4, 9 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest7Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1 , 2 , 3 , 4 , 5 , 6 , 7 }, 
                       { 24, 25, 26, 27, 28, 29, 8 }, 
                       { 23, 40, 41, 42, 43, 30, 9 }, 
                       { 22, 39, 48, 49, 44, 31, 10 }, 
                       { 21, 38, 47, 46, 45, 32, 11 }, 
                       { 20, 37, 36, 35, 34, 33, 12 }, 
                       { 19, 18, 17, 16, 15, 14, 13 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = new int[49];
    for (int i = 0; i<49; i++) {expected[i]=i+1;}
    assertArrayEquals(result, expected);
  }

  @Test
  public void MatrixChangeTest3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] before = { { 6, 2, 3, 5 }, 
                       { 8, 9, 4, 0 }, 
                       { 5, 9, 4, 7 },
                       { 7, 1, 5, 3 } };
    int[][] after = { { 6, 2, 3, 5 }, 
                      { 8, 9, 4, 0 }, 
                      { 5, 9, 4, 7 },
                      { 7, 1, 5, 3 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(before);
    count.get(10, TimeUnit.SECONDS);
    assertArrayEquals(after, before);
  }

  @Test(timeout = 1000)
  public void ScreenLockinPatternTestNLength2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int n = 15;
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
      matrix[i][j] = 0;
      }
    }
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = new int[n*n];
    for (int i = 0; i<n*n; i++) { expected[i]=0; }
    assertArrayEquals(result, expected);
  }

}