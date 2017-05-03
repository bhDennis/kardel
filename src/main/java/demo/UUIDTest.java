package demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class UUIDTest {

	public static void main(String[] args) {
		
//		UUID uuId = UUID.randomUUID();
//		
//		System.out.println(uuId);
//		
//		System.out.println(uuId.hashCode());
//		
//		Random random = new Random(uuId.hashCode());
//				
//		System.out.println(random.nextInt(100));
//		
//		System.out.println(System.currentTimeMillis());
//		
//		int random3 = (int)(Math.random()*1000);
//		
//		System.out.println(random3);
//		System.out.println(String.valueOf(System.currentTimeMillis())+random3);
		
//        int i = 32;
//        
//        int a = 65536;
//        
//        int b = 128;
//        
//        int c = 4096;
//        
//        boolean resulta = (a^i) < a ;
//        
//        boolean resultb = (b^i) < b  ;
//        
//        boolean resultc = (c^i) < c  ;
//        
//        boolean resultd = (i^i) < i  ;
//        
//        System.out.println("resulta="+(a^i)+","+resulta);
//        System.out.println("resultb="+(b^i)+","+resultb);
//        System.out.println("resultc="+(c^i)+","+resultc);
//        System.out.println("resultd="+(i^i)+","+resultd);
		
//		String serialNo = generateNo();
//		System.out.println(serialNo+",length:"+serialNo.length());
//		
//		String serialNo2 = generateNo2();
//		System.out.println(serialNo2+",length:"+serialNo2.length());
		
//		List<String> productNos = Arrays.asList("20161116001","20161116002","20161116001","20161116002","20161116001","20161116002");
//		System.out.println(productNos.size());
//		String result="";
//		for(int i = 0;i<productNos.size();i++){
//			if( i == 0){
//				result = result+productNos.get(i);
//				continue;
//			}else{
//				result = result+","+productNos.get(i);
//			}
//		}
//		System.out.println(result);
		
//		List<String> s = new ArrayList<String>(0);
//		String st = convertToString(s,",");
//		System.out.println(st);
		
//		List<Long> str = Arrays.asList(1l,2l);
//		
//		System.out.println(str.toString());
		
//		List<Integer> i1 = new ArrayList<Integer>();
//		i1.add(1);
//		i1.add(2);
//		i1.add(3);
//		i1.add(4);
//		i1.add(5);
//		i1.add(6);
//		
//		List<Integer> i2 = new ArrayList<Integer>();
//		i2.add(2);
//		i2.add(3);
//		i2.add(6);
//		
//		for(int i = 0;i<i1.size();i++){
//			Integer emp = i1.get(i);
//			for(int j = 0;j<i2.size();j++){
//				if(emp.intValue() == i2.get(j)){
//					break;
//				}
//			}
//			System.out.println("i="+emp);
//		}
		
//		String finalValueUnits = ";1256;1261;1271;1275;1277;1279;1283;1285;1286;1287;1288;1294;1313;1499;1563;";
//		if(finalValueUnits.startsWith(";")) finalValueUnits = finalValueUnits.substring(1);
//		System.out.println("finalValueUnits:"+finalValueUnits);
//		String[] strArray = finalValueUnits.split(";");
//		System.out.println("strArray:"+strArray);

		
//		List<Integer> is = new ArrayList<Integer>();
//		is.add(1);
//		is.add(2);
//		is.add(3);
//		is.add(4);
//		
//		List<Integer> is1 = is.stream().filter(i->i!=2).collect(Collectors.toList());
//		
//		List<Integer> is2 = is.stream().filter(j->
//		   {
//			   return j!=2;
//		   })
//		.collect(Collectors.toList());
//		System.out.println(is);
//		System.out.println(is1);
//		System.out.println(is2);
		
//        List<String> is = new ArrayList<String>();
//        is.add("a");
//        is.add("b");
//        System.out.println(is.toString());
		
//		String s = "1";
//		int i = 1;
//		Integer j = 1;
//		System.out.println(s.equals(i));
//		System.out.println(s.equals(j));
//		System.out.println(j.equals(i));
		
//		Integer i = 1;
//		int j = 1;
//		System.out.println(i.equals(j));
		
//		List<String> s  = Arrays.asList("a","b");
//		System.out.println(s);
//		
//		String[] strArray = new String[]{"a","b"};
//		System.out.println(strArray.toString());
//		
//		StringBuffer sb = new StringBuffer();
//		sb.append("a").append(",").append("b");
//		System.out.println(sb);
//		
		AtomicInteger i  = new AtomicInteger(0);
		i.addAndGet(10);
	    int result = i.addAndGet(20);
	    System.out.println(result);
		
//		int i = 1;
//		
//		if(i>0){
//			System.out.println("����0");
//		}else if(i == 1){
//			System.out.println("����1");
//		}else if(i>0.1){
//			System.out.println("����0.1");
//		}
		
	}
	
	public static String generateNo(){
		
		final int Min = 100000;
		final int Max = 999999;
		Random random = new Random(java.util.UUID.randomUUID().hashCode());
		int number = random.nextInt((Max - Min) + 1) + Min;		
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());	
		System.out.println("generateNo,number:"+number+",date:"+date);
		return "T" + date + number;
	}
	
	public static String generateNo2(){
		
		final int Min = 1000000;
		final int Max = 9999999;
		Random random = new Random(java.util.UUID.randomUUID().hashCode());
		int number = random.nextInt((Max - Min) + 1) + Min;		
		String date = String.valueOf(System.currentTimeMillis());
		System.out.println("generateNo2,number:"+number+",date:"+date);
		return "T" + date + number;
	}
	
	public static String convertToString(List<String> list,String separator){
		
		if(list == null || list.size() == 0)
			
			return "";
		
		if(list.size() == 1)
			
			return list.get(0);
		
		StringBuilder sb = new StringBuilder();
		sb.append(list.get(0));
		
		for(int i = 1;i<list.size();i++){
			sb.append(separator);
			sb.append(list.get(i));
		}
		
		return sb.toString();	
	}
}
