package me.dto;

import java.text.MessageFormat;

public class PickupDocumentSku {

	private Integer id;

    private String pickupSerialNo;

    private Integer skuId;

    private Integer productLevelId;

    private String shelfCode;
    
    private Integer quantity;

    private Integer pickupQuantity;
    
    private final static String keyLocateShelf = "skuId:{0}:productLevelId:{1}:shelfCode:{2}";
    
	public final static String keyLocateShelf(Integer skuId, Integer productLevelId,String shelfCode){
		return MessageFormat.format(keyLocateShelf, skuId, productLevelId, shelfCode);
	}
	
	public final String getKeyLocateShelf(){
		return keyLocateShelf(skuId,productLevelId,shelfCode);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPickupSerialNo() {
		return pickupSerialNo;
	}

	public void setPickupSerialNo(String pickupSerialNo) {
		this.pickupSerialNo = pickupSerialNo;
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public Integer getProductLevelId() {
		return productLevelId;
	}

	public void setProductLevelId(Integer productLevelId) {
		this.productLevelId = productLevelId;
	}

	public String getShelfCode() {
		return shelfCode;
	}

	public void setShelfCode(String shelfCode) {
		this.shelfCode = shelfCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPickupQuantity() {
		return pickupQuantity;
	}

	public void setPickupQuantity(Integer pickupQuantity) {
		this.pickupQuantity = pickupQuantity;
	}

	@Override
	public String toString() {
		return "PickupDocumentSku [id=" + id + ", pickupSerialNo=" + pickupSerialNo + ", skuId=" + skuId
				+ ", productLevelId=" + productLevelId + ", shelfCode=" + shelfCode + ", quantity=" + quantity
				+ ", pickupQuantity=" + pickupQuantity + "]";
	}
}
