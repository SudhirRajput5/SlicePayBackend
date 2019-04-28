package com.slice.SlicePay.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/slicePay")
public class SpringSlicePayController {

	//import any service class
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String appWorking()
	{
		return "bhai, kaam kar raha hai!!!";
	}
	
}
