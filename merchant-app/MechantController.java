package org.jsp.merchantapp.controller;

import java.util.Optional;

import org.jsp.merchantapp.dao.MerchantDao;
import org.jsp.merchantapp.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MerchantController {

	
	@Autowired
	private MerchantDao dao;
	
	@PostMapping("/merchant")
	public Merchant saveMerchant(@RequestBody Merchant merchant) {
		
		System.out.println(merchant.getEmail());
		
		return dao.saveMerchant(merchant);
	}
	
	
	@PutMapping("/merchant")
	public Merchant updateMerchant(@RequestBody Merchant merchant) {
	
		
		return dao.updateMerchant(merchant);
	}
	
	
	@GetMapping("/merchant/{id}")
	public Merchant findById(@PathVariable int id ) {
		Optional<Merchant> recMerchant = dao.findById(id);
		if (recMerchant.isPresent())
		return recMerchant.get();
		return null;
		
	}
	
	
	@DeleteMapping("/merchant/{id}")
	public String deleteById(@PathVariable int id) {
		boolean deleted = dao.deleteByid(id);
		if (deleted)
		return "merchant deleted";
		return "merchant  not deleted";
		
	}
	
	
	
	
	
	
	@PostMapping("/merchant/verify-by-phone")
	public Merchant verifyMerchant(@RequestParam long phone, @RequestParam String password) {
		Optional<Merchant> recMerchant = dao.verifyMerchant(phone , password);
		if (recMerchant.isPresent())
		return recMerchant.get();
		return null;
			
	}
	
	
	@PostMapping("/merchant/verify-by-name")
	public Merchant verifyMerchant(@RequestParam String name, @RequestParam String password) {
		Optional<Merchant> recMerchant = dao.verifyMerchant(name , password);
		if (recMerchant.isPresent())
		return recMerchant.get();
		return null;	
		
	}
	

	@PostMapping("/merchant/verify-by-id")
	public Merchant verifyMerchant(@RequestParam int id, @RequestParam String password) {
		Optional<Merchant> recMerchant = dao.verifyMerchant(id , password);
		if (recMerchant.isPresent())
		return recMerchant.get();
		return null;	
		
	}
	
	

	@PostMapping("/merchant/verify-by-email")
	public Merchant verifyMerchantbyemail(@RequestParam String email, @RequestParam String password) {
		Optional<Merchant> recMerchant = dao.verifyMerchantbyemail(email , password);
		if (recMerchant.isPresent())
		return recMerchant.get();
		return null;	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
