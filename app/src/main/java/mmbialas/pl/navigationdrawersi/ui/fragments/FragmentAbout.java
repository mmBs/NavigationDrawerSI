package mmbialas.pl.navigationdrawersi.ui.fragments;

import com.devspark.robototextview.widget.RobotoTextView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mmbialas.pl.navigationdrawersi.R;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class FragmentAbout extends Fragment {

    @InjectView(R.id.aboutTextView)
    RobotoTextView aboutTextView;

    @InjectView(R.id.aboutTextViewAdditionalText)
    RobotoTextView aboutTextViewAdditionalText;

    @InjectView(R.id.aboutContact)
    RobotoTextView aboutContact;


    public static FragmentAbout newInstance() {
        FragmentAbout fragmentAbout = new FragmentAbout();
        return fragmentAbout;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, containter, false);
        ButterKnife.inject(this, view);
        setSpans();
        return view;
    }

    @OnClick(R.id.aboutContact)
    public void onClick() {

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri
                .fromParts("mailto", getString(R.string.user_email), null));
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                getString(R.string.about_msg_subject));
        try {
            startActivity(
                    Intent.createChooser(emailIntent, getString(R.string.about_mail_chooser)));
        } catch (ActivityNotFoundException exception) {
            Toast.makeText(getActivity(), getString(R.string.about_intent_failed),
                    Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    private void setSpans() {
        final SpannableString text1 = new SpannableString(getString(R.string.about_text));
        final SpannableString text2 = new SpannableString(getString(R.string.about_text2));
        text1.setSpan(new RelativeSizeSpan(1.5f), 23, 31,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new RelativeSizeSpan(1.5f), text1.length() - 45, text1.length() - 29,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new RelativeSizeSpan(1.5f), text1.length() - 20, text1.length() - 9,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.material_blue)), 23,
                31, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.material_blue)),
                text1.length() - 45,
                text1.length() - 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.material_blue)),
                text1.length() - 20, text1.length() - 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 23, 31,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), text1.length() - 45, text1.length() - 29,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), text1.length() - 20, text1.length() - 9,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text2.setSpan(new RelativeSizeSpan(1.5f), 24, text2.length() - 10,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.material_blue)),
                24,
                text2.length() - 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text2.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 24, text2.length() - 10,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        aboutTextView.setText(text1);
        aboutTextViewAdditionalText.setText(text2);
    }


}
