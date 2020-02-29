package ads.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Search {


    /**
     * ['o','a','a','n'],
     *   ['e','t','a','e'],
     *   ['i','h','k','r'],
     *   ['i','f','l','v']
     * ]
     */
    @Test
    public void test(){
        char[][] test = {{'o','a', 'a', 'n'},{'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};

        NodeX[][] nodes = new NodeX[test.length][test[0].length];
        int i=0, j=0;
        for(char[] row: test) {
            j=0;
            for (char cell : row) {
                nodes[i][j] = new NodeX(cell);
                j++;
            }
            i++;
        }

        boolean found=false;
        String testStr = "rain";
        i=0; j=0;
        for(char[] row: test){
            j=0;
            for(char cell: row){
                if(cell==testStr.charAt(0)){
                    found = find(nodes, i, j, testStr);
                    if(found) break;
                }
                j++;
            }
            if(found) break;
            i++;
        }
        System.out.println(found);
    }

    public boolean find(NodeX[][] arr, int x, int y, String str){
        arr[x][y].isVisited=true;
        if(str.length()==1){
            boolean found = arr[x][y].c ==str.charAt(0);
            arr[x][y].isVisited=false;
            return found;
        }
        if(str.charAt(0)!=arr[x][y].c) {
            arr[x][y].isVisited=false;
            return false;
        }
        String balanceStr = str.substring(1);
        //board edge,
        List<int[]> dirs = new ArrayList<int[]>();
        int[] north = {-1, 0};
        int[] south = {1, 0};
        int[] east = {0, 1};
        int[] west = {0, -1};
        dirs.add(north); dirs.add(south); dirs.add(east); dirs.add(west);

        for(int[] dir: dirs){
            //stay in board
            if(x+dir[0]<0 || x+dir[0]>arr.length-1) continue;
            if(y+dir[1]<0||y+dir[1]>arr.length-1) continue;
            //make sure you don't revisit;
            if(arr[x+dir[0]][y+dir[1]].isVisited) continue;

            if(find(arr, x+dir[0], y+dir[1], balanceStr)) {
                arr[x][y].isVisited=false;
                return true;
            }
        }
        arr[x][y].isVisited=false;
        return false;
    }


}

class NodeX{
    char c;
    boolean isVisited;

    public NodeX(char c){
        this.c=c;
        this.isVisited=false;
    }
}
