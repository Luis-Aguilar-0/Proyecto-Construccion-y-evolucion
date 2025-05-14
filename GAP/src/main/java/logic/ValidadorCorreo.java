package logic;

import java.util.regex.Pattern;

public class ValidadorCorreo {

    public static boolean validarCorreo(String correo){

        //Exprecion regular 
        String correoRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        //Conbierte la exprecion regular en un patron
        Pattern pattern = Pattern.compile(correoRegex);

        //Matcher matcher = pattern.matcher(correo);//el objeto matcher me permite hacer comprovbaciones
        //Se aplica el patron al correo que se ingresa y .matches() valida si cumple con el patron
        return pattern.matcher(correo).matches();
        //return matcher.matches();

    }



}
