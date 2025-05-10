package com.test1;
import java.util.Arrays;
import java.util.Collections;

public class LargestSmallerNumber {
    public static int findLargestSmallerNumber(int n, Integer[] A) {
        String nStr = String.valueOf(n);
        char[] digits = nStr.toCharArray();
        Arrays.sort(A, Collections.reverseOrder()); // 从大到小排序集合 A

        StringBuilder result = new StringBuilder();
        boolean found = false;

        for (int i = 0; i < digits.length; i++) {
            char currentDigit = digits[i];
            boolean digitPlaced = false;

            for (int j = 0; j < A.length; j++) {
                char a = (char)(int)A[j];
                if (a < currentDigit) {
                    result.append(a);
                    digitPlaced = true;
                    for (int k = i + 1; k < digits.length; k++) {
                        result.append(A[0]); // 在后面填充最大的数字
                    }
                    found = true;
                    break;
                }
            }

            if (!digitPlaced) {
                // 如果找不到比当前数字小的数字，回到前一位
                if (result.length() == 0) {
                    return -1; // 无法找到符合要求的数字
                } else {
                    result.deleteCharAt(result.length() - 1); // 删除最后一位并回溯
                }
            }
        }

        return found ? Integer.parseInt(result.toString()) : -1;
    }

    public static void main(String[] args) {
        LargestSmallerNumber lar=new LargestSmallerNumber();
        Integer[] A = {2, 4, 9};
        int n = 23121;
        System.out.println(lar.findLargestSmallerNumber(n, A));
    }
}
