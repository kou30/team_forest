package model;
import java.io.Serializable;

public class AnimalInfo implements Serializable{
	private int animalKey;	//動物のインデックス
	private String sex;		//性別
	private String age;		//年齢
	private String place;	//現在地
	private Long image;		//画像
	private int ifKey;

	public int getAnimalKey() { return animalKey; }
	public void setAnimalKey(int animalKey) { this.animalKey = animalKey; }

	public String getSex() { return sex; }
	public void setSex(String sex) { this.sex = sex; }

	public String getAge() { return age; }
	public void setAge(String age) { this.age = age; }

	public String getPlace() { return place; }
	public void setPlace(String place) { this.place = place; }

	public Long getImage() { return image; }
	public void setImage(long image) { this.image = image; }


	public int getifKey() { return ifKey; }
	public void setifKey(int ifKey) { this.ifKey = ifKey; }
	public AnimalInfo() {

	}

	public AnimalInfo(int animalKey) {
		this.animalKey = animalKey;

	}

	public AnimalInfo(int animalKey, String sex) {
		this.animalKey = animalKey;
		this.sex = sex;

	}

	public AnimalInfo(int animalKey, String sex, String age) {
		this.animalKey = animalKey;
		this.sex = sex;
		this.age = age;
	}

	public AnimalInfo(int animalKey, String sex, String age, String place) {
		this.animalKey = animalKey;
		this.sex = sex;
		this.age = age;
		this.place = place;
	}

	public AnimalInfo(int animalKey, String sex, String age, String place, Long image) {
	this.animalKey = animalKey;
		this.sex = sex;
		this.age = age;
		this.place = place;
		this.image = image;
	}

}