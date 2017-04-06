package rtrk.pnrs1.ra51_2014;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by student on 6.4.2017.
 */

public class ListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<TaskCalss>mTasks;

    public ListAdapter(Context mContext) {
        this.mContext = mContext;
        mTasks = new ArrayList<TaskCalss>();
    }
    public void addTask(TaskCalss task){
        mTasks.add(task);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mTasks.size();
    }

    @Override
    public Object getItem(int position) {
        Object rv = null;
        try {
            rv = mTasks.get(position);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return  rv;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
