/*
 * Copyright (C) 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.willkernel.app.coordinatorlayoutdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FlexibleSpaceExampleActivity extends AppCompatActivity
        implements AppBarLayout.OnOffsetChangedListener {
    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;
    private View mFab;
    private int mMaxScrollSize;
    private boolean mIsImageHidden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexible_space);
        AppBarLayout appBarLayout = findViewById(R.id.flex_appbar);
        appBarLayout.addOnOffsetChangedListener(this);
        mFab = findViewById(R.id.flex_fab);
        Toolbar toolbar = findViewById(R.id.flex_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (mMaxScrollSize == 0) {
            mMaxScrollSize = appBarLayout.getTotalScrollRange();
        }
        if (mMaxScrollSize == 0) return;
        int currentScrollPercentage = (Math.abs(i)) * 100
                / mMaxScrollSize;
        if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE && !mIsImageHidden) {
            mIsImageHidden = true;
            mFab.animate().scaleX(0).scaleY(0).start();
        }
        if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE && mIsImageHidden) {
            mIsImageHidden = false;
            mFab.animate().scaleX(1).scaleY(1).start();
        }
    }

    public static void start(Context c) {
        c.startActivity(new Intent(c, FlexibleSpaceExampleActivity.class));
    }
}
