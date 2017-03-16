package mmbialas.pl.navigationdrawersi.data;

import android.support.v4.app.Fragment;

import mmbialas.pl.navigationdrawersi.ui.fragments.FragmentAbout;
import mmbialas.pl.navigationdrawersi.ui.fragments.FragmentOne;
import mmbialas.pl.navigationdrawersi.ui.fragments.FragmentThree;
import mmbialas.pl.navigationdrawersi.ui.fragments.FragmentTwo;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public enum Fragments {

  ONE(FragmentOne.class), TWO(FragmentTwo.class), THREE(FragmentThree.class), ABOUT(
      FragmentAbout.class);

  final Class<? extends Fragment> fragment;

  Fragments(Class<? extends Fragment> fragment) {
    this.fragment = fragment;
  }

  public String getFragment() {
    return fragment.getName();
  }
}
