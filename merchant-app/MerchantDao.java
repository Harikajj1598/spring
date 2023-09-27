package org.jsp.merchantapp.dao;


import java.util.Optional;


import org.jsp.merchantapp.dto.Merchant;
import org.jsp.merchantapp.repository.MerchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {

	
	@Autowired
	private MerchatRepository repository;
	
	public Merchant saveMerchant(Merchant merchant) {
		System.out.println(repository);
		return repository.save(merchant);
	}
	
	public Merchant updateMerchant(Merchant merchant) {
		
		return repository.save(merchant);
	}
	
	public Optional<Merchant> findById(int id ){
		
		return repository.findById(id);
	}
	
	public boolean deleteByid (int id ) {
		
		Optional<Merchant> recMerchant = findById(id);
		if (recMerchant.isPresent()) {
			repository.delete(recMerchant.get());
			repository.deleteById(id);
			return true ;
		}
		return false ;
	}
	
    public Optional<Merchant> verifyMerchant (long phone, String password){
    	return repository.verifyMerchant(phone, password);
    		
    }
	
    

    public Optional<Merchant> verifyMerchant (String name, String password){
    	return repository.verifyMerchant(name, password);
    		
    }
	

    public Optional<Merchant> verifyMerchant (int id, String password){
    	return repository.verifyMerchant(id, password);
    		
    }
    
    public Optional<Merchant> verifyMerchantbyemail (String email, String password){
    	return repository.verifyMerchant(email, password);
    		
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	
	
	
	
	
}
