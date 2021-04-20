package com.ego.service.impl;

import com.ego.service.FileUploadService;
import com.ego.uti.FileUploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName FileUploadServiceImpl
 * Description:
 *
 * @Author:一尘
 * @Version:1.0
 * @Date:2021-04-19-14:48
 */
@Service
public class FileUploadServiceImpl  implements FileUploadService {
    @Value("${ftp.host}")
    private String host;
    @Value("${ftp.port}")
    private Integer port;
    @Value("${ftp.username}")
    private String userName;
    @Value("${ftp.password}")
    private String password;
    @Value("${ftp.ftpPath}")
    private String ftpPath;

    @Override
    public Map<String,Object> fileUpload(MultipartFile file) {
        //创建日期的前缀
        //jdk1.8 日期转字符串
        DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String datePath = LocalDate.now().format(formatter);
        System.out.println(datePath+"日期前缀");
       Map<String,Object> map = new HashMap<>();
        //调用文件上传的方法
       String path  =  FileUploadUtil.fileUpload(this.host,
                this.port,
                this.userName,
                this.password,
                this.ftpPath+"/"+datePath,
              file);
       //上传成功的路径判断
       if(!path.isEmpty() && path.length() > 0){
          map.put("success","success");
          map.put("message","上传成功");
          map.put("fileUrl",path);
       }
       else {
          map.put("error","error");
       }
        return map;
    }
}
