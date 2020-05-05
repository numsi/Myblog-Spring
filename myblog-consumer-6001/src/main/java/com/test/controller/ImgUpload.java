package com.test.controller;


import com.test.utils.Result;
import com.test.utils.ResultFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 */
@RestController
public class ImgUpload {


    @Value("${file.uploadFolder}")
    private String uploadPath; //文件上传的地址


    @PostMapping(value = "/img/upload")
    @CrossOrigin
    public Result fileUpload(@RequestParam("image") MultipartFile file) {
//        try {
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get("F:\\upload\\"+file.getOriginalFilename());
//            Files.write(path,bytes);
//            return "文件上传成功";
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "文件上传失败";
//        }



        //上传目录地址
        String uploadDir = uploadPath;

        //如果目录不存在，自动创建文件夹
        File dir = new File(uploadDir);
        if(!dir.exists())
        {
            dir.mkdirs();
        }
        String suffix = null;
        String fileName = null;
        try {
            suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")); //后缀名
            fileName = UUID.randomUUID() + suffix;
            IOUtils.copy(file.getInputStream(), new FileOutputStream(uploadDir + "\\" + fileName));
        }catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult("头像上传失败");
        }


        System.out.println(uploadDir+"-------"+fileName);
        String imgUrl = "http://localhost:6001/img/"+fileName;
        return ResultFactory.buildSuccessResult(imgUrl);

//        return "http://localhost:8181/img1/timg.jpg";

    }

    @PostMapping("/blog/covers")
    public String coversUpload(MultipartFile file) {
        //上传目录地址
        String uploadDir = uploadPath;

        //如果目录不存在，自动创建文件夹
        File dir = new File(uploadDir);
        if(!dir.exists())
        {
            dir.mkdirs();
        }
        String suffix = null;
        String fileName = null;
        try {
            suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")); //后缀名
            fileName = UUID.randomUUID() + suffix;
            IOUtils.copy(file.getInputStream(), new FileOutputStream(uploadDir + "\\" + fileName));
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }


        System.out.println(uploadDir+"-------"+fileName);
        String imgUrl = "http://localhost:6001/img/"+fileName;
        return imgUrl;
    }


}
