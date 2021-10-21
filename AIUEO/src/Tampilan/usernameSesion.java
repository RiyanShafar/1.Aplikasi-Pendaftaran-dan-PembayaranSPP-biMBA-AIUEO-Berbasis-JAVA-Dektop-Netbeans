/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;

/**
 *
 * @author Satrio_Ganteng
 */
public class usernameSesion {
    private static String user;
    
    public static void setUser(String user){
    usernameSesion.user=user;
    }
    
    public static String getUser(){
    return user;
    }
}
