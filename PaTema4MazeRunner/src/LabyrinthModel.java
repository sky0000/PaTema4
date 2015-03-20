
public interface LabyrinthModel {
	int [] getStartCell();
	int [] getFinishCell();
	int isFreeAt(int linie,int coloana );
    int isWallAt(int linie,int coloana);
   int getRowCount();
   int getColumnCount();
}
