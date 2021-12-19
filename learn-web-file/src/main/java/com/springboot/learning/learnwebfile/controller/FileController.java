package com.springboot.learning.learnwebfile.controller;

import com.springboot.learning.learnwebfile.module.FileInfo;
import com.springboot.learning.learnwebfile.response.Response;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;

@RestController
public class FileController {
    @PostMapping("/upload")
    public Response<FileInfo> uploadFile(@RequestParam("file") MultipartFile file) {
        long size = file.getSize();
        String name = file.getOriginalFilename();
        FileInfo fileInfo = FileInfo.builder().size(size).name(name).build();
        return Response.OK(fileInfo);
    }

    @GetMapping("/downloadFile")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam("filePath") String filePath) throws IOException {
        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok().headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(file.getInputStream()));
    }

    @GetMapping("/downloadFile2")
    public void downloadFile2(@RequestParam("filePath") String filePath, HttpServletResponse response) throws IOException {
        if (filePath.contains("%")) {
            filePath = URLDecoder.decode(filePath, "UTF-8");
        }
        ServletOutputStream out = null;
        FileInputStream in = null;
        in = new FileInputStream(filePath);
        String[] dir = filePath.split("/");
        String fileName = dir[dir.length - 1];
        // 设置响应类型为html，编码为utf-8，处理相应页面文本显示的乱码
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // 设置文件头：最后一个参数是设置下载文件名
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        out = response.getOutputStream();
        // 读取文件流
        int len = 0;
        byte[] buffer = new byte[1024 * 10];
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.flush();
        response.flushBuffer();
        out.close();
        in.close();
    }

}
