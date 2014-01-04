package com.xda_drm.lbe51_translation_ww.translate;

import android.content.res.XModuleResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;


public class Translate_SpecialVersions implements IXposedHookZygoteInit, IXposedHookInitPackageResources{
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
        if (!resparam.packageName.equals("com.lbe.security"))
            return;

//      XposedBridge.log("XDA_DRM: Replacing LBE Strings ...");
      XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, resparam.res);
Integer older=0;


// Require UTF-8 16 bit Characters - see http://www.irongeek.com/homoglyph-attack-generator.php
//try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Today","﻿Το�?ау"); } catch(RuntimeException e) { };
//try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Yesterday","﻿Үеѕτеʀ�?ау"); } catch(RuntimeException e) { };
//try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Before_Yesterday","ΒеｆοʀеҮеѕτеʀ�?ау"); } catch(RuntimeException e) { };
//try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Tomorrow","ΤοМο�?��?�οѡ"); } catch(RuntimeException e) { };
//try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_After_Tomorrow","AｆτеʀΤοМο�?��?�οѡ"); } catch(RuntimeException e) { };
//try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Before_Dawn","﻿ΒеｆοʀеⅮаѡɴ"); } catch(RuntimeException e) { };
//try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_AM","ΑϺ﻿"); } catch(RuntimeException e) { };
//try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Noon","﻿�?ооɴ"); } catch(RuntimeException e) { };
//try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_PM","РМ"); } catch(RuntimeException e) { };
//try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Night","﻿�?іɡһτ"); } catch(RuntimeException e) { };

// Version Dependent Strings
      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_NotifMode","Battery logging"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_NotifMode_Des","Battery always under control"); } catch(RuntimeException e) { };

      // Should only be loaded for LBE 5.1.4722 (and earlier ?)

      try { resparam.res.setReplacement("com.lbe.security", "string", "Update_VirusEngine_Title","Virus detection engine updates"); }
        catch(RuntimeException e) { 
        	older=1;
        };

        if(older>0) { try { resparam.res.setReplacement("com.lbe.security", "string", "AV_Update_CurrentVer","Virus database version :%1$s"); } catch(RuntimeException e) { };
        }
      
        }

}