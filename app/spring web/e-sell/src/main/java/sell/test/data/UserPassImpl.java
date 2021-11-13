package sell.test.data;

import java.io.File;
import java.util.Map;

import com.github.javafaker.Faker;

import lombok.NoArgsConstructor;
import sell.sellers.Sellers;

@NoArgsConstructor
public class UserPassImpl implements UserPassword{

	@Override
	public boolean saveTestData(Map<Integer, Sellers> data) {
		Faker faker = new Faker();
		//morati cu provjeravati za isti number trebam listu saveanih integera u fileu i 
		//funkciju za kreiranje random random vrijednosti varijabli funkcija posebna cita 
		//listu i vraca listu po kojoj ce se gledati idovi i prema kojoj ce se
		//generirati lista ako prazan file ne postoji ili ako je lista prazna
		//generira se odmah random integer. 
		Integer numb=faker.number().randomDigit();
		return false;
	}

	@Override
	public void readData(File file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readUserPasswordByDesktopApplication(File file) {
		// TODO Auto-generated method stub
		
	}

}
