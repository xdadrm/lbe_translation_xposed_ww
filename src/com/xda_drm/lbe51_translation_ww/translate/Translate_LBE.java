package com.xda_drm.lbe51_translation_ww.translate;

import java.lang.reflect.Field;
import com.xda_drm.lbe51_translation_ww.R;

import android.content.res.XModuleResources;
import android.content.res.XResources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;


public class Translate_LBE implements IXposedHookZygoteInit, IXposedHookInitPackageResources{
    private static String MODULE_PATH = null;

    
    @Override
    public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) throws Throwable    {
        // XResources.setSystemWideReplacement("android", "bool", "config_unplugTurnsOnScreen", false);
        MODULE_PATH = startupParam.modulePath;
        //      XposedBridge.log("XDA_DRM: Zygote Init ...");
    }
    
    private void editResourceImage(InitPackageResourcesParam resparam, int resourceID, String yourText)
    {
    	try { 

        Bitmap src = BitmapFactory.decodeResource(resparam.res , resourceID); // the original file yourimage.jpg i added in resources
        Bitmap dest = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas cs = new Canvas(dest);
        Paint tPaint = new Paint();
        tPaint.setTextSize(35);
        tPaint.setColor(Color.WHITE);
        tPaint.setStyle(Style.FILL);

        cs.drawBitmap(src, 0f, 0f, null);
        
        Rect bounds = new Rect();
        tPaint.getTextBounds(yourText, 0, yourText.length(), bounds);        
        
        float width = bounds.width(); // tPaint.measureText(yourText);
        float x_coord = src.getWidth()/3.3f;
        float y_coord = (src.getHeight()+bounds.height())/2;
        if(y_coord < 0 )y_coord=src.getHeight()/2;
        
        // Scale the Text if necessary
        tPaint.setTextScaleX(Math.min(1.0f,(src.getWidth()-x_coord)/(width+5)));

        // Pick Color from original bitmap and cover a part with a rectangle
        Paint tBox = new Paint();
        int pixel = dest.getPixel(10,10);
        int redValue = Color.red(pixel);
        int greenValue = Color.green(pixel);
        int blueValue = Color.blue(pixel);
        tBox.setARGB(255, redValue, greenValue, blueValue);
        cs.drawRect(x_coord, 0f, dest.getWidth(), dest.getHeight(), tBox);
        // Just covering the Backgtound is too little :
        //cs.drawRect(x_coord+bounds.left-15, y_coord+bounds.top, x_coord+bounds.right+15, y_coord+bounds.bottom+35, tBox);
        
        // Rotate Text 45 at x and y_coord
        cs.save();
        // cs.rotate(45,x_coord,y_coord);
        // tPaint.getTextBounds(yourText, 0, yourText.length(), bounds);


        cs.drawText(yourText, x_coord, y_coord , tPaint); 
        cs.restore();

        final Drawable mDrawable = new BitmapDrawable(resparam.res,dest);
//        resparam.res.setReplacement(resparam.packageName, "drawable", "adware_banner_view_normal", new XResources.DrawableLoader() {
        resparam.res.setReplacement(resourceID, new XResources.DrawableLoader() {
        	@Override
        	public Drawable newDrawable(XResources res, int id) throws Throwable {
        		return mDrawable;
        	}
        });
        } catch(RuntimeException e) { };    	
    }

    @Override
    public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable    {
//      XposedBridge.log("XDA_DRM: Testing to Replacing LBE Strings ...");
        if (!resparam.packageName.equals("com.lbe.security"))
            return;

//      XposedBridge.log("XDA_DRM: Replacing LBE Strings ...");
        XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, resparam.res);

        try { resparam.res.setReplacement(resparam.packageName, "drawable", "adware_banner_view_normal", modRes.fwd(R.drawable.adware_banner_view_normal)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "adware_banner_view_press", modRes.fwd(R.drawable.adware_banner_view_press)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "blocked", modRes.fwd(R.drawable.blocked)); } catch(RuntimeException e) { };          
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "ic_splash", modRes.fwd(R.drawable.ic_splash)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "phone_intercept_hint_bg_normal", modRes.fwd(R.drawable.phone_intercept_hint_bg_normal)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "phone_intercept_hint_bg_pressed", modRes.fwd(R.drawable.phone_intercept_hint_bg_pressed)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "private_applock_not_start", modRes.fwd(R.drawable.private_applock_not_start)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "root_mode_auth_off", modRes.fwd(R.drawable.root_mode_auth_off)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "root_mode_auto_on", modRes.fwd(R.drawable.root_mode_auto_on)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "home_swipe_up_guide_text", modRes.fwd(R.drawable.home_swipe_up_guide_text)); } catch(RuntimeException e) { };

        try { resparam.res.setReplacement(resparam.packageName, "drawable", "phone_entry_ipcall_enable", modRes.fwd(R.drawable.phone_entry_ipcall_enable)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "phone_entry_ipcall_disable", modRes.fwd(R.drawable.phone_entry_ipcall_disable)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "phone_entry_location_enable", modRes.fwd(R.drawable.phone_entry_location_enable)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "phone_entry_location_disable", modRes.fwd(R.drawable.phone_entry_location_disable)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "phone_entry_unread_enable", modRes.fwd(R.drawable.phone_entry_unread_enable)); } catch(RuntimeException e) { };
        try { resparam.res.setReplacement(resparam.packageName, "drawable", "phone_entry_unread_disable", modRes.fwd(R.drawable.phone_entry_unread_disable)); } catch(RuntimeException e) { };


      editResourceImage(resparam, resparam.res.getIdentifier("adware_banner_view_normal", "drawable", resparam.packageName), modRes.getString(R.string.AD_Report));
      editResourceImage(resparam, resparam.res.getIdentifier("adware_banner_view_press", "drawable", resparam.packageName), modRes.getString(R.string.AD_Report));
      editResourceImage(resparam, resparam.res.getIdentifier("phone_intercept_hint_bg_normal", "drawable", resparam.packageName), modRes.getString(R.string.Phone_ReportMessageTitle));
      editResourceImage(resparam, resparam.res.getIdentifier("phone_intercept_hint_bg_pressed", "drawable", resparam.packageName), modRes.getString(R.string.Phone_ReportMessageTitle));

      
      // Require UTF-8 16 bit Characters - see http://www.irongeek.com/homoglyph-attack-generator.php
      try { resparam.res.setReplacement(resparam.packageName, "string", "Generic_Time_Today","﻿Το�?ау"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement(resparam.packageName, "string", "Generic_Time_Yesterday","﻿Үеѕτеʀ�?ау"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement(resparam.packageName, "string", "Generic_Time_Before_Yesterday","ΒеｆοʀеҮеѕτеʀ�?ау"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement(resparam.packageName, "string", "Generic_Time_Tomorrow","ΤοМο�?��?�οѡ"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement(resparam.packageName, "string", "Generic_Time_After_Tomorrow","AｆτеʀΤοМο�?��?�οѡ"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement(resparam.packageName, "string", "Generic_Time_Before_Dawn","﻿ΒеｆοʀеⅮаѡɴ"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement(resparam.packageName, "string", "Generic_Time_AM","ΑϺ﻿"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement(resparam.packageName, "string", "Generic_Time_Noon","﻿�?ооɴ"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement(resparam.packageName, "string", "Generic_Time_PM","РМ"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement(resparam.packageName, "string", "Generic_Time_Night","﻿�?іɡһτ"); } catch(RuntimeException e) { };
      
      Field[] fields = null;
      try{
      fields = R.string.class.getFields();
      for(final Field field : fields) {
         String name = field.getName(); //name of string
         try{
             int id = field.getInt(R.string.class); //id of string
             try { resparam.res.setReplacement(resparam.packageName, "string", name,modRes.getString(id)); } catch(RuntimeException e) { };
         }catch (Exception ex) {
             //Simply ignore ...
         }
      }
    } catch(RuntimeException e) { };
    
      try{
      fields = R.array.class.getFields();
      for(final Field field : fields) {
         String name = field.getName(); //name of string
         try{
             int id = field.getInt(R.array.class); //id of string
             try { resparam.res.setReplacement(resparam.packageName, "array", name,modRes.getStringArray(id)); } catch(RuntimeException e) { };
         }catch (Exception ex) {
             //Simply ignore ...
         }
      }
    } catch(RuntimeException e) { };

      /*
       * Not needed, but can be used to process drawables
      fields = R.drawable.class.getFields();
      for(final Field field : fields) {
         String name = field.getName(); //name of string
         try{
             int id = field.getInt(R.drawable.class); //id of string
             try { resparam.res.setReplacement(resparam.packageName, "drawable", name,modRes.getDrawable(id)); } catch(RuntimeException e) { };
         }catch (Exception ex) {
             //Simply ignore ...
         }
      }
      */

     

 // Version Dependent Strings
       try { resparam.res.setReplacement(resparam.packageName, "string", "Battery_NotifMode","Battery logging"); } catch(RuntimeException e) { };
       try { resparam.res.setReplacement(resparam.packageName, "string", "Battery_NotifMode_Des","Battery always under control"); } catch(RuntimeException e) { };

       // Should only be loaded for LBE 5.1.4722 (and earlier ?)
       
       Integer older=0;
       try { resparam.res.setReplacement(resparam.packageName, "string", "Update_VirusEngine_Title","Virus detection engine updates"); }
         catch(RuntimeException e) { 
         	older=1;
         };

         if(older>0) { try { resparam.res.setReplacement(resparam.packageName, "string", "AV_Update_CurrentVer","Virus database version :%1$s"); } catch(RuntimeException e) { };
         }
       
    }
    
}