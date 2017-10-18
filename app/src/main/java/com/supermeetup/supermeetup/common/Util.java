package com.supermeetup.supermeetup.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BindingAdapter;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.supermeetup.supermeetup.model.Category;
import com.supermeetup.supermeetup.model.EventHost;
import com.supermeetup.supermeetup.model.Venue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;
import org.parceler.Parcels;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class Util {

    public static final int PERMISSIONREQUEST_ACCESS_LOCATION = 0;

    public static final String KEY_ATTEMPTINGLOGIN = "attempinglogin";
    public static final String KEY_CATEGORIES = "categories";

    public static final String FIELDS_DEFAULT = "event_hosts, group_category, group_photo";
    public static final float RADIUS_DEFAULT = 30.0f;

    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_CATEGORYLIST = "categorylist";

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

    public static String getString(Context context, int resId){
        return context.getResources().getString(resId);
    }

    public static int getColor(Context context, int resId){
        return context.getResources().getColor(resId);
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
        return getResourceId(context, variableName, "mipmap");
    }

    public static int getCategoryIcon(Context context, long categoryId){
        int id = getMipMapResourceId(context, "ic_c" + categoryId);
        if(id == -1){
            id = getMipMapResourceId(context, "ic_c");
        }
        return id;
    }

    public static void writeBoolean(Activity activity, String key, boolean value){
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean readBoolean(Activity activity, String key){
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }

    public static void writeString(Activity activity, String key, String value){
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String readString(Activity activity, String key){
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }

    public static void hideSoftKeyboard(Activity activity) {
        if (activity != null) {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (activity.getCurrentFocus() != null && inputManager != null) {
                inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
                inputManager.hideSoftInputFromInputMethod(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }


    @BindingAdapter({"iconid"})
    public static void setIconId(ImageView view, long iconid) {
        view.setImageResource(Util.getCategoryIcon(view.getContext(), iconid));
    }

}
