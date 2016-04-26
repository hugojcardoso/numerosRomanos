package com.example.exercicioprova;

import android.annotation.SuppressLint;

public class ConverterDecimalRomano {

	private String romanos[] = new String[]  {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
	private Integer equi [] = new Integer [] {1,4,5,9,10,40,50,90,100,400,500,900,1000};
	
	public String converter(int decimal){
		String retorno = "",repete="";
    	int div;
    	int i=equi.length-1;
    	while(decimal != 0){
			div = decimal / equi[i];
			repete = "";
			for(int j=1; j <= div; j++) repete += romanos[i];
			retorno+= repete;
			decimal = decimal % equi[i];
			i--;
		}
    	return retorno;   
	}
}
