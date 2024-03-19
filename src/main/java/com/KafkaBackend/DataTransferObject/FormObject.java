package com.KafkaBackend.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FormObject {
    private String formId;
    private boolean generalSaving;
    private boolean capitalSaving;
    private boolean otherSaving;
    private boolean addPhoneEmail;
    private boolean statementTypeAcc;
    private boolean passbookTypeAcc;
    private boolean online_MobileBanking;
    private boolean sriLankanCitizenship;
    private boolean otherCitizenship;
    private String email;
    private String fullName;
    private String address;
    private String profession;
    private String dob;
    private String nic;
    private String passportNumber;
    private int age;
    private int mobileNumber;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String id) {
        this.formId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setForm(String fullName, String email, String address, String dob, String nic, int mobile, String passportNumber, int age) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.mobileNumber = mobile;
        this.passportNumber = passportNumber;
        this.age = age;
    }

    @Override
    public String toString() {
        String output = "" , savings = "", accType = "", displayEmail = "";
        String displayFLName = "", displayAddress = "", displayProfession = "", displayDob = "", displayNic = "";
        String displayAge = "", displaypassportNum = "", dissplayMobile = "", citizenship = "";
        //Checking savings type
        if (capitalSaving) {
            savings = "capital Saving";
        } else if (generalSaving) {
            savings = "General Saving";
        } else if (otherSaving) {
            savings ="Other Saving";
        } else {
            savings = "Not Provided";
        }
        //Checking Account Type
        if (passbookTypeAcc){
            accType = "Passbook Type Account";
        } else if (statementTypeAcc){
            accType = "Statement Type Account";
        }
        if(sriLankanCitizenship){
            citizenship = "Sri-Lankan";
        } else if (otherCitizenship){
            citizenship = "Other";
        } else {
            citizenship = "Not Provided";
        }
        if(email == null){
            displayEmail = "Not provided";
        } else {
            displayEmail = email;
        }
        if(fullName == null){
            displayFLName = "Not provided";
        } else {
            displayFLName = fullName;
        }
        if(address == null){
            displayAddress = "Not provided";
        } else {
            displayAddress = address;
        }
        if(profession == null){
            displayProfession = "Not provided";
        } else {
            displayProfession = profession;
        }
        if(dob == null){
           displayDob = "Not provided";
        } else {
            displayDob = dob;
        }
        if(nic == null){
           displayNic = "Not provided";
        } else {
            displayNic = nic;
        }
        if(passportNumber == null){
           displaypassportNum = "Not provided";
        } else {
            displaypassportNum = passportNumber;
        }
        if(age == 0){
           displayAge = "Not provided";
        } else {
            displayAge = String.valueOf(age);
        }
        if(mobileNumber == 0){
            dissplayMobile = "Not provided";
        } else {
            dissplayMobile = String.valueOf(mobileNumber);
        }

        //Main Printing Details
        if (addPhoneEmail){
            output = String.format("FormFlexa User Details:\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n",
                    "Form Id", formId,
                    "Email", displayEmail,
                    "FullName", displayFLName,
                    "Address", displayAddress,
                    "Profession", displayProfession,
                    "Date of Birth", displayDob,
                    "NIC No", displayNic,
                    "Citizenship", citizenship,
                    "PassportNumber", displaypassportNum,
                    "Age", displayAge,
                    "MobileNumber", dissplayMobile,
                    "Savings Type", savings,
                    "Account Type", accType);

        } else {
            output = String.format("FormFlexa User Details:\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n" +
                            "  %-15s: %s\n",
                    "Form Id", formId,
                    "FullName", displayFLName,
                    "Address", displayAddress,
                    "Profession", displayProfession,
                    "Date of Birth", displayDob,
                    "NIC No", displayNic,
                    "Citizenship", citizenship,
                    "PassportNumber", displaypassportNum,
                    "Age", displayAge,
                    "Savings Type", savings,
                    "Account Type", accType);
        }
        return output;
    }
}
