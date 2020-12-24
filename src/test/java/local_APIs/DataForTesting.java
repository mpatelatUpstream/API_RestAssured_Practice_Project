package local_APIs;

import org.testng.annotations.DataProvider;

public class DataForTesting {
	
	@DataProvider(name ="DataForPost")
	public Object[][] dataForPost() {
		/*	Object[][] data = new Object[2][3];
		data[0][0] = "FName1";
		data[0][1] = "LName1";
		data[0][2] = 1;

		data[1][0] = "FName2";
		data[1][1] = "LName2";
		data[1][2] = 2;

		return data;*/

		return new Object[][] {
			{"FName1","LName1",1},
			{"FName2","LName2",2},
			{"Graham","Bell",1},
			{"Henry","Ford",2}, 
			{"Albert", "Einstein", 1},
			{"Thomas", "Edison", 2}
			};
	}

	@DataProvider(name="DataForDelete")
	public Object[] dataForDelete() {
		return new Object[] {6,7};
	}
}
