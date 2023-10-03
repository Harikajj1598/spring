package org.jsp.merchantapp.service;
import java.util.Optional;

import org.jsp.merchantapp.dao.MerchantDao;
import org.jsp.merchantapp.dao.ProductDao;
import org.jsp.merchantapp.dto.Merchant;
import org.jsp.merchantapp.dto.Product;
import org.jsp.merchantapp.dto.ResponseStructure;
import org.jsp.merchantapp.execption.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class ProductService {
	@Autowired
	private ProductDao dao;
	@Autowired
	private MerchantDao merchantDao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product,int merchant_id)
	{
		ResponseStructure<Product> structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=merchantDao.findById(merchant_id);
		if(recMerchant.isPresent())
		{
			Merchant m=recMerchant.get();
			m.getProducts().add(product);
			product.setMerchant(m);
			merchantDao.updateMerchant(m);
			dao.saveProduct(product);
			structure.setMessage("Product added");
			structure.setData(product);
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product,int merchant_id)
	{
		ResponseStructure<Product> structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=merchantDao.findById(merchant_id);
		if(recMerchant.isPresent())
		{
			Merchant m=recMerchant.get();
			product.setMerchant(m);
			dao.saveProduct(product);
			structure.setMessage("Product updated");
			structure.setData(product);
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Product>> findById(int id)
	{
		ResponseStructure<Product> structure=new ResponseStructure<>();
		Optional<Product> recProduct=dao.findById(id);
		if(recProduct.isPresent())
		{
			structure.setData(recProduct.get());
			structure.setMessage("Product is found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Merchant>> findByMerchantId(int mercahnt_id)
	{
		ResponseStructure<Merchant> structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=merchantDao.findById(mercahnt_id);
		if(recMerchant.isPresent())
		{
			structure.setData(recMerchant.get());
			structure.setMessage("Products found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

}
