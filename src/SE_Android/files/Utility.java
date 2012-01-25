package SE_Android.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Utility {
	/**
	 * Formats a file-path to a package-name
	 */
	public String formatPackageName(String name) {
		return name.replace("/", ".");
	}
	
	/**
	 * Copies a File
	 */
	public boolean copyImageFile(String sourcePath, String destinationPath, String filename) {
		File oldFile = new File(sourcePath, filename);
		File newFile = new File(destinationPath);
		
		if(!newFile.exists()) {
			newFile.mkdirs();
		}
		
		try {
			InputStream in = new FileInputStream(oldFile);
			OutputStream out = new FileOutputStream(new File(newFile, "ic_launcher.png"));
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
