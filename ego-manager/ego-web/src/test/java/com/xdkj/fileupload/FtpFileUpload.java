package com.xdkj.fileupload;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName FtpFileUpload
 * Description:文件上传测试
 *
 * @Author:一尘
 * @Version:1.0
 * @Date:2021-04-14-17:34
 */
public class FtpFileUpload {
    public static void main(String[] args) {
        //获取vsftpd文件上传客户端
        FTPClient  ftpClient = new FTPClient();
        try {
            /*设置编码*/
            ftpClient.setControlEncoding("utf8");
            //设置端口
           // ftpClient.setDefaultPort(21);
            //设置ip地址
            ftpClient.connect("192.168.59.175",21);
            ftpClient.login("ftpuser", "123456");
            //登录结果的状态码
            int code  = ftpClient.getReplyCode();
            System.out.println(code);
           if(!FTPReply.isPositiveCompletion(code)){
               //登录失败
               ftpClient.disconnect();
               return;
           }
            //登录成功文件上传
            File  file = new File("E:\\MacBuntu-Wallpapers\\th.jpg");
            InputStream inputStream = new FileInputStream(file);
            //文件上传的路径
            String path = "/home/ftpuser/ego";
            boolean directory = ftpClient.changeWorkingDirectory(path);
            if(!directory){
                //创建路径 一次只能创建一级
                ftpClient.makeDirectory(path);
                //改变路径
                ftpClient.changeWorkingDirectory(path);
            }
                //二进制上传文件
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            boolean result = ftpClient.storeFile("hehe.jpg", inputStream);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
