package com.inplace.zombie;

import org.junit.Test;

public class Zombie {
    //current only has either
    public int[][] nextState(int[][] current, int N, int M){
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                current[i][j] = getNext(current, i, j);


        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                current[i][j] = decode(current[i][j]);

        return current;
    }

    private int decode(int x){
        return x/10;
    }

    private int getNext(int[][] arr, int i, int j){
        int current = arr[i][j];
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1},
                        {1,1}, {-1,-1}, {-1,1} ,{1,-1}};
        int total=0;
        for(int[] dir: dirs){
            int I = i+dir[0];
            int J= j+dir[1];
            if(I>=0 && I<arr.length && J>=0 && J<arr.length)
                total += arr[I][J]%10;
        }
        return getNextFromTotal(arr[i][j], total);
    }

    private int getNextFromTotal(int current, int total){
        current = current%10;
        if(current==1){
            if(total==2||total==3)
                return 11;
            return 1;
        }
        if(total==3)
            return 10;
        return 0;
    }

    @Test
    public void test2(){
        int[][] test = {{1,0,1},
                        {1,1,0}};
        test = nextState(test, 2,3);
        for (int[] row: test) {
            for (int cell : row)
                System.out.print(cell + "\t");
            System.out.println();
        }
    }

}
