package yyl.yylib;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * ——感觉自己萌萌哒——
 * +   /\_/\     +
 * + =( °w° )=   +
 * +   )   (  // +
 * + (__ __)//   +
 * +++++++++++++++
 * <p>
 * author: yangxiaoling
 * Create_Date:   2017/7/12 上午10:57
 * Package_NAME  yyl.yylib
 * Describe:
 */

public class CountView extends View {

    Paint paint;

    private final static int DEFAULT_TEXTSIZE=45;
    private final static int DEFAULT_TEXTCOLOR=Color.BLACK;
    private Rect mTextBounds = new Rect();

    private String num = "2012";

    private float textHeight;

    private float offset=1;


    public CountView(Context context) {
        super(context);
        init(context,null);
    }

    public CountView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Log.v("textHeight",textHeight+"");
        canvas.drawText(num,100,100,paint);
        canvas.translate(0,200);
        //canvas.drawText(num,100,200,paint);
        canvas.restore();
    }
    Handler handler = new Handler();

    private void init(Context context,AttributeSet attrs){
        initPaint();
        getTextHeight();
    }

    private void getTextHeight(){

        paint.getTextBounds(num,0,num.length(),mTextBounds);
        textHeight = mTextBounds.height();
    }

    private void initPaint(){
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setTextSize(DEFAULT_TEXTSIZE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);

        setMeasuredDimension(width,height);
    }

    /**
     * 测量宽度
     * @param measureSpec
     * @return
     */
    private int measureWidth(int measureSpec){
        int mode = MeasureSpec.getMode(measureSpec);
        int widthSpec = MeasureSpec.getSize(measureSpec);

        int tempWidth = 0;

        switch (mode){
            case MeasureSpec.EXACTLY:
                tempWidth = widthSpec;
                break;
            case MeasureSpec.AT_MOST:

                break;
        }
          return tempWidth;
    }

    /**
     * 测量高度
     * @param measureSpec
     * @return
     */
    private int measureHeight(int measureSpec){
        int mode = MeasureSpec.getMode(measureSpec);
        int heightSpec = MeasureSpec.getSize(measureSpec);

        int tempHeight = 0;
        tempHeight = heightSpec;

        return tempHeight;
    }
}
