package tree.rbt;

import java.util.Map;
import java.util.TreeMap;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-09
 * Time : 21:20
 * Description :
 */
public class TreeMapTest {

    public static void main(String[] args) {


        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(1, 5);
        map.put(5, 5);
        map.put(2, 5);
        map.put(4, 5);

//        for (Map.Entry<Integer, Integer> enrty : map.entrySet()) {
//            System.out.println(enrty.getKey());
//        }

        System.out.println(map.ceilingKey(3));
        System.out.println(map.floorKey(3));
        System.out.println(map.higherKey(3));
        System.out.println(map.lowerKey(3));

        Map.Entry<Integer, Integer> entry = map.ceilingEntry(3);
        System.out.println(entry.getValue());

    }
}
