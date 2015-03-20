import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class Maze implements LabyrinthModel,LabyrinthView,LabyrinthSolver
{
int[][] map1=new int[100][100];
int row,column;
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
	System.out.println(exemplu.toString());
	exemplu.play();
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
	if (this.map1[i][j]==0)
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
	if(i==0||this.isWallAt(i-1, j)==1)return 0;
	return 1;
}
public int moveDown(int i,int j)
{
	if(i==row ||this.isWallAt(i+1, j)==1)return 0;
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
this.map1[i][j]=3;
}
public void play()
{
	int [] start=this.
			getStartCell();
	int [] finish=this.getFinishCell();
	int [] pozitieCurenta=start;
	System.out.println(pozitieCurenta[0]+" "+pozitieCurenta[1]+" finish"+ finish[0]+" "+finish[1]);
	while(start[0] !=finish[0]&&start[1]!=finish[1])
	{
		Scanner read=new Scanner(System.in);
		String muta=read.next();
		switch(muta)
		{
		case "w" : if(this.moveUp(start[0], start[1])==1&&this.isFreeAt(start[0]-1, start[1])==1)
		          {this.muta(start[0]-1, start[1]);
		          start[0]=start[0]-1;this.map1[start[0]][start[1]]=3;
		          System.out.println(this.toString());break;
		          }
		case "s" : if(this.moveDown(start[0], start[1])==1&&this.isFreeAt(start[0]+1, start[1])==1)
        {this.muta(start[0]+1, start[1]);
        start[0]=start[0]+1;this.map1[start[0]][start[1]]=3;
        System.out.println(this.toString());break;
        }
		case "a" : if(this.moveLeft(start[0], start[1])==1&&this.isFreeAt(start[0],start[1]-1)==1)
        {this.muta(start[0], start[1]-1);
        start[1]=start[1]-1;this.map1[start[0]][start[1]]=3;
        System.out.println(this.toString());break;
        }
		case "d" : if(this.moveRight(start[0], start[1])==1&&this.isFreeAt(start[0], start[1]+1)==1)
        {this.muta(start[0], start[1]+1);
        start[1]=start[1]+1;this.map1[start[0]][start[1]]=3;
        System.out.println(this.toString());break;
        }
			
		}
	}
	System.out.println("good job"+pozitieCurenta[0]+" "+pozitieCurenta[1]+" finish"+ finish[0]+" "+finish[1]);
}
}

