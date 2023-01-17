package sort.util;

/**
 * @author baicai
 */
public class Print {
    public static void out(String preStr, int[] list) {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------\n");
        sb.append(preStr);
        sb.append("\n[");
        for (int i = 0; i < list.length; i++) {
            if(i != 0){
                sb.append(",");
            }
            sb.append("\t");
            sb.append(list[i]);
        }
        sb.append("\t]\n[");
        for (int i = 0; i < list.length; i++) {
            if(i != 0){
                sb.append(",");
            }
            sb.append("\t");
            sb.append(i);
        }
        sb.append("\t]\n");
        sb.append("-------------------------");
        System.out.println(sb.toString());
    }
}
