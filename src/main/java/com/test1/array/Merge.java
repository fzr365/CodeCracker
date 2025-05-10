package com.test1.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        //先按照第一个元素排序
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> ret=new ArrayList<>();
        for(int [] p:intervals){
            //当前区间左端点小于已知的最后一个区间的右端点，则可以合并
            if(!ret.isEmpty()&&p[0]<=ret.get(ret.size()-1)[1]){
                ret.get(ret.size()-1)[1]=Math.max(ret.get(ret.size()-1)[1],p[1]);
            }else{
                //不能合并
                ret.add(p);
            }
        }
        return ret.toArray(new int[ret.size()][]);
    }

    public static void main(String[] args) {
        Merge merge=new Merge();
        int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
        //多维数组转输出
        System.out.println(Arrays.deepToString(merge.merge(intervals)));
    }
}
