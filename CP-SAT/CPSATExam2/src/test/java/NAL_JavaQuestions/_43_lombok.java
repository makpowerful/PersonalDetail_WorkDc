package NAL_JavaQuestions;

public class _43_lombok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_43_lombokPO lm = new _43_lombokPO("kalam",30,true);
		
		System.out.println(lm);
		System.out.println(lm.getCustomerName()+ ", "+lm.getAge()+ ", "+lm.isActive());
		
	}

}
