package com.instagrocer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.instagrocer.business.ItemBean;
import com.instagrocer.entity.ItemEntity;
import com.instagrocer.service.ItemService;
@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addItem(@RequestBody @Valid ItemBean itemBean, Errors errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors()+" ", HttpStatus.BAD_REQUEST);
		} else {
			ItemEntity itemEntity = itemService.addItem(itemBean);
			return new ResponseEntity<String>("Item created successfully with item id : " + itemEntity.getItemId(),
					HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value = "/getItemById/{itemId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemEntity> getItemById(@PathVariable("itemId") int itemID) {
		ItemEntity bean = itemService.getItemById(itemID);
		if (bean != null)
			return new ResponseEntity<ItemEntity>(bean, HttpStatus.OK);
		else
			return new ResponseEntity<ItemEntity>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/getAllItems",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ItemBean> getAllItems()
	{
		return itemService.getAllItems();
	}
	
	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> deleteItem(@RequestBody @Valid ItemBean itemBean, Errors errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors()+" ", HttpStatus.BAD_REQUEST);
		} else {
			ItemEntity itemEntity = itemService.deleteItem(itemBean);
			return new ResponseEntity<String>("Item deleted successfully with item id : " + itemEntity.getItemId(),
					HttpStatus.CREATED);
		}
	}
	

}
