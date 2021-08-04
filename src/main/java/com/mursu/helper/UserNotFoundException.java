package com.mursu.helper;

public class UserNotFoundException  extends  Exception{


    public UserNotFoundException() {

        super("user not found!!!");

    }


    public  UserNotFoundException(String msg){
        super(msg);
    }


}
