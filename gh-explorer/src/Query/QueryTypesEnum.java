package Query;

public enum QueryTypesEnum {
	USER(1), REPO(2);
	
	private int type;
	
	QueryTypesEnum(int i) {
		this.type = i;
	}
	
	public int getType() {
		return type;
	}
}
