package com.googlecode.simplelife.struts;

public class ProductAction {
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String execute() throws Exception {
		System.out.println(">>" + this.product);
		return "success";
	}
}
