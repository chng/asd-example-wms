import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Queue;

/**
 * Created by chn on 16/5/8.
 */
public class ScheduleTask implements Task {

    Queue<DuationTask> tasks = Lists.newLinkedList();
    public ScheduleTask add(DuationTask t) {
        tasks.add(t);
        return this;
    }

    public void exec() {
        while(!tasks.isEmpty()) {
            DuationTask t = tasks.remove();

            long cur = System.currentTimeMillis();
            // 时间到
            if (t.getStartTime() + t.getInterval() < cur) {
                t.exec();
                t.setStartTime(System.currentTimeMillis());
            }
            tasks.offer(t);
        }
    }

    class DuationTask implements Task {
        private long startTime = System.currentTimeMillis();
        private long interval = 0;

        public DuationTask(long interval) {
            this.interval = interval;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getInterval() {
            return interval;
        }
        public long getStartTime() {
            return startTime;
        }

        public void exec() {
            System.out.println("exec");
        }
    }

    @Test
    public void test() {
        ScheduleTask st = new ScheduleTask();
        st.add(new DuationTask(1000)).add(new DuationTask(2000));
        st.exec();
    }
}
