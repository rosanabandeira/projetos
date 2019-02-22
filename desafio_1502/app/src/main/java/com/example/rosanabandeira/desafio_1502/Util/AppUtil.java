package com.example.rosanabandeira.desafio_1502.Util;

import android.app.Activity;

public class AppUtil {
    private Activity activity;
    private int[] ids;

    public AppUtil(Activity activity, int... ids) {
        this.activity = activity;
        this.ids = ids;
    }

    public void lockFields(boolean isToLock) {
        for (int id : ids) {
            setLockField( id, isToLock );
        }
    }

    private void setLockField(int fieldId, boolean isToLock) {
        activity.findViewById( fieldId ).setEnabled( !isToLock );
    }
}
