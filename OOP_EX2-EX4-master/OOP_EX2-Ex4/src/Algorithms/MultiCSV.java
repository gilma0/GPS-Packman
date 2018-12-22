package Algorithms;

import java.io.File;
import java.io.IOException;

import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import File_format.Csv2kml;
import GIS.Element;
import GIS.Element;
import GIS.Layer;
import GIS.Project;
/**
 *Search CSV file from chosen location.
 *we used this web.
 *http://www.javapractices.com/topic/TopicAction.do?Id=68
 * @author Gil && Amit
 *
 */

public final class MultiCSV extends Csv2kml  {
	  public static  ArrayList<String> csvFillArr =new ArrayList<String>(); 
	  public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in); 
		System.out.println("insert path name:");
	    String ROOT =sc.nextLine();
	    FileVisitor<Path> fileProcessor = new ProcessFile();
	    //search all CSV files.
	    Files.walkFileTree(Paths.get(ROOT), fileProcessor);
	    //create project and KML for every file.
	    csvFiles(csvFillArr);
	  }
	  
private static final class ProcessFile extends SimpleFileVisitor<Path> { 
	   
	  	public FileVisitResult visitFile( Path file, BasicFileAttributes attrs) throws IOException {
	  		String temp = file.getFileName().toString();
	  		if (!temp.contains(".csv")) {
	    		return FileVisitResult.CONTINUE;
	    	}
	        System.out.println("Processing file:" + file);
	        csvFillArr.add(file.toString());
	        return FileVisitResult.CONTINUE;
	    }
	    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
	      System.out.println("Processing directory:" + dir);
	      return FileVisitResult.CONTINUE;
	    }
	  }
	} 