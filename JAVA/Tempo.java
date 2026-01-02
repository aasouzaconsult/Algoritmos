//
// Classe Tempo
//
// Armazenar tempos, note-se que esta classe
// cria tempos não modificáveis pois não existem
// métodos que permitam alterar os campos após a
// criação do Objecto (tal como em String)
public class Tempo {
	
	//Constante que indica um tempo inválido
	public final static Tempo invalid = new Tempo(-1, -1, -1);

	//Campos privados para horas, minutos, segundos
	private int horas;
	private int minutos;
	private int segundos;

	//Construtores...

	//Aceita strings no formato hhh:mm[:ss]
	//Ver checkValid()
	public Tempo(String str) {
		
		int p1 = str.indexOf(":");
		if (p1>0) {
			int p2 = str.indexOf(":",p1+1);
			if (p2>0) {
				horas = Integer.parseInt(str.substring(0,p1));
				minutos = Integer.parseInt(str.substring(p1+1,p2));
				segundos = Integer.parseInt(str.substring(p2+1));
			} else {
				horas = Integer.parseInt(str.substring(0,p1));
				minutos = Integer.parseInt(str.substring(p1+1));
				segundos = 0;
			}
		} else {
			horas = -1;
			minutos = -1;
			segundos = -1;
		}
		checkValid();
	}

	//Aceita os valores de horas, minutos, segundos
	//Ver checkValid()
	public Tempo(int horas, int minutos, int segundos) {
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
		checkValid();
	}

	//Aceita um tempo em segundos
	//Qualquer valor é válido desde que >=0
	public Tempo(int segundos) {
		
		this.horas = segundos/3600;
		this.minutos = (segundos/60)%60;
		this.segundos = segundos%60;
		checkValid();
	}

	//Método privado que verifica a validade
	//dos campos.
	//Um tempo inválido é indicado por segundos=-1
	private void checkValid() {
		if (segundos<0 || segundos>59) {
			segundos = -1;
			return;
		}
		if (minutos<0 || minutos>59) {
			segundos = -1;
			return;
		}
		if (horas<0) {
			segundos = -1;
		}
	}

	//Indica se este tempo é válido
	public boolean isValid() {
		return segundos!=-1;
	}

	//Compara dois tempos
	public boolean equals(Tempo t) {
		return (segundos == t.segundos) && (minutos == t.minutos) && (horas == t.horas);
	}

	//Devolve a representação em string
	//Um tempo inválido é indicado por "##:##:##"
	public String toString() {
		if (isValid()) {
			return formatString(horas," ") + ":" + formatString(minutos,"0") + ":" + formatString(segundos,"0");
		} else {
			return "##:##:##";
		}
	}

	//Devolve o campo horas
	public int getHoras() {
		if (isValid()) {
			return horas;
		} else {
			return -1;
		}
	}

	//Devolve o campo minutos
	public int getMinutos() {
		if (isValid()) {
			return minutos;
		} else {
			return -1;
		}
	}

	//Devolve o campo segundos
	public int getSegundos() {
		if (isValid()) {
			return segundos;
		} else {
			return -1;
		}
	}

	
	//Devolve o tempo armazenado em horas
	public float getFloatHoras() {
		if (isValid()) {
			return horas + minutos/60.0F + segundos/60.0F/60.0F;
		} else {
			return -1;
		}
	}
	
	//Devolve o tempo armazenado em minutos
	public float getFloatMinutos() {
		if (isValid()) {
			return horas*60.0F + minutos + segundos/60.0F;
		} else {
			return -1;
		}
	}

	//Devolve o tempo armazenado em segundos
	public float getFloatSegundos() {
		if (isValid()) {
			return horas*60.0F*60.0F + minutos*60.0F + segundos;
		} else {
			return -1;
		}
	}

	//Soma entre tempos, se este Tempo ou o
	//outro tempo a somar for inválido então
	//é devolvido um tempo inválido
	public Tempo somar(Tempo t) {
		int h;
		int m;
		int s;

		if (isValid() && t.isValid()) {
			h = horas + t.horas;
			m = minutos + t.minutos;
			s = segundos + t.segundos;
			m = m+s/60;
			h = h+m/60;
			s = s%60;
			m = m%60;
			return new Tempo(h,m,s);
		} else {
			return Tempo.invalid;
		}
	}

	//Função auxiliar para formatação de números
	private String formatString(int t, String s2) {
		String s1 = ""+t;
		while (s1.length()<2) s1=s2 + s1;
		return s1;
	}
}