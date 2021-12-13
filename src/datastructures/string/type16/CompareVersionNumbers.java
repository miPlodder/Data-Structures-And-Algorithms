package datastructures.string.type16;

//https://leetcode.com/problems/compare-version-numbers/
public class CompareVersionNumbers {

    public static void main(String[] args) {
        System.out.println(compareVersion("1.1", "1.001.90"));
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.1.90", "1.001.09"));
        System.out.println(compareVersion("1.1", "1.001.0.0"));
        System.out.println(compareVersion("1.1", "1.001.0.9"));

    }

    private static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < split1.length && j < split2.length) {
            int val1 = Integer.parseInt(split1[i]);
            int val2 = Integer.parseInt(split2[j]);
            if (val1 > val2) {
                return 1;
            } else if (val1 < val2) {
                return -1;
            }
            i++;
            j++;
        }
        while (i < split1.length) {
            int val = Integer.parseInt(split1[i]);
            if (val > 0) {
                return 1;
            }
            i++;
        }
        while (j < split2.length) {
            int val = Integer.parseInt(split2[j]);
            if (val > 0) {
                return -1;
            }
            j++;
        }

        return 0;
    }
}
