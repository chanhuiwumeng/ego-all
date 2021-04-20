package com.ego.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileUploadService {
    Map<String,Object> fileUpload(MultipartFile file);
}
