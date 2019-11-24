import java.util.Arrays;
import java.util.LinkedList;

//https://leetcode-cn.com/problems/queue-reconstruction-by-height/
public class ReconstructionQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(people);
    }
}
