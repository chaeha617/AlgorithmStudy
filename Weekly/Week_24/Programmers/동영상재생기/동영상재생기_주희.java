import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int count = 0;
        int convertPos = timeConvertInt(pos);

        convertPos = opening(op_start, op_end, convertPos);
        while (count < commands.length) {
            String command = commands[count];

            convertPos = beforeSec(command, convertPos, op_start, op_end);

            convertPos = afterSec(command, video_len, convertPos, op_start, op_end);

            convertPos = opening(op_start, op_end, convertPos);
            count++;
        }

        return intConvertTime(convertPos);
    }

    private int opening(String op_start, String op_end, int convertPos) {
        int osLength = timeConvertInt(op_start);
        int oeLength = timeConvertInt(op_end);

        if (convertPos >= osLength && convertPos < oeLength) {
            convertPos = oeLength;
        }

        return convertPos;
    }

    private int beforeSec(String command, int convertPos, String op_start, String op_end) {
        if ("prev".equals(command)) {
            convertPos -= 10;
            if (convertPos < 0) {
                convertPos = 0;
            }

            return convertPos;
        }

        return convertPos;
    }

    private int afterSec(String command, String video_len, int convertPos, String op_start, String op_end) {
        if ("next".equals(command)) {
            convertPos += 10;
            int videoLength = timeConvertInt(video_len);

            if (convertPos > videoLength) {
                convertPos = videoLength;
            }

            return convertPos;
        }

        return convertPos;
    }

    private int timeConvertInt(String time) {
        String[] timeSplit = time.split(":");
        int mm = Integer.parseInt(timeSplit[0]);
        int ss = Integer.parseInt(timeSplit[01]);

        return mm * 60 + ss;
    }

    private String intConvertTime(int time) {
        int mm = time / 60;
        int ss = time % 60;

        return String.format("%02d:%02d", mm, ss);
    }
}