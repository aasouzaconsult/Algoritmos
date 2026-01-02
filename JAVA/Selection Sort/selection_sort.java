/*
 * @(#)SelectionSortAlgorithm.java	1.0 95/06/23 Jason Harrison
 *
 * Copyright (c) 1995 University of British Columbia
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies. Please refer to the file "copyright.html"
 * for further important copyright and licensing information.
 *
 * UBC MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UBC SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

/**
 * A selection sort demonstration algorithm
 * SortAlgorithm.java, Thu Oct 27 10:32:35 1994
 *
 * @author Jason Harrison@cs.ubc.ca
 * @version 	1.0, 23 Jun 1995
 *
 */
class SelectionSortAlgorithm extends SortAlgorithm {
    void sort(int a[]) throws Exception {
	   for (int i = 0; i < a.length; i++) {
	       int min = i;
           int j;

           /*
            *  Encontra o menor elemento na lista não ordenada
            */
           for (j = i + 1; j < a.length; j++) {
	          if (stopRequested) {
		         return;
              }

		      if (a[j] < a[min]) {
                 min = j;
              }
	          pause(i,j);
	       }

           /*
            *  Coloca o menor elemento não ordenado no fim da lista ordenada
            */
           int T = a[min];
           a[min] = a[i];
           a[i] = T;
	       pause(i,j);
       }
    }
}