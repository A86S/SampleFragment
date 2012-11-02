package edu.a45.android.fragment.samplefragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class DemoFragment extends Fragment {

	private View view;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// If activity recreated (such as from screen rotate), restore
		if (savedInstanceState != null) {
			// get your data
		}

		// Inflate the layout for this fragment
		view = inflater.inflate(R.layout.demo, container, false);

		Button listBtn = (Button) view.findViewById(R.id.listbtn);
		listBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DemoListFrag listFrag = new DemoListFrag();
				// Add the fragment to the 'fragment_container' FrameLayout
				// Must Comit after add or replace
				
				FragmentTransaction transaction = getActivity()
						.getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.fragment_container, listFrag);
				transaction.addToBackStack(null);
				
				transaction.commit();
			}
		});
		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// put your data to bundle in case we need to recreate the fragment
	}

}
