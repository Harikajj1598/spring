package org.jsp.merchantapp.controller;

import java.util.Optional;

import org.jsp.merchantapp.dao.MerchantDao;
import org.jsp.merchantapp.dto.Merchant;
import org.jsp.merchantapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseStructure<Merchant> saveMerchant(@RequestBody Merchant merchant) {
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
        merchant= dao.saveMerchant(merchant);
        structure.setData(merchant);
        structure.setMessage("Mercahnt registered succesfully");
        structure.setStatusCode(HttpStatus.CREATED.value());
        return structure;
	}
	
	
	@PutMapping("/merchant")
	public ResponseStructure<Merchant> updateMerchant(@RequestBody Merchant merchant) {
	
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
        merchant= dao.updateMerchant(merchant);
        structure.setData(merchant);
        structure.setMessage("Mercahnt updated succesfully");
        structure.setStatusCode(HttpStatus.ACCEPTED.value());
        return structure;
	}
	
	
	@GetMapping("/merchant/{id}")
	public ResponseStructure<Merchant> findById(@PathVariable int id ) {
		Optional<Merchant> recMerchant = dao.findById(id);
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			  structure.setData(recMerchant.get());
		        structure.setMessage("Mercahnt Found");
		        structure.setStatusCode(HttpStatus.OK.value());
		        return structure;
		}
	
		  structure.setData(null);
	        structure.setMessage(" Invaild Mercahnt Id");
	        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	        return structure;
	}
	
	
	@DeleteMapping("/merchant/{id}")
	public ResponseStructure<String> deleteById(@PathVariable int id) {
		ResponseStructure<String> structure= new ResponseStructure<>();
		boolean deleted = dao.deleteByid(id);
		
		if (deleted) {
			 structure.setData("merchant deleted");
		        structure.setMessage("Mercahnt Found");
		        structure.setStatusCode(HttpStatus.OK.value());
		        return structure;
		}

		  structure.setData(null);
	        structure.setMessage(" Invaild Mercahnt Id");
	        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	        return structure;
	}
	
	
	
	
	
	
	@PostMapping("/merchant/verify-by-phone")
	public ResponseStructure<Merchant> verifyMerchant(@RequestParam long phone, @RequestParam String password) {
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.verifyMerchant(phone , password);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
	        structure.setMessage("Mercahnt verified");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return structure;
			}

		  structure.setData(null);
	        structure.setMessage(" Invaild Mercahnt phone/password");
	        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	        return structure;

			
	}
	
	
	@PostMapping("/merchant/verify-by-name")
	public ResponseStructure<Merchant> verifyMerchant(@RequestParam String name, @RequestParam String password) {
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.verifyMerchant(name , password);
		
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
	        structure.setMessage("Mercahnt verified");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return structure;
		}
		structure.setData(null);
        structure.setMessage(" Invaild Mercahnt name/password");
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return structure;

		
	}
	

	@PostMapping("/merchant/verify-by-id")
	public ResponseStructure<Merchant> verifyMerchant(@RequestParam int id, @RequestParam String password) {
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.verifyMerchant(id , password);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
	        structure.setMessage("Mercahnt verified");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return structure;
		}
		structure.setData(null);
        structure.setMessage(" Invaild Mercahnt id/password");
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return structure;
		
	}
	
	

	@PostMapping("/merchant/verify-by-email")
	public ResponseStructure<Merchant> verifyMerchantbyemail(@RequestParam String email, @RequestParam String password) {
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.verifyMerchantbyemail(email , password);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
	        structure.setMessage("Mercahnt verified");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return structure;
		}
		structure.setData(null);
        structure.setMessage(" Invaild Mercahnt email/password");
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return structure;
	}
	
	
}
