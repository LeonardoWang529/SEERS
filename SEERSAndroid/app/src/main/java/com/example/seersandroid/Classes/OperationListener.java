package com.example.seersandroid.Classes;


import com.example.seersandroid.data.Result;

public interface OperationListener {
    public void onSuccess(Result result);

    public void onError(Result result);

    public void onPreExecution();

    public void onPostExecution();

    public void onOperationProgressUpdate(String... updateParams);
}
