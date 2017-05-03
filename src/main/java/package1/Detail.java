package package1;

public class Detail {

	private String productNo;
	
	private String receiveDept;

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getReceiveDept() {
		return receiveDept;
	}

	public void setReceiveDept(String receiveDept) {
		this.receiveDept = receiveDept;
	}

	@Override
	public String toString() {
		return "Detail [productNo=" + productNo + ", receiveDept=" + receiveDept + "]";
	}
	
}
