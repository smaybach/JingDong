package com.example.rxretrofitok.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;

import com.example.rxretrofitok.net.DownloadThread;

/**
 * Created by yfeng on 2017/11/9.
 */

public class DialogUtils {
    public static long MAX_SIZE = 0;
    public static long PROGRESS = -2;

    public static void showUpdataDialog(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("是否更新")
                .setMessage("太旧了，更新吧")
                .setNegativeButton("就不", null)
                .setPositiveButton("可以", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new DownloadThread("aaa.json", context.getCacheDir() + "/c.json").start();
//                        showProgress(context);
                    }
                }).show();
    }

    public static void showProgress(final Context context){
        final ProgressDialog pd = new ProgressDialog(context);
        pd.setTitle("正在更新");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMax(100);
        pd.show();

        new AsyncTask<String, Integer, String>(){

            @Override
            protected String doInBackground(String... strings) {
                while (PROGRESS + 1 < MAX_SIZE){
                    SystemClock.sleep(100);
                    if(MAX_SIZE > 0){
                        publishProgress((int)(PROGRESS * 100 / MAX_SIZE));
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                pd.dismiss();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                pd.setProgress(values[0]);
            }
        }.execute();
    }
}
