package edu.a45.android.fragment.samplefragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import edu.a45.android.fragment.samplefragment.DemoListFrag.DemoListListner;

public class MainActivity extends FragmentActivity implements DemoListListner {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DemoFragment demoFrag = new DemoFragment();
		demoFrag.setArguments(getIntent().getExtras());

		// Add the fragment to the 'fragment_container' FrameLayout
		// Must Comit after add or replace
		getSupportFragmentManager().beginTransaction()
				.add(R.id.fragment_container, demoFrag).commit();
	}

	@Override
	public void onItemSelect(int position) {

		MessageFrag messageFrag = (MessageFrag) getSupportFragmentManager()
				.findFragmentById(R.id.message_frag);

		if (messageFrag != null) {
			messageFrag.updateMessage(position);
		} else {
			MessageFrag msgrag = new MessageFrag();
			Bundle args = new Bundle();
			args.putInt(MessageFrag.ARG_POSITION, position);
			msgrag.setArguments(args);

			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();
			transaction.replace(R.id.fragment_container, msgrag);
			transaction.addToBackStack(null);

			transaction.commit();
		}

	}

}
