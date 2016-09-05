package jbuilder.org.android_dagger2_demo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jbuilder.org.android_dagger2_demo.data.model.Repository;
import jbuilder.org.android_dagger2_demo.ui.activity.RepositoriesListActivity;
import jbuilder.org.android_dagger2_demo.ui.adapter.viewholder.RepositoriesListViewHolderFactory;
import jbuilder.org.android_dagger2_demo.ui.adapter.viewholder.RepositoryViewHolder;

/**
 * Created by d05660ddw on 16/9/4.
 */
public class RepositoriesListAdapter extends RecyclerView.Adapter  {

    private RepositoriesListActivity repositoriesListActivity;
    private Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories;

    private final List<Repository> repositories = new ArrayList<>();

    public RepositoriesListAdapter(RepositoriesListActivity repositoriesListActivity,
                                   Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories) {
        this.repositoriesListActivity = repositoriesListActivity;
        this.viewHolderFactories = viewHolderFactories;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = viewHolderFactories.get(viewType).createViewHolder(parent);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRepositoryItemClicked(viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    private void onRepositoryItemClicked(int adapterPosition) {
        repositoriesListActivity.onRepositoryClick(repositories.get(adapterPosition));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RepositoryViewHolder) holder).bind(repositories.get(position));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    @Override
    public int getItemViewType(int position) {
        Repository repository = repositories.get(position);
        if (repository.stargazers_count > 500) {
            if (repository.forks_count > 100) {
                return Repository.TYPE_FEATURED;
            }
            return Repository.TYPE_BIG;
        }
        return Repository.TYPE_NORMAL;
    }

    public void updateRepositoriesList(List<Repository> repositories) {
        this.repositories.clear();
        this.repositories.addAll(repositories);
        notifyDataSetChanged();
    }
}
