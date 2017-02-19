package pers.fhr.musicstore.viewmodels;

public class ShoppingCartRemoveViewModel {
	 private String message;
	 private double cartTotal;
	 private int cartCount;
	 private int itemCount;
	 private int deleteId;
	 public ShoppingCartRemoveViewModel(String message,double cartTotal,int cartCount,int itemCount,int deleteId){
		 this.message=message;
		 this.cartTotal=cartTotal;
		 this.itemCount=itemCount;
		 this.deleteId=deleteId;
	 }
	 public ShoppingCartRemoveViewModel(){
		 
	 }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}
	public int getCartCount() {
		return cartCount;
	}
	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(int deleteId) {
		this.deleteId = deleteId;
	}
}
