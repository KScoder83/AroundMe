package code.aroundme.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import code.aroundme.DetailActivity;
import code.aroundme.R;
import code.aroundme.adapter.viewholder.ViewHolder;
import code.aroundme.model.SampleData;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<String> mValues;


    public String getValueAt(int position) {
        return mValues.get(position);
    }

    public RecyclerViewAdapter(Context context, List<String> items) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mBoundString = mValues.get(position);
        holder.mTextView.setText(mValues.get(position));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_NAME, holder.mBoundString);

                context.startActivity(intent);
            }
        });

        Glide.with(holder.mImageView.getContext())
                .load(SampleData.getRandomCheeseDrawable())
                .fitCenter()
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
