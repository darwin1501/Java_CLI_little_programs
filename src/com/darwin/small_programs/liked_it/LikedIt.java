package com.darwin.small_programs.liked_it;

public class LikedIt {

    public void likeIt(String[] likers){
        String message;
        if(likers.length == 0){
            message = "Nobody likes this post";
        }else if(likers.length == 1){
            message = likers[0] + " likes this post";
        }else if(likers.length == 2){
         message = likers[0]+" and "+likers[1]+" like this post";
        }else if(likers.length == 3){
            message = likers[0] +", "+ likers[1]+" and "+likers[2]+" like this post";
        }else  {
            message = likers[0] +", "+ likers[1]+" and "+(likers.length - 2 )+" others like this post";
        }

        System.out.println(message);
    }
}
