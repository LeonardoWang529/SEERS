package com.example.seersandroid.Utilities;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seersandroid.BuildConfig;
import com.example.seersandroid.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;

public class Utils {

    private static final String TAG = Utils.class.getSimpleName();

/*    public static void logoutUser(Context context) {
        if (KaresPref.isUserLoggedIn(context)) {
            resetUserData(context);
            // stop step counter service
            if (isServiceRunning(context, StepCounterService.class)) {
                Intent intent = new Intent(context, StepCounterService.class);
                context.stopService(intent);
            }
            //Stop location updates
            LocationTracker tracker = ((KaresApplication) context.getApplicationContext()).getLocationTracker();
            tracker.removeLocationUpdatesFromProvider();

            // Stop Periodic Location sync alarm
            LocationTracker.cancelPeriodicLocationAlarm(context);

            Intent intent = new Intent(context, LaunchActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
    }

    public static void resetUserData(Context context) {

        // reset step pref
        KaresPref.resetStepCounter(context, true);
        KaresPref.setStepsCount(context, 0);
        KaresPref.setCounterStarted(context, false);
        //reset location pref
        KaresPref.resetLocationList(context);

        //reset user account details pref
        KaresPref.resetUserAccountDetails(context);
        KaresPref.setUserLoggedIn(context, false);
    }*/

    public static boolean isServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (manager != null) {
            for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (serviceClass.getName().equals(service.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = null;
        if (connectivityManager != null) {
            mWifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        }
        return mWifi != null && mWifi.isConnected();
    }

    public static String memberType(Context context, int type) {
        if (type == 0) {
            return "Self";
        } else if (type == 1) {
            return "Bot";
        } else if (type == 2) {
            return "MK";
        } else if (type == 3) {
            return "";
        }
        return "";
    }

    public static InsetDrawable getDividerInset(Context context) {
        int[] ATTRS = new int[]{android.R.attr.listDivider};

        TypedArray a = context.obtainStyledAttributes(ATTRS);
        Drawable divider = a.getDrawable(0);
        int inset = 50;
        InsetDrawable insetDivider = new InsetDrawable(divider, inset, 0, inset, 0);
        a.recycle();
        return insetDivider;
    }

    public static void getTransparentStatusBar(Window window) {
        // for transparent status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    public static void showToast(Context context, String msg) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        TextView v = toast.getView().findViewById(android.R.id.message);
        if (v != null) v.setGravity(Gravity.CENTER);
        toast.show();
    }

    public static String resourceMsgConvter(Context context, String msg){
        int resId = context.getResources().getIdentifier(msg, "string",
                context.getPackageName());
        if (resId != 0) msg = context.getResources().getString(resId);
        return msg;
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static String getIPAddress(boolean useIPv4) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress();
                        boolean isIPv4 = sAddr.indexOf(':') < 0;

                        if (useIPv4) {
                            if (isIPv4)
                                return sAddr;
                        } else {
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 zone suffix
                                return delim < 0 ? sAddr.toUpperCase() : sAddr.substring(0, delim).toUpperCase();
                            }
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return "";
    }

    public static String getVersionNumber(Context context) {
        return BuildConfig.VERSION_NAME;
    }

    public static String intToIP(int ip) {
        return String.format(Locale.getDefault(), "%d.%d.%d.%d",
                (ip & 0xff),
                (ip >> 8 & 0xff),
                (ip >> 16 & 0xff),
                (ip >> 24 & 0xff));
    }

    public static String prefixToSubnetMask(int prefix) {
        int mask = 0xffffffff << (32 - prefix);
        int value = mask;
        byte[] bytes = new byte[]{
                (byte) (value >>> 24), (byte) (value >> 16 & 0xff), (byte) (value >> 8 & 0xff), (byte) (value & 0xff)};

        try {
            InetAddress netAddr = InetAddress.getByAddress(bytes);
            return netAddr.getHostAddress();
        } catch (Exception e) {
            Log.e(TAG, " Exception " + e);
        }
        return "";
    }

/*    public static void checkNewRequestCount(Context context, APIInterface mApiInterface, NavigationView navigationView) {
        mApiInterface = RetrofitClient.getRetrofitInstance().create(APIInterface.class);

        mApiInterface.getUnreadRequestCount(KaresPref.getToken(context)).enqueue(new Callback<UnreadRequestResponse>() {
            @Override
            public void onResponse(Call<UnreadRequestResponse> call, Response<UnreadRequestResponse> response) {
                if (response.isSuccessful()) {
                    UnreadRequestResponse unreadRequestResponse = response.body();
                    int requestCount = unreadRequestResponse.getUnreadRequestCount();
                    if (requestCount > 0) {
                        MenuItem menuItem = navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
                        TextView textView = menuItem.getActionView().findViewById(R.id.request_count_text);
                        textView.setText(String.valueOf(requestCount));
                    } else {
                        navigationView.getMenu().getItem(3).collapseActionView();
                    }
                } else {
                    ResponseErrorBody error = new Gson().fromJson(response.errorBody().charStream(), ResponseErrorBody.class);
                    Log.e(TAG, " Error code = " + error.getCode());
                    Log.e(TAG, " Error msg = " + error.getMessage());
                    Utils.showToast(context, error.getMessage());
                }
            }

            @Override
            public void onFailure(Call<UnreadRequestResponse> call, Throwable t) {
                Utils.showToast(context, context.getString(R.string.error_fetching_fav_groups));
            }
        });
    }*/

    public static Bitmap getMarkerIconFromDrawable(Drawable drawable) {
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static String getCompleteAddressString(Context context, float LATITUDE, float LONGITUDE) {
        String strAdd = context.getString(R.string.address_not_found_text);
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder
                    .getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null && !addresses.isEmpty()) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress
                            .append(returnedAddress.getAddressLine(i)).append(
                            "\n");
                }
                strAdd = strReturnedAddress.toString();
            } else {
                Log.e(TAG, "Error fetching address from location");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Error fetching address from location");
        }
        return strAdd;
    }

    public static LatLng getLatLngFromAddress(Context context, String address) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        LatLng eventlatLng = null;
        try {
            List<Address> addressList = geocoder.getFromLocationName(address, 1);
            if (addressList != null && addressList.size() > 0) {
                Address geoaddress = addressList.get(0);
                eventlatLng = new LatLng(geoaddress.getLatitude(), geoaddress.getLongitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eventlatLng;
    }
}
