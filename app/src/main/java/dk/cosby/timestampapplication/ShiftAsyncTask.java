package dk.cosby.timestampapplication;

import android.os.AsyncTask;
import android.util.Log;

public class ShiftAsyncTask extends AsyncTask<Void, String, Void> {


    public ShiftAsyncTask() {
        super();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.i("TEST PRE EXECUTE", "Pre execute");

    }

    @Override
    protected Void doInBackground(Void... voids) {

        String s = "+++";

        for (int i = 0; i < 10; i++) {
            Log.i("TEST BACKGROUND", "Text " + i);
            s = s.concat(String.valueOf(i));
        }

        publishProgress(s);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Log.i("TEST POST EXECUTE", "Post execute");
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);

        String s = values[0];

        Log.i("TEST PROGRESS UPDATE", "Progress update " + s);
    }
}
