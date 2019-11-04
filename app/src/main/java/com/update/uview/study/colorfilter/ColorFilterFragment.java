package com.update.uview.study.colorfilter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.update.uview.study.paint.PaintView;

/**
 * @author : liupu
 * date   : 2019/10/12
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class ColorFilterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new ColorFilterView(getActivity());
    }

}
