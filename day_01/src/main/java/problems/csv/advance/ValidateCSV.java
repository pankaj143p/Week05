package problems.csv.advance;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        return m.find();
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^[+]?[0-9]{10}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(phoneNumber);
        return m.find();
    }
    public static void main(String[] args) throws Exception {
        int cnt=0;
        try {
            CSVReader reader = new CSVReader(new FileReader("isvalidfile.csv"));
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                if (cnt > 0) {
                    String email = nextRecord[3];
                    String phoneNumber = nextRecord[2];
                    if (!isValidEmail(email) && !isValidPhoneNumber(phoneNumber)) {
                        System.out.println("Invalid mail and mobile number : " + email + ", " + phoneNumber);
                    } else if (!isValidEmail(email)) {
                        System.out.println("Invalid email : " + email);
                    } else if (!isValidPhoneNumber(phoneNumber)) {
                        System.out.println("Invalid Mobile Number :  " + phoneNumber);
                    }

                }
                cnt++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
