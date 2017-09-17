package de.marcelhuber.mathematik.algebra;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class PartitionierungEinerNatuerlichenZahlEffizientUnfertig {

    List<List<ArrayList<Long>>> partitionList = new ArrayList<>();

    public static void main(String[] args) {
        PartitionierungEinerNatuerlichenZahlEffizientUnfertig dummyObject = new PartitionierungEinerNatuerlichenZahlEffizientUnfertig();
        long x = 4;
        dummyObject.createAllPartitions(x);
    }

    private void createAllPartitions(long x) {
        for (long k = 1; k <= x; k++) {
            createPartitionOfNumber(k);
        }
    }

    private void createPartitionOfNumber(long x) {
        List<List<Long>> thisList = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            if (i == 0) {
                List<Long> localList = new ArrayList<>();
                localList.add(x);
                thisList.add(localList);
                System.out.println("thisList: " + thisList);
            } else {
                for (List<Long> list : thisList) {
                    System.out.println("list: " + list);
                    List<Long> listCopy = new ArrayList<>();
                    for (Long entry : list) {
                        listCopy.add(entry);
                    }
                    listCopy.set(0, listCopy.get(0) - i);
                    listCopy.add(1, (long) i);
                    System.out.println("listCopy: " + listCopy);
                }
            }
        }
    }

    private boolean monotonFallend(List<Long> testListe) {
        for (int k = 0; k < testListe.size() - 1; k++) {
            if (testListe.get(k) < testListe.get(k + 1)) {
                return false;
            }
        }
        return true;
    }

//    private boolean checkSum(long[] possiblePartition, long x) {
//        long sum = 0;
//        for (long entry : possiblePartition) {
//            sum += entry;
//        }
//        return (sum == x);
//    }
}
