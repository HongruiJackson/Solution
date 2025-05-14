package com.jackson.solution.dp;

// 392. 判断子序列
// https://leetcode.cn/problems/is-subsequence/description/?envType=problem-list-v2&envId=dynamic-programming
public class dp006 {

    // 在数据量较少的时候，双指针更好，双指针的思路其实蛮简单的
    // 当数据量较多的时候，例如传参时List<String> list, String t的时候，动态规划更好
    // 这里为训练动态规划，采用动态规划的思路
    public boolean isSubsequence(String s, String t) {
        // 这道题是看了题解才会用动态规划的，这里我将总结一下思路来源。
        // 我觉得这道题的意义在于灵活地运用动态规划的思想
        // 先从双指针谈起，假设现在有两个字符串s=abc，和t=aaaaaaabddddc
        // 自然而然会想到两个字符串的第一个a会匹配上
        // 现在就要去找s的b在t当中有没有出现，所以会去移动t的指针
        // 那么这里就会有个构想，我们能否提前存储某个位置后的某个字母的位置呢？
        // 当然是可以的，毕竟字母就26个，且这个串已经在我们的手上了！
        // 那么我们尝试从正向遍历
        // a a a a a a a b , 发现还是要经过多次遍历
        // 但同时我们也发现，这前面的所有的a后第一次出现b都是同一个位置
        // 那么也就是说任意一个位置（注意，这里强调的是位置，不是字符，这会在dp建立完成后有用），
        // 判断另一个字符出现的位置，如果相同则是其本身的位置，如果不同则与它后一个字符的位置是相同的
        // 对于不可达，就用一个无法遍历到的字符去进行表示

        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[tLength + 1][26];
        // 初始化不可达的列
        for (int j = 0; j < 26; j++) {
            dp[tLength][j] = tLength;
        }
        // 完成dp状态补充
        for (int i = tLength-1 ; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(j)=='a'+j) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        // 开始判断
        int tPoint = 0;
        for (int i = 0; i< sLength; i++) {
            if (dp[tPoint][s.charAt(i)-'a'] == tLength) { // 不可达
                return false;
            }
            tPoint = dp[tPoint][s.charAt(i)-'a']+1; // 为什么要+1，因为当你匹配到某个值的时候应该是要将它“消费”掉
        }

        return true;
    }

}
