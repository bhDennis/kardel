package demo;

import dto.PickupDocumentSku;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MainTest {

	public static void main(String[] args) {
		
//		List<Integer> productIds2 = Arrays.asList(1001,1002,1003,1004,1005,1006,1007,1009,1110,1111);
//		
//		List<Integer> productIds = new ArrayList<Integer>(productIds2);
//		productIds.add(1001);
//		productIds.add(1002);
//		productIds.add(1003);
//
//		for(int i=productIds.size()-1;i>=0;i--){
//			productIds.remove(i);
//		}
//		System.out.println(productIds);
		
		
//		PickupDocumentSku emp1 = new PickupDocumentSku();
//		emp1.setId(1);
//		emp1.setPickupSerialNo("A1");
//		emp1.setSkuId(60827);
//		emp1.setProductLevelId(122);
//		emp1.setShelfCode(String.valueOf(114));
//		emp1.setQuantity(5);
//		emp1.setPickupQuantity(2);
//		
//		
//		PickupDocumentSku emp2 = new PickupDocumentSku();
//		emp2.setId(2);
//		emp2.setPickupSerialNo("A2");
//		emp2.setSkuId(60827);
//		emp2.setProductLevelId(122);
//		emp2.setShelfCode(String.valueOf(114));
//		emp2.setQuantity(6);
//		emp2.setPickupQuantity(3);
//		
//		
//		PickupDocumentSku emp3 = new PickupDocumentSku();
//		emp3.setId(3);
//		emp3.setPickupSerialNo("A3");
//		emp3.setSkuId(60827);
//		emp3.setProductLevelId(122);
//		emp3.setShelfCode(String.valueOf(114));
//		emp3.setQuantity(7);
//		emp3.setPickupQuantity(4);
//		
//		PickupDocumentSku emp4 = new PickupDocumentSku();
//		emp4.setId(3);
//		emp4.setPickupSerialNo("A3");
//		emp4.setSkuId(60826);
//		emp4.setProductLevelId(122);
//		emp4.setShelfCode(String.valueOf(114));
//		emp4.setQuantity(7);
//		emp4.setPickupQuantity(4);
//		
//		List<PickupDocumentSku> lists = new ArrayList<PickupDocumentSku>(3);
//		lists.add(emp1);
//		lists.add(emp2);
//		lists.add(emp3);
//		lists.add(emp4);
//		
//		System.out.println(lists.get(6));
////		
//		List<PickupDocumentSku> afterFilterLists = lists.stream().filter(t->t.getId().equals(1)).collect(Collectors.toList());
//		
//		System.out.println(afterFilterLists);
//		
//		PickupDocumentSku p = new PickupDocumentSku();
//		System.out.println(p.getId() != null);
		
//		Map<String,List<PickupDocumentSku>> mapPickupDocumentSkus = lists.stream().collect(Collectors.groupingBy(t->t.getKeyLocateShelf()));
//	
//		System.out.println(mapPickupDocumentSkus);
		
		List<PickupDocumentSku> transferDetails = new ArrayList<PickupDocumentSku>(0);
	    transferDetails = transferDetails.stream().filter(t-> t.getId() != null).collect(Collectors.toList());
        
	    Map<Integer,PickupDocumentSku> mapTransferDetail = transferDetails.stream().collect(Collectors.toMap(t->t.getId(), t->t));

		System.out.println("測試");
		
	}
}
