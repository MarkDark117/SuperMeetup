package com.supermeetup.supermeetup.common;

import android.content.Context;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import com.supermeetup.supermeetup.model.EventHost;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Util {

    public static void disableBottomNavigationViewShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

    public static int getResourceId(Context context, String pVariableName, String pResourcename)
    {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getMipMapResourceId(Context context, String variableName){
        int id = getResourceId(context, variableName, "mipmap");
        if(id == -1){
            id = getResourceId(context, "ic_c", "mipmap");
        }
        return id;
    }
}
