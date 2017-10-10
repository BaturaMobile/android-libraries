package com.baturamobile.utils.callbacks;

/**
 * Created by vssnake on 26/10/2016.
 */

public abstract class CallbackC<T> implements CallbackI<T> {
    @Override
    public void onResponse(T dataResponse) {}

    @Override
    public void onError(int codeError, String stringError, Throwable ExceptionError) {}
}
