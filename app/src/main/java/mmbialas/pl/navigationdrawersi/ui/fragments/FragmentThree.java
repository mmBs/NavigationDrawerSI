package mmbialas.pl.navigationdrawersi.ui.fragments;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mmbialas.pl.navigationdrawersi.R;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class FragmentThree extends Fragment {

    @InjectView(R.id.circleLayout)
    LinearLayout circleLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, containter, false);
        ButterKnife.inject(this, view);
        ((GradientDrawable) circleLayout.getBackground())
                .setColor(getResources().getColor(R.color.material_purple));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
