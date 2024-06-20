import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class Main {
    private static final int ARRAY_SIZE = 8388608; // 2^23
    private static final int SEED = 42;
    public static void main(String[] args) throws IOException {
        Random rand = new Random(SEED);
        FileWriter csvWriter = new FileWriter("sort_times.csv");

        csvWriter.append("Thread Count,Run Type,Execution Time (ms),Is Sorted\n");

        int[] threadCounts = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

        for (int threadCount : threadCounts) {
            for (int i = 0; i < 5; i++) { // Run each setting 5 times
                List<Integer> list = new ArrayList<>();
                for (int j = 1; j <= ARRAY_SIZE; j++) {
                    list.add(j);
                }
                Collections.shuffle(list, rand); // Shuffles the list using the seeded random

                int[] array = list.stream().mapToInt(Integer::intValue).toArray();
                int[] arrayCopy = array.clone();  // Make a copy for concurrent sorting

                // Single-threaded merge sort
                long startTime = System.currentTimeMillis();
                List<Interval> intervals = generate_intervals(0, array.length - 1);
                for (Interval interval : intervals) {
                    merge(array, interval.getStart(), interval.getEnd());
                }
                long elapsedTime = System.currentTimeMillis() - startTime;
                boolean sorted = isSorted(array);
                csvWriter.append(threadCount + ",Single-threaded," + elapsedTime + "," + sorted + "\n");

                // Concurrent merge sort
                ForkJoinPool pool = new ForkJoinPool(threadCount);
                MergeSortTask task = new MergeSortTask(arrayCopy, 0, arrayCopy.length - 1);
                startTime = System.currentTimeMillis();
                pool.invoke(task);
                elapsedTime = System.currentTimeMillis() - startTime;
                sorted = isSorted(arrayCopy);
                csvWriter.append(threadCount + ",Concurrent," + elapsedTime + "," + sorted + "\n");
            }
        }
        
        csvWriter.flush();
        csvWriter.close();
    }

    // Generate intervals 
    public static List<Interval> generate_intervals(int start, int end) {
        List<Interval> intervals = new ArrayList<>();
        if (start == end) {
            intervals.add(new Interval(start, end));
            return intervals;
        }

        int mid = start + (end - start) / 2;
        intervals.addAll(generate_intervals(start, mid));
        intervals.addAll(generate_intervals(mid + 1, end));
        intervals.add(new Interval(start, end));
        return intervals;
    }

    // Merge function as provided in the template
    public static void merge(int[] array, int s, int e) {
        if (s < e) {
            int m = s + (e - s) / 2;
            int[] left = new int[m - s + 1];
            int[] right = new int[e - m];
            int l_ptr = 0, r_ptr = 0;
            for(int i = s; i <= e; i++) {
                if(i <= m) {
                    left[l_ptr++] = array[i];
                } else {
                    right[r_ptr++] = array[i];
                }
            }
            l_ptr = r_ptr = 0;

            for(int i = s; i <= e; i++) {
                if(l_ptr < left.length && (r_ptr == right.length || left[l_ptr] <= right[r_ptr])) {
                    array[i] = left[l_ptr++];
                } else {
                    array[i] = right[r_ptr++];
                }
            }
        }
    }

    // Utility method to check if the array is sorted
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int start;
        private final int end;

        public MergeSortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (start < end) {
                int mid = start + (end - start) / 2;
                MergeSortTask leftTask = new MergeSortTask(array, start, mid);
                MergeSortTask rightTask = new MergeSortTask(array, mid + 1, end);
                invokeAll(leftTask, rightTask);
                merge(array, start, end);
            }
        }
    }
}
