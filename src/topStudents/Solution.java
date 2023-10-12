package topStudents;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
 *
 * 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
 *
 * 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
 *
 * 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
 */

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> words = new HashMap<>();
        for (String word : positive_feedback) {
            words.put(word, 3);
        }
        for (String word : negative_feedback) {
            words.put(word, -1);
        }
        int n = report.length;
        int[] scores = new int[n];
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            int score = 0;
            for (String word : report[i].split(" ")) {
                score += words.getOrDefault(word, 0);
            }
            A[i] = new int[]{-score, student_id[i]};
        }
        Arrays.sort(A, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<Integer> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topK.add(A[i][1]);
        }
        return topK;
    }
}

//class Solution {
//    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
//        List<Integer> list= new ArrayList<>(Collections.nCopies(student_id.length, 0));
//        List<String> positive= Arrays.asList(positive_feedback);
//        List<String> negative = Arrays.asList(negative_feedback);
//        for(int i=0;i< report.length;i++){
//            String[] reports = report[i].split(" ");
//            for(int j =0;j<reports.length;j++){
//                if(positive.contains(reports[j])){
//                    list.set(i,list.get(i)+3);
//                }
//                else if(negative.contains(reports[j])){
//                    list.set(i,list.get(i)-1);
//                }
//            }
//        }
//        Map<Integer,Integer> map=new HashMap<>();
//        for(int i=0;i<list.size();i++){
//            map.put(student_id[i],list.get(i));
//        }
//        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(map.entrySet());
//        sortedList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed()
//                .thenComparing(Map.Entry.comparingByKey()));
//
//        List<Integer> list1 = new ArrayList<>();
//        int count = 0;
//        for (Map.Entry<Integer, Integer> entry : sortedList) {
//
//            list1.add(entry.getKey());
//            count++;
//            if(count>=k){
//                break;
//            }
//
//        }
//
//        return list1;
//    }
//}