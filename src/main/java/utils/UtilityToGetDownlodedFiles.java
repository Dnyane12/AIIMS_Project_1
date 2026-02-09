package utils;

import java.io.File;

public class UtilityToGetDownlodedFiles {
	public static File getDownloadedPdf(String downloadDir, int timeoutInSeconds) {

	    File dir = new File(downloadDir);
	    long endTime = System.currentTimeMillis() + timeoutInSeconds * 1000;

	    while (System.currentTimeMillis() < endTime) {
	        File[] files = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".pdf"));

	        if (files != null && files.length > 0) {
	            return files[0];   // This is pdfFile
	        }

	        try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}

}
