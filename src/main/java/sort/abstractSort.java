package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class abstractSort {
    private int sortCount=1000;
    private int arrayLen=100;
    protected List<String> disOrderList=new ArrayList();
    protected List<String> sequenceList=new ArrayList();
    protected List<String> reserveList=new ArrayList();
    public abstractSort sortCount(int sortCount){
        this.sortCount=sortCount;
        return this;
    }
    public abstractSort arrayLen(int arrayLen){
        this.arrayLen=arrayLen;
        return this;
    }
    protected abstract void sort(int[] array);
    public void execute(){
        long start=System.currentTimeMillis();
        int sequenceOrder=0,reserveOrder=0,disOrder=0,sortCount=this.sortCount,arrayLen=this.arrayLen;
        for(int i=0;i<sortCount;i++) {
            int[] array = sortUtil.produceArray(arrayLen);
            sort(array);
            int orderType = sortUtil.checkArray2(array);
            if (orderType == 0) {
                disOrder++;
                disOrderList.add(Arrays.toString(array));
            } else if (orderType == 1) {
                sequenceOrder++;
                sequenceList.add(Arrays.toString(array));
            } else {
                reserveOrder++;
                reserveList.add(Arrays.toString(array));
            }
        }
        long end=System.currentTimeMillis();
        System.out.printf("array len: %s --  total count: %s --  sequence order: %s --  reserve order: %s  --  disorder: %s  \r\n",arrayLen,sortCount,sequenceOrder,reserveOrder,disOrder);
        System.out.printf("cost time: %s  \r\n",(end-start));
    }
}
