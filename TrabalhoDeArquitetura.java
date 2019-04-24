package TrabalhoDeArquitetura;
import java.util.Random;
public class TrabalhoDeArquitetura
{
	public static void main(String[] args)
	{
	int I = 10000; // linhas
	int J = 5000; // colunas
		
	//Instanciacao da matriz N*M
    long [][] matriz = new long [I] [J];
	
    //Metodo que gera numeros aleatorios
    Random randomico = new Random();
    
    //Metodo que mostra o tempo do sistema em nanosegundos
    long st1 = System.nanoTime();//Inicio da contagem de tempo
    
    //Criacao da matriz utilizando o método IJ
    for (int i = 0; i < I; i++){
        for (int j = 0; j < J; j++){
          matriz [i][j] = randomico.nextInt();
        }
    }
    //Fim da contagem de tempo
    st1 = System.nanoTime() - st1; 
    System.out.println("Tempo da criacao da primeira matriz = " + st1+ " nanosegundos");
    
    matriz = null;
    matriz = new long[I][J];
    
    //Inicio da contagem de tempo
    long st2 = System.nanoTime();
    
    //Criacao da matriz utilizando o método JI
    for (int j = 0; j < J; j++){
        for (int i = 0; i < I; i++){
          matriz [i][j] = randomico.nextInt();
        }
    }
    //Fim da contagem de tempo
    st2 = System.nanoTime() - st2;
    System.out.println("Tempo da criacao da segunda matriz  = " + st2+ " nanosegundos");
	}
	
	public void mostraMatriz(long matriz[][], int I, int J) 
	{
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				System.out.println(matriz[i][j] + " ");
			}
		}
	}
}

