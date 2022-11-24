package assignment2;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise18 {

    public static void main(String[] args) {
        File file = new File("src");
        System.out.println(getSize(file));
    }

    public static long getSize(File directory) {
        Queue<File> queue = new LinkedList<>();

        long size = 0;

        queue.offer(directory);
        while (!queue.isEmpty()) {
            File temp = queue.poll();

            if (temp.isFile()) {
                size += temp.length();
            } else {
                File[] subFiles = temp.listFiles();
                for (File subFile : subFiles
                ) {
                    queue.offer(subFile);
                }
            }

        }
        return size;
    }
}
