package com.journaldev.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Product;

import io.restassured.RestAssured;
import io.restassured.response.Response;



@Repository
public class ProductDAOImpl implements ProductDAO{

	@Override
	public List<Product> listProducts() throws JSONException {
		System.out.println("in pd dao impl..");
		
		 Response response = RestAssured.get("http://localhost:8080/restws/rest/products/1");
			
		String responseString = response.asString();
		
		System.out.println(responseString);
		
		JSONObject json = new JSONObject(responseString);
		
		System.out.println("json tostring "+json.toString());
		json=new JSONObject(json.toString());
		Product p =new Product(json.getInt("productId"),  json.getString("productName"), json.getInt("productPrice"),json.getString("productCategory"));
		System.out.println("myproduct :"+p);
		
		JSONArray jsonArray = new JSONArray(responseString);
		 json =null;
		List<Product> productList = new ArrayList();
		for(int i=0;i<jsonArray.length();i++){
			 json = new JSONObject(jsonArray.get(i).toString());
			 productList.add(new Product(json.getInt("productId"),  json.getString("productName"), json.getInt("productPrice"),json.getString("productCategory")));
		}
		return null;
		
		
	}

}
