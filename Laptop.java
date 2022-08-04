
public class Laptop {
	private String manufacturer;
	private String RAM;
	private int cost;
	public static void main(String[] args) {
		Laptop HP = new Laptop("HP", "6GB", 55000);
		HP.InsertingRAM();
	}
	public Laptop(String manufacturer, String rAM, int cost) {
		super();
		this.manufacturer = manufacturer;
		RAM = rAM;
		this.cost = cost;
	}
	
	private MotherBoard ATX = new MotherBoard("Intel", "11th",true);
	
	public void InsertingRAM() {
		System.out.println(ATX.canRAMBeExtendable(true));
	}
	
	static class MotherBoard{
		private String provider;
		private String generation;
		private boolean isRAMSlotAvailable;
		
		public MotherBoard(String provider, String generation, boolean isRAMSlotAvailable) {
			super();
			this.provider = provider;
			this.generation = generation;
			this.isRAMSlotAvailable = isRAMSlotAvailable;
		}	
		
		String canRAMBeExtendable(boolean checker) {
			this.isRAMSlotAvailable=checker;
			if(this.isRAMSlotAvailable) {
				return "YES Can be Extended";
			}
			else {
				return "No space Available";
			}
		}
		
	}



	
}
