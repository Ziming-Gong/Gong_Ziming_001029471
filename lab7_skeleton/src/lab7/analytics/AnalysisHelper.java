/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

/**
 * @author harshalneelkamal
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;


public class AnalysisHelper {
    //Find Average number of likes per comment.
    //TODO
    public void getAverageLikesPerCommets() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        System.out.println("comments = " + comments.size());
        System.out.println("comments = " + comments.size());
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
        }

        System.out.println("average of likes per comments: " + likeNumber / commentNumber);

    }

    //2
    public void getMaxLikesComment() {
        Map<Integer, List<Comment>> commentsMap = DataStore.getInstance().getComments().values().stream().collect(Collectors.groupingBy(Comment::getLikes));
        Integer maxCount = commentsMap.keySet().stream().max(Integer::compareTo).get();
        List<Comment> comments = commentsMap.get(maxCount);
        for (Comment comment : comments) {
            System.out.println(String.format("max of likes CommentId: %s, likes: %s, comment content: %s", comment.getId(), maxCount, comment.getText()));
        }
    }

    //3
    public void getMaxCommentCountPost() {
        Map<Integer, List<Post>> postsMap = DataStore.getInstance().getPosts().values().stream()
                .collect(Collectors.groupingBy(o1 -> o1.getComments().size()));
        Integer maxCount = postsMap.keySet().stream().max(Integer::compareTo).get();
        List<Post> posts = postsMap.get(maxCount);
        String postIds = posts.stream().map(Post::getPostId).map(Object::toString).collect(Collectors.joining(","));
        System.out.println(String.format("max of comments postId: %s, comments count: %s", postIds, maxCount));
    }

    //4
    public void getUnActivityUserDesc5() {
        Map<Integer, User> userMap = DataStore.getInstance().getUsers();
        Map<Integer, List<Post>> postsMap = DataStore.getInstance().getPosts().values()
                .stream().collect(Collectors.groupingBy(Post::getUserId));
        List<Map.Entry<Integer, List<Post>>> entries = postsMap.entrySet().stream()
                .sorted(((o1, o2) -> Integer.compare(o1.getValue().size(), o2.getValue().size()))).collect(Collectors.toList());
        for(int i=0;i<Math.min(entries.size(), 5);i++){
            Map.Entry<Integer, List<Post>> entry = entries.get(i);
            User user = userMap.get(entry.getKey());
            String printString = String.format("No.%s, userId: %s, firstName: %s, lastName: %s, postCount: %s", i+1, user.getId(), user.getFirstName(), user.getLastName(), entry.getValue().size());
            System.out.println(printString);
        }
    }

    //5
    public void getMinCountOfCommentDesc5() {
        Map<Integer, User> userMap = DataStore.getInstance().getUsers();
        Map<Integer, List<Comment>> commentsMap = DataStore.getInstance().getComments().values()
                .stream().collect(Collectors.groupingBy(Comment::getUserId));
        List<Map.Entry<Integer, List<Comment>>> entries = commentsMap.entrySet().stream()
                .sorted(((o1, o2) -> Integer.compare(o1.getValue().size(), o2.getValue().size()))).collect(Collectors.toList());
        for(int i=0;i<Math.min(entries.size(), 5);i++){
            Map.Entry<Integer, List<Comment>> entry = entries.get(i);
            User user = userMap.get(entry.getKey());
            String printString = String.format("No.%s, userId: %s, firstName: %s, lastName: %s, postCount: %s", i+1, user.getId(), user.getFirstName(), user.getLastName(), entry.getValue().size());
            System.out.println(printString);
        }
    }

    //6
    public void getMinCountOfCommentAndPostAndLikes5() {
        Map<Integer, User> userMap = DataStore.getInstance().getUsers();
        Map<Integer, List<Comment>> commentsMap = DataStore.getInstance().getComments().values()
                .stream().collect(Collectors.groupingBy(Comment::getUserId));
        Map<Integer, List<Post>> postsMap = DataStore.getInstance().getPosts().values()
                .stream().collect(Collectors.groupingBy(Post::getUserId));
        Map<Integer, Integer> countOfUserMap = new HashMap<>();
        for(Map.Entry<Integer, List<Post>> entry : postsMap.entrySet()){
            countOfUserMap.put(entry.getKey(), entry.getValue().size());
        }
        for(Map.Entry<Integer, List<Comment>> entry : commentsMap.entrySet()){
            Integer count = countOfUserMap.getOrDefault(entry.getValue(), 0);
            count += entry.getValue().size();
            for(Comment comment : entry.getValue()){
                count += comment.getLikes();
            }
            countOfUserMap.put(entry.getKey(), count);
        }
        List<Map.Entry<Integer, Integer>> entries = countOfUserMap.entrySet().stream()
                .sorted(((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()))).collect(Collectors.toList());
        for(int i=0;i<Math.min(entries.size(), 5);i++){
            Map.Entry<Integer, Integer> entry = entries.get(i);
            User user = userMap.get(entry.getKey());
            String printString = String.format("No.%s, user:%s, count: %s", i+1, user.toString(), entry.getValue());
            System.out.println(printString);
        }
    }

    //7
    public void getMaxCountOfCommentAndPostAndLikes5() {
        Map<Integer, User> userMap = DataStore.getInstance().getUsers();
        Map<Integer, List<Comment>> commentsMap = DataStore.getInstance().getComments().values()
                .stream().collect(Collectors.groupingBy(Comment::getUserId));
        Map<Integer, List<Post>> postsMap = DataStore.getInstance().getPosts().values()
                .stream().collect(Collectors.groupingBy(Post::getUserId));
        Map<Integer, Integer> countOfUserMap = new HashMap<>();
        for(Map.Entry<Integer, List<Post>> entry : postsMap.entrySet()){
            countOfUserMap.put(entry.getKey(), entry.getValue().size());
        }
        for(Map.Entry<Integer, List<Comment>> entry : commentsMap.entrySet()){
            Integer count = countOfUserMap.getOrDefault(entry.getValue(), 0);
            count += entry.getValue().size();
            for(Comment comment : entry.getValue()){
                count += comment.getLikes();
            }
            countOfUserMap.put(entry.getKey(), count);
        }
        List<Map.Entry<Integer, Integer>> entries = countOfUserMap.entrySet().stream()
                .sorted(((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))).collect(Collectors.toList());
        for(int i=0;i<Math.min(entries.size(), 5);i++){
            Map.Entry<Integer, Integer> entry = entries.get(i);
            User user = userMap.get(entry.getKey());
            String printString = String.format("No.%s, user:%s, count: %s", i+1, user.toString(), entry.getValue());
            System.out.println(printString);
        }
    }
}
