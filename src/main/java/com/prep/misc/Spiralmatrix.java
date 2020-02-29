package com.prep.misc;

import org.junit.Test;

public class Spiralmatrix {

    @Test
    public void test(){
        int[][] test={{1, 2, 3}, {4, 5, 6}};
        print(test, 0, 0, 2, 3);
    }

    public void print(int[][] arr, int I, int J, int depth, int width){
        if(depth<1 || width<1) return;
        int x=I, y=J;
        System.out.print(arr[I][J]+"\t");
        for(y=J+1;y<J+width-1;y++){
            System.out.print(arr[x][y]+"\t");
        }
        y=J+width-1;
        if(width>1)
            System.out.print(arr[I][J+width-1]+"\t");
        for(x=I+1; x<I+depth-1; x++){
            System.out.print(arr[x][J+width-1]+"\t");
        }
        if(depth>1 && width>1)
            System.out.print(arr[I+depth-1][J+width-1]+"\t");
        x=I+depth-1;
        for(y=J+width-2; y>J; y--){
            System.out.print(arr[I+depth-1][y]+"\t");
        }
        if(depth>1)
            System.out.print(arr[I+depth-1][J]+"\t");
        for(x=I+depth-2; x>I; x--){
            System.out.print(arr[x][J]+"\t");
        }
        print(arr, I+1, J+1, depth-2, width-2);
    }
}
