package TrabalhoDeArquitetura;
import java.util.Random;
public class TrabalhoDeArquiteturaThreads
{
	public static void main(String[] args)
	{
		// Quantas threads o programa vai possuir, DE PREFERÊNCIA NÚMEROS PARES
		double numeroDeThreads = 4;
		// MULTIPLICADOR evita ArrayOutOfBoundsException, garante que o for vai ser do tamanho das linhas e colunas
		double MULTIPLICADOR = 1/numeroDeThreads;
		
		// nota: quanto mais threads mais demorado fica, mas é preciso levar em consideração o tempo da criação das threads
		
		// LINHAS E COLUNAS DA MATRIZ
		final int I = 10000;
		final int J = 10000;
		
		// Cria a matriz, é um objeto pois estava testando uma coisa, mas esqueci o que era...
		Matriz matriz = new Matriz(I, J);
		
		// Metodo que mostra o tempo do sistema em nanosegundos
		long st1 = System.nanoTime();//Inicio da contagem de tempo
		// For para a criação dos threads
		for (int i = 1; i <= numeroDeThreads; i++) 
		{
			CriaMatrizIJ cmij = new CriaMatrizIJ(I * (MULTIPLICADOR * (i - 1)), I * (MULTIPLICADOR * i), J * (MULTIPLICADOR * (i - 1)), J * (MULTIPLICADOR * i), matriz);
			Thread t = new Thread(cmij);
			t.start();
		}
		st1 = System.nanoTime() - st1; //Fim da contagem de tempo
		
		
		//Metodo que mostra o tempo do sistema em nanosegundos
		long st2 = System.nanoTime();//Inicio da contagem de tempo
		// for para criar threads
		for (int i = 1; i <= numeroDeThreads; i++) 
		{
			CriaMatrizJI cmji = new CriaMatrizJI(I * (MULTIPLICADOR * (i - 1)), I * (MULTIPLICADOR * i), J * (MULTIPLICADOR * (i - 1)), J * (MULTIPLICADOR * i), matriz);
			Thread t = new Thread(cmji);
			t.start();
		}
		st2 = System.nanoTime() - st2; //Fim da contagem de tempo
		// mostra os tempos
		System.out.println("Tempo em nanossegundos da criacao da primeira matriz = " + st1+ " nanosegundos");
		System.out.println("Tempo em nanossegundos da criacao da segunda  matriz = " + st2+ " nanosegundos");
	}
}

class CriaMatrizIJ implements Runnable
{	
	final private double posicaoMenorI;
	final private double posicaoMaiorI;
	final private double posicaoMenorJ;
	final private double posicaoMaiorJ;
	Matriz matriz;
	private Random randomico = new Random();
	
	// construtor
	public CriaMatrizIJ(double iMenor, double iMaior, double jMenor, double jMaior, Matriz matriz) 
	{
		this.posicaoMenorI = iMenor;
		this.posicaoMaiorI = iMaior;
		this.posicaoMenorJ = jMenor;
		this.posicaoMaiorJ = jMaior;
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
				matriz.matriz[i][j] = randomico.nextInt();
			}
		}
	}	
}

// classe das threads que só faz criar uma matriz mesmo
class CriaMatrizJI implements Runnable{	
	final private double posicaoMenorI;
	final private double posicaoMaiorI;
	final private double posicaoMenorJ;
	final private double posicaoMaiorJ;
	Matriz matriz;
	Random randomico = new Random();
	
	// construtor
	public CriaMatrizJI(double posicaoMenorI, double posicaoMaiorI, double posicaoMenorJ, double posicaoMaiorJ, Matriz matriz) 
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
				matriz.matriz[i][j] = randomico.nextInt();
			}
		}
	}	
}

class Matriz
{
	long matriz[][];
	
	public Matriz(int i, int j) 
	{
		matriz = new long[i][j];
	}
}
