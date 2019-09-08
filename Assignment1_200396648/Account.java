/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1_200396648;

import java.util.Objects;

/**
 *
 * @author gurleenrandhawa
 */


//Create the necessary instance variables. These instance variables should only be accessible inside the Account class.
//The account class will need to store
// An account number, which will be a whole number.
// An account balance representing a quantity of cash.
// An account name.
public class Account {

   private String accountName;
    public String accountNumber;
    private double accountBalance;
 
    //this is blank default constructor
public Account() {}

//   Constructor with 3 arguments
//   Sets the instance variables of the class
	public Account(String accountName, String accountNumber, double accountBalance) {
		if(testAccountName(accountName))
                    this.accountName = accountName;
                else
                    this.accountName = null;
                
                if(testAccountBalance(accountBalance))
                    this.accountBalance = accountBalance;
             
                if(testAccountNumber(accountNumber))
                    this.accountNumber = accountNumber;
                else
                    this.accountNumber=null;
	}
        
//        getAccountName
// retrievesthenameoftheaccount
	public String getAccountName() {
		return accountName;
	}
        
//        setAccountName
//  returns a Boolean value representing whether the account name is valid o only updates the name of the account if the name is valid
	public boolean setAccountName(String accountName) {
            if(testAccountName(accountName)){
                this.accountName = accountName;
                return true;
            }else{
		return false;
            }
	}
        
//        getAccountNumber
//   retrievestheaccountnumber
	public String getAccountNumber() {
		return accountNumber;
	}
        
//        setAccountNumber
// returns a Boolean value representing whether the account number is valid o only updates the account number if it is valid
	public boolean setAccountNumber(String accountNumber) {
            if(testAccountNumber(accountNumber)){
                this.accountNumber = accountNumber;
                return true;
            }else{
                return false;
            }
        }
        
//    getAccountBalance
// retrieves the balance of the account    
	public double getAccountBalance() {
		return accountBalance;
	}
        
//        setAccountBalance
// returns a Boolean value representing whether the account balance is valid o only updates the balance of the account if the balance is valid
	public boolean setAccountBalance(double value) {
            if(testAccountBalance(value)){
                this.accountBalance=value;
                return true;
            }else{
                return false;
            }
	}
        
//        The account number can only contain numeric values
//        The account number must be a minimum of 7 digits
            boolean testAccountNumber(String accountNumber){
            String accountNumberRegex = "^[0-9]+$";
            if(accountNumber.matches(accountNumberRegex) && accountNumber.length() >=7 )
                return true;
            else
                return false;
        }
        
//        The account name can only contain alphabetical characters and hyphens o A-Z, a-z, -
//        The account name must be a minimum of 2 characters
        boolean testAccountName(String accountName){
            String accoountNameregex = "^[a-zA-Z\\-]+$";
            
            if(accountName.matches(accoountNameregex) && accountName.length() >= 2)
                return true;
            else
                return false;
        }
        
//         The account balance can contain positive and negative values but can have a precision of 2 decimal places.
        boolean testAccountBalance(double accountBalance){
              String text = Double.toString(Math.abs(accountBalance));
            int intPlaces = text.indexOf('.');
            int decimalPlaces = text.length() - intPlaces - 1;
            if((accountBalance > 0 || accountBalance <=0) && decimalPlaces <=2 )
                return true;
            else 
                return false;
        }
        
//        equals
//o returns a Boolean value of whether one object is equal in VALUE to an account object

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (Double.doubleToLongBits(this.accountBalance) != Double.doubleToLongBits(other.accountBalance)) {
            return false;
        }
        if (!Objects.equals(this.accountName, other.accountName)) {
            return false;
        }
        if (!Objects.equals(this.accountNumber, other.accountNumber)) {
            return false;
        }
        return true;
    }

//    toString
//    returns a string summary of the account
    @Override
    public String toString() {
        return "Account{" + "accountName=" + accountName + ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + '}';
    }

}


