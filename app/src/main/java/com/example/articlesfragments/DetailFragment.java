package com.example.articlesfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView textViewTitle;
    private TextView textViewBody;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle bundle = getArguments();
        String title = bundle.getString("title");
        String body = bundle.getString("body");

        textViewTitle = getView().findViewById(R.id.tv_title);
        textViewBody = getView().findViewById(R.id.tv_body);

        textViewTitle.setText(title);
        textViewBody.setText(body);
    }
}
