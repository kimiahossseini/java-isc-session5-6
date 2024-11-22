package model;

public class product {
	public String name;
	public producttype type;
	public int price;
	public boolean sale;
	public product(String name, producttype type, int price, boolean sale) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.sale = sale;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public producttype getType() {
		return type;
	}
	public void setType(producttype type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isSale() {
		return sale;
	}
	public void setSale(boolean sale) {
		this.sale = sale;
	}
	@Override
	public String toString() {
		return "product [name=" + name + ", type=" + type + ", price=" + price + ", sale=" + sale + "]";
	}
	
	

}
