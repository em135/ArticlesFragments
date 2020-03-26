package com.example.articlesfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment implements ArticleAdapter.ArticleViewHolderOnClickListener {

    private ArticleAdapter articleAdapter;
    private MasterFragmentOnSelectedListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (MasterFragmentOnSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement MasterFragmentOnSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_master, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        articleAdapter = new ArticleAdapter(this);

        RecyclerView recyclerView = getView().findViewById(R.id.article_recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(articleAdapter);
        setDatasourceForAdapter();
    }

    private void setDatasourceForAdapter() {
        ArrayList<Article> articles = ArticleManager.getInstance().getArticles();
        articleAdapter.setArticles(articles);
    }

    @Override
    public void articleOnClick(Article article) {
        listener.onMasterFragmentSelected(article);
    }

    public interface MasterFragmentOnSelectedListener {
        void onMasterFragmentSelected(Article article);
    }
}
