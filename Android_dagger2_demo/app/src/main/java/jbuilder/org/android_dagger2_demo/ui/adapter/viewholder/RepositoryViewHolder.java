package jbuilder.org.android_dagger2_demo.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import jbuilder.org.android_dagger2_demo.data.model.Repository;

/**
 * Created by d05660ddw on 16/9/5.
 */
public abstract class RepositoryViewHolder extends RecyclerView.ViewHolder {
    public RepositoryViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Repository repository);
}
