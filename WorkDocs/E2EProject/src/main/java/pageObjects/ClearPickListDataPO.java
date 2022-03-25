package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import resources.base;

public class ClearPickListDataPO extends base {
	
	public ClearPickListDataPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}
	
	public void ClearPrimaryApplicant() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Primary Applicant");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Primary Applicant", i+1, 1, "");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Primary Applicant", i+1, 3, "");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Primary Applicant", i+1, 5, "");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Primary Applicant", i+1, 7, "");
		}
	}
	
	public void ClearHouseholdMemberDetails() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i+1, 1, "");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i+1, 3, "");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i+1, 5, "");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Household Member Details", i+1, 7, "");
		}
	}
	
	public void ClearContactDetails() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Contact Details");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Contact Details", i+1, 1, "");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Contact Details", i+1, 3, "");
		}
	}
	
	public void ClearAuthorizedRepresentative() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Authorized Representative");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Authorized Representative", i+1, 1, "");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Authorized Representative", i+1, 3, "");
		}
	}
	
	public void ClearRelationships() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Relationships");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Relationships", i+1, 1, "");
			
		}
	}
	
	public void ClearHighestLevelOfEducation() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Highest Level of Education");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Highest Level of Education", i+1, 1, "");
			
		}
	}
	
	public void ClearCurrentEducation() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Current Education");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Current Education", i+1, 1, "");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Current Education", i+1, 3, "");
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Current Education", i+1, 5, "");
		}
	}
	
	public void ClearAmericanIndianAlaskanNative() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "American Indian Alaskan Native");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "American Indian Alaskan Native", i+1, 1, "");

		}
	}
	
	public void ClearPregnancy() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Pregnancy");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Pregnancy", i+1, 1, "");

		}
	}
	
	public void ClearPLLivingArrangement() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Living Arrangement");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Living Arrangement", i+1, 1, "");

		}
	}
	
	public void ClearPLConviction1() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Conviction");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Conviction", i+1, 1, "");

		}
	}
	
	public void ClearPLConviction2() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Conviction");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Conviction", i+1, 3, "");

		}
	}
	
	//****************************ALL ASSET*****************************************************
	
	public void ClearPLAllTypeofAsset() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "All Assets");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "All Assets", i+1, 1, "");

		}
	}
	
	public void ClearPLLifeInsurance() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Life Insurance");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Life Insurance", i+1, 1, "");

		}
	}
	
	public void ClearPLBurialAsset() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Burial");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Burial", i+1, 1, "");

		}
	}
	
	public void ClearPLRealEstateProperty() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Real Estate");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Real Estate", i+1, 1, "");

		}
	}
	
	public void ClearPLVehicle() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Vehicle");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Vehicle", i+1, 1, "");

		}
	}
	
	public void ClearPLTrust() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Trust");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Trust", i+1, 1, "");

		}
	}
	
	public void ClearPLAccount() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Account");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Account", i+1, 1, "");

		}
	}
	
	public void ClearPLInvestment() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Investment");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Investment", i+1, 1, "");

		}
	}
	
	public void ClearPLOtherLiquidAsset() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Other Liquid Asset");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "Asset-Other Liquid Asset", i+1, 1, "");

		}
	}
	
	//****************************ALL INCOME & SUBSIDIES*****************************************************
	
	public void ClearPLAllTypeofIncome() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Job Income");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Job Income", i+1, 1, "");

		}
	}
	
	public void ClearPLTypeofjobincome() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Job Income");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Job Income", i+1, 1, "");

		}
	}
	
	public void ClearPLIncomefrequency() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "All Income and Subsidies");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "All Income and Subsidies", i+1, 3, "");

		}
	}
	
	public void ClearPLsocialsecurityrailroad() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Social Security");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Social Security", i+1, 1, "");

		}
	}
	
	public void ClearPLSelfEmployment() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Self-Employ");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Self-Employ", i+1, 1, "");

		}
	}
	
	public void ClearPLretirementpension() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Retire pension");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Retire pension", i+1, 1, "");

		}
	}
	
	public void ClearPLdividendsinterests() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Dividends");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Dividends", i+1, 1, "");

		}
	}
	
	public void ClearPLmaintenanceincome() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Maintance Income");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Maintance Income", i+1, 1, "");

		}
	}
	
	public void ClearPLTypeofinsurancepayment() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Insurance");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Insurance", i+1, 1, "");

		}
	}
	
	public void ClearPLTypeofothergoods() throws Exception {
		
		int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Other goods");
		System.out.println(k);
		for(int i=0;i<=k;i++) {
			
			setData("src\\main\\java\\testData\\PickListResult.xlsx", "IncSub-Other goods", i+1, 1, "");

		}
	}
	
	//****************************ALL Expenses*****************************************************
	
		public void ClearPLAllTypeofExpenses() throws Exception {
			
			int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "All Expenses");
			System.out.println(k);
			for(int i=0;i<=k;i++) {
				
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "All Expenses", i+1, 1, "");

			}
		}
		
		public void ClearPLTypeofshelterexpense() throws Exception {
			
			int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Shelter Expense");
			System.out.println(k);
			for(int i=0;i<=k;i++) {
				
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Shelter Expense", i+1, 1, "");

			}
		}
		
		public void ClearPLTypeofutilityexpense() throws Exception {
			
			int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Utility Expense");
			System.out.println(k);
			for(int i=0;i<=k;i++) {
				
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Utility Expense", i+1, 1, "");

			}
		}
		
		public void ClearPLTypeoftaxdeduction() throws Exception {
			
			int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Tax Deduction");
			System.out.println(k);
			for(int i=0;i<=k;i++) {
				
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Tax Deduction", i+1, 1, "");

			}
		}
		
		public void ClearPLExpenseFrequency() throws Exception {
			
			int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "All Expenses");
			System.out.println(k);
			for(int i=0;i<=k;i++) {
				
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "All Expenses", i+1, 3, "");

			}
		}
		
		public void ClearPLTypeofmedicalexpense() throws Exception {
			
			int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Medical Expense");
			System.out.println(k);
			for(int i=0;i<=k;i++) {
				
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "Expense-Medical Expense", i+1, 1, "");

			}
		}
			
	
		public void ClearPLNotUSCitizen() throws Exception {
			
			int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "Not US Citizen");
			System.out.println(k);
			for(int i=0;i<=k;i++) {
				
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "Not US Citizen", i+1, 1, "");
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "Not US Citizen", i+1, 3, "");

			}
		}
		

		public void ClearPLMemEnroll() throws Exception {
			
			int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "HealthCare Coverage");
			System.out.println(k);
			for(int i=0;i<=k;i++) {
				
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "HealthCare Coverage", i+1, 1, "");

			}
		}
		
		public void ClearPLReasonforRemoval() throws Exception {
			
			int k=getRowCount("src\\main\\java\\testData\\PickListResult.xlsx", "HealthCare Coverage");
			System.out.println(k);
			for(int i=0;i<=k;i++) {
				
				setData("src\\main\\java\\testData\\PickListResult.xlsx", "HealthCare Coverage", i+1, 3, "");

			}
		}
		
	public void AllClear() throws Exception {
		
		  ClearPrimaryApplicant();
		  ClearAmericanIndianAlaskanNative();
		  ClearAuthorizedRepresentative();
		  ClearContactDetails();
		  ClearCurrentEducation();
		  ClearHighestLevelOfEducation();
		  ClearHouseholdMemberDetails();
		  ClearPLAccount();
		  ClearPLAllTypeofAsset();
		  ClearPLAllTypeofIncome();
		  ClearPLBurialAsset();
		  ClearPLConviction1();
		  ClearPLConviction2();
		  ClearPLdividendsinterests();
		  ClearPLIncomefrequency();
		  ClearPLInvestment();
		  ClearPLLifeInsurance();
		  ClearPLLivingArrangement();
		  ClearPLmaintenanceincome();
		  ClearPLOtherLiquidAsset();
		  ClearPLRealEstateProperty(); 
		  ClearPLretirementpension();
		  ClearPLSelfEmployment();
		  ClearPLsocialsecurityrailroad(); 
		  ClearPLTrust();
		  ClearPLTypeofinsurancepayment();
		  ClearPLTypeofjobincome();
		  ClearPLTypeofothergoods(); 
		  ClearPLVehicle();
		  ClearPregnancy();
		  ClearRelationships(); 

	}

}
