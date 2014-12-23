package test.java;


import main.java.UI.Constants;
import main.java.testBase;
import org.hamcrest.core.StringContains;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Set;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class SmokeRegistration_test extends testBase{
   // String correctEmail =  "btazbbytqroe@dropmail.me"; //for debug is already register
   // String correctEmail =  "aewulrrw@yomail.info";//for debug is already get email
    String correctEmail;


    public String  getEMail()
    {   app.getWindowsHelper().openNewMailWindow(app.getProperty("temporaryMail"));
        return  app.getMailHelper().getTemporaryEmail();
    }


 //  @Test(enabled=false)
   //check correctRegister Link
    public void openRegistrationPage() {
           app.getRegistrationHelper().goToRegistrationPageFromURL();
           assertThat(app.getWebDriverHelper().getDriver().getCurrentUrl(), equalTo(app.getRegistrationHelper().getRegistrationURL()));
    }

    // correctRegister
     @Test(groups = {"default"}, dataProvider = "registrationCorrectData", dataProviderClass = DataGenerator.class )
  //   @Test(enabled=true, dataProvider = "registrationCorrectData", dataProviderClass = DataGenerator.class )
    public void positiveTest(String correctName, String correctOrg ) throws InterruptedException {
        log.log( Level.INFO, "positiveTest start. LANG = " + language);
        correctEmail = getEMail();
        app.getWindowsHelper().switchToOriginalPage();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(1), true);
        log.log(Level.INFO, "Page 1 was open ");
        app.getRegistrationHelper().fillRegistrationFormFromClipBoard(correctName, correctOrg, correctEmail);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(2), true) ;  //добавить wait
        log.log( Level.INFO, "Page 2 was open");
        app.getRegistrationHelper().confirmCheckbox();
        app.getRegistrationHelper().clickRegisterButtonPage2();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(3), true) ;     //добавить wait
        log.log( Level.INFO, "Page 3 was open");
        app.getWindowsHelper().switchToMailPage();
        Assert.assertEquals(app.getMailHelper().emptyMail(), false);
        log.log( Level.INFO, "mail "+ correctEmail +" is not empty");
         //отдельно
         checkMailText();
         //отдельно
         checkMailLink();
        log.log( Level.INFO, "positiveTest stop");
        app.getWindowsHelper().switchToOriginalPage();
    }

 //  @Test(groups = {"default"}, enabled=false,dependsOnMethods = { "positiveTest"}, dataProvider = "registrationSimpleDataWithoutEmail", dataProviderClass = DataGenerator.class)
  //move  to incorrect test
   public void alreadyRegisterEmail (String simpleName, String simpleOrg ){
       log.log( Level.INFO, "Already get  email test start . LANG: \" + language ");
       app.getRegistrationHelper().fillRegistrationForm(simpleName, simpleOrg, correctEmail);
       app.getRegistrationHelper().clickRegisterButtonPage1();
       assertThat( app.getRegistrationHelper().getText("register.email.error"), equalTo(Constants.getAlreadyExistErrorLanguage(language)));
       log.log( Level.INFO, Constants.getAlreadyExistErrorLanguage(language));
   }

    // @Test ( dependsOnMethods = { "positiveTest"})

    public void checkMailText() {
         //пока запускается before и меняется lang
        log.log( Level.INFO, "check mail text start");
        app.getWindowsHelper().switchToMailPage();
        //move to main test
        log.log( Level.INFO, app.getMailHelper().getMailtext());
         assertThat(app.getMailHelper().getMailtext().contains(Constants.getMailText(language)), equalTo(true));
    }

    public void checkMailLink() {
        //пока запускается before и меняется lang
        //need refactor
        log.log( Level.INFO, "check mail link  start");
        app.getWindowsHelper().switchToMailPage();
        Set<String> OldList = app.getWindowsHelper().getCurrentListOfHandles();
        app.getMailHelper().goToMailLink();
        Set<String> NewList = app.getWindowsHelper().getCurrentListOfHandles();
        app.getWindowsHelper().getCMSHandles(OldList, NewList);
        app.getWindowsHelper().switchToCMSPage();
        log.log( Level.INFO, app.getWindowsHelper().getCurrentUrl());
        assertThat(app.getWindowsHelper().getCurrentUrl() , containsString(app.getRegistrationHelper().getNewUserURL()));
        app.getWindowsHelper().switchToOriginalPage();
    }


    //begin register in CMS!
  //  @Test(groups = {"default"}, enabled=false, dependsOnMethods = { "positiveTest","alreadyRegisterEmail" }, dataProvider = "registrationSimpleDataWithoutEmail", dataProviderClass = DataGenerator.class)
    //move  to incorrect test
    public void alreadyExistInDataBaseEmail (String simpleName, String simpleOrg ){
        log.log( Level.INFO, "Already register email start. LANG: " + language );
        correctEmail = "bvozgzesqzaq@dropmail.me";
        app.getRegistrationHelper().fillRegistrationForm(simpleName, simpleOrg, correctEmail);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat( app.getRegistrationHelper().getText("register.email.error"), equalTo(Constants.getAlreadyExistInDatabaseErrorLanguage(language)));
        log.log( Level.INFO, Constants.getAlreadyExistInDatabaseErrorLanguage(language));
    }




}
