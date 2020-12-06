package com.tyagiabhinav.dialogflowchat.utility;

import android.util.Log;


import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.Arrays;
import java.util.List;


public class Tools {

    public static String benWordToNumber(String query){

        if (query == null || query == "") {

            return "আপনার প্রশ্নটি সঠিক নয়";
        }

        String replacedEn = query.replaceAll("০","0")
                .replaceAll("১","1")
                .replaceAll("২","2")
                .replaceAll("৩","3")
                .replaceAll("৪","4")
                .replaceAll("৫","5")
                .replaceAll("৬","6")
                .replaceAll("৭","7")
                .replaceAll("৮","8")
                .replaceAll("৯","9")
                .replaceAll("শত","*100")
                .replaceAll("হাজার","*1000")
                .replaceAll("লক্ষ","*100000")
                .replaceAll("কোটি","*10000000")
                .replaceAll("যোগ","+")
                .replaceAll("বিয়োগ","-")
                .replaceAll("গুন","*")
                .replaceAll("ভাগ","/")
                ;

   /*     System.out.println(replacedEn);

        String[] splited = replacedEn.split("\\s+");

        StringBuilder builder =new StringBuilder();

        for (String x : splited){
            System.out.println(x);
            if (!x.startsWith("+") || !x.startsWith("-") ||!x.startsWith("*") ||!x.startsWith("/") ||!x.startsWith("%")){
                x="+"+x;
            }
            builder.append(x.trim());
        }

        replacedEn=builder.toString();
*/
        System.out.println(replacedEn);

        Context context = Context.enter(); //
        context.setOptimizationLevel(-1); // this is required[2]
        Scriptable scope = context.initStandardObjects();
        Object result = context.evaluateString(scope, replacedEn, "<cmd>", 1, null);
        String replacedOne = result.toString().replaceAll("0","০").replaceAll("1","১").replaceAll("2","২").replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫").replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮").replaceAll("9","৯");

        return replacedOne.toString();
//
//        ScriptEngineManager mgr = new ScriptEngineManager();
//        ScriptEngine engine = mgr.getEngineByName("Java");
//        String foo = replacedEn;
//        try {
//            return engine.eval(foo)+"";
//        } catch (ScriptException e) {
//            e.printStackTrace();
//            return "আপনার প্রশ্নটি সঠিক নয়";
//        }

    }
}
