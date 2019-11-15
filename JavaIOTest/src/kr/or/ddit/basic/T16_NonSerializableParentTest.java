package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 부모 클래스가 Serializable 인터페이스를 구현하고 자식 클래스가 이를 상속받을 경우 
 * 자동적으로 자식 클래스는 Serializable을 상속 받는다 
 * ------------------------------------------------------------------------
 * 부모 클래스가 Serializable 인터페이스를구현하고 있지 않은 경우
 * 부모 객체의 필드값 처리 방법
 * 1.부모 클래스가 Serializable인터페이스를 구현하도록 해야한다. - 이를 상속한 자식 클래스는 모두 Serializable
 * 2. 자식 클래스에 writeObject()와 readObject()메소드를 이용해
 * 부모 객체의 필드값을 처리할 수 있도록 직접 구현
 */
public class T16_NonSerializableParentTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("d:/D_Other/nonSerialTest.bin");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		
		Child child = new Child();
		child.setParentName("부모");
		child.setChildName("자식");
		oos.writeObject(child);// 밑에 메소드 실행 , object의 writeObject가 실행되는 것이 아님
		oos.flush(); // 생략 가능
		oos.close();
		//---------------------------------------
		FileInputStream fis = new FileInputStream("d:/D_Other/nonSerialTest.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Child child2 = (Child) ois.readObject();
		System.out.println("parentName:" + child2.getParentName());
		System.out.println("ChildName:" + child2.getChildName());
	}
}
/*
 *  Serializable 을 구현하지 않은 부모 클래스
 * 
 */
class Parent{
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
/*
 * Serializable을 구현한 자식 클래스
 */
class Child extends Parent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	//직렬화 될 때 자동으로 호출된다
	// 접근제한자가 private이 아니면 자동 호출 되지 않는다 
	// 없으면 parentName = null, ChildName = 세팅값
	// 원래 객체를 읽어들이는 writeObject를 재정의(와 비슷한 방법)하여 사용
	private void writeObject(ObjectOutputStream out) throws IOException{ // 일종의 재정의
		//ObjectOutputStream 객체의 메소드를 이용해 부모객체 필드값 처리
		out.writeUTF(getParentName()); // 상속받은 부모 값을 수동으로 추가
		out.defaultWriteObject(); // 더 이상 쓸 것이 없다면 실행됨
	}

	//역직렬화 될 때 자동으로 호출된다
	// 접근제한자가 private이 아니면 자동 호출 되지 않는다 
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{ // 일종의 재정의
		// ObjectInputStream객체의 메소드를 이용해 부모객체 필드값 처리
		setParentName(in.readUTF());
		in.defaultReadObject();
		
	}	
}
