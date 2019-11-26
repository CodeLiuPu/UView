package com.update.uview.choreographer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.update.uview.R;

/**
 * Choreographer 测试类
 */
public class ChoreographerFragment extends Fragment {
    private long mStartFrameTime = 0;
    private int mFrameCount = 0;
    private static final long MONITOR_INTERVAL = 160L; // 单词计算FPS使用 160ms
    private static final long MONITOR_INTERVAL_NANOS = 160L;
    private static final long MAX_INTERVAL = 1000L;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flow_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getFPS();
    }

    private void getFPS() {
        final long starTime = System.nanoTime();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
                Log.e("update", "starTime=" + starTime
                        + ", frameTimeNanos=" + frameTimeNanos
                        + ", frameDueTime=" + (frameTimeNanos - starTime) / 1000000);
            }
        });
    }
}