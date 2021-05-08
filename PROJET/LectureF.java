
package amine.bigpro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class LectureF {
    private String[][] result;
    
    
    public void Segmenter()
    {
        File fic = new File("C:\\Users\\amine\\OneDrive\\Bureau\\PROJET\\nom.txt");
        try
        {

            FileReader f = new FileReader(fic);
            BufferedReader in = new BufferedReader(f);  
            String ligne = null;
            ArrayList<String> tmp = new ArrayList<String>(); // création d'une liste de String qui va nous permettre de ranger les informations comprises dans chaque ligne mais aussi de connaître le nombre de lignes
              
            while (in.ready()){
                ligne = in.readLine();
                tmp.add(ligne);
            }
            in.close();
            
            result = new String[tmp.size()][5];
            for(int i=0; i<tmp.size(); i++){
                result[i] = tmp.get(i).split(";"); // on segmente les informations en fonction du séparateur
            }        
            
        }
	catch(FileNotFoundException e)
	{
	    // Exception lancée quand le fichier n'est pas trouvé
	    System.out.format("Le fichier %s n'existe pas !\n",fic.getAbsolutePath());
	}	
        catch(IOException e)
        {
	    // Exception lancée lorsque il y a des échecs ou des intéruptions produits des opérations de Input/Output
            System.out.format("Erreur d'E/S : %s\n",fic.getAbsolutePath());
        }

    }
    
    /*
        Méthode qui permet de lire le fichier (notre base de données) et de segmenter les différentes lignes du fichier (chaque ligne représente l'ensemble des informations d'un film).
        On segmente donc chaque ligne en 5 (ces 5 segments représentent le titre , la date, la durée, le synopsis, et le chemin de la photo soit l'ensemble des information d'un film).
        On range dans un tableau de String à deux dimensions les différents segments pour chaque ligne.
    */ 
    
    public String[][] Getresult(){
        return result;
    }
    
    /*
        Accesseur en lecture du tableau à deux dimensions contenant l'ensemble des films et leurs informations
    */ 
    
    
    
}
