package Codelit;

import java.util.ArrayList;
import java.util.List;

public class potd8aug {
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
                    // east    south west north
        int[ ][] coor={{1,0},{0,-1},{-1,0},{0,1}};

List<int[]> ans=new ArrayList<>();
        int steps=0;
        int dir=0;
ans.add(new int[]{rStart,cStart});
while(ans.size()<rows*cols)
{
    if(dir==0 || dir==2)
    {
        steps++;
    }
    for(int count=0;count<steps;count++)
    {
        rStart+=coor[dir][0];
    cStart+=coor[dir][1];

    if(rStart>=0 && rStart< rows && cStart>=0 && cStart<cols)
    {
        ans.add(new int[]{rStart,cStart});
    }
    }
    dir=(dir+1)%4;
}

int[][] fi=new int[rows][cols];
for(int i=0;i<ans.size();i++)
{
//fi[i/rows][i%cols]=new int[]{ans.get(i)[0],ans.get(i)[1]};
}
        return fi;
    }
    public static void main(String[] args) {

    }

}
