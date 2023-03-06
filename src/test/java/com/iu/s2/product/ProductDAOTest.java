package com.iu.s2.product;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s2.MyTestCase;
import com.iu.s2.bankBook.BankBookDTO;

public class ProductDAOTest extends MyTestCase{

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void getProductListTest() throws Exception {
		 List<ProductDTO> ar = productDAO.getProductList();
		 //단정문 
		 assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getProductDetailTest()throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(11L);
		productDTO = productDAO.getProductDetail(productDTO);
		assertNotNull(productDTO);
	}
	
	//insert
	//@Test
	public void setProductAddTest()throws Exception{
		
		for(int i=0;i<30;i++) {
			Random r = new Random();
			double d = r.nextDouble();//0.1234
			int num = (int)(d*1000);//123
			d = num/100.0;
			
			BankBookDTO bankBookDTO= new BankBookDTO();
			bankBookDTO.setBookName("우리저금"+i);
			bankBookDTO.setBookRate(d);
			bankBookDTO.setBookSale(1);
		}
		System.out.println("Finish");
		
	}

}
