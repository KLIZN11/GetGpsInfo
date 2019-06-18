package cn.edu.imnu.com;

import java.io.File;
import java.util.Iterator;

public class GetGPSInfo {
	public static void main(String[] args){
		File jpegFile = new File("F:/图片定位/DCIM/P20130116_125539.jpg");
		Metadata metadata;
		try {
		metadata = JpegMetadataReader.readMetadata(jpegFile);
		Directory exif = metadata.getDirectory(ExifDirectory.class);
		Iterator tags1 = exif.getTagIterator();
		while (tags1.hasNext()) {
		Tag tag = (Tag)tags1.next();
		System.out.println(tag);
		}
		Directory jpeg = metadata.getDirectory(JpegDirectory.class);
		Iterator tags2 = jpeg.getTagIterator();
		while (tags2.hasNext()) {
		Tag tag = (Tag)tags2.next();
		System.out.println(tag);
		}
		Directory gps = metadata.getDirectory(GpsDirectory.class);
		Iterator tags3 = gps.getTagIterator();
		while (tags3.hasNext()) {
		Tag tag = (Tag)tags3.next();
		System.out.println(tag);
		}
		} catch (JpegProcessingException e) {
		e.printStackTrace();
		}
		}
}
