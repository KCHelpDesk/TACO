package Build;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.image.Image;

public class BannerControl {
	private static Image banner;
	private static File dateFile = new File("resources/date.taco");
	
	public static Image getBanner() {
		// TODO Auto-generated method stub
		return banner;
	}
	
	public static void checkDate() {
		if (getDateFile().exists()){
			String installDate;
			try {
				installDate = new String(Files.readAllBytes(Paths.get("resources/date.taco")));
				installDate.trim();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate date = LocalDate.parse(installDate, formatter);
				LocalDate sixMonths = date.plusMonths(6);
				if (LocalDate.now().isAfter(sixMonths) && LocalDate.now().isBefore(sixMonths.plusMonths(2))){
					setBanner("file:resources/img/coupon.png");
				}
				else{
					setBanner("file:resources/img/banner.png");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void buildDateFile() {
		if (!getDateFile().exists()) {
			try {
				BufferedWriter output =  new BufferedWriter(new FileWriter(getDateFile()));
				output.write(LocalDate.now().toString());
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static File getDateFile() {
		return dateFile;
	}
	
	public static void setDateFile(File file){
		dateFile = file;
	}
	
	private static void setBanner(String string){
		banner = new Image(string);
		
	}

}
