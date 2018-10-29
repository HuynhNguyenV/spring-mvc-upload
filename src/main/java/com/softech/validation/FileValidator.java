package com.softech.validation;

import com.softech.model.FileUpload;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Component
public class FileValidator implements Validator {



    public boolean supports(Class<?> aClass) {
        return FileValidator.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        FileUpload fileUpload = (FileUpload)  o;
        CommonsMultipartFile[] commonsMultipartFiles = fileUpload.getFiles();
        for (CommonsMultipartFile multipartFile : commonsMultipartFiles){
            if (multipartFile.getSize() == 0){
                errors.rejectValue("files", "missing.file");
            }
        }
    }
}
