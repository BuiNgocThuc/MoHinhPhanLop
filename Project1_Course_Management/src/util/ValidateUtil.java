package util;

import exception.ValidationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

    public static boolean isName(String name) {
        Pattern pattern = Pattern.compile("/^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$/u");
        Matcher matcher = pattern.matcher(name);
        boolean matchFound = matcher.find();

        return matchFound;
    }
}
