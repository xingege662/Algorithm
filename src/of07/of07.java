package of07;

/**
 * Created by xinchang on 2018/3/6.
 */

/**
 * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。
 */
public class of07 {

    public static int replaceBlank(char[] strings, int usedLength) {
        if (null == strings && strings.length == 0) {
            throw new RuntimeException("数组不存在");
        }

        int blankNumber = 0 ;

        for(int i = 0 ; i < usedLength ;i++) {
            if (' ' == strings[i]) {
                blankNumber++;
            }
        }

        if (blankNumber == 0) {
            return usedLength;
        }

        int totalLength = blankNumber * 2 + usedLength;


        if (totalLength > strings.length) {
            return -1;
        }

        int tmp = totalLength;


        usedLength--;
        System.out.println(totalLength);
        totalLength--;

        while(usedLength < totalLength && usedLength >= 0 ){
            if(' ' == strings[usedLength]){
                strings[totalLength--] = '0';
                strings[totalLength--] = '2';
                strings[totalLength--] = '%';
            }else{
                strings[totalLength--] = strings[usedLength];
            }

            usedLength--;

        }
        return  tmp;

    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';

        int length = replaceBlank(string, 12);
        System.out.println(new String(string, 0, length));
    }
}
