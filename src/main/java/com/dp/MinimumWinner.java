package com.dp;

import org.junit.Test;

public class MinimumWinner {

    //choose one of the ends alternatively -- min sum wins
    public int getBalance(int[] inputs){
        // min( a(i)-sol(i+1, j), a(j)-sol(i, j-1) )
        //

        int[][] solution = new int[inputs.length][inputs.length];
        for(int i=0; i<inputs.length; i++)
            solution[i][i]=inputs[i];

        for(int j=1; j<solution.length; j++) {
            int k = 0;
            while (j + k < inputs.length){
                solution[k][j + k] = min(inputs[k] - solution[k + 1][j + k], inputs[j + k] - solution[k][j + k - 1]);
                k++;
            }
        }
        return solution[0][inputs.length-1];

    }
    private int min(int a, int b){
        return a>b?b:a;
    }
    
    @Test
    public  void test(){
        int input[] = {2,5,3,1,4};
        int x = getBalance(input);
        System.out.println(x);
    }
}