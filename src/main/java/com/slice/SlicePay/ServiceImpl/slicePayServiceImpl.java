package com.slice.SlicePay.ServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.slice.SlicePay.Service.slicePayService;

@Service
public class slicePayServiceImpl implements slicePayService {
	
	public String saveUploadedFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		String UPLOADED_FOLDER = "D:\\Java Softwares\\Backend Project1(Slice Pay)\\SlicePay\\github_slicePay\\SlicePayBackend\\Documents\\";
		
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        return "redirect:/uploadStatus";
	}

}
