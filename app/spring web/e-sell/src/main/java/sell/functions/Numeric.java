package sell.functions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

 public Map<Double, Double> initMap(){
	 this.classification=new HashMap<Double,Double>();
	 return this.classification;
 }
 
 public int getIndexOfArray() {
	 return indexOfArray;
 }
}
