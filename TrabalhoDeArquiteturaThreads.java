package TrabalhoDeArquitetura;
import java.util.Random;
public class TrabalhoDeArquiteturaThreads
{
	public static void main(String[] args)
	{
		System.out.println("Threads");
		int I = 10000;
		int J = 5000;
		final int numeroDeThreads = 4;
		//Instanciacao da matriz N*M
		long [][] matriz = new long [I][J];
    
		//Metodo que gera numeros aleatorios
		Random randomico = new Random();
		
		//Metodo que mostra o tempo do sistema em nanosegundos
		long st1 = System.nanoTime();//Inicio da contagem de tempo
		
		CriaMatrizIJ cmij_1 = new CriaMatrizIJ(I * (0.25 * (1 - 1)), I * (0.25 * 1), J * (0.25 * (1 - 1)), J * (0.25 * 1), matriz);
		CriaMatrizIJ cmij_2 = new CriaMatrizIJ(I * (0.25 * (2 - 1)), I * (0.25 * 2), J * (0.25 * (2 - 1)), J * (0.25 * 2), matriz);
		CriaMatrizIJ cmij_3 = new CriaMatrizIJ(I * (0.25 * (3 - 1)), I * (0.25 * 3), J * (0.25 * (3 - 1)), J * (0.25 * 3), matriz);
		CriaMatrizIJ cmij_4 = new CriaMatrizIJ(I * (0.25 * (4 - 1)), I * (0.25 * 4), J * (0.25 * (4 - 1)), J * (0.25 * 4), matriz);

		Thread t1 = new Thread(cmij_1);
		Thread t2 = new Thread(cmij_2);
		Thread t3 = new Thread(cmij_3);
		Thread t4 = new Thread(cmij_4);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		st1 = System.nanoTime() - st1; //Fim da contagem de tempo
		System.out.println("Tempo em nanossegundos da criacao da primeira matriz = " + st1+ " nanosegundos");
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		st1 = System.nanoTime();//Inicio da contagem de tempo
		
		CriaMatrizJI cmij_5 = new CriaMatrizJI(I * (0.25 * (1 - 1)), I * (0.25 * 1), J * (0.25 * (1 - 1)), J * (0.25 * 1), matriz);
		CriaMatrizJI cmij_6 = new CriaMatrizJI(I * (0.25 * (2 - 1)), I * (0.25 * 2), J * (0.25 * (2 - 1)), J * (0.25 * 2), matriz);
		CriaMatrizJI cmij_7 = new CriaMatrizJI(I * (0.25 * (3 - 1)), I * (0.25 * 3), J * (0.25 * (3 - 1)), J * (0.25 * 3), matriz);
		CriaMatrizJI cmij_8 = new CriaMatrizJI(I * (0.25 * (4 - 1)), I * (0.25 * 4), J * (0.25 * (4 - 1)), J * (0.25 * 4), matriz);

		Thread t5 = new Thread(cmij_5);
		Thread t6 = new Thread(cmij_6);
		Thread t7 = new Thread(cmij_7);
		Thread t8 = new Thread(cmij_8);

		t5.start();
		t6.start();
		t7.start();
		t8.start();
		
		st1 = System.nanoTime() - st1; //Fim da contagem de tempo
		System.out.println("Tempo em nanossegundos da criacao da segunda  matriz = " + st1+ " nanosegundos");

    
	}
}

class CriaMatrizIJ implements Runnable{	
	final private double posicaoMenorI;
	final private double posicaoMaiorI;
	final private double posicaoMenorJ;
	final private double posicaoMaiorJ;
	final private long matriz[][];
	private Random randomico = new Random();
	
	// construtor
	public CriaMatrizIJ(double posicaoMenorI, double posicaoMaiorI, double posicaoMenorJ, double posicaoMaiorJ, long matriz[][]) 
	{
		this.posicaoMenorI = posicaoMenorI;
		this.posicaoMaiorI = posicaoMaiorI;
		this.posicaoMenorJ = posicaoMenorJ;
		this.posicaoMaiorJ = posicaoMaiorJ;
		this.matriz = matriz;
	}
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		for (int i = (int)posicaoMenorI; i < (posicaoMaiorI -1); i++) 
		{
			for (int j = (int)posicaoMenorJ; j < (posicaoMaiorJ -1); j++) 
			{
				matriz[i][j] = randomico.nextInt();
			}
		}
	}	
}

class CriaMatrizJI implements Runnable{	
	final private double posicaoMenorI;
	final private double posicaoMaiorI;
	final private double posicaoMenorJ;
	final private double posicaoMaiorJ;
	final private long matriz[][];
	private Random randomico = new Random();
	
	// construtor
	public CriaMatrizJI(double posicaoMenorI, double posicaoMaiorI, double posicaoMenorJ, double posicaoMaiorJ, long matriz[][]) 
	{
		this.posicaoMenorI = posicaoMenorI;
		this.posicaoMaiorI = posicaoMaiorI;
		this.posicaoMenorJ = posicaoMenorJ;
		this.posicaoMaiorJ = posicaoMaiorJ;
		this.matriz = matriz;
	}
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		for (int j = (int)posicaoMenorJ; j < (posicaoMaiorJ -1); j++) 
		{
			for (int i = (int)posicaoMenorI; i < (posicaoMaiorI -1); i++) 
			{
				matriz[i][j] = randomico.nextInt();
			}
		}
	}	
}
