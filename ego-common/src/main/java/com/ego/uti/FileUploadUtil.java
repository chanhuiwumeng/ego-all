package com.ego.uti;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * ClassName FileUploadUtil
 * Description:文件上传
 *
 * @Author:一尘
 * @Version:1.0
 * @Date:2021-04-19-14:41
 */
@Component
public class FileUploadUtil {

    //实现文件上传
    public static  String  fileUpload(String host,
                                         Integer port,
                                         String username,
                                         String password,
                                         String ftpPath,
                                         MultipartFile file){
        //文件上传的返回值
        FileUploadResult  fileUploadResult = new FileUploadResult();
        //获取vsftpd文件上传客户端
        FTPClient ftpClient = new FTPClient();
        String finalPath = "";
        try {
            /*设置编码*/
            ftpClient.setControlEncoding("utf8");
            //设置端口
            // ftpClient.setDefaultPort(21);
            //设置ip地址
            ftpClient.connect(host,port);
            ftpClient.login(username, password);
            //登录结果的状态码
            int code  = ftpClient.getReplyCode();
            System.out.println(code);
            if(!FTPReply.isPositiveCompletion(code)){
                //登录失败
                ftpClient.disconnect();
                //return fileUploadResult.setError("ftp连接失败");
            }
            //登录成功文件上传
            InputStream inputStream = file.getInputStream();
            //文件上传的路径
            String path = ftpPath; //  /home/ftpuser/ego/2020/04/18/    名字.jpg
            String temp ="";
            for (String s : path.split("/")) {
                temp  =  temp + s+"/";
                System.out.println(temp+"temp路径");
                boolean directory = ftpClient.changeWorkingDirectory(temp);
                if(!directory){
                    //创建路径 一次只能创建一级
                    ftpClient.makeDirectory(temp);
                    //改变路径
                    ftpClient.changeWorkingDirectory(temp);
                }
            }
            //二进制上传文件
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //文件名称
            String originalFilename = file.getOriginalFilename();
            String exName = originalFilename.substring(originalFilename.indexOf("."));
            String newName = UUID.randomUUID().toString().replaceAll("-","")+exName;
            //文件上传
            boolean result = ftpClient.storeFile(newName, inputStream);
            //我们最终文件上传完成以后我们要向前台页面 返回文件上传成功的绝对Url
           finalPath = "http://"+host+ftpPath+"/"+newName;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  finalPath;
    }
}
