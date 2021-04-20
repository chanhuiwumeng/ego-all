package com.ego.uti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName FileUploadResult
 * Description:文件上传的ajax的结果
 *
 * @Author:一尘
 * @Version:1.0
 * @Date:2021-04-19-14:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadResult implements Serializable {
    private String success;
    private String error;
    private String message;
    private String fileUrl;
}
