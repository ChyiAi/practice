package com.smao.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack == null || stack.size()==0) {
                if (map.keySet().contains(c)) {
                    return false;
                } else {
                    stack.push(c);
                    continue;
                }
            }
            if (map.keySet().contains(c)) {
                if(map.get(c)!=stack.pop()){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.print(isValid("()"));
    }
}
