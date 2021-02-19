package DailyQuestion;
/**
 * 给你两个长度相同的字符串，s 和 t。
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * 示例 1：
 *
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 方法:双指针

 */
public class LeetCodee1208 {
    public static int  equalSubstring(String s, String t, int maxCost) {
        int left=0;
        int right=0;
        int cost=0;
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        while (right<ss.length){
            //计算快指针的差值,并统计
            cost=Math.abs(ss[right]-ts[right])+cost;
            //如果count大于maxCount,则移动慢指针
            if (cost>maxCost) {
                cost=cost-Math.abs(ss[left]-ts[left]);
                left++;
            }
            right++;
        }
        return right-left;
    }

    public static void main(String[] args) {
        String s="abcd";
        String t="acde";
        int i = equalSubstring(s, t, 0);
        System.out.println(i);

    }
}
