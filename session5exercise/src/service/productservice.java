package service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import model.product;
import model.producttype;

public class productservice {
	private static final Logger logger=Logger.getLogger(productservice.class.getName());
	private static List<product> products;
	static {
		product pro1=new product("mobile",producttype.digital, 600, false);
		product pro2=new product("scarf",producttype.garment, 50, false);
		product pro3=new product("laptop",producttype.digital, 8000, true);
		product pro4=new product("chair",producttype.domestic, 800, false);
		product pro5=new product("tshirt",producttype.garment, 60, true);
		product pro6=new product("lamp",producttype.domestic, 500, false);
		product pro7=new product("chair",producttype.domestic, 400, false);
		product pro8=new product("chair",producttype.digital, 200, false);
		products=List.of(pro1,pro2,pro3,pro4,pro5,pro6,pro7,pro8);
	}
	//if client enter products name--------------------------------------------------------
	public static List<product> findproduct1(String productname) throws productnotfoundexception{
		logger.info("your enter:"+ productname +" for searching");
		List<product> findproduct=products.stream()
							   .filter(t ->t.getName().equals(productname))
							   .collect(Collectors.toList());
		if (findproduct.size()==0) {
			logger.warning("we couldn't find your product name type available product correctly");
			throw new productnotfoundexception("we couldn't find your product name");
		}
							   
		
		return findproduct;		
	}
	//if client enter type product for searching-------------------------------------------
	public static List<product> findproduct2(producttype type) throws producttypenotfoundexception{
		List<product> findproducts=products.stream()
							.filter(t ->t.getType().equals(type))
							.collect(Collectors.toList());
		if (findproducts.size()==0) {
			logger.warning("we couldn't find: "+type +" maybe you don't write correctly");
			throw new producttypenotfoundexception("we couldn't your target type product");
		}
		
		return findproducts;	
	}
	//if client enter nothing we should show all products---------------------------------------
	public static void findproduct3(){
		products.forEach(t -> System.out.println(t));	
	}
	//if client enter name,type,price for searching-------------------------------------------
	public static void findproduct4(String productname,producttype type,int price) throws productnotfoundexception,producttypenotfoundexception{
		
		List<product> firsttarget=findproduct1(productname);
		System.out.println("list products with name: "+ productname + "is  "+ firsttarget);
		
		List<product> secondtarget=firsttarget.stream()
								.filter(t ->t.getType().equals(type))
								.collect(Collectors.toList());
		if (secondtarget.size()==0) {
			throw new producttypenotfoundexception("we couldn't find your target type product");
		}
		System.out.println("list product with name: "+ productname + " and type: "+type +"  is: "+ secondtarget);
		
		List<product> thirdtarget=secondtarget.stream()
				            .filter(t -> t.getPrice()==price).collect(Collectors.toList());
		System.out.println("list product with name: "+ productname + " and type: "+type + " and pric: "+price+ "is "+ thirdtarget);
		
		
		
	}
	
	

}
