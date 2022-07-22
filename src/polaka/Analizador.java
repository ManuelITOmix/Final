/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polaka;

/**
 *
 * @author parti
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Analizador{
	public static char x[];
	public static  String invertida,postfija,nueva;
	public static char a[];
	public static char pila[];
	public static int tope,i,cont,j,a1,a2,k,l,n,m;	
	public static String invierte(String a)
	{
		invertida="";	
		nueva="";	
		x=a.toCharArray();
		for(int p=x.length-1;p>=0;p--)
		{
			invertida=invertida+String.valueOf(x[p]);
		}
		x=invertida.toCharArray();
		for (int p=0;p<x.length;p++)
		{
			if (x[p]==')')
			{x[p]='(';
			nueva=nueva+String.valueOf(x[p]);}			
			else if(x[p]=='(')
			{x[p]=')';
			nueva=nueva+String.valueOf(x[p]);}
			else
			nueva=nueva+String.valueOf(x[p]);
			}	
		return(nueva);	
	}
	public static String pofija(String entrefija)
	{		
		entrefija="("+entrefija+")";
		tope=-1;
		postfija="";
		pila=new char[250];
		a=entrefija.toCharArray();
		tope=Cabecera.pushPila(pila,tope,'#');		
		for(i=0;i<a.length;i++)
		{
			if(a[i]=='(')
			{
				tope=Cabecera.pushPila(pila,tope,a[i]);
							}
			else if(a[i]==')')
			{
				cont=tope;
				while(pila[cont]!='(')
				{		
					postfija=postfija+String.valueOf(pila[cont]);					
					tope=Cabecera.popPila(pila,tope);								
					cont--;					
				}
				if (tope!=0)
				tope=Cabecera.popPila(pila,tope);			
			}
			else if(Cabecera.evaluar(a[i])==4)
			{
				postfija=postfija+String.valueOf(a[i]);
			}
			else			
			{	
				cont=tope;
				while(pila[cont]!='('&&Cabecera.evaluar(pila[cont])>=Cabecera.evaluar(a[i]))
				{
					postfija=postfija+String.valueOf(pila[cont]);
					tope=Cabecera.popPila(pila,tope);
 
					cont--;
				}
 
				tope=Cabecera.pushPila(pila,tope,a[i]);				
			}		
 
 
		}		
		return(postfija);
 
 
	}
 
	public static void tercerpa(String cade)
	{	
		System.out.println(invierte(pofija(invierte(cade))));
 
	}
	public static void main (String args[])
	{
		Analizador uno=new Analizador();
		Scanner ent=new Scanner(System.in);
		System.out.println("Inserta la exprecion en infijo: ");
		String pre=ent.next();
		System.out.println("En prefijo es: ");
		uno.tercerpa(pre);
	}
}