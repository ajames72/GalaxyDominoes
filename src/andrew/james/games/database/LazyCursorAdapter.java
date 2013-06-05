package andrew.james.games.database;

import andrew.james.games.R;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyCursorAdapter extends CursorAdapter {
	
	
	public LazyCursorAdapter(Context context, Cursor c) {
		super(context, c);
	}
	/**
	 * Format each of the cells here
	 */
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		
		// Position text
		TextView position = (TextView) view.findViewById(R.id.winnerPositionView);
		position.setText(String.valueOf((cursor.getPosition() + 1)));
		
		//Winner icon
		ImageView imageView = (ImageView) view.findViewById(R.id.winnerIconView);
		int rId = cursor.getInt(1);
		imageView.setImageResource(rId);
		
		//Winner name
		TextView name = (TextView) view.findViewById(R.id.winnerNameView);
		name.setText(cursor.getString(2));
		
		//Winner score
		TextView score = (TextView) view.findViewById(R.id.winnerScoreView);
		score.setText(String.valueOf(cursor.getInt(3)));
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.result_row_layout, parent, false);
		bindView(v, context, cursor);
		return v;

	}
	


}
