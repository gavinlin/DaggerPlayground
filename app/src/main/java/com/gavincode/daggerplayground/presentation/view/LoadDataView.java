package com.gavincode.daggerplayground.presentation.view;

import android.content.Context;

/**
 * Created by gavinlin on 31/07/15.
 */
public interface LoadDataView {
    void showLoading();
    void hideLoading();
    void showRetry();
    void hideRetry();
    void showError(String message);
    Context getContext();
}
