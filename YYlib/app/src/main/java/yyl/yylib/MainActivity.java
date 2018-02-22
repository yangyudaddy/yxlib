package yyl.yylib;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         myText = (TextView)findViewById(R.id.mytext);
        myText.setText("Hello World");
//        testOf();
//        margin();
    }
    private void testOf(){
        ValueAnimator animator = ValueAnimator.ofObject(new CharEvaluator(),9,0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int text = (int)animation.getAnimatedValue();
                myText.setText(String.valueOf(text));
            }
        });
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();

    }

    public class CharEvaluator implements TypeEvaluator<Integer> {
        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            int startInt  = (int)startValue;
            int endInt = (int)endValue;
            int curInt = (int)(startInt+fraction *(endInt - startInt));
            Integer result = (int)curInt;
            Log.v("result",fraction+"+++++"+result);
            return result;
        }
    }

    private void margin(){

        ValueAnimator animator = ValueAnimator.ofInt(0,100);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatorValue = (int)animation.getAnimatedValue();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) myText.getLayoutParams();
                marginLayoutParams.topMargin = animatorValue;
                myText.setLayoutParams(marginLayoutParams);
            }
        });

        //4.设置动画的持续时间、是否重复及重复次数等属性
        animator.setDuration(2000);
        animator.setRepeatCount(3);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        //5.为ValueAnimator设置目标对象并开始执行动画
        animator.setTarget(myText);
        animator.start();

    }
}
