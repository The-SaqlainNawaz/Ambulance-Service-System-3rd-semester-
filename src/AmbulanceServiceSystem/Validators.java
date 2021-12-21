/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Proud To Be Muslims
 */
public class Validators {

    public boolean validName(String b) {
        boolean flag = false;
        int size = b.length();
        if (size <= 28) {
            for (int i = 0; i < size; i++) {
                if ((b.charAt(i) >= 'A' && b.charAt(i) <= 'Z') || (b.charAt(i) >= 'a' && b.charAt(i) <= 'z') || b.charAt(i) == ' ') {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return flag;
    }

    /**
     *
     * Validator for cnic
     *
     * @param b
     * @return boolean
     */
    public boolean validcnic(String b) {
        boolean flag = false;
        if (b.length() == 13) {
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) >= '0' && b.charAt(i) <= '9') {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return flag;

    }

    public boolean setdateOfBirth(Date dateBirth) {
        boolean flag = false;
        int year, day;
        int month;
        year = dateBirth.getYear(); //parseInt is used to convert
        day = dateBirth.getDay();
        month = dateBirth.getMonth();
        ///validator
        if ((day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1990 && year <= 2005)) {
            flag = true;
        }

        return flag;
    }

    public boolean ValidatePhoneNumber(String num) {

        //String sPhoneNumber = "605-88899991";
        //String sPhoneNumber = "605-888999A";
        Pattern pattern = Pattern.compile("(03)\\d{2}-\\d{7}");
        Matcher matcher = pattern.matcher(num);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
   

}
