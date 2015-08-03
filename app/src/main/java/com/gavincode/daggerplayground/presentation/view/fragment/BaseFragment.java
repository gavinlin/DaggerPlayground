package com.gavincode.daggerplayground.presentation.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.gavincode.daggerplayground.presentation.di.HasComponent;

/**
 * Created by gavinlin on 31/07/15.
 */
public class BaseFragment extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>)getActivity()).getComponent());
    }
}
