package multi.chapter4;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//p.70 线程安全的  VisualComponent将其线程安全性委托给keyListeners和 mouseListeners 两个独立的状态变量   可与 NumberRange类比
public class VisualComponent {

	private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<KeyListener>(); // CopyOnWriteArrayList是一个线程安全的链表
	private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<MouseListener>();
	
	public void addKeyListener(KeyListener listener){
		keyListeners.add(listener);
	}
	
	public void addMouseListener(MouseListener listener){
		mouseListeners.add(listener);
	}
	
	public void removeKeyListener(KeyListener listener){
		keyListeners.remove(listener);
	}
	
	public void removeMouseListener(MouseListener listener){
		mouseListeners.remove(listener);
	}
}
