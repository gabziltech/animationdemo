package gabzil.com.animationprojectdemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity {
    Button start;
    ImageView image;
    String str;
    float angle;
    long speed;
    private Spinner swingAngle, swingSpeed;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=(Button)findViewById(R.id.startanimation);
        image=(ImageView)findViewById(R.id.animationView);
        swingAngle = (Spinner) findViewById(R.id.spinnerangle);
        swingSpeed = (Spinner) findViewById(R.id.spinnerspeed);
        t1=(TextView) findViewById(R.id.in);

        swingAngle.setSelection(9);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    angle = Float.parseFloat(String.valueOf(swingAngle.getSelectedItem()));
                    if(angle>0){
                        t1.setText("In-Swing");
                        t1.setVisibility(View.VISIBLE);
                    }
                    else{
                        t1.setText("out-Swing");
                        t1.setVisibility(View.VISIBLE);
                    }
                    str = String.valueOf(swingSpeed.getSelectedItem());
                    if(str.equals("Slow")){
                        speed=5000;
                    }else if(str.equals("Medium")){
                        speed=2000;
                    }else if(str.equals("Fast")){
                        speed=500;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Step1 : create the  RotateAnimation object
                RotateAnimation anim = new RotateAnimation(0f, angle, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

                // Step 2:  Set the Animation properties
                anim.setFillAfter(true);
                anim.setInterpolator(new LinearInterpolator());

                //anim.setRepeatCount(Animation.RELATIVE_TO_SELF);
                anim.setRepeatCount(Animation.ABSOLUTE);
                anim.setDuration(speed);

                // Step 3: Start animating the image
                image.startAnimation(anim);

            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
