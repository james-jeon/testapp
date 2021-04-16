package com.testapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.supremainc.android.libsupremaac.SupremaAc;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class Module extends ReactContextBaseJavaModule {
    final String TAG = Module.class.getSimpleName();
    private ReactApplicationContext mContext;

    public Module(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;

    }
    @NonNull
    @Override
    public String getName() {
        return TAG;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getSdkVersion() {
        return SupremaAc.getInstance().getSDKVersion();
    }

    @ReactMethod
    public void init(Callback callback) {
        Boolean result = SupremaAc.getInstance().init(mContext);
        callback.invoke(result);
    }
}
