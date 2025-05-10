package com.test1.interest;
public class ValidIPAddress {
    public static boolean isValidIPv4(String ip) {
        // 按点分割字符串
        String[] parts = ip.split("\\.");

        // 有效的IPv4地址由4部分组成
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            // 检查每部分是否只包含数字
            if (!part.matches("\\d+")) {
                return false;
            }

            // 检查是否有前导零且长度大于1
            if (part.length() > 1 && part.startsWith("0")) {
                return false;
            }

            // 将字符串转换为整数
            int num;
            try {
                num = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                return false;
            }

            // 检查数字是否在0到255之间
            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ip1 = "192.168.1.1";
        String ip2 = "192.168.01.1";
        String ip3 = "192.168.1.00";
        String ip4 = "192.168@1.1";

        System.out.println(isValidIPv4(ip1));
        System.out.println(isValidIPv4(ip2));
        System.out.println(isValidIPv4(ip3));
        System.out.println(isValidIPv4(ip4));
    }
}