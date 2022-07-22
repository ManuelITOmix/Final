/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polaka;

/**
 *
 * @author parti
 */
import javax.swing.JOptionPane;
import java.awt.*;
class Procesos
{
	public static  String postfija;
	public static char a[],b[],c[],d[],e[],f[];
	public static char pila[],pila1[],pila2[];
	public static int tope,i,cont,j,a1,a2,k,l,n,m;
	public static boolean t=false,lp;	
	public static void Convert(String entrefija,List uno,List dos,List tres,List cuatro,List cinco,List seis,Label letra)
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
				dos.addItem(String.valueOf(a[i]));	
				cinco.addItem(String.valueOf(a[i]));		
			}
			else if(a[i]==')')
			{
				cont=tope;
				while(pila[cont]!='(')
				{	
 
					postfija=postfija+String.valueOf(pila[cont]);	
					tres.addItem(String.valueOf(pila[cont]));
					seis.addItem(String.valueOf(pila[cont]));							
					tope=Cabecera.popPila(pila,tope);
					cinco.remove(cont);											
					cont--;					
				}
				if (tope!=0)
				cinco.remove(tope);
				tope=Cabecera.popPila(pila,tope);
 
			}
			else if(Cabecera.evaluar(a[i])==4)
			{
				tres.addItem(String.valueOf(a[i]));					
				seis.addItem(String.valueOf(a[i]));	
				postfija=postfija+String.valueOf(a[i]);
			}
			else			
			{	
				cont=tope;
				while(pila[cont]!='('&&Cabecera.evaluar(pila[cont])>=Cabecera.evaluar(a[i]))
				{
					tres.addItem(String.valueOf(pila[cont]));
					seis.addItem(String.valueOf(pila[cont]));
					postfija=postfija+String.valueOf(pila[cont]);
					tope=Cabecera.popPila(pila,tope);
					cinco.remove(cont);						
					cont--;
				}
				dos.addItem(String.valueOf(a[i]));
				cinco.addItem(String.valueOf(a[i]));
				tope=Cabecera.pushPila(pila,tope,a[i]);				
			}		
 
			System.out.println(a[i]);
			uno.addItem(String.valueOf(a[i]));		
			cuatro.addItem(String.valueOf(a[i]));		
		}		
		System.out.println(postfija);
		letra.setText(postfija);
 
	}
	public static boolean vercadena(String pp)
	{
		if(balanceo(pp)==true&&entrefija(pp)==true)
		{
			b=pp.toCharArray();
			for(j=0;j<b.length;j++)
			{
				if (b[j]=='A'||b[j]=='B'||b[j]=='C'||b[j]=='D'||b[j]=='E'||b[j]=='F'||b[j]=='G'||b[j]=='H'||b[j]=='I'||b[j]=='J'||b[j]=='K'||b[j]=='L'||b[j]=='M'||b[j]=='N'||b[j]=='Ñ'||b[j]=='O'||b[j]=='P'||b[j]=='Q'||b[j]=='R'||b[j]=='S'||b[j]=='T'||b[j]=='U'||b[j]=='V'||b[j]=='W'||b[j]=='X'||b[j]=='Y'||b[j]=='Z'||b[j]=='+'||b[j]=='-'||b[j]=='*'||b[j]=='/'||b[j]=='^'||b[j]=='('||b[j]==')')
					{												
						t=true;
					}					
			else
					{
						j=b.length;
						t=false;
					}				
			}
		}	
		return t;
	}	
	public static boolean balanceo(String cadena)
	{
		c=cadena.toCharArray();
		for(k=0;k<c.length;k++)
		{
			if(c[k]=='(')
			a1=a1+1;
			else if (c[k]==')')
			a2=a2+1;
		}
		if (a1==a2)
		return true;
		else
		return false;
	}	
	public static boolean entrefija(String algo)
	{
		d=quita(algo).toCharArray();
		for(l=1;l<d.length-1;l++)
		{	
				if (signo(d[l-1])==1&&signo(d[l])==2&&signo(d[l+1])==1)
			{
				lp=true;				
			}	
			else if (signo(d[l-1])==2&&signo(d[l])==1&&signo(d[l+1])==2)
			{
				lp=true;
			}				
			 else
			{
				l=d.length-1;
				lp=false;				
			}			
 
 
		}
		return lp;		
	}	
	public static String quita(String a)
	{
		String ha="";
		e=a.toCharArray();
 
		for( n=0;n<e.length;n++)	
		{
			if (Cabecera.evaluar(e[n])!=5)
				ha=ha+String.valueOf(e[n]);				
		}	
		return ha;
	}	
	public static int signo(char al)
	{
		int f;
 
		if (al=='*'||al=='/'||al=='+'||al=='-'||al=='^')
		f=2;		
		else
		f=1;
		return f;
	}
}	