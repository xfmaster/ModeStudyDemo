package com.app.mode.demo.decorator.utils;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface Binding {
    View getView(int id);

    void putView(View view);

    void setTextView(int id, String text);

    void setTextView(int id, int resId);

    void setImageViewResource(int id, int resId);

    void setImageViewDrawable(int id, Drawable drawable);

    void setVisible(int id, boolean isVisible);

    void setGone(int id, boolean isGone);

    void addChildOnClick(int id);
}
