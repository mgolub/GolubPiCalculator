package golub.picalculator;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by student1 on 11/19/2015.
 */
public class PiCalculationAsyncTask extends AsyncTask<Long, String, String> {
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0]);
    }

    private TextView textView;

    public PiCalculationAsyncTask(TextView textView){
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Long... params) {
        double pi = calculate(100000000L);
        return String.valueOf(pi);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        textView.setText(s);
    }
    public double calculate(long iterations){
        double pi = 0;

        double numerator = 4;
        double denominator = 1;

        boolean positive = true;
        for (long i = 0; i < iterations; i++){
            if (positive){
                pi += numerator/denominator;
            }
            else{
                pi -= numerator/denominator;
            }
            denominator +=2;
            positive = !positive;
            publishProgress(String.valueOf(pi));

        }

        return pi;
    }
}
