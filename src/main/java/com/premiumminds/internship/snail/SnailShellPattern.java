package com.premiumminds.internship.snail;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    final int[][] m = matrix;
    Callable<int[]> task = new Callable<int[]>()  {
      @Override
      public int[] call() throws Exception {
        int[] result = Arrays.copyOf(m[0], m.length*m[0].length);
        int x1; int y2;
        int index = m.length;
        // iterate over 2 sides of the martix
        // i represents the number of values in each side
        for (int i = m.length-1; i>0; i--){ 
          // if the direction of those sides is down and left
          if (i%2 != m.length%2){ 
            x1 = (i + m.length -1)/2; // when moving horizontally, x is constant
            // then iterate over the y values to go down
            for (int y1 = x1-i+1; y1 <= x1; y1++) {
              result[index] = m[y1][x1];
              index++;
            } 
            y2 = x1; // when moving vertically, y is constant
            // then iterate over the x values to go left
            for (int x2 = y2 - 1; x2 >= y2-i; x2--) {
              result[index] = m[y2][x2];
              index++;
            }
          } else { // if the direction of those sides is up and right
            x1 = ((m.length - i) -2)/2; // when moving horizontally, x is constant
            // then iterate over the y values to go up
            for (int y1 = x1 + i; y1 >= x1 + 1; y1--) {
              result[index] = m[y1][x1];
              index++;
            }
            y2 = x1+1;  // when moving vertically, y is constant
            // then iterate over the x values to go right
            for (int x2 = y2; x2 <= y2+i-1; x2++) {
              result[index] = m[y2][x2];
              index++;
            }
          }
        }
        return result;
      }
    };
    Future<int[]> result = executor.submit(task);
    executor.shutdown();
    return result; 
  };
  
}
