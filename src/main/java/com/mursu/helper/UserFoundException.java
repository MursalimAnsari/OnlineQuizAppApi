package com.mursu.helper;

public class UserFoundException  extends  Exception{

    public UserFoundException() {

        super("user already exists!!!");

    }


      public  UserFoundException(String msg){
        super(msg);
      }


}
