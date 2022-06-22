package sell.functions;

import java.util.HashMap;
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

 public Map<Double, Double> initMap(){
	 this.classification=new HashMap<Double,Double>();
	 return this.classification;
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
 
}
