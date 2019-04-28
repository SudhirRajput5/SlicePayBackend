package com.slice.SlicePay.ServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.slice.SlicePay.Beans.Stocks;
import com.slice.SlicePay.Service.slicePayService;
import com.slice.SlicePay.repository.StocksRepository;

@Service
public class slicePayServiceImpl implements slicePayService {
	
	@Autowired
	private StocksRepository stockRepository;
	
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

            readBooksFromCSV(UPLOADED_FOLDER + file.getOriginalFilename());
            
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        return "redirect:/uploadStatus";
	}
	

	private Stocks createStock(int counter, String attributes[])
	{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = null;
		try {
		date = simpleDateFormat.parse(attributes[0].substring(0, 10));
		} catch(Exception e) {
			// no problem
		}
		
		String symbol = attributes[1];
		Double open = Double.parseDouble(attributes[2]);
		Double close = Double.parseDouble(attributes[3]);
		Double low = Double.parseDouble(attributes[4]);
		Double high = Double.parseDouble(attributes[5]);
		Double volume = Double.parseDouble(attributes[6]);
		Stocks stock = new Stocks(counter, date, symbol, open, close, low, high, volume);
		return stock;
	}
	
	private void readBooksFromCSV(String fileName) { 
		Path pathToFile = Paths.get(fileName); 
		int counter = 0;
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			br.readLine();
			String line = br.readLine(); 
			while (line != null) { 
				String[] attributes = line.split(","); 
				System.out.println("the attributes: "+ Arrays.asList(attributes));
				Stocks stock = createStock(counter, attributes);
				counter += 1;
				stockRepository.save(stock);
				line = br.readLine(); } } 
		catch (IOException ioe) { 
			ioe.printStackTrace(); 
		}
	}

}
