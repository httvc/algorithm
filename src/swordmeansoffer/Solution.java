package src.swordmeansoffer;

/**
 * 在一个二维数组中(每个一维数组的长度相同)，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和
 * 一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    //挨个遍历数组，找到就返回true
    public boolean Find(int target, int [][] array) {
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                if (array[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    //从左下角找，当target大于向右找，当小于向上找，等于返回true
    public boolean Find1(int target, int [][] array) {
        int row=array.length;
        if(row==0){
            return false;
        }
        int column=array[0].length;
        if(column==0){
            return false;
        }
        int i=row-1,j=0;
        while(i>=0&& j<column){
            if(target<array[i][j]){
                i--;
            }else if(target>array[i][j]){
                j++;
            }else if(target==array[i][j]){
                return true;
            }
        }
        return false;
    }
}
