package edu.a45.android.fragment.samplefragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DemoListFrag extends ListFragment {

	DemoListListner mCallBack;

	public interface DemoListListner {
		public void onItemSelect(int position);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// This makes sure that the container activity has implemented
		// the callback interface. If not, it throws an exception.
		try {
			mCallBack = (DemoListListner) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement DemoListListner");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// Create an array adapter for the list view, using the Demo demoArray
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, Demo.demoArray));
	}

	@Override
	public void onStart() {
		super.onStart();

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Notify the parent activity of selected item
		mCallBack.onItemSelect(position);
		// Set the item as checked to be highlighted when in two-pane layout
		getListView().setItemChecked(position, true);
	}

}
