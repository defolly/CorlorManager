package com.belle.cordova.plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
  private static File greenfile = new File("/sys/class/leds/gscan/brightness"); // 写0 灭 写255 亮
  private static File redfile = new File("/sys/class/leds/rscan/brightness");
  private static String[] orange = new String[] {"255", "255"};
  private static String[] red = new String[] {"255", "0"};
  private static String[] green = new String[] {"0", "255"};

  /**
   * 扫描枪显示灯颜色
   *
   * @param color color, "red" or "orange" or "green"
   */
  public static void showColor(String color) {
    try {
      switch (color) {
        case "red":
          stringToFile(greenfile, "0");
          stringToFile(redfile, red[0]);
          break;
        case "orange":
          stringToFile(greenfile, "255");
          stringToFile(redfile, orange[0]);
          break;
        case "green":
          stringToFile(greenfile, "255");
          stringToFile(redfile, green[0]);
          break;
        default:
          closeColor();
          break;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 扫描枪关闭显示灯
   *
   * @param color color, "red" or "orange" or "green"
   */
  public static void closeColor() {
    try {
      stringToFile(greenfile, "0");
      stringToFile(redfile, "0");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void stringToFile(File file, String s) throws IOException {
    System.out.println("path--->" + file.getAbsoluteFile());
    if (file == null || !file.exists()) {
      System.out.println("文件不存在");
      return;
    }
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    fileOutputStream.write(s.getBytes());
    fileOutputStream.flush();
  }
}