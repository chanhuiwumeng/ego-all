package com.ego.controller;

import com.ego.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * ClassName FileUploadController
 * Description:
 *
 * @Author:一尘
 * @Version:1.0
 * @Date:2021-04-19-14:36
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;

    @RequestMapping(value = "/save",produces = "application/json;charset=utf8")
    @ResponseBody
    public Map<String,Object> fileUploadSave(MultipartFile  file){
        Map<String,Object> stringMap =null;
        System.out.println(file.getOriginalFilename());
        //文件上传实现
        try {
            stringMap = fileUploadService.fileUpload(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringMap;
    }
}
