package com.test1.interest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonalizedRecommender {
        //存储用户-商品交互关系,user->Set<item>
        private Map<String, Set<String>> userItemMap=new HashMap<String, Set<String>>();
        //存储商品-用户交互关系,item->Set<user>
        private Map<String,Set<String>> itemUserMap=new HashMap<>();


        public void addInteraction(String userId, String itemId) {
              userItemMap.putIfAbsent(userId,new HashSet<>());
              userItemMap.get(userId).add(itemId);
              itemUserMap.putIfAbsent(itemId,new HashSet<>());
              itemUserMap.get(itemId).add(userId);
        }

        public List<String> recommend(String userId, int k) {
            //先计算用户的相似度
            Map<String,Integer> similarityMap=new HashMap<>();
            //遍历
            for(String otherUser:userItemMap.keySet()) {
                if(!otherUser.equals(userId)) {
                    int commonItems=countCommonItems(userId,otherUser);
                    similarityMap.put(otherUser,commonItems);
                }
            }
            //找出最相似的k个用户
            List<Map.Entry<String,Integer>> sortedUsers=new ArrayList<>(similarityMap.entrySet());
            sortedUsers.sort((a,b)->b.getValue().compareTo(a.getValue()));
            List<String>similarUsers=new ArrayList<>();
            //遍历
            for(int i=0;i<Math.min(k,sortedUsers.size());i++) {
                similarUsers.add(sortedUsers.get(i).getKey());
            }
            //合并相似用户交互过的商品，过滤
            Map<String,Integer> itemCountMap=new HashMap<>();
            for(String similarUser:similarUsers) {
                for(String item:userItemMap.get(similarUser)) {
                    if(!userItemMap.get(userId).contains(item)) {
                        itemCountMap.put(item,itemCountMap.getOrDefault(item,0) + 1);
                    }
                }
            }

            //按照次数降序
            List<Map.Entry<String,Integer>> sortedItems=new ArrayList<>(itemCountMap.entrySet());
            sortedItems.sort((a,b)->{
                int countDiff=b.getValue().compareTo(a.getValue());
                if(countDiff==0) {
                    return a.getKey().compareTo(b.getKey());
                }
                return countDiff;
            });

            List<String>recommendations=new ArrayList<>();
            for(Map.Entry<String,Integer> entry:sortedItems) {
                recommendations.add(entry.getKey());
            }
            return recommendations;
        }

    private int countCommonItems(String user1, String user2) {
            Set<String> items1=userItemMap.get(user1);
            Set<String> items2=userItemMap.get(user2);
            int count=0;
            for(String item:items1) {
                if(items2.contains(item)) {
                    count++;
                }
            }
            return count;
    }

    public static void main(String[] args) {
            // test
            PersonalizedRecommender recommender = new PersonalizedRecommender();
            recommender.addInteraction("user1", "item1");
            recommender.addInteraction("user1", "item2");
            recommender.addInteraction("user2", "item1");
            recommender.addInteraction("user2", "item3");
            recommender.addInteraction("user3", "item2");
            recommender.addInteraction("user3", "item3");
            List<String> recommendations = recommender.recommend("user1", 2);
            System.out.println(recommendations);
        }
}

