package com.hex.trs.streamsdemo;

import java.util.List;

public class StreamsMainApp {

	public static void main(String[] args) {
		StreamsService streamService = new StreamsService();
		List<Product> list =  streamService.populateProducts();
		
		
		// filter - as per mobile category
		
		List<Product> filteredList = list.stream().filter(p->p.getCategory().equals(Category.MOBILE)).toList();
		streamService.displayList(filteredList);
		
		// sort - as per price ASC order
		
		List<Product> sortedList = list.stream().sorted((p1, p2)->(int)(p1.getPrice()-p2.getPrice())).toList();
		streamService.displayList(sortedList);
		
		//map - get list of name of product
		
		List<String> productNames =  list.stream().map((p)->p.getTitle()).toList();
		System.out.println(productNames);

	}

}
