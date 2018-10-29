package com.softech.controller;

import com.softech.model.FileUpload;
import com.softech.validation.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UploadController {
    @Autowired
    FileValidator fileValidator;

    @RequestMapping(value = "/uploadPage", method = RequestMethod.GET)
    public ModelAndView uploadPage(){
        ModelAndView modelAndView = new ModelAndView("upload_page");
        modelAndView.addObject("formUpload", new FileUpload());
        return modelAndView;
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(@ModelAttribute("upload_page") FileUpload fileUpload, BindingResult result) throws IOException{
        //validate file upload
        fileValidator.validate(fileUpload, result);

        if (result.hasErrors()){
            return new ModelAndView("upload_page");
        }

        return new ModelAndView("success", "fileNames", processUpload(fileUpload));

    }


    private List<String> processUpload(FileUpload files) throws IOException{

        List<String> fileNames = new ArrayList<String>();

        CommonsMultipartFile[] commonsMultipartFiles = files.getFiles();

        for (CommonsMultipartFile multipartFile : commonsMultipartFiles){
            FileCopyUtils.copy(multipartFile.getBytes(), new File("/home/huynhnguyen/upload/" + multipartFile.getOriginalFilename()));
            fileNames.add(multipartFile.getOriginalFilename());
        }
        return fileNames;
    }

}
