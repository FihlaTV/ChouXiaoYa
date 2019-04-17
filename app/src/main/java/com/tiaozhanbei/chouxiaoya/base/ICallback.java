package com.tiaozhanbei.chouxiaoya.base;


public interface ICallback<RESULT> {

    void onResult(RESULT result);

    void onError(Throwable error);

    void onStringError(int code, String error);

}
