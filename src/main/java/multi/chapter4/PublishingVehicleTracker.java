package multi.chapter4;

import dto.SafePoint;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


// p.73 线程安全的 将安全性委托给底层的ConcurrentHashMap 只是map中的元素是线程安全的且可变的

public class PublishingVehicleTracker {

	private final Map<String, SafePoint> locations;
	private final Map<String,SafePoint> unmodifiableMap;
	
	public PublishingVehicleTracker(Map<String,SafePoint> locations){
		this.locations = new ConcurrentHashMap<String,SafePoint>(locations);
		this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
	}
	
	public Map<String,SafePoint> getLocations(){
		return unmodifiableMap;
	}
	
	public SafePoint getLocation(String id){
		return locations.get(id);
	}
	
	public void setLocation(String id,int x,int y){
		if(!locations.containsKey(id)){
			throw new IllegalArgumentException("invalid vehicle name:"+id);
		}
		locations.get(id).set(x, y);
	}
}
