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
public class Cabecera
{
	public static int eva;
	public static int pushPila(char pila[],int tope,char dato)
	{
		if (tope<pila.length)
		{
			tope++;
			pila[tope]=dato;
			return (tope);
		}
		else
			JOptionPane.showMessageDialog(null,"pila llena ... OverFlow");
		return (tope);	
	}		
	public static int popPila(char pila[],int tope)
	{
		if (tope!=-1)
		{
			pila[tope]=0;
			tope--;
			return (tope);
		}
		else
			JOptionPane.showMessageDialog(null,"Pila vacia ... underflow");
		return (tope);	
 
	}
	public static int ver(char pila[],int tope)
	{
		int i;
		String s="";
		for(i=tope;i>=0;i--)
		{
			s+="posicion "+i+" = "+pila[i]+'\n';
		}
		JOptionPane.showMessageDialog(null,s);
		return tope;
	}
	public static int evaluar(char a)
	{
		if (a=='+'||a=='-')
		{
			eva=1;		
		}
		else if(a=='/'||a=='*')
		{
			eva=2;		
		}
		else if (a=='^')
		{
			eva=3;		
		}
		else if (a=='('||a==')')
		eva=5;	
		else
		{
			eva=4;
		}
		return eva;
	}
}	
