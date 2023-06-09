package com.example.vehiclemanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String SHARED_REF_NAME= "volleyregisterlogin";
    private static final String KEY_ID="keyid";
    private static final String KEY_USERNAME="keyusername";
    private static final String KEY_PASSWORD="keypassword";
    private static final String KEY_CREATETIME="keycreatetime";
    private static SharedPrefManager mInstance;
    private static Context ctx;
    private SharedPrefManager(Context context){
        ctx=context;
    }
    public static synchronized SharedPrefManager getInstance(Context context){
        if(mInstance==null){
            mInstance=new SharedPrefManager(context);
        }
        return mInstance;
    }
    public void userLogin(User user)
    {
        SharedPreferences sharedPreferences=ctx.getSharedPreferences(SHARED_REF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(KEY_ID,user.getId());
        editor.putString(KEY_USERNAME,user.getUsername());
        editor.putString(KEY_PASSWORD,user.getPassword());
        editor.putString(KEY_CREATETIME,user.getCreateTime());
        editor.apply();
    }
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_REF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null) != null;
    }
    public User getUser() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_REF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString(KEY_ID, null),
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_PASSWORD, null),
                sharedPreferences.getString(KEY_CREATETIME, null)
        );
    }
    public void logout(){
        SharedPreferences sharedPreferences= ctx.getSharedPreferences(SHARED_REF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();editor.clear();
        editor.apply();
        ctx.startActivity(new Intent(ctx,LoginActivity.class));
    }
}
