package com.fourthsource.cc.server.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.fourthsource.cc.server.util.FileUploadProperties;
import com.fourthsource.cc.shared.Message;
import com.fourthsource.cc.shared.MessageType;
import com.fourthsource.cc.shared.ResponseFileUpload;

@Controller
@ControllerAdvice
public class UploadFileController {
	
	@Autowired
	private FileUploadProperties fileUploadProperties;
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
    public @ResponseBody ResponseFileUpload handleFileUpload(@RequestParam("file") MultipartFile file) {
		ResponseFileUpload response = new ResponseFileUpload();
		String path = fileUploadProperties.getPath();
		
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + file.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
                
                Message message = fileUploadProperties.getSuccessMessage();
                message.setMessageType(MessageType.OK);
                message.setMessage(String.format(message.getMessage(), file.getOriginalFilename()));
                
                response.setResponse(message);
            } catch (Exception e) {
            	Message message = fileUploadProperties.getGeneralException();
            	message.setMessageType(MessageType.ERROR);
                message.setMessage(String.format(message.getMessage(), file.getOriginalFilename()));
                
            	response.setResponse(message);
            }
        } else {
        	Message message = fileUploadProperties.getFileEmpty();
        	message.setMessageType(MessageType.WARNING);
        	
        	response.setResponse(message);
        }
        
        return response;
    }
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
    public @ResponseBody ResponseFileUpload handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
		ResponseFileUpload response = new ResponseFileUpload();
		Message message = fileUploadProperties.getFileSizeExceeded();
		message.setMessageType(MessageType.ERROR);
		response.setResponse(message);
		return response;
    }
	
}
