package de.marcelhuber.pruefungsvorbereitung.ocp;

//import de.marcelhuber.systemtools.PressEnter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Marcel Huber
 */
public class ForkJoinForMaxindexFind {

    int[] data;

    public static void main(String[] args) {
        new ForkJoinForMaxindexFind().go();
    }

    void go() {
        initData();
        ForkJoinPool pool = new ForkJoinPool();
        RecursiveTask<Integer> task = new ArrayFindMaxindex(data, 0, data.length);
        int maxIndex = pool.invoke(task);
        System.out.println("data:                                           "
                + Arrays.toString(data));
        System.out.println("data bis zum ersten Auftreten des Maximalwerts: "
                + Arrays.toString(subdata(data, 0, maxIndex + 1)));
        System.out.println("maxIndex:                                       " + maxIndex);
        System.out.println("Maximalwert:                                    " + data[maxIndex]);
    }

    private void initData() {
        data = new int[]{1, 3, 2, 5, 2, 8, 7, 4, 11, 1, 11, 2, 5, 2, 8, 10, 4, 5};
    }

    private Integer[] subdata(int[] data, int start, int end) {
        Integer[] subdata;
        List<Integer> subdataList = new ArrayList<>();
        for (int k = start; k < end; k++) {
            subdataList.add(data[k]);
        }
        subdata = new Integer[subdataList.size()];
        subdataList.toArray(subdata);
        return subdata;
    }
}

class ArrayFindMaxindex extends RecursiveTask<Integer> {

    static private final int schwellwert = 3;
    private int[] data;
    private int startIndex;
    private int endIndex;
    private int middleIndex;
    private int indexOfMaximum;

    public ArrayFindMaxindex(int[] data, int startIndex, int endIndex) {
        this.data = data;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    protected Integer compute() {
//        System.out.println("startIndex: " + startIndex);
//        System.out.println("endIndex: " + endIndex);
//        PressEnter.toContinue();
        if (endIndex - startIndex <= schwellwert) {
            if ((endIndex - startIndex) >= 2) {
                indexOfMaximum = startIndex + 1;
                if (data[startIndex] > data[indexOfMaximum]) {
                    indexOfMaximum = startIndex;
                } else if (data[endIndex] > data[indexOfMaximum]) {
                    indexOfMaximum = endIndex;
                } else if (data[startIndex] == data[indexOfMaximum]) {
                    indexOfMaximum = (startIndex < indexOfMaximum) ? startIndex : indexOfMaximum;
                } else if (data[endIndex] == data[indexOfMaximum]) {
                    indexOfMaximum = (endIndex < indexOfMaximum) ? endIndex : indexOfMaximum;
                }
            } else if (endIndex == startIndex + 1) {
                indexOfMaximum = (data[startIndex] >= data[endIndex]) ? startIndex : endIndex;
            } else if (startIndex == endIndex) {
                indexOfMaximum = startIndex;
            }
            return indexOfMaximum;
        } else {
            middleIndex = (startIndex + endIndex) / 2;

            ArrayFindMaxindex firstHalf = new ArrayFindMaxindex(data, startIndex, middleIndex);
            ArrayFindMaxindex secondHalf = new ArrayFindMaxindex(data, middleIndex, endIndex);

            secondHalf.fork();

            int index1 = firstHalf.compute();
            int index2 = secondHalf.join();

            if (data[index1] > data[index2]) {
                return index1;
            } else if (data[index2] > data[index1]) {
                return index2;
            } else {
                return index1 < index2 ? index1 : index2;
            }
        }
    }
}
