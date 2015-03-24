import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Maze implements LabyrinthModel,LabyrinthView,LabyrinthSolver,LabyrinthObserver
{
int[][] map1=new int[100][100];
int row,column;
String solPart;
 ArrayList<String> ex= new ArrayList<String>(); 
public Maze()
{
	File locatie= new File("D:\\!Scoala\\gitRep\\Tema4\\PaTema4MazeRunner\\src\\map2.txt");
	try
	{
		FileReader readFrom=new FileReader(locatie);
		BufferedReader bufferReader=new BufferedReader(readFrom);
		String line;
		int linie=0;
		while((line=bufferReader.readLine())!=null)
		{
			int coloana=0;
			String [] date=line.split(" ");
            while (coloana<5&&date[coloana]!=null)
            {   
            	int value=Integer.parseInt(date[coloana]);
            	map1[linie][coloana]=value;/////
            	coloana=coloana+1;
            }
            column=coloana;
          linie=linie+1;  
		}
		row=linie;
		bufferReader.close();
		}

 catch(Exception e)
	{
	System.out.println("Nu pot citi date "+e.getMessage());
	}
}
@Override
public String toString()
{
	StringBuilder matrix=new StringBuilder();
	String NEW_LINE=System.getProperty("line.separator");
	for(int i =0;i<row;i++)
	{
		for(int j=0 ;j<column;j++)
		{
			matrix.append(map1[i][j]+" ");
		}
		matrix.append(NEW_LINE);
	}
		return matrix.toString();
	}
public String toString(String txt)
{
		StringBuilder matrix=new StringBuilder();
		String NEW_LINE=System.getProperty("line.separator");
		for(int i =0;i<row;i++)
		{
			for(int j=0 ;j<column;j++)
			{
				if(map1[i][j]==-1)
					matrix.append("|"+"S");
				else 
				if(map1[i][j]==1)
					matrix.append("|" + "*");
				else
				if(map1[i][j]==2)
					matrix.append("|"+ "F");
				else if(map1[i][j]==0)
					
					matrix.append("| ");		
				else if(map1[i][j]==3)
					matrix.append("|$");
			}
			matrix.append("|"+NEW_LINE);
		}
			return matrix.toString();
}

public int[] getStartCell()
{
	int poz[]=new int[2];
	for(int i =0;i<this.row;i++)
		for(int j=0;j<this.
				column;j++)
			if(map1[i][j]==-1)
			{
				poz[0]=i;poz[1]=j;
				break;
			}
	System.out.println(poz[0]+" "+poz[1]);
				return  poz;

			
}
public static void main(String [] args)
{
	Maze exemplu=new Maze();
	//exemplu.cccc();
    //exemplu.sort();
  if( exemplu.nextCellToExplore(4, 0))
	  System.out.println("succes");
}
public void sort()
{
	Collections.sort(ex,new Comparator<String>(){
		@Override
		public int compare(String s1,String s2)
		{
			if(s1.length()<s2.length())
			{
				return -1;
			}
			else 
			{
				return s1.compareTo(s2);
			}
			
		}
	}); 
	for(String film : ex)
    	System.out.println(film+"" );
}
void cccc()
{
	int nrjoc=1;
	while(nrjoc==1)
	{ 
		for(int i= 0;i<row;i++)
			for(int j=0;j<column;j++)
				if(map1[i][j]==3)map1[i][j]=0;
		solPart=new String();
		System.out.println(this.toString(""));
	this.play();
	System.out.println("0-Iesi\n 1-Joaca din nou");
	Scanner read1=new Scanner(System.in);
	int nr=read1.nextInt();
	if (nr==1)
		nrjoc=1;
	else nrjoc=0;
}
	for(String exa : ex)
	{
	System.out.println(exa.toString());
	}
}
public int[] getFinishCell() {
	int [] poz=new int[2];
	for(int i =1;i<this.row;i++)
		for(int j=0;j<this.column;j++)
			if(map1[i][j]==2)
			{
				poz[0]=i;
				poz[1]=j;
			}
				return  poz;
}
public int isFreeAt(int i,int j)
{
	if (this.map1[i][j]==0||this.map1[i][j]==2||this.map1[i][j]==3)
		return 1;
	return 0;		
}
public int isWallAt(int i,int j)
{
	{
		if (this.map1[i][j]==1)
			return 1;
		return 0;		
	}
}
public int getRowCount()
{
	return this.row;
}
public int getColumnCount()
{
	return this.column;
}
public int moveUp(int i,int j) {
	if(i==0)return 0;
	else if(this.isWallAt(i-1, j)==1)return 0;
	return 1;
}
public int moveDown(int i,int j)
{
	if(i==row ||map1[i][j]==2||this.isWallAt(i+1, j)==1 )return 0;
	return 1;
}
public int moveLeft(int i,int j)
{
	if(j==0)return 0;
	else if(this.isWallAt(i, j-1)==1)return 0;
	return 1;
}
public int moveRight(int i,int j)
{
	if(j==column)return 0;
	else if(this.isWallAt(i, j+1)==1)return 0;
	return 1;
}
public void muta(int i,int j)
{
if(this.map1[i][j]!=-1)
	this.map1[i][j]=0;;
}
public void play()
{
	int ok=1;
	int [] start=this.
			getStartCell();
	int [] finish=this.getFinishCell();
	int [] pozitieCurenta=start;
	System.out.println(pozitieCurenta[0]+" "+pozitieCurenta[1]+" finish"+ finish[0]+" "+finish[1]);

	while(ok==1)
	{  
		Scanner read=new Scanner(System.in);
		String muta=read.next();
		switch(muta)
		{
		case "w" : 
					if(this.moveUp(start[0], start[1])==1&&this.isFreeAt(start[0]-1, start[1])==1)
						if(this.map1[start[0]-1][start[1]]==2) 
							{
							solPart=solPart+"su ";
							ok=0;
							break;
							}			 
						else	

							{
								this.muta(start[0], start[1]);
								
								start[0]=start[0]-1;
								this.map1[start[0]][start[1]]=3;
								System.out.println(this.toString(""));
								solPart=solPart+"su ";break;
	                	
						}
					
					else
		        	  break;
		          
		case "s" : 
					if(this.moveDown(start[0], start[1])==1&&this.isFreeAt(start[0]+1, start[1])==1)
						if(this.map1[start[0]+1][start[1]]==2)
						{   solPart=solPart+"jo ";
							ok=0;
							break;
						}

						else
						{
						  this.muta(start[0], start[1]);
						  
						  start[0]=start[0]+1;
						  this.map1[start[0]][start[1]]=3;
						  System.out.println(this.toString(""));
						  solPart=solPart+"jo ";break;
						}
					else
						break;
		case "a" : 
					if(this.moveLeft(start[0], start[1])==1&&this.isFreeAt(start[0],start[1]-1)==1)
						if(this.map1[start[0]][start[1]-1]==2)
							{
							solPart=solPart+"st ";
							ok=0;
							break;
							}

							else
							{
								this.muta(start[0], start[1]);
								
							 start[1]=start[1]-1;
							 this.map1[start[0]][start[1]]=3;
							 System.out.println(this.toString(""));
							 solPart=solPart+"st ";break;
	                	} 
					else
						break;
		case "d" :	
					if(this.moveRight(start[0], start[1])==1&&this.isFreeAt(start[0], start[1]+1)==1)
						if(this.map1[start[0]][start[1]+1]==2) 
							{   solPart=solPart+"dr ";
								ok=0;
								break;
							}

							else
							{
							 this.muta(start[0], start[1]);
							
							 start[1]=start[1]+1;
							 this.map1[start[0]][start[1]]=3;
							 System.out.println(this.toString(""));
							 solPart=solPart+"dr ";break;
						 	} 
					else
						break;
		case "q" :this.processCell();break;
		default : System.out.println("Mutare nepermisa");
		}
	}
	ex.add(solPart);
	this.processSolution();
	System.out.println("good job"+pozitieCurenta[0]+" "+pozitieCurenta[1]+" finish"+ finish[0]+" "+finish[1]);
	

}
public void processCell()
{  System.out.println("Solutie partiala:");
	String [] result =solPart.toString().split(" ");
	for(int i=0;i<result.length;i++)
		
	System.out.println(result[i]+" ");
	
}
public void processSolution()
{
	 System.out.println("Solutie finala:");
		String [] result =solPart.toString().split(" ");
		for(int i=0;i<result.length;i++)
			
		System.out.println(result[i]+" ");
}
public boolean nextCellToExplore(int i,int j)
{  
	if(map1[i][j]==2)
	
{return true;}
	this.map1[i][j]=3;

	System.out.println(this.toString(""));
	
	
    if (this.moveDown(i, j)==1  && this.isFreeAt(i+1,j) == 1 && nextCellToExplore(i + 1, j))
	    {
	        return true;
	    }
	 else
	 if (this.moveUp(i, j)==1 && this.isFreeAt(i-1,j) == 1 && nextCellToExplore(i - 1, j))
	    {
	        return true;
	    }
	 else
	 if (this.moveLeft(i, j)==1&& this.isFreeAt(i,j-1) == 1 && nextCellToExplore(i , j-1))
	    {
	        return true;
	    }
	 else
	 if ( this.moveRight(i, j)==1 && this.isFreeAt(i,j+1) == 1 && nextCellToExplore(i, j+1))
	    {
	        return true;
	    }
	 else
     this.map1[i][j]=0;
     System.out.println(this.toString(""));
    try 
    {
    	Thread.sleep(60000);
    }
    catch(InterruptedException ex){
    	Thread.currentThread().interrupt();
    }
    return false;
    }
    
}
