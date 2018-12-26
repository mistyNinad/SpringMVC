package com.journaldev.spring;

import java.net.URI;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Product;
import com.journaldev.spring.service.PersonService;
import com.journaldev.spring.service.ProductService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView listProducts(Model model ) throws JSONException {
		System.out.println("inside products...");
		
		Response response = RestAssured.get("http://localhost:8080/restws/rest/products/1");
		
		String responseString = response.asString();
		
		System.out.println(responseString);
		
		JSONObject json = new JSONObject(responseString);
		
		Product p =new Product(json.getInt("productId"),  json.getString("productName"), json.getInt("productPrice"),json.getString("productCategory"));
		System.out.println("product "+p);
		
		
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", this.productService.listProducts());

		List<Product> lop = this.productService.listProducts();
		ModelAndView mav = new ModelAndView();
		mav.addObject("ninad", this.productService.listProducts());
		mav.setViewName("Product");

		return mav;
	}

	@RequestMapping(value = "/pro", method = RequestMethod.GET)
	public void m2() throws JSONException {

		RestAssured.baseURI = "http://localhost:3306/restws/rest";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "sample2ee26d9@gmail.com");

		System.out.println(requestParams.toString());

		request.body(requestParams.toString());

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		Response response = request.post("/products");
		
		//HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);

		
		//HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
		//restTemplate.put(uRL, entity);

	}

}
