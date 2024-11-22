package digikala;

import java.util.Scanner;

import model.producttype;
import service.productnotfoundexception;
import service.productservice;
import service.producttypenotfoundexception;

public class digikalaapp {

	public static void main(String[] args) {
		//-----------------------------enter product name--------------------------------------------------------------------
		String nameproduct;
		Scanner name=new Scanner(System.in);
		System.out.println("enter your desire product:  "+ "available product: mobile,scarf,laptop,chair,tshirt,lamp");
		nameproduct=name.nextLine();
		System.out.println("we are searching..."+ nameproduct);
		try {
			var targetproduct1=productservice.findproduct1(nameproduct);
			System.out.println(targetproduct1);
		} catch (productnotfoundexception e) {
			System.out.println("we couldn't find your product enter available product correctly");
			
		}
		//-----------------------------------enter type product------------------------------------------------------------
		String typeinput;
		producttype type;
		Scanner namee=new Scanner(System.in);
		System.out.println("enter your desire typ product:  "+ "available typ:  digital,garment,domestic");
		typeinput=namee.nextLine();
		type=producttype.valueOf(typeinput);
		System.out.println("we are searching..."+ type);
		try {
			var targetproduct2=productservice.findproduct2(type);
			System.out.println(targetproduct2);
		} catch (producttypenotfoundexception e) {
			System.out.println("we couldn't find your product enter available type product correctly");
		}
		//--------------------------------------enter nothing --------------------------------------------------------------
		System.out.println("******************************************");
		System.out.println("if you enter nothing we will show all product");
		productservice.findproduct3();
		
		//----------------------------------enter name,type,price--------------------------------------------------
		System.out.println("***************************************");
		try {
			productservice.findproduct4("chair",producttype.domestic, 400);
		} catch (productnotfoundexception e) {
			System.out.println("we couldn't find your product name");
		} catch (producttypenotfoundexception e) {
			System.out.println("we couldn't fin your product with your type");
		}
		
		
	}

}
