package course.labs.fragmentslab;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeedFragment extends Fragment {

	private static final String TAG = "Lab-Fragments";

	private TextView mTextView;
	private static FeedFragmentData feedFragmentData;

    private static final String TEXT_KEY = "text";
    String mText = "";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.feed, container, false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            // Restore last state
            mText = savedInstanceState.getString(TEXT_KEY);
            //Log.i(TAG, "value of mText is " + mText);
            mTextView = (TextView) getView().findViewById(R.id.feed_view);
            mTextView.setText(mText);
        }

		// Read in all Twitter feeds 
		if (null == feedFragmentData) { 
			
			feedFragmentData = new FeedFragmentData(getActivity());

		}
	}


	// Display Twitter feed for selected feed

	void updateFeedDisplay(int position) {

		Log.i(TAG, "Entered updateFeedDisplay()");
				
		mTextView = (TextView) getView().findViewById(R.id.feed_view);
		mTextView.setText(feedFragmentData.getFeed(position));

	}

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(TEXT_KEY, mTextView.getText().toString());
        //Log.i(TAG, "State Checking -------------> " + mTextView.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

}
