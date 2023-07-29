package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char[] charArray = tradeLicenseId.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                rearrangeLicenseId(charArray, i);
                return;
            }
        }
    }
    public void rearrangeLicenseId(char[] charArray, int index) {
        int i = index;
        int j = index + 1;
        while (j < charArray.length && charArray[i] == charArray[j]) {
            j++;
        }
        if (j == charArray.length) {
            throw new RuntimeException("Valid License can not be generated");
        }
        char temp = charArray[index];
        charArray[index] = charArray[j];
        charArray[j] = temp;
        tradeLicenseId = new String(charArray);
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
