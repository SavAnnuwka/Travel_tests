package main.java.UI;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Constants {
   // languages
    static String EN =  "en";
    static String DE =  "de";
    static String ES =  "es";
    static String FR =  "fr";
    static String IT =  "it";
    static String NL =  "nl";
    static String SV =  "sv";
    static String RU =  "ru";
    static  String PT =  "pt";
    static String RO =  "ro";
    static  String ZH =  "zh";
    public static String  SimpleName = "Name Surname";
    public static String  SimpleOrganisation= "Organisation Museum";
    public static String  SimpleEmail = "testannaiziteq@gmail.com";


    public static String getRandomLanguage() {
      String[] allLang = {DE, EN, ES, FR, IT, NL, PT, RO, RU, SV, ZH};
        Random rand = new Random();
        int i= rand.nextInt(10);
        return  allLang[i];
    }
    //EMPTY ERROR
    public static String getEmptyErrorLanguage(String language ) throws UnsupportedEncodingException {
        if   (language.equals(EN)) {
            return "Required field can not be left blank.";
        }
        if   (language.equals(DE)) {
            return "Das Pflichtfeld darf nicht leer sein.";
        }
        if   (language.equals(ES)) {
            return "El campo obligatorio no puede dejarse en blanco.";
        }
        if  (language.equals(FR)) {
            return "Le champ obligatoire ne peut être laissé vide.";
        }
        if   (language.equals(IT)) {
            return "Il campo obbligatorio non può essere vuoto.";
        }
        if   (language.equals(NL)) {
            return "Een verplicht veld mag niet leeg zijn.";
        }
        if   (language.equals(SV)) {
            return "Obligatoriskt fält kan inte lämnas tomt.";
        }
        if   (language.equals(RU)){
            return "Это поле должно быть заполнено.";
        }
        if   (language.equals(PT)) {
             //????//
            return new  String( "Campo obrigatório não pode ser deixado em branco.".getBytes("UTF-8"), "UTF-8") ;

        }
        if   (language.equals(RO)) {
            return "Câmpul obligatoriu nu poate fi lăsat necompletat.";
        }
        if  (language.equals(ZH)) {
            return "必填栏不得留空。";
        }
        throw new Error("Unknown lang" + language);

    }

    //INCORRECT EMAIL
    public static String getIncorrectEmailErrorLanguage(String language)
    {
        if   (language.equals(EN)) {
            return "Invalid e-mail format";
        }
        if   (language.equals(DE)) {
            return "Ungültiges E-Mail-Format";
        }
        if   (language.equals(ES)) {
            return "Formato de correo electrónico incorrecto";
        }
        if  (language.equals(FR)) {
            return "Format d'adresse e-mail invalide";
        }
        if   (language.equals(IT)) {
            return "Il formato dell'email non è valido";
        }
        if   (language.equals(NL)) {
            return "Ongeldig e-mailformaat";
        }
        if   (language.equals(PT)) {
            return "Formato de e-mail inválido";
        }
        if   (language.equals(RO)) {
            return "Format e-mail nevalid";
        }
        if   (language.equals(RU)){
            return "Недопустимый формат электронной почты";
        }
        if   (language.equals(SV)) {
            return "Felaktigt e-postformat";
        }
        if  (language.equals(ZH)) {
            return "无效邮件格式";
        }
        throw new Error("Unknown lang" + language);
    }



    public static String getIncorrectCheckBoxLanguage(String language) {
        if   (language.equals(EN)) {
            return "In order to use our service, you must agree to the License terms";
        }
        if   (language.equals(DE)) {
            return "Um unseren Dienst nutzen zu können, müssen Sie den Lizenzbedingungen zustimmen";
        }
        if   (language.equals(ES)) {
            return "Formato de correo electrónico incorrecto";
        }
        if  (language.equals(FR)) {
            return "Pour utiliser notre service, vous devez accepter les Conditions de la licence";
        }
        if   (language.equals(IT)) {
            return "Per poter utilizzare il nostro servizio, devi accettare i Termini di Licenza";
        }
        if   (language.equals(NL)) {
            return "Om onze dienst te gebruiken, moet u akkoord gaan met de licentievoorwaarden";
        }
        if   (language.equals(PT)) {
            return "Para utilizar o nosso serviço, você deve concordar com os termos da Licença";
        }
        if   (language.equals(RO)) {
            return "Pentru a putea folosi serviciul nostru, trebuie să fiți de acord cu Termenii licenței";
        }
        if   (language.equals(RU)){
            return "Для продолжения регистрации необходимо принять условия лицензионного соглашения";
        }
        if   (language.equals(SV)) {
            return "För att använda vår tjänst måste du godkänna licensvillkoren";
        }
        if  (language.equals(ZH)) {
            return "该邮件地址已被注册 ";
        }
        throw new Error("Unknown lang" + language);

    }

}
