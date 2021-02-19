package DailyQuestion;

/**
 * 2021.2.1
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 来源：力扣（LeetCode）
 * 方法:双指针(滑动窗口)

 */
public class LeetCode424 {
    public static int characterReplacement(String s, int k) {
        //初始判断
        if (s.length()==k){
            return k;
        }
        //双指针(快慢指针)
        int left=0;
        int right=0;
        int maxCount=0;
        int res=0;
        char[] req=new char[26];
        char[] chars = s.toCharArray();
        //right-left正好是滑动窗口的大小
        while (right<chars.length){
            //该字母的数量 右指针移动
            req[chars[right]-'A']++;
            //统计最大值
            maxCount=Math.max(maxCount,req[chars[right]-'A']);
            right++;
            if (right-left>maxCount+k){
                //左指针移动
                req[chars[left]-'A']--;
                left++;
            }
        }
        return right-left;
    }

    public static void main(String[] args) {
        String s="AABABBA";
        int res = characterReplacement(s, 1);
        System.out.println(res);

    }
}
