package sell.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Numeric {
 public Double key;
 public Double value;
 public Double remainder;
 public Map<Double, Double> classification;
 public List<Map<Double,Double>> list; 
 public Double maximum;
 public Integer counter;
 public int indexOfArray;
 int[] numberArray;
 List<Double> doubleNumArray;

 public Map<Double, Double> initMap(){
	 this.classification=new HashMap<Double,Double>();
	 return this.classification;
 }
 
 public List<Double> initList(){
	 this.doubleNumArray=new ArrayList<Double>();
	 return this.doubleNumArray;
 }
 
 
 public int getIndexOfArray() {
	 return indexOfArray;
 }
 
 
 public int[] generateRandomIndexesWithoutRepeat(int number, int howMany) {
		
		 int array[] = new int[number];
			 for (int i=0; i< array.length;i++) {
					int num=generateValue(number);
					array[i]=num;
					
				} 
		
		
         

		 return array;
	}



	public int generateValue(int max) {
		 Faker faker = new Faker();
		return faker.random().nextInt(0, max);
	}

	public  void printArray(int array[]) {
		for (int i : array) {
			System.out.println(i);
		}
	}
 
public List<Double> convertMapToDoubleArray(Map<Double,Double> map, int howMany) {
	initList();
	int index=0;
	for (Map.Entry<Double, Double> entry : map.entrySet()) {
		if(index==howMany) break;
		
	    System.out.println("Index"+index);  
		Double key = entry.getKey();
		doubleNumArray.add(key);
		Double val = entry.getValue();
		doubleNumArray.add(val);
		index++;
		
		System.out.println(key+" "+ val);
		//numeric.getClassification().put(key, val);
		printDoubleList(getDoubleNumArray());
	}

	return getDoubleNumArray();
   
}

public void printDoubleList(List<Double> list) {
	for (Double double1 : list) {
		System.out.println("Value"+double1);
	}
	
}
	
}
