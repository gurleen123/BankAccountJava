/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1_200396648;

import java.util.ArrayList;

/**
 *
 * @author gurleenrandhawa
 */
public class Bank {
//     Pleaseaddaminimumof3BranchLocationsvalue
  public static enum BranchLocations {LONDON,BRAMPTON,TORONTO};
   
//  Create the necessary instance variables. These instance variables should only be accessible inside the Bank class.
	private String bankName;
        private BranchLocations branchLocations;
        private String bankLocation;
        public ArrayList<Account> accounts = new ArrayList<>();
        
       // Default constructor Leaveblank.
	public Bank() {}
        
//        Constructor with 2 arguments Sets the instance variables of the class

	public Bank(String bankName, String branchLocation) {
            if(testBankName(bankName))
                this.bankName = bankName;
            else
                this.bankName = null;
            if(testBranchLocation(branchLocation))
                this.branchLocations = BranchLocations.valueOf(branchLocation);
            else
                this.branchLocations = null;
        
        }
        
        //        Constructor with 2 arguments Sets the instance variables of the class
	public Bank(String bankName, BranchLocations branchLocation) {
            if(testBankName(bankName))
                this.bankName = bankName;
            else
                this.bankName = null;
            this.branchLocations = branchLocation;
        
        }
       
//        getBankName retrievesthenameofthebank

public String getBankName() {
    if(bankName!=null)
        return bankName;
    else
    return "";
}
       
//setBankName
//o returns a Boolean value representing whether the bank name is valid o only updates the name of the bank if the name is valid

	public boolean setBankName(String bankName) {
            String BankNameRegex = "^[a-zA-Z]+$";
            if(bankName.matches(BankNameRegex) && bankName.length() >=5 ) //     bank name can only contain alphabetical characters o A-Z, a-z
                                                                          //▪ (Please note there can be zero or many of this characters) min. 5 characters
                
                return true;
            else{
		return false;
            }
	}
        
//setBranchLocation x 2
// returns a Boolean value representing whether the bank branch is valid
	public boolean setBranchLocation(String branchLocation) {
            if(testBranchLocation(branchLocation)){
                this.branchLocations = BranchLocations.valueOf(branchLocation) ; //        It’s Branch location (one possible value from the enum of BranchLocations)
                return true;
            }else{
		return false;
            }
	}
        
//        getBranchLocation
//       returns a string representation of the branch location instance variable
	public String getBranchLocation() {
            if(branchLocations!=null)
		return branchLocations.name();
            else
                return "";
	}

    @Override
    public String toString() {
        return "Bank{" + "branchLocations=" + branchLocations + ", bankLocation=" + bankLocation + '}';
    }

			
	public boolean setBranchLocation(BranchLocations branchLocation) {
            this.branchLocations = branchLocation;
            return false;
	}
        
//getAccountByNumber
//o returns an Account object if the account number is found in the list of Accounts o if the account number is not found, return an empty object using the default constructor

	public Account getAccountByNumber(String accountNumber) {
            for (Account account : accounts) {
             if(account.accountNumber.equals(accountNumber)){
                 return account;
             }   
            }
		return new Account();
	}
	
//        Methods to add an account.
//        Ensure the account number is unique. This is a requirement for the account to be added the Bank.
	public boolean addAccount(Account account) {
            if(accounts.isEmpty() ){
                accounts.add(account);
                return true;
            }
            for (Account account1 : accounts) {
                if(!account1.accountNumber.equals(account.accountNumber)){
                    accounts.add(account);
                    return true;
                }
            }
            return false;
	}
	public boolean addAccount(String accountName, String accountNumber, double accountBalance) {
          if(accounts.isEmpty()){
              Account account = new Account();
              if(testAccountName(accountName)){
                  account.setAccountName(accountName);
              }
              if(testAccountNumber(accountNumber))
                  account.setAccountNumber(accountNumber);
              if(testAccountBalance(accountBalance))
                  account.setAccountBalance(accountBalance);
              
              accounts.add(account);
              return true;
          }
            for (Account account : accounts) {
                if(!account.accountNumber.equals(accountNumber)
                        && testAccountName(accountName)
                         && testAccountNumber(accountNumber)
                            && testAccountBalance(accountBalance)){
                
                    accounts.add(new Account(accountName, accountNumber, accountBalance));
                    return true;
                }
            }
            return false;
	}
        
//        viewAccount(String)
	public Account viewAccount(String accountNumber) {
            for (Account account : accounts) {
                if(account.accountNumber.equals(accountNumber)){
                    return account;
                }
            }
		return new Account();
	}
        
//        viewAccount(int)
	public Account viewAccount(int index) {
            if(index >= 0 && accounts.get(index)!=null){
                return accounts.get(index);
            }else{
		return new Account();
            }
	}
        
//        Methods to modify an account
	public boolean modifyAccount(String accountNumber, String accountName) {
            for (Account account : accounts) {
                if(account.getAccountNumber().equals(accountNumber)){
                    Account newAccount = getAccountByNumber(accountNumber);
                    if(testAccountName(accountName)){
                        newAccount.setAccountName(accountName);
                        accounts.add(newAccount);
                        return true;
                    }
                }
                
            }
            return false;
	}
	public boolean modifyAccount(String accountNumber, double accountBalance) {
            for (Account account : accounts) {
                if(account.getAccountNumber().equals(accountNumber)){
                    Account newAccount = getAccountByNumber(accountNumber);
                    if(testAccountBalance(accountBalance)){
                        newAccount.setAccountBalance(accountBalance);
                        accounts.add(newAccount);
                        return true;
                    }
                }
                
            }
            return false;
	}
	public boolean modifyAccount(String accountNumber, String accountName, double accountBalance) {
            for (Account account : accounts) {
                if(account.accountNumber.equals(accountNumber)){
                    Account newAccount = getAccountByNumber(accountNumber);
                    if(testAccountName(accountName)){
                        newAccount.setAccountName(accountName);
                        
                    }else{
                        return false;
                    }
                    if(testAccountBalance(accountBalance)){
                        newAccount.setAccountBalance(accountBalance);
                    }else{
                        return false;
                    }
                    accounts.add(newAccount);
                   return true;
                }
            }
            return false;
	}

