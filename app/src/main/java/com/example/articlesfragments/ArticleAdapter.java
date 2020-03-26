package com.example.articlesfragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private ArrayList<Article> articles;
    private ArticleViewHolderOnClickListener listener;

    public ArticleAdapter(ArticleViewHolderOnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        int tvArticleListItemId = R.layout.article_list_item;
        View view = layoutInflater.inflate(tvArticleListItemId, viewGroup, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder articleViewHolder, int i) {
        articleViewHolder.articleTextView.setText(String.valueOf(articles.get(i).getTitle()));
    }

    @Override
    public int getItemCount() {
        if (articles == null) {
            return 0;
        }
        return articles.size();
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }


    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView articleTextView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            articleTextView = itemView.findViewById(R.id.tv_article_list_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int index = getAdapterPosition();
            listener.articleOnClick(articles.get(index));
        }
    }

    public interface ArticleViewHolderOnClickListener{
        void articleOnClick(Article article);
    }
}
