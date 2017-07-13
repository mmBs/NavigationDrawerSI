package mmbialas.pl.navigationdrawersi.ui.fragments;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mmbialas.pl.navigationdrawersi.R;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class FragmentTwo extends Fragment {

  @BindView(R.id.circleLayout) LinearLayout circleLayout;
  private Unbinder unbinder;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup containter,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_two, containter, false);
    unbinder = ButterKnife.bind(this, view);
    ((GradientDrawable) circleLayout.getBackground()).setColor(
        getResources().getColor(R.color.material_pink));
    return view;
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }
}
