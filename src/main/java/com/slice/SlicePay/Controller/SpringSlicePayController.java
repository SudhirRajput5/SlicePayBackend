package com.slice.SlicePay.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.slice.SlicePay.Service.slicePayService;

@RestController
@RequestMapping(value="/slicePay")
public class SpringSlicePayController {

	//import any service class
	@Autowired
	slicePayService slicepayservice;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String appWorking()
	{
		return "bhai, kaam kar raha hai!!!";
	}
	
	@PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		return slicepayservice.saveUploadedFile(file, redirectAttributes);
    }
	
}
