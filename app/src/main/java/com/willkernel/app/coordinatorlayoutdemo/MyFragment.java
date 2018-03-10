package com.willkernel.app.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by willkernel on 2018/3/9.
 */

public class MyFragment extends Fragment {
    private RecyclerView rootView;

    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (RecyclerView) inflater.inflate(R.layout.fragment_page, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        rootView.setAdapter(new MyPageAdapter(10));
    }

    private class MyPageAdapter extends RecyclerView.Adapter<MyVH> {
        private final int count;

        public MyPageAdapter(int count) {
            this.count = count;
        }

        @Override
        public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_card, parent, false);
            return new MyVH(item);
        }

        @Override
        public void onBindViewHolder(MyVH holder, int position) {

        }

        @Override
        public int getItemCount() {
            return count;
        }
    }

    private class MyVH extends RecyclerView.ViewHolder {
        public MyVH(View itemView) {
            super(itemView);
        }
    }
}
