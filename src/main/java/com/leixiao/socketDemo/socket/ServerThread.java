package com.leixiao.socketDemo.socket;

import com.leixiao.socketDemo.entiy.File;
import com.leixiao.socketDemo.entiy.User;
import com.leixiao.socketDemo.service.FileService;
import com.leixiao.socketDemo.service.UserService;
import com.leixiao.socketDemo.util.CommandTransfer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.server.ExportException;

public class ServerThread extends Thread{
    private UserService userService = new UserService();
    private FileService fileService = new FileService();

    private Socket socket = null;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    //多线程执行的操作，相应客户端的请求
    @Override
    public void run(){
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try{
            ois = new ObjectInputStream(socket.getInputStream());

            //接收客户端发送的消息
            CommandTransfer commandTransfer = (CommandTransfer) ois.readObject();

            //关闭输出流
            socket.shutdownInput();

            //用接收到的CommandTransfer对象执行excute方法执行
            commandTransfer = excute(commandTransfer);

            //返回给客户端
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(commandTransfer);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(ois != null){
                    ois.close();
                }
                if(oos != null){
                    oos.close();
                }
                if(socket != null){
                    socket.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private CommandTransfer excute(CommandTransfer commandTransfer){
        String cmd = commandTransfer.getCmd();

        if("login".equals(cmd)){
            //向服务器打印客户登陆信息
            System.out.println("登陆用户："+((User)commandTransfer.getData()).getUsername()+
                    "密码："+((User) commandTransfer.getData()).getPassword());

            //调用service验证用户密码是否正确
            boolean vertifyPassword = userService.vetifyUser(((User) commandTransfer.getData()));

            if(vertifyPassword){
                commandTransfer.setFlag(true);
                commandTransfer.setResult("登陆成功");
            }else {
                commandTransfer.setFlag(false);
                commandTransfer.setResult("登陆失败～～");
            }
        }else if("enroll".equals(cmd)){
            //向服务器打印用户注册信息
            System.out.println("注册用户："+((User)commandTransfer.getData()).getUsername()+"密码："+
                    ((User)commandTransfer.getData()).getPassword());

            //调用service注册用户
            int line = userService.regist((User) commandTransfer.getData());
            if(line == 1){
                commandTransfer.setFlag(true);
                commandTransfer.setResult("注册成功");
            }else {
                commandTransfer.setFlag(false);
                commandTransfer.setResult("注册失败～～");
            }
        }else if("upload".equals(cmd)){
            int line = fileService.upload((File) commandTransfer.getData());
            if (line > 0){
                commandTransfer.setFlag(true);
                commandTransfer.setResult("文件上传成功，再见");
            }else {
                commandTransfer.setFlag(false);
                commandTransfer.setResult("文件上传失败");
            }
        }

        return commandTransfer;
    }


}
