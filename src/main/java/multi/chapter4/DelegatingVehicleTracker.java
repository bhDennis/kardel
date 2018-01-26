package multi.chapter4;

import dto.Point;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


//p.68 基于委托的车辆追踪器 线程安全的
public class DelegatingVehicleTracker {

	private final ConcurrentMap<String, Point> locations;
	private final Map<String,Point> unmodifiableMap;
	
	public DelegatingVehicleTracker(Map<String,Point> points){
		locations = new ConcurrentHashMap<String,Point>(points);
		unmodifiableMap = Collections.unmodifiableMap(locations); //ǳ����
	}
	
	public Map<String,Point> getLocations(){
		return unmodifiableMap;
	}
	
	public Point getLocation(String id){
		return locations.get(id);
	}
	
	public void setLocation(String id,int x,int y){
		if(locations.replace(id, new Point(x,y)) == null){
			throw new IllegalArgumentException("invalid vehicle name:"+id);
		}
	}
	
}
