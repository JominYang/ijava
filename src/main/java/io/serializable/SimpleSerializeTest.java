package io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SimpleSerializeTest {

	//对象序列化到输出流
	public static void wirteObject() throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
		Person person = new Person("Jomin", 20);
		oos.writeObject(person);
	}
	
	//从输入流中泛序列化对象
	public static void readObject() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
		Person person = (Person) ois.readObject();
	}
}

class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String _name;
	private int _age;
	
	public Person(String name, int age) {
		_name = name;
		_age = age;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public int get_age() {
		return _age;
	}

	public void set_age(int _age) {
		this._age = _age;
	}
	
}
