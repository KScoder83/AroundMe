package code.aroundme.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import code.aroundme.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public String mBoundString;

    public final View mView;
    public final ImageView mImageView;
    public final TextView mTextView;

    public ViewHolder(View view) {
        super(view);
        mView = view;
        mImageView = (ImageView) view.findViewById(R.id.avatar);
        mTextView = (TextView) view.findViewById(android.R.id.text1);
    }
}
