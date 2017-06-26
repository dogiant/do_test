package com.dogiant.springboot.demo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelMapController {
	
	@RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://shop.dogiant.com");
        Map<String,Object> productMap = new HashMap<String,Object>();
        productMap.put("name", "菠萝");
        productMap.put("price", 100.00);
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        list.add(productMap);
        map.addAttribute("allProducts",list);
        return "index";
    }

}
