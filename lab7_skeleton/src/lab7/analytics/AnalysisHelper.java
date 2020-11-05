/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

/**
 *
 * @author harshalneelkamal
 */

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;


public class AnalysisHelper {
    //Find Average number of likes per comment.
    //TODO
    public void getAverageLikesPerCommets() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
            
        }
        System.out.println(likeNumber);
        System.out.println("average of likes per comments: " + likeNumber / commentNumber);
            
    }
    public void getMostLikeComments(){
        Map<Integer,Comment> comments = DataStore.getInstance().getComments();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        List <Integer> likeList = new ArrayList<>();
        
        for(Comment c : comments.values() ){
        likeList.add(c.getLikes());
        }

        Collections.sort(likeList);
        //System.out.println("like set is : " +likeList);
        int maxKeynumber;
        maxKeynumber = likeList.get(likeList.size()-1);//最大like的值
        //List<Integer> maxKey = new ArrayList<>();
        
        for (Comment c : comments.values()){
            if(c.getLikes()==maxKeynumber){
                System.out.println("the most like comments: " +c);
                for(Post p : posts.values()){
                    if(p.getPostId()==c.getPostId()){
                        System.out.println("the most like post: " +p);
                    }
            }
        }
            }
        //for(int i = 0; i<comments.size()-1; i++){
           // if (likeList.get(i).equals(maxKeynumber)){
           //     maxKey.add(likeList.get(i));
         //   }
           
                
       // }
       
       //Comment c =  (Comment) comments.get(maxKeynumber);
        //maxKey.add(maxKeynumber);
        //System.out.println("the most like comments: " +maxKey);
        //System.out.println("most like post is " + posts.get(maxKeynumber));
        
        
    
 //       for(Comment c : comments.values()){
     //       if(c.equals(maxKey)){
      //          String maxText = c.getText();
     //           System.out.println("most like text is " +maxText);
                
     //       }
            
   //     }
       // System.out.println("the most like comments: " + comments.get(maxKey));
        
   //     Map<Integer, Comment> comments = DataStore.getInstance().getComments();
  //      int commentNumber = comments.size();
   //     for(Comment c : comments.values()){
   //     List<Integer> like = new ArrayList<>();
 //       like.add(c.getLikes());
    //    Collections.sort(like);
     //   int max = (int) Collections.max(like);
      //  System.out.println("the most like comments: " + max);
      //  for (int i = 0; i < commentNumber-1; i++){
       //    String m = Integer.toString(like.get(i));
     //      System.out.println("the most like comments: " + m); 
      // }
       // }
    }
    public void getmostComments(){
        Map<Integer,Comment> comments = DataStore.getInstance().getComments();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        
        List <Integer> commentsizelist = new ArrayList<>();
        for(Post p : posts.values()){
            commentsizelist.add(p.getComments().size());
        }
        Collections.sort(commentsizelist);
       // System.out.println("the most like comments: " +commentsizelist);
        int mostcommentnumber;
        mostcommentnumber = commentsizelist.get(commentsizelist.size()-1);
       // System.out.println("the most like comments: " +mostcommentnumber);
        for(Post p : posts.values()){
            if(p.getComments().size()==mostcommentnumber){
                System.out.println("the most comment post: " +p);
            }
        }
        
    }
    public void gettopfivepostnumberuserpost(){
        Map<Integer,Comment> comments = DataStore.getInstance().getComments();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
       //查list
       List<Integer> postlist = new ArrayList<>();

        for(Post p : posts.values()){
            postlist.add(p.getUserId());
        }
       // System.out.println("postlist: " +postlist);
        
        int usersize;
        usersize = users.size();
        //System.out.println("the most like comments: " +usersize);//查人数
        List<Integer> postnumberlist = new ArrayList<>();
       for (User u : users.values()){
           postnumberlist.add(u.getId());
       }
       Collections.sort(postnumberlist);
       //System.out.println("idlist is: " +postnumberlist);//total number of post
       Map<Integer, Integer> postmap = new HashMap<Integer, Integer>();
       for(User u : users.values()){
           for (Post p : posts.values()){

                    int totalpostnumber = 0;
                    for(int i = 0; i<postlist.size(); i++){
                    if(u.getId()==postlist.get(i)){
                        totalpostnumber++;
                    }
                    }
                    postmap.put(u.getId(), totalpostnumber);
           
           }
       }
        System.out.println("someone value is: " +postmap.get(usersize-1));
        List<Integer> totalpostlist = new ArrayList<>();
        for(int i = 0; i < usersize; i++){
            totalpostlist.add(postmap.get(i));
        }
        System.out.println("total list is: " +totalpostlist);
        Collections.sort(totalpostlist);
        int top1= totalpostlist.get(0);
        int top2= totalpostlist.get(1);
        int top3= totalpostlist.get(2);
        int top4= totalpostlist.get(3);
        int top5= totalpostlist.get(4);

        //System.out.println("key is: " +top1);
       // System.out.println("key is: " +top2);
        //System.out.println("key is: " +top3);
       // System.out.println("key is: " +top4);
       // System.out.println("key is: " +top5);
        
            for(Map.Entry<Integer,Integer> pm : postmap.entrySet()){
                if (pm.getValue().equals(top1)){
                    for(User u : users.values()){
                        if (pm.getKey()==u.getId()){
                        System.out.println("top1 is: " +u);
                        }
                    }
                }
            }
            for(Map.Entry<Integer,Integer> pm : postmap.entrySet()){
                if (pm.getValue().equals(top2)){
                    for(User u : users.values()){
                        if (pm.getKey()==u.getId()){
                        System.out.println("top2 is: " +u);
                        }
                    }
                }
            }
            for(Map.Entry<Integer,Integer> pm : postmap.entrySet()){
                if (pm.getValue().equals(top3)){
                    for(User u : users.values()){
                        if (pm.getKey()==u.getId()){
                        System.out.println("top3 is: " +u);
                        }
                    }
                }
            }
            for(Map.Entry<Integer,Integer> pm : postmap.entrySet()){
                if (pm.getValue().equals(top4)){
                    for(User u : users.values()){
                        if (pm.getKey()==u.getId()){
                        System.out.println("top4 is: " +u);
                        }
                    }
                }
            }
            for(Map.Entry<Integer,Integer> pm : postmap.entrySet()){
                if (pm.getValue().equals(top5)){
                    for(User u : users.values()){
                        if (pm.getKey()==u.getId()){
                        System.out.println("top5 is: " +u);
                        }
                    }
                }
            }

    }
    public void gettopfivebycomment(){
        Map<Integer,Comment> comments = DataStore.getInstance().getComments();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        
        int usersize;
        usersize = users.size();
        //System.out.println("the most like comments: " +usersize);//查人数
        List<Integer> postnumberlist = new ArrayList<>();
       for (User u : users.values()){
           postnumberlist.add(u.getComments().size());
       }
       Collections.sort(postnumberlist);
       //System.out.println("the most like comments: " +postnumberlist);//total number of post
       int top1 = postnumberlist.get(postnumberlist.size()-1);
       int top2 = postnumberlist.get(postnumberlist.size()-2);
       int top3 = postnumberlist.get(postnumberlist.size()-3);
       int top4 = postnumberlist.get(postnumberlist.size()-4);
      int top5 = postnumberlist.get(postnumberlist.size()-5);
       for(User u : users.values()){
          if(u.getComments().size()==top1)
            System.out.println("Top1: " +u );
          else if(u.getComments().size()==top2)
           System.out.println("Top2 : " +u);
           else if(u.getComments().size()==top3)
            System.out.println("Top3 : " +u);
           else if(u.getComments().size()==top4)
            System.out.println("Top4 : " +u);
           else if(u.getComments().size()==top5)
            System.out.println("Top5: " +u);
       }
    }
    public void getinoverall(){
        Map<Integer,Comment> comments = DataStore.getInstance().getComments();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
       //查list
       List<Integer> postlist = new ArrayList<>();

        for(Post p : posts.values()){
            postlist.add(p.getUserId());
        }
       // System.out.println("postlist: " +postlist);
        
        int usersize;
        usersize = users.size();
        //System.out.println("the most like comments: " +usersize);//查人数
        List<Integer> postnumberlist = new ArrayList<>();
       for (User u : users.values()){
           postnumberlist.add(u.getId());
       }
       Collections.sort(postnumberlist);
       //System.out.println("idlist is: " +postnumberlist);//total number of post
       Map<Integer, Integer> postmap = new HashMap<Integer, Integer>();
       for(User u : users.values()){
           for (Post p : posts.values()){

                    int totalpostnumber = 0;
                    for(int i = 0; i<postlist.size(); i++){
                    if(u.getId()==postlist.get(i)){
                        totalpostnumber++;
                    }
                    }
                    postmap.put(u.getId(), totalpostnumber);
           
           }
       }
        System.out.println("someone value is: " +postmap.get(usersize-1));
        List<Integer> totalpostlist = new ArrayList<>();
        for(int i = 0; i < usersize; i++){
            totalpostlist.add(postmap.get(i));
        }
        System.out.println("total list is: " +totalpostlist);
        Collections.sort(totalpostlist);
        int top1= totalpostlist.get(0);
        int top2= totalpostlist.get(1);
        int top3= totalpostlist.get(2);
        int top4= totalpostlist.get(3);
        int top5= totalpostlist.get(4);

        //System.out.println("key is: " +top1);
       // System.out.println("key is: " +top2);
        //System.out.println("key is: " +top3);
       // System.out.println("key is: " +top4);
       // System.out.println("key is: " +top5);
        
            for(Map.Entry<Integer,Integer> pm : postmap.entrySet()){
                if (pm.getValue().equals(top1)){
                    for(User u : users.values()){
                        if (pm.getKey()==u.getId()){
                        System.out.println("top1 is: " +u);
                        }
                    }
                }
            }
            for(Map.Entry<Integer,Integer> pm : postmap.entrySet()){
                if (pm.getValue().equals(top2)){
                    for(User u : users.values()){
                        if (pm.getKey()==u.getId()){
                        System.out.println("top2 is: " +u);
                        }
                    }
                }
            }
            for(Map.Entry<Integer,Integer> pm : postmap.entrySet()){
                if (pm.getValue().equals(top3)){
                    for(User u : users.values()){
                        if (pm.getKey()==u.getId()){
                        System.out.println("top3 is: " +u);
                        }
                    }
                }
            }
            for(Map.Entry<Integer,Integer> pm : postmap.entrySet()){
                if (pm.getValue().equals(top4)){
                    for(User u : users.values()){
                        if (pm.getKey()==u.getId()){
                        System.out.println("top4 is: " +u);
                        }
                    }
                }
            }
            for(Map.Entry<Integer,Integer> pm : postmap.entrySet()){
                if (pm.getValue().equals(top5)){
                    for(User u : users.values()){
                        if (pm.getKey()==u.getId()){
                        System.out.println("top5 is: " +u);
                        }
                    }
                }
            }
        
    }
    public void getoverall(){
        Map<Integer,Comment> comments = DataStore.getInstance().getComments();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        
        int usersize;
        usersize = users.size();
        //System.out.println("the most like comments: " +usersize);//查人数
        List<Integer> postnumberlist = new ArrayList<>();
       for (User u : users.values()){
           postnumberlist.add(u.getComments().size());
       }
       Collections.sort(postnumberlist);
       //System.out.println("the most like comments: " +postnumberlist);//total number of post
       int top1 = postnumberlist.get(postnumberlist.size()-1);
       int top2 = postnumberlist.get(postnumberlist.size()-2);
       int top3 = postnumberlist.get(postnumberlist.size()-3);
       int top4 = postnumberlist.get(postnumberlist.size()-4);
      int top5 = postnumberlist.get(postnumberlist.size()-5);
       for(User u : users.values()){
          if(u.getComments().size()==top1)
            System.out.println("Top1: " +u );
          else if(u.getComments().size()==top2)
           System.out.println("Top2 : " +u);
           else if(u.getComments().size()==top3)
            System.out.println("Top3 : " +u);
           else if(u.getComments().size()==top4)
            System.out.println("Top4 : " +u);
           else if(u.getComments().size()==top5)
            System.out.println("Top5: " +u);
       }
    }
}
    
