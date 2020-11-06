package com.example.seersandroid.Utilities.providers;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.util.Preconditions;

/**
 * Concrete implementation of the {@link BaseResourceProvider} interface.
 */
public class ResourceProvider implements BaseResourceProvider {

    @NonNull
    private final Context mContext;

    public ResourceProvider(@NonNull Context context) {
        mContext = Preconditions.checkNotNull(context, "context cannot be null");
    }

    @NonNull
    @Override
    public String getString(@StringRes final int id) {
        return mContext.getString(id);
    }

    @NonNull
    @Override
    public String getString(@StringRes final int id, final Object... formatArgs) {
        return mContext.getString(id, formatArgs);
    }
}
