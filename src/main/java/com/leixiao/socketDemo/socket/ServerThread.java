package com.leixiao.socketDemo.socket;

import com.leixiao.socketDemo.service.FileService;
import com.leixiao.socketDemo.service.UserService;

import java.net.Socket;

public class ServerThread extends Thread{
    private UserService userService = new UserService();
    private FileService fileService = new FileService();

    private Socket socket = null;

    public ServerThread(Socket socket){
        this.socket = socket;
    }


}