	public boolean modifyAccount(int index, String accountName) {
            if(index >= 0 && accounts.get(index)!=null){
                if(testAccountName(accountName)){
                    Account account = accounts.get(index);
                    account.setAccountName(accountName);
                    accounts.add(account);
                    return true;
                }
                
            }
		return false;
	}
	public boolean modifyAccount(int index, double accountBalance) {
		if(index >= 0 && accounts.get(index)!=null){
                if(testAccountBalance(accountBalance)){
                    Account account = accounts.get(index);
                    account.setAccountBalance(accountBalance);
                    accounts.add(account);
                    return true;
                }
                
            }
		return false;
	}
	public boolean modifyAccount(int index, String accountName, double accountBalance) {
            
            if(index >=0 && accounts.get(index)!=null){
                Account account = accounts.get(index);
                if(testAccountName(accountName) && testAccountBalance(accountBalance)){
                    account.setAccountName(accountName);
                    account.setAccountBalance(accountBalance);
                accounts.add(account);
                return true;
                }else{
                    return false;
                }
            }
		return false;
	}
        
//      deleteAccount(String)
	public boolean deleteAccount(String accountNumber) {
            for (Account account : accounts) {
                if(account.getAccountNumber().equals(accountNumber)){
                    accounts.remove(account);
                    return true;
                }
            }
		return false;
	}
        
//deleteAccount(int)        
	public boolean deleteAccount(int index) {
            if(index >= 0 && accounts.get(index)!=null){
                accounts.remove(index);
                return true;
            }
            return false;
	}
        
        boolean testBankName(String bankName){
            String bankNameRegex = "^[a-zA-Z]+$";
            if(bankName.matches(bankNameRegex) && bankName.length() >=5 )
                return true;
            else
                return false;
        }
        boolean testBranchLocation(String branchLocation){
            
            for (BranchLocations object : BranchLocations.values()) {
                if(object.name().equals(branchLocation))
                    return true;
            }
            return false;
        }
        boolean testBankLocation(String bankLocation){
            
            for (BranchLocations object : BranchLocations.values()) {
                if(object.name().equals(bankLocation))
                    return true;
            }
            return false;
        }
        
	 boolean testAccountName(String accountName){
            String accoountNameregex = "^[a-zA-Z\\-]+$";
            
            if(accountName.matches(accoountNameregex) && accountName.length() >= 2)
                return true;
            else
                return false;
        }
        
        boolean testAccountNumber(String accountNumber){
            String accountNumberRegex = "^[0-9]+$";
            if(accountNumber.matches(accountNumberRegex) && accountNumber.length() >=7 )
                return true;
            else
                return false;
        }
        boolean testAccountBalance(double accountBalance){
           String text = Double.toString(Math.abs(accountBalance));
            int intPlaces = text.indexOf('.');
            int decimalPlaces = text.length() - intPlaces - 1;
        if((accountBalance > 0 || accountBalance <=0) && decimalPlaces <=2 )
                return true;
            else 
                return false;
        }
	}



















