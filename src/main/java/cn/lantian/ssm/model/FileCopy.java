package cn.lantian.ssm.model;

import java.io.*;

/**
 * Created by Lzbin、LANTIAN on 2017/10/17.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.model
 * @Dercripton
 * @Time 1:53
 */
public class FileCopy  {
    public static void FileCopy(File source, File target) throws IOException {
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(source));
            fos = new BufferedOutputStream(new FileOutputStream(target));
            byte[] buf = new byte[4096];
            int i;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            fis.close();
            fos.close();
        }
    }
}
