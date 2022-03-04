package com.orella.capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orella.capstone.exceptions.ResourceNotFoundException;
import com.orella.capstone.models.WishlistModel;
import com.orella.capstone.repository.WishlistRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
 public class WishlistController {
	
	@Autowired
	private WishlistRepository wishlistRepo;
	
	// Get request that brings ups all items that are on wishlist. Fulfills Read requirement in CRUD
	@GetMapping ("/checkallitems")
	public List<WishlistModel> getAllWishlistItems() {
		return wishlistRepo.findAll();
	}
	
	//Get request that finds items on wishlist by their id number 
	@GetMapping("/finditembyid/{id}")
	public ResponseEntity<WishlistModel> getItemById(@PathVariable int id){
		WishlistModel item = wishlistRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException ("Item not found."));
				return ResponseEntity.ok(item);
	}
	
//	Get request that finds items by their name 
	@GetMapping("/finditembyname/{itemname}")
	public List<WishlistModel> getItemByItemname (@PathVariable String itemname){
		List<WishlistModel> items = wishlistRepo.findByItemname(itemname);
		if(items.isEmpty()) {
			System.out.println(new ResourceNotFoundException("Wishlist item(s) with the name " + itemname + " not found"));
		}
		return wishlistRepo.findByItemname(itemname);
	}

//	Post request that allows user to add new item to wishlist. Fulfills the Create requirement in CRUD
	@PostMapping("/additem")
	public WishlistModel newItem(@RequestBody WishlistModel item) {
		return wishlistRepo.save(item);
}
	

	@PutMapping("updateitem/{id}")
	public ResponseEntity<WishlistModel> updateItem(@PathVariable int id, @RequestBody WishlistModel newItem){
		WishlistModel foundItem = wishlistRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found."));
		
		foundItem.setItemname(newItem.getItemname());
		foundItem.setItemdescription(newItem.getItemdescription());
		
		WishlistModel updatedItem = wishlistRepo.save(foundItem);
		
		return ResponseEntity.ok(updatedItem);
	}
//Delete request that deletes item by their id number. Fulfills the Delete requirement in CRUD
		@DeleteMapping("/deleteitem/{id}")
		public ResponseEntity<String> deleteItem(@PathVariable int id) {
			wishlistRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Item not found."));
			String message = "Item has been deleted.";
			wishlistRepo.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
}