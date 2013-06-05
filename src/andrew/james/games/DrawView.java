package andrew.james.games;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

public class DrawView extends View {
	public Paint paint = new Paint();
	public Bitmap bitmap = Bitmap.createBitmap(618, 388, Bitmap.Config.ARGB_8888);
	public Drawable image;

	public DrawView(Context context){
		super(context);
	}

	@Override
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		if(image != null)
			image.draw(canvas);
		canvas.drawBitmap(bitmap, 618, 388, paint);
	}
}
