package com.slice.SlicePay.Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface slicePayService {
	
	public String saveUploadedFile(MultipartFile file, RedirectAttributes redirectAttributes);

}
