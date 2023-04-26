import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;
public class CalculateSortTimeProject { 
	
	public static void main(String[] args) {

		int[] myArray= new int[50000000];
		ArrayList<Integer> myList= new ArrayList<Integer>(50000000);
		Vector<Integer> myVector= new Vector<Integer>(50000000);
		
		double totalArray= 0;
		double totalList= 0;
		double totalVector= 0;
		
		double totalSortArray= 0;
		double totalSortList= 0;
		double totalSortVector= 0;
		
		Random random= new Random();
		int[] randArray= new int[50000000];
		for (int j=0; j<50000000; j++) {
			randArray[j]=  random.nextInt(1, Integer.MAX_VALUE); //1 inclusive, MAX_VAL exclusive
		}
		
		//Array add, sort, calculate time difference, add to total time
		for (int i=0; i<10; i++) {
			long beginArray= System.currentTimeMillis();
			for (int m=0; m<50000000; m++) {
				myArray[m]= randArray[m];
			}
			long endArray= System.currentTimeMillis(); 
			Arrays.sort(myArray);
			long endSortingArray= System.currentTimeMillis();
		
			totalArray+= endArray-beginArray;
			totalSortArray+= endSortingArray-endArray;
			
			//ArrayList add, sort, calculate time difference, add to total time
			long beginList=System.currentTimeMillis();
			for (int k=0; k<50000000; k++) {;
				myList.add(randArray[k]);
			}
			long endList= System.currentTimeMillis();
			Collections.sort(myList);
			long endSortingList= System.currentTimeMillis();
				
			myList.clear();
			totalList+= endList-beginList;
			totalSortList+= endSortingList-endList;
			
			//Vector add, sort, calculate time difference, add to total time
			long beginVector= System.currentTimeMillis();
			for (int l=0; l<50000000; l++) {
				myVector.add(randArray[l]);
			}
			long endVector= System.currentTimeMillis();
			Collections.sort(myVector);
			long endSortingVector= System.currentTimeMillis();
				
			myVector.clear();
			totalVector+= endVector-beginVector;
			totalSortVector+= endSortingVector-endVector;
		}
			
		//print add and sort times
		System.out.println("Array add time: " + totalArray/10.0 + " ms");	
		System.out.println("ArrayList add time: " + totalList/10.0 + " ms");
		System.out.println("Vector add time: " + totalVector/10.0 + " ms");
		System.out.println("Array sort time: " + totalSortArray/10.0 + " ms"); 
		System.out.println("ArrayList sort time: " + totalSortList/10.0 + " ms");
		System.out.println("Vector sort time: " + totalSortVector/10.0 + " ms");
	}
}
