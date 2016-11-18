//********************************************************************
//  Sortlab.java       Author:
//
//  Driver to exercise the use of several Sorting Arrays methods.
//********************************************************************
package com.company;

public class SortsLab {
    static final int MAX=20;

    public static void main(String[] args) {
        new SortsLab();
    }

    public SortsLab() {
    	int[] list = new int[MAX], list2 = new int[MAX], list3 = new int[MAX], list4 = new int[MAX], list5 = new int[MAX];
		int qcount=0, icount = 0, scount = 0, mcount = 0;


		////////////////////////////////////////Random Order//////////////////
			System.out.println("Random order lists ");
			ListSetup.MakeRandom (list);
			ListSetup.Copy (list,list2);
			ListSetup.Copy (list,list3);
			ListSetup.Copy (list,list4);
			ListSetup.Copy (list,list5);

			System.out.println("List before sorting:");
			ListSetup.Print (list);
			System.out.println("Here is the list after the Insertion Sort. ");
			icount = Sorts.Insertion(list);
			System.out.println("iCount = " + icount);
			ListSetup.Print (list);
			//System.out.println("There were " + icount + " comparisons ");
			
			System.out.println("Here is the list after the Selection Sort. ");
			scount = Sorts.Selection(list2);
			System.out.println("sCount = " + scount);
			ListSetup.Print (list2);
			System.out.println("Here is the list after the Quicksort (split first). ");
			qcount = Sorts.QuickSort(list3, 0, list.length - 1);
			System.out.println("qCount = " + qcount);
			ListSetup.Print (list3);
			System.out.println("Here is the list after the Merge Sort. ");
			mcount = Sorts.mergeSort(list4, 0, list.length - 1);
			System.out.println("mCount = " + mcount);
			ListSetup.Print (list4);


		///////////////////////////////////////Ascending Order//////////////////






		////////////////////////////////////////Descending Order//////////////////
		}
}
