package com.xda_drm.lbe51_translation_ww.translate;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.logging.Handler;

//import com.xda_drm.lbe51_translation_en.R;

//import android.content.res.Resources;
import android.content.res.XModuleResources;
//import android.content.res.XResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
//import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

//import de.robv.android.xposed.IXposedHookLoadPackage;
//import de.robv.android.xposed.XposedBridge;
//import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;


public class Translate_AntiTheft implements IXposedHookZygoteInit, IXposedHookInitPackageResources{
    private static String MODULE_PATH = null;

    
    @Override
    public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) throws Throwable    {
        // XResources.setSystemWideReplacement("android", "bool", "config_unplugTurnsOnScreen", false);
        MODULE_PATH = startupParam.modulePath;
        //      XposedBridge.log("XDA_DRM: Zygote Init ...");
    }

    @Override
    public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable    {
//      XposedBridge.log("XDA_DRM: Testing to Replacing LBE Strings ...");
        if (!resparam.packageName.equals("com.lbe.antitheft"))
            return;

//      XposedBridge.log("XDA_DRM: Replacing LBE Strings ...");
      XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, resparam.res);

      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "app_name","Antitheft"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Launch_Enabled","LBE security service is protecting your phone"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Launch_No_SimCard","Please insert the SIM card to use LBE security service"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Launch_SimCard_NotReady","SIM card on your device is not ready , please try again later"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Launch_SimCardRegistered","LBE security service detects the SIM card replacement, has automatically register new SIM card for you"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Launch_BackupCommands","Theft instruction to a safe backup phone"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Launch_UpdateAPK","LBE security service Updating settings\nLater will automatically restart"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_SetPassword","Anti-theft password"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_SetPassword_Warn","Anti-theft alarm you send the password command or enter the security features will be used to get the time , please keep in mind"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Password","Password:"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Password_Length","Password length 1-8"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Password_Confirm","Confirm Password:"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_SetPassword_Can","You can set the security code :"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_PhoneLocate","Mobile positioning"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_PhoneLocate_Can","You can always get the phone's current location , to help you recover your phone."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Destroy","Data Destruction"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Destroy_Can","Destruction lost cell phone text messages, call logs, contacts ; and clears all the data on the SD card . Prevent privacy leaks, protect your privacy."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_GetData","Contacts Backup"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_GetData_Can","Help you recover lost precious phone contact information to protect your privacy."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Alert","Bell Alarm"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Alert_Can","Emit maximum sound alarm, easy touring love machine."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Warn","Virtual Warnings"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Warn_Can","Send a warning message to your lost phone."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_SetSecurity_Number","Set security phone number"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_SetSecurity_Proposal_Number","Recommend that you use someone's phone number"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Phone_Number","No.:"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Phone_Number_Confirm","Confirmation Number:"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_SetSecurity_Number_Can","Phone numbers can be set up security :"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Change_SMS","Replaced for SMS notification"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Guide_Change_SMS_Can","Changing the card when the phone is lost , it will automatically send text messages to your default security phone, to help you get lost phone clues , allowing you retrieve phone.\nWhen you forget your security code , you can also retrieve security password through the Security numbers ."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Locate","Mobile positioning"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Locate_Hint","Positioning phone's current location"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Locate_Desc","Phone is lost , you can locate any mobile phone to send commands to your lost phone , access to the phone's current location , to help you recover your phone. After successful positioning phone , your phone will send text messages to inform current location.\n\n\n+ Positioning phone instructions are : dingwei%security code"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_GetPassword","Forget security code"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_GetPassword_Hint","Forget using your phone security code security"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_GetPassword_Desc","When you forget your security code , you can use your phone to retrieve your security settings theft password.\n\n\n+ Forget password security command is : huodemima\nNote: Retrieve Password instruction must be safe phone to send"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Warning","Virtual Warnings"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Warning_Hint","Send a custom warning message to your phone"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Warning_Desc","After the phone is lost , you can use any phone to send a warning message to your lost phone , a warning message will be displayed on top of the screen .\n\n\n+ Virtual warning instructions are : jinggao%security password#warning message"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Lock","Lock the phone"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Lock_Hint","Prevent others from using your phone"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Lock_Desc","After the phone is lost , you can use any phone to send commands to the phone lock your lost phone. LBE security service receives this command , it will lock the phone 's screen to prevent leakage of your privacy .\n\n\n+ Lock phone instructions are : suoding%security code"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Alarm","Bell Alarm"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Alarm_Hint","Cause the phone to continue to play at full volume alarm sounds"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Alarm_Desc","After the phone is lost , you can use any phone to send this command to your lost phone. LBE security service receives this command , it will lock the phone's screen and alarm music playing at full volume , allowing you to retrieve your phone.\n\n\n+ Alarm tone commands are : baojing%security code"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Backup","Backup contacts"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Backup_Hint","Backup contacts to the cloud"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Backup_Desc","After the phone is lost , you can use any phone to send this command to your lost phone. LBE security service receives this command, the contacts will be backed up to the cloud server, you can always download and restore it to your phone.\n\n\n+ Backup command is : beifen%security code"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Destroy","Destroy data"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Destroy_Hint","Destruction of the personal information on your phone"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Destroy_Desc","After the phone is lost , you can use any phone to send this command to your lost phone. LBE security service receives this command , it will destroy all your personal data on your phone to prevent leakage of your privacy .\n\n\n+ Destruction instruction is : xiaohui%security code"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Sim","Changing Card Notification"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Sim_Hint","SIM card replacement phone notifies you set up security"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Sim_Desc","When your phone's SIM card is replaced , LBE security service will automatically be set to report this message to your cell phone safe ."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_AntiCamera","Security camera"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_AntiCamera_Warn_Error","Your device does not support !\n* Security camera phone has a front camera needs\n* Camera firmware only supports Android 2.3 and above"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_AntiCamera_Hint","Photographed user photo"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_AntiCamera_Desc","Log in to the anti-theft module at someone , or unlock a locked phone , continuous input the wrong password twice to take his photo sent to security number."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Result_SimChange","[LBE.1] LBE security service to remind you: your mobile phone SIM card is changed"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Result_GetPassword","[LBE.2] Your security code is : %1$s"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Result_SimChange_Commands","[LBE.3] destroy data:\nxiaohui%security code\nLock the phone :\nsuoding%security code\nPositioning Mobile:\ndingwei%security code\nBell Alarm:\nbaojing%security code\nBackup information :\nbeifen%security code\nVirtual Warning:\njinggao%security password # warning message\nForget Password:\nhuodemima\nNote: Retrieve Password instruction must be safe phone to send"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Result_Locate_Literal","[LBE.4] your phone near the %1$s %2$d m range."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Result_Locate_Url","[LBE.5] You can also log in http://www.lbesec.com/anti/sw?a1=%1$f&amp;a2=%2$f&amp;a3=%3$d View online map"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Result_Locate_Failed","[LBE.6] network is not yet available , you can not get your phone location . LBE security service attempts to open the network , the network connection will be automatically sent to your cell phone location information"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Result_Backup","[LBE.7] contacts have been successfully backed up , you can visit %1$s Download"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Result_Backup_Failed","[LBE.8] network is not yet available , LBE security service attempts to open the network , the network connection will automatically be uploaded"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Result_Backup_ContastNull","[LBE.9] LBE security service prompts you : contact list is empty, temporarily unable to back up."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Cmd_Result_AntiCamera","[LBE.10] someone tries to unlock your phone, have captured their photos, please visit the following address View : %1$s"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Demo","Experience"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Demo_Result_GetPassword","Your password has been sent to the anti-theft %1$s"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Demo_Result_Commands","Security instructions have been sent to %1$s"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Demo_Warning_Desc","Here will show you send warnings"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Demo_Locate_Desc","This feature will give you the security of mobile phones to send text messages to set the report to view the current location . SMS and traffic fees charged by the operator ."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Demo_Backup_Desc","This feature will backup your contact information , to set up your phone to send SMS security , messaging and traffic fees charged by the operator ."); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref","LBE security service settings"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Service","Security Services"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Service_Enabled","Is turned on , your phone is in LBE under the protection of security services"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Service_Disabled","Closed , LBE security service has stopped running"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_SimLock","SIM card replacement protection"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_SimLock_Enabled","Detects the SIM is replaced, the phone automatically locks"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_SimLock_Disabled","SIM change is detected , you can still operate the phone properly"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Uninstall","Uninstall LBE security service"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Password","Security code"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Password_Warn","Security code and instructions are available in the registry"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Password_New","New password"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Password_Confirm","Confirm Password"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Password_Title","Anti-theft password"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Password_Empty","Password can not be blank"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Password_NotSame","Enter the password twice inconsistent"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Password_Error","Wrong password"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Password_Saved","Password is set successfully"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Phone","Security Phone"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Phone_Warn","Phone number can be used to obtain security password security"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Phone_New","New number"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Phone_Confirm","Confirmation Number"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Phone_Title","Set security phone number"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Phone_Empty","Numbers can not be empty"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Phone_NotSame","Enter the number two inconsistent"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Phone_Current","Current security phone number is : %1$s"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Pref_Phone_Saved","Security phone number set successfully"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Lock_Password","Please enter the security code"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Lock_Forget","Forgot your password?"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Lock_Forget_Title","Forget security code"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Lock_Forget_Content","Use secure phone %1$s\nSend SMS to the unit huodemima\nYou can retrieve your forgotten password"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Lock_ExitDemo","Exit experience"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Warning","Warning"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "OK","Determine"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Wizard_Next","Next"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Wizard_Finish","Complete"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.antitheft", "string", "Wizard_Congratulation","Congratulations, you have completed setting LBE security service"); } catch(RuntimeException e) { };

    }

}